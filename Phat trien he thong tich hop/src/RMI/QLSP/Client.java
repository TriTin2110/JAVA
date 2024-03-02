package RMI.QLSP;

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
		setBounds(100, 100, 438, 191);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnAddProduct = new JButton("Tạo sản phẩm");
		panel.add(btnAddProduct);
		btnAddProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddProduct.setAlignmentX(CENTER_ALIGNMENT);

		JButton btnDeleteProduct = new JButton("Xóa sản phẩm");
		panel.add(btnDeleteProduct);
		btnDeleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnDeleteProduct.setAlignmentX(0.5f);

		JButton btnSearchProduct = new JButton("Tìm sản phẩm");
		panel.add(btnSearchProduct);
		btnSearchProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSearchProduct.setAlignmentX(0.5f);
		btnSearchProduct.addActionListener(controller);

		JButton btnUpdateProduct = new JButton("Cập nhật sản phẩm");
		panel.add(btnUpdateProduct);
		btnUpdateProduct.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateProduct.setAlignmentX(0.5f);
		btnUpdateProduct.addActionListener(controller);
		btnDeleteProduct.addActionListener(controller);
		btnAddProduct.addActionListener(controller);
		this.setLocationRelativeTo(null);
	}

}
