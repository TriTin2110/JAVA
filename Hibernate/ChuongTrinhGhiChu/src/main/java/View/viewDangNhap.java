package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

public class viewDangNhap extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldTaiKhoan;
	public JPasswordField fieldMatKhau;
	public JLabel lblMatKhau;

	/**
	 * Create the frame.
	 */
	public viewDangNhap() {
		Controller controller = new Controller(this);
		this.setTitle("Đăng nhập tài khoản!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 448, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTaiKhoan = new JLabel("Tài khoản:");
		lblTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTaiKhoan.setBounds(10, 34, 113, 32);
		contentPane.add(lblTaiKhoan);

		textFieldTaiKhoan = new JTextField();
		textFieldTaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldTaiKhoan.setBounds(118, 33, 292, 35);
		contentPane.add(textFieldTaiKhoan);
		textFieldTaiKhoan.setColumns(10);

		lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMatKhau.setBounds(10, 119, 113, 32);
		contentPane.add(lblMatKhau);

		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangNhap.setBounds(224, 182, 148, 32);
		contentPane.add(btnDangNhap);
		btnDangNhap.addActionListener(controller);

		JButton btnDangKy = new JButton("Đăng ký");
		btnDangKy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDangKy.setBounds(66, 182, 148, 32);
		contentPane.add(btnDangKy);
		btnDangKy.addActionListener(controller);

		fieldMatKhau = new JPasswordField();
		fieldMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));
		fieldMatKhau.setBounds(118, 119, 292, 33);
		contentPane.add(fieldMatKhau);

		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public int kiemTraMatKhau(String matKhauTrongDB) {
		// TODO Auto-generated method stub
		return (fieldMatKhau.getText().equals(matKhauTrongDB)) ? 1 : 0;
	}

}
