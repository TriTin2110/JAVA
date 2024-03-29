package Window.AddWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.rmi.Naming;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Interface.MainInterface;
import Model.ModelStudent;
import MyClass.CheckingUserInputIssues;
import MyClass.NumberController;
import main.ClientMainFrame;

public class AddStudentWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldStudentID;
	private JTextField textFieldStudentName;
	private JTextField textFieldAge;
	private JTextField textFieldPhone;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public AddStudentWindow(ClientMainFrame clientMainFrame) {
		this.setTitle("Thêm sinh viên mới!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panelStudentID = new JPanel();
		mainPanel.add(panelStudentID);
		panelStudentID.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorID = new JLabel("Id sinh viên:");
		lblAuthorID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelStudentID.add(lblAuthorID);

		textFieldStudentID = new JTextField();
		textFieldStudentID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelStudentID.add(textFieldStudentID);
		textFieldStudentID.setColumns(10);

		JPanel panelStudentName = new JPanel();
		mainPanel.add(panelStudentName);
		panelStudentName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorName = new JLabel("Tên sinh viên:");
		lblAuthorName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelStudentName.add(lblAuthorName);

		textFieldStudentName = new JTextField();
		textFieldStudentName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldStudentName.setColumns(10);
		panelStudentName.add(textFieldStudentName);

		JPanel panelStudentSpecialized = new JPanel();
		mainPanel.add(panelStudentSpecialized);
		panelStudentSpecialized.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentSpeacialized = new JLabel("Chuyên ngành:");
		lblStudentSpeacialized.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelStudentSpecialized.add(lblStudentSpeacialized);

		String[] country = { "CNTT", "Công nghệ Ô Tô", "Cơ Khí", "Điện", "Marketing", "Logistic", "Y Học" };
		JComboBox<String> comboBoxSpecialized = new JComboBox<String>(country);
		comboBoxSpecialized.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentSpecialized.add(comboBoxSpecialized);
		JPanel panelAuthorAge = new JPanel();
		mainPanel.add(panelAuthorAge);
		panelAuthorAge.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAge = new JLabel("Tuổi:");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelAuthorAge.add(lblAge);

		textFieldAge = new JTextField();
		textFieldAge.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldAge.setColumns(10);
		panelAuthorAge.add(textFieldAge);

		JPanel panelAuthorPhone = new JPanel();
		mainPanel.add(panelAuthorPhone);
		panelAuthorPhone.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelAuthorPhone.add(lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldPhone.setColumns(10);
		panelAuthorPhone.add(textFieldPhone);

		JPanel panelSubmit = new JPanel();
		mainPanel.add(panelSubmit);
		panelSubmit.setLayout(new BoxLayout(panelSubmit, BoxLayout.X_AXIS));

		JButton btnAccept = new JButton("Xác nhận");
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSubmit.add(btnAccept);

		JButton btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSubmit.add(btnCancel);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

		btnAccept.addActionListener(e -> {
			try {
				MainInterface mainInterface = (MainInterface) Naming.lookup("rmi://localhost:1026/test");
				String id = this.textFieldStudentID.getText();
				String name = this.textFieldStudentName.getText();
				String age = this.textFieldAge.getText();
				String phone = this.textFieldPhone.getText();
				String specialed = comboBoxSpecialized.getSelectedItem().toString();

				String[] textField = { id, name, age, phone, specialed };

				if (CheckingUserInputIssues.checkingLackInformation(textField)) {
					if (NumberController.checkCharacterIntNumber(age) == 0
							|| NumberController.checkCharacterIntNumber(phone) == 0) {
						JOptionPane.showMessageDialog(this,
								"Số điện thoại hoặc tuổi có chứa chữ cái. Vui lòng kiểm tra lại!");
					} else {
						if (!CheckingUserInputIssues.checkingPhoneAndAge(age, phone)) {
							JOptionPane.showMessageDialog(this, "SĐT hoặc tuổi không hợp lệ!");
						} else {
							ModelStudent modelStudent = new ModelStudent(id, name, Integer.parseInt(age), phone,
									specialed);
							if (mainInterface.searching(modelStudent, "Student") != null) {
								JOptionPane.showMessageDialog(this, "Sinh viên đã tồn tại trong danh sách!");
							} else {
								int result = mainInterface.add(modelStudent, "Student");
								JOptionPane.showMessageDialog(this, "Đã thêm thành công " + result + " dòng!");
								System.out.println("Đã thêm sinh viên mới thành công");
								this.dispose();

							}
						}
					}
				} else {
					JOptionPane.showMessageDialog(this, "Xin vui lòng điền đầy đủ thông tin!");
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

		btnCancel.addActionListener(e -> {
			this.dispose();
		});
	}

}
