package View;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Controller.ControllerChuongTrinhDangNhap;

public class KhungDangNhap extends JFrame {

	private JPanel contentPane;
	public JTextField textUser;
	public JButton btnTaoTaiKhoanMoi;
	public JPasswordField textPassword;
	public JButton btnExit;

	/**
	 * Create the frame.
	 */
	public KhungDangNhap() {
		ControllerChuongTrinhDangNhap controllerChuongTrinhDangNhap = new ControllerChuongTrinhDangNhap(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("User:");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(32, 25, 107, 32);
		contentPane.add(lblUser);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(32, 73, 107, 32);
		contentPane.add(lblPassword);

		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textUser.setBounds(136, 26, 155, 30);
		contentPane.add(textUser);
		textUser.setColumns(10);

		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOk.setBounds(41, 133, 113, 32);
		btnOk.addActionListener(controllerChuongTrinhDangNhap);
		contentPane.add(btnOk);

		btnExit = new JButton("Exit");
		btnExit.addActionListener(controllerChuongTrinhDangNhap);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExit.setBounds(178, 132, 113, 32);
		contentPane.add(btnExit);

		btnTaoTaiKhoanMoi = new JButton("Tạo tài khoản mới");
		btnTaoTaiKhoanMoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTaoTaiKhoanMoi.setBounds(73, 175, 196, 38);
		btnTaoTaiKhoanMoi.addActionListener(controllerChuongTrinhDangNhap);
		contentPane.add(btnTaoTaiKhoanMoi);

		textPassword = new JPasswordField();
		textPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textPassword.setBounds(135, 73, 156, 30);
		contentPane.add(textPassword);

		this.setTitle("Chương trình đăng nhập!");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
