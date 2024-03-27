package Window.AddWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.rmi.Naming;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Implements.ConnectionMuonTraSach;
import Interface.MainInterface;
import Model.ModelBook;
import MyClass.CheckingUserInputIssues;
import MyClass.DateFormatter;
import MyClass.NumberController;
import MyClass.StringController;
import main.ClientMainFrame;

public class AddBookWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldBookID;
	private JTextField textFieldBookName;
	private JTextField textFieldQuantity;
	private JDatePickerImpl jDatePickerImpl;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public AddBookWindow(ClientMainFrame clientMainFrame) {
		this.setTitle("Thêm sách mới!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 310);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

		JPanel panelBookID = new JPanel();
		mainPanel.add(panelBookID);
		panelBookID.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookId = new JLabel("Id sách:");
		lblBookId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelBookID.add(lblBookId);

		textFieldBookID = new JTextField();
		textFieldBookID.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelBookID.add(textFieldBookID);
		textFieldBookID.setColumns(10);

		JPanel panelBookName = new JPanel();
		mainPanel.add(panelBookName);
		panelBookName.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBookName = new JLabel("Tên sách:");
		lblBookName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelBookName.add(lblBookName);

		textFieldBookName = new JTextField();
		textFieldBookName.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldBookName.setColumns(10);
		panelBookName.add(textFieldBookName);

		JPanel panelKindOfBook = new JPanel();
		mainPanel.add(panelKindOfBook);
		panelKindOfBook.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblKindOfBook = new JLabel("Thể loại:");
		lblKindOfBook.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelKindOfBook.add(lblKindOfBook);

		String[] country = { "Sách thiếu nhi", "Sách tâm lý, tình cảm", "Sách tôn giáo",
				"Sách văn hoá xã hội", "Sách lịch sử", "Sách văn học viễn tưởng",
				"Sách tiểu sử, tự truyện" };
		JComboBox<String> comboBoxKindOfBook = new JComboBox<String>(country);
		comboBoxKindOfBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelKindOfBook.add(comboBoxKindOfBook);
		JPanel panelAuthorId = new JPanel();
		mainPanel.add(panelAuthorId);
		panelAuthorId.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblAuthorId = new JLabel("Mã tác giả:");
		lblAuthorId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelAuthorId.add(lblAuthorId);

		JComboBox<String> comboBoxAuthorID = new JComboBox<String>(StringController.StringArraySort(getAuthorID()));
		comboBoxAuthorID.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelAuthorId.add(comboBoxAuthorID);

		JPanel panelQuantity = new JPanel();
		mainPanel.add(panelQuantity);
		panelQuantity.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblQuantity = new JLabel("Số lượng:");
		lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelQuantity.add(lblQuantity);

		textFieldQuantity = new JTextField();
		textFieldQuantity.setFont(new Font("Tahoma", Font.PLAIN, 19));
		textFieldQuantity.setColumns(10);
		panelQuantity.add(textFieldQuantity);

		JPanel panelPublicDay = new JPanel();
		mainPanel.add(panelPublicDay);
		panelPublicDay.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblPublicDay = new JLabel("Ngày xuất bản:");
		lblPublicDay.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelPublicDay.add(lblPublicDay);

		UtilDateModel uCalendarModel = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "today");
		properties.put("text.month", "month");
		properties.put("text.year", "year");
		JDatePanelImpl jDatePanelImpl = new JDatePanelImpl(uCalendarModel, properties);
		jDatePickerImpl = new JDatePickerImpl(jDatePanelImpl, new DateFormatter());
		panelPublicDay.add(jDatePickerImpl);
		// Lấy dữ liệu từ JDatePickerImpl
//		jDatePickerImpl.getModel().getValue();

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
				String status = "Còn sách";
				Object object = this.jDatePickerImpl.getModel().getValue();
				// Kiểm tra date đã được chọn hay chưa
				if (object == null) {
					JOptionPane.showMessageDialog(this, "Xin vui lòng điền đầy đủ thông tin!");
				} else {
					String[] textField = { this.textFieldBookID.getText(), this.textFieldBookName.getText(),
							comboBoxKindOfBook.getSelectedItem().toString(),
							comboBoxAuthorID.getSelectedItem().toString(), status, this.textFieldQuantity.getText(),
							object.toString() };
					// Kiểm tra thông tin có đầy đủ ko
					if (!CheckingUserInputIssues.checkingLackInformation(textField)) {
						JOptionPane.showMessageDialog(this, "Xin vui lòng điền đầy đủ thông tin!");
					} else if (NumberController.checkCharacterIntNumber(this.textFieldQuantity.getText()) == 0) {
						JOptionPane.showMessageDialog(this, "Số lượng sách phải là chữ số!");
					} else if (Integer.parseInt(textField[5]) <= 0) {
						JOptionPane.showMessageDialog(this, "Số lượng sách không thể nhỏ hơn 1!");
					} else {
						// Kiểm tra số lượng sách nhập vào
						int result = (NumberController.checkCharacterIntNumber(textField[5]) == 0) ? 0 : 1;
						if (result == 0) {
							JOptionPane.showMessageDialog(this,
									"Số lượng chỉ được chứa ký tự số. Xin vui lòng kiểm tra lại!", "Lỗi!!",
									JOptionPane.ERROR_MESSAGE);
						} else {
							ModelBook modelBook = new ModelBook(textField[0], textField[1], textField[2], textField[3],
									textField[4], Integer.parseInt(textField[5]), getDate());
							if (mainInterface.searching(modelBook, "Book") != null) {
								JOptionPane.showMessageDialog(this, "Sách đã có id tồn tại trong danh sách", "Lỗi!!",
										JOptionPane.ERROR_MESSAGE);
							} else {
								result = mainInterface.add(modelBook, "Book");
								JOptionPane.showMessageDialog(this, "Đã thêm thành công " + result + " dòng!");
								System.out.println("Đã thêm sách mới thành công");
								this.dispose();

							}
						}

					}
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

		btnCancel.addActionListener(e ->

		{
			this.dispose();
		});
	}

	public Date getDate() {
		int day = this.jDatePickerImpl.getModel().getDay();
		int month = this.jDatePickerImpl.getModel().getMonth();
		int year = this.jDatePickerImpl.getModel().getYear();
		@SuppressWarnings("deprecation")
		Date date = new Date(year - 1900, month, day);
		return date;
	}

	public String[] getAuthorID() {
		String[] result = null;
		try {
			Connection connection = ConnectionMuonTraSach.getConnection();
			Statement statement = connection.createStatement();
			// Lấy số dòng của bảng author
			ResultSet resultSet = statement.executeQuery("select count(*) from author");
			int count = (resultSet.next()) ? resultSet.getInt(1) : 0;
			// Tạo mảng string với độ lớn = số dòng đã lấy
			result = new String[count];

			count = 0;

			String sql = "select id_author from author";
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result[count] = resultSet.getString("id_author");
				count++;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return StringController.StringArraySort(result);
	}
}