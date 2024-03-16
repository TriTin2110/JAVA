package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.hibernate.Session;

import Controller.Controller;
import HibernateUtil.HibernateUtil;
import model.modelTaiKhoan;

public class viewDangKy extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldTaiKhoanMoi;
	private JLabel lblMtKhu;
	private JLabel lblMtKhu_1;
	public JPasswordField fieldMatKhauMoi;
	private JButton btnTaoTaiKhoanMoi;
	private JPasswordField fieldXacNhanMatKhau;
	static Controller controller;

	/**
	 * Create the frame.
	 */
	public viewDangKy() {
		controller = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Tạo tài khoản mới!");
		setBounds(100, 100, 448, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(10, 25, 98, 31);
		contentPane.add(lblTaiKhoan);

		textFieldTaiKhoanMoi = new JTextField();
		textFieldTaiKhoanMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTaiKhoanMoi.setBounds(132, 23, 292, 35);
		contentPane.add(textFieldTaiKhoanMoi);
		textFieldTaiKhoanMoi.setColumns(10);

		lblMtKhu = new JLabel("Mật khẩu:");
		lblMtKhu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu.setBounds(10, 76, 98, 31);
		contentPane.add(lblMtKhu);

		lblMtKhu_1 = new JLabel("Nhập lại MK:");
		lblMtKhu_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMtKhu_1.setBounds(10, 131, 171, 31);
		contentPane.add(lblMtKhu_1);

		fieldMatKhauMoi = new JPasswordField();
		fieldMatKhauMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fieldMatKhauMoi.setBounds(132, 72, 292, 35);
		contentPane.add(fieldMatKhauMoi);

		btnTaoTaiKhoanMoi = new JButton("Tạo tài khoản mới!");
		btnTaoTaiKhoanMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaoTaiKhoanMoi.setBounds(110, 172, 239, 42);
		contentPane.add(btnTaoTaiKhoanMoi);
		btnTaoTaiKhoanMoi.addActionListener(controller);

		fieldXacNhanMatKhau = new JPasswordField();
		fieldXacNhanMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fieldXacNhanMatKhau.setBounds(132, 127, 292, 35);
		contentPane.add(fieldXacNhanMatKhau);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	// 1: message type
	// 0: error type
	public modelTaiKhoan dangKy(boolean dieuKien) {
		// TODO Auto-generated method stub
		String taiKhoan = textFieldTaiKhoanMoi.getText();
		String matKhau = fieldMatKhauMoi.getText();
		String xacNhanMatKhau = fieldXacNhanMatKhau.getText();

//				Nếu tài khoản đã có trong db hoặc mật khẩu và xác nhận Mk là khác nhau;
		if (!dieuKien || !matKhau.equals(xacNhanMatKhau)
		// Kiểm tra tính hợp lệ của tài khoản
				|| !controller.kiemTraTaiKhoanVaMatKhau(taiKhoan, matKhau))
			return null;
//				Ngược lại
		else {
			Session session = HibernateUtil.getSessionFactory().openSession();
			modelTaiKhoan modelTaiKhoan = new modelTaiKhoan(taiKhoan, matKhau);
			session.beginTransaction();
			session.save(modelTaiKhoan);
			session.getTransaction().commit();
			session.close();
			return modelTaiKhoan;
		}
	}

}
