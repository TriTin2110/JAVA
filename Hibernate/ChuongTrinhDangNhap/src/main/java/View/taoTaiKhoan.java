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

public class taoTaiKhoan extends JFrame {

	private JPanel contentPane;
	public JTextField textUser;
	public JPasswordField passwordConfirmPassword;
	public JPasswordField passwordPassword;
	public JButton btnCancel;

	/**
	 * Create the frame.
	 */
	public taoTaiKhoan() {
		ControllerChuongTrinhDangNhap controllerChuongTrinhDangNhap = new ControllerChuongTrinhDangNhap(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 350, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblUser = new JLabel("Tên tài khoản: ");
		lblUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUser.setBounds(10, 22, 145, 34);
		contentPane.add(lblUser);

		textUser = new JTextField();
		textUser.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textUser.setBounds(150, 22, 161, 34);
		contentPane.add(textUser);
		textUser.setColumns(10);

		JLabel lblPassword = new JLabel("Mật khẩu:");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(10, 76, 145, 34);
		contentPane.add(lblPassword);

		JLabel lblConfirmPassword = new JLabel("Xác nhận mật khẩu:");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword.setBounds(10, 135, 145, 34);
		contentPane.add(lblConfirmPassword);

		passwordConfirmPassword = new JPasswordField();
		passwordConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordConfirmPassword.setBounds(150, 135, 161, 34);
		contentPane.add(passwordConfirmPassword);

		passwordPassword = new JPasswordField();
		passwordPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		passwordPassword.setBounds(150, 76, 161, 34);
		contentPane.add(passwordPassword);

		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreate.setBounds(44, 179, 106, 34);
		btnCreate.addActionListener(controllerChuongTrinhDangNhap);
		contentPane.add(btnCreate);

		btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(controllerChuongTrinhDangNhap);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCancel.setBounds(176, 179, 106, 34);
		contentPane.add(btnCancel);

		this.setTitle("Tạo tài khoản mới!");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}
