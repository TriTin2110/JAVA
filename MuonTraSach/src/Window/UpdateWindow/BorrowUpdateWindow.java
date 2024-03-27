package Window.UpdateWindow;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import Implements.ConnectionMuonTraSach;
import Interface.MainInterface;
import Model.ModelBorrowDetail;
import MyClass.CheckingUserInputIssues;
import MyClass.DateFormatter;
import MyClass.GetAttribute;
import MyClass.StringController;

public class BorrowUpdateWindow extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JDatePickerImpl jDatePickerImplBorrowDay;
	private String id;
	private JDatePickerImpl jDatePickerImplReturnDay;
	private JComboBox<String> comboBoxBookId;
	private JComboBox<String> comboBoxStudentId;
	private JComboBox<String> comboBoxExpiredStatus;
	private JComboBox<String> comboBoxReturnStatus;
	private UtilDateModel uCalendarModel;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	public BorrowUpdateWindow(ModelBorrowDetail modelBorrowDetail, String id) {
		this.id = id;
		this.setTitle("Thêm thẻ mượn sách mới!");
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

		String[] listBookId = GetAttribute.getId("Book");
		comboBoxBookId = new JComboBox<String>(listBookId);
		comboBoxBookId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelBookID.add(comboBoxBookId);

		JPanel panelStudentId = new JPanel();
		mainPanel.add(panelStudentId);
		panelStudentId.setLayout(new GridLayout(0, 2, 0, 0));

		String[] listStudentId = GetAttribute.getId("Student");
		JLabel lblStudentId = new JLabel("Id sinh viên:");
		lblStudentId.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelStudentId.add(lblStudentId);

		comboBoxStudentId = new JComboBox<String>(listStudentId);
		comboBoxStudentId.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelStudentId.add(comboBoxStudentId);

		JPanel panelExpiredStatus = new JPanel();
		mainPanel.add(panelExpiredStatus);
		panelExpiredStatus.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblExpiredStatus = new JLabel("Trạng thái:");
		lblExpiredStatus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelExpiredStatus.add(lblExpiredStatus);

		String[] expiredStatus = { "Còn hạn", "Hết hạn" };
		comboBoxExpiredStatus = new JComboBox<String>(expiredStatus);
		comboBoxExpiredStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelExpiredStatus.add(comboBoxExpiredStatus);
		JPanel panelReturnStatus = new JPanel();
		mainPanel.add(panelReturnStatus);
		panelReturnStatus.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblReturnStatus = new JLabel("Trạng thái trả:");
		lblReturnStatus.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelReturnStatus.add(lblReturnStatus);

		String[] returnStatus = { "Chưa trả", "Đã trả" };
		comboBoxReturnStatus = new JComboBox<String>(returnStatus);
		comboBoxReturnStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelReturnStatus.add(comboBoxReturnStatus);

		JPanel panelBorrowDay = new JPanel();
		mainPanel.add(panelBorrowDay);
		panelBorrowDay.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblBorrowDay = new JLabel("Ngày mượn:");
		lblBorrowDay.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelBorrowDay.add(lblBorrowDay);

		uCalendarModel = new UtilDateModel();
		Properties properties = new Properties();
		properties.put("text.today", "today");
		properties.put("text.month", "month");
		properties.put("text.year", "year");
		JDatePanelImpl jDatePanelImpl = new JDatePanelImpl(uCalendarModel, properties);
		jDatePickerImplBorrowDay = new JDatePickerImpl(jDatePanelImpl, new DateFormatter());
		panelBorrowDay.add(jDatePickerImplBorrowDay);

		JPanel panelReturnDay = new JPanel();
		mainPanel.add(panelReturnDay);
		panelReturnDay.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel lblReturnDay = new JLabel("Ngày trả:");
		lblReturnDay.setFont(new Font("Tahoma", Font.PLAIN, 19));
		panelReturnDay.add(lblReturnDay);
		jDatePickerImplReturnDay = new JDatePickerImpl(jDatePanelImpl, new DateFormatter());
		panelReturnDay.add(jDatePickerImplReturnDay);
		panelReturnDay.setEnabled(false);

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
		comboBoxReturnStatus.addItemListener(this);
		jDatePickerImplReturnDay.setVisible(false);
		setTextField(modelBorrowDetail.getBorrowID());
		// *Khi returnStatus = "Đã trả sách" thì ngày trả phải bằng ngày hiện tại*
		btnAccept.addActionListener(e -> {
			try {
				MainInterface mainInterface = (MainInterface) Naming.lookup("rmi://localhost:1026/test");
				// Kiểm tra date đã được chọn hay chưa
				String[] textField = { comboBoxBookId.getSelectedItem().toString(),
						comboBoxStudentId.getSelectedItem().toString(),
						comboBoxExpiredStatus.getSelectedItem().toString(),
						comboBoxReturnStatus.getSelectedItem().toString() };
				// Kiểm tra đã trả sách hay chưa
				Date borrowDate = null;
				Date returnDate = null;
				if (jDatePickerImplReturnDay.getModel().getValue() != null) {
					if (comboBoxReturnStatus.getSelectedItem().toString().equals("Đã trả")) {
						borrowDate = GetAttribute.getBorrowDate(this.id);
						returnDate = GetAttribute.getDate(jDatePickerImplBorrowDay);
					} else {
						borrowDate = GetAttribute.getDate(jDatePickerImplBorrowDay);
						returnDate = Date.valueOf(borrowDate.toLocalDate().plusDays(7));
					}
					// Kiểm tra ngày trả và ngày mượn có hợp lệ hay không
					if (returnDate.after(borrowDate)) {
						// Kiểm tra thông tin có đầy đủ ko
						if (!CheckingUserInputIssues.checkingLackInformation(textField)) {
							JOptionPane.showMessageDialog(this, "Xin vui lòng điền đầy đủ thông tin!");
						} else {
							@SuppressWarnings("deprecation")
							ModelBorrowDetail md = new ModelBorrowDetail(id, textField[0], textField[1], textField[2],
									textField[3], borrowDate, returnDate);
							int result = mainInterface.update(md, "Borrow");
							JOptionPane.showMessageDialog(this, "Đã cập nhật thành công " + result + " dòng!");
							System.out.println("Đã cập nhật chi tiết mượn mới thành công");
							this.dispose();

						}
					} else {
						JOptionPane.showMessageDialog(this, "Ngày trả phải sau ngày mượn!", "Lỗi!!",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày!");
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

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getStateChange() == ItemEvent.SELECTED) {
			switch (e.getItem().toString()) {

			// Nếu chưa trả thì sẽ cho phép nhập borrow date và return date = borrow date +
			// 7
			case "Chưa trả":
				jDatePickerImplReturnDay.setVisible(false);
				jDatePickerImplBorrowDay.setVisible(true);
				break;

			// Nếu đã trả thì sẽ không cho phép chọn borrow date và cho phép chọn return
			// date
			// Khi đó borrow date sẽ = borrow date trước đó của record
			case "Đã trả":
				jDatePickerImplBorrowDay.setVisible(false);
				jDatePickerImplReturnDay.setVisible(true);
				break;
			}
		}
	}

	private void setTextField(String id) {
		try {
			MainInterface mainInterface = (MainInterface) Naming.lookup("rmi://localhost:1026/test");
			ModelBorrowDetail modelBorrowDetail = (ModelBorrowDetail) mainInterface.searching(new ModelBorrowDetail(id),
					"Borrow");
			this.comboBoxBookId.setSelectedItem(modelBorrowDetail.getBookID());
			this.comboBoxStudentId.setSelectedItem(modelBorrowDetail.getStudentID());
			this.comboBoxExpiredStatus.setSelectedItem(modelBorrowDetail.getExpiredStatus());
			this.comboBoxReturnStatus.setSelectedItem(modelBorrowDetail.getReturnStatus());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
