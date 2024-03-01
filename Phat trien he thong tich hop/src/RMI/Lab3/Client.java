package RMI.Lab3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Client frame = new Client();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Client() {
		ActionListener controller = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 241);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnCreateCustomer = new JButton("Tạo Khách Hàng");
		btnCreateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnCreateCustomer);
		btnCreateCustomer.setAlignmentX(CENTER_ALIGNMENT);
		btnCreateCustomer.addActionListener(controller);

		JButton btnDeleteCustomer = new JButton("Xóa khách hàng");
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteCustomer.setAlignmentX(0.5f);
		panel.add(btnDeleteCustomer);
		btnDeleteCustomer.addActionListener(controller);

		JButton btnSearchCustomer = new JButton("Tìm khách hàng");
		btnSearchCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchCustomer.setAlignmentX(0.5f);
		panel.add(btnSearchCustomer);
		btnSearchCustomer.addActionListener(controller);

		JButton btnUpdateCustomer = new JButton("Cập nhật khách hàng");
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateCustomer.setAlignmentX(0.5f);
		panel.add(btnUpdateCustomer);
		btnUpdateCustomer.addActionListener(controller);
	}

}
