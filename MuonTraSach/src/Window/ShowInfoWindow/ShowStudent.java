package Window.ShowInfoWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.ModelStudent;

public class ShowStudent extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public ShowStudent(ModelStudent modelStudent) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panelStudentId = new JPanel();
		mainPanel.add(panelStudentId);
		panelStudentId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentId = new JLabel("Mã sinh viên:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentId.add(lblStudentId);

		JLabel lblStudentIdResult = new JLabel(modelStudent.getId());
		lblStudentIdResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentId.add(lblStudentIdResult);

		JPanel panelStudentName = new JPanel();
		mainPanel.add(panelStudentName);
		panelStudentName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentName = new JLabel("Tên sinh viên:");
		lblStudentName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentName.add(lblStudentName);

		JLabel lblStudentNameResult = new JLabel(modelStudent.getName());
		lblStudentNameResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentName.add(lblStudentNameResult);

		JPanel panelStudentAge = new JPanel();
		mainPanel.add(panelStudentAge);
		panelStudentAge.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentAge = new JLabel("Tuổi sinh viên:");
		lblStudentAge.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentAge.add(lblStudentAge);

		JLabel lblStudentAgeResult = new JLabel(modelStudent.getAge() + "");
		lblStudentAgeResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentAge.add(lblStudentAgeResult);

		JPanel panelStudentPhone = new JPanel();
		mainPanel.add(panelStudentPhone);
		panelStudentPhone.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentPhone = new JLabel("Số điện thoại sinh viên:");
		lblStudentPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentPhone.add(lblStudentPhone);

		JLabel lblStudentPhoneResult = new JLabel(modelStudent.getPhone());
		lblStudentPhoneResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentPhone.add(lblStudentPhoneResult);

		JPanel panelStudentCountry = new JPanel();
		mainPanel.add(panelStudentCountry);
		panelStudentCountry.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblStudentCountry = new JLabel("Chuyên ngành sinh viên:");
		lblStudentCountry.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentCountry.add(lblStudentCountry);

		JLabel lblStudentCountryResult = new JLabel(modelStudent.getSpecialized());
		lblStudentCountryResult.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentCountry.add(lblStudentCountryResult);

		JPanel panelSubmit = new JPanel();
		mainPanel.add(panelSubmit);
		panelSubmit.setLayout(new BoxLayout(panelSubmit, BoxLayout.X_AXIS));

		JButton btnSubmit = new JButton("OK");
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSubmit.add(btnSubmit);

		// Đóng cửa sổ này khi người dùng ấn chọn nút Ok
		btnSubmit.addActionListener(e -> {
			this.dispose();
		});

		this.setVisible(true);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setTitle("Thông tin chi tiết của sinh viên!");
	}

}
