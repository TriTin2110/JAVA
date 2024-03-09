package RMI.QLKH;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.rmi.Naming;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

class Client extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JButton btnAddCustomer = new JButton("Thêm khách hàng");
		btnAddCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAddCustomer.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(btnAddCustomer);

		JButton btnRemoveCustomer = new JButton("Xóa khách hàng");
		btnRemoveCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnRemoveCustomer.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(btnRemoveCustomer);

		JButton btnUpdateCustomer = new JButton("Cập nhật khách hàng");
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdateCustomer.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(btnUpdateCustomer);

		JButton btnFindCustomer = new JButton("Tìm khách hàng");
		btnFindCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnFindCustomer.setAlignmentX(CENTER_ALIGNMENT);
		panel.add(btnFindCustomer);

		JPanel panelWelcome = new JPanel();
		contentPane.add(panelWelcome, BorderLayout.NORTH);
		panelWelcome.setLayout(new BoxLayout(panelWelcome, BoxLayout.Y_AXIS));

		JLabel lblWelcome = new JLabel("Chương trình quản lý khách hàng");
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 24));
		panelWelcome.add(lblWelcome);
		lblWelcome.setAlignmentX(CENTER_ALIGNMENT);
		btnUpdateCustomer.addActionListener(e -> {

			try {
				CustomerInterface customerInterface = (CustomerInterface) Naming
						.lookup("rmi://localhost:1026/Customer");
				String id = JOptionPane.showInputDialog(this, "Hãy nhập mã khách hàng");
				if (customerInterface.findCustomer(new ModelCustomer(id)) != null) {
					String name = JOptionPane.showInputDialog(this, "Hãy nhập tên khách hàng");
					String address = JOptionPane.showInputDialog(this, "Hãy nhập địa chỉ khách hàng");
					String type = JOptionPane.showInputDialog(this, "Hãy nhập loại khách hàng");

					JOptionPane.showMessageDialog(this, "Đã cập nhật thành công "
							+ customerInterface.alterCustomer(new ModelCustomer(id, name, address, type)) + " dòng!");
				} else
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại trong danh sách!");
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

		btnFindCustomer.addActionListener(e -> {
			try {
				String id = JOptionPane.showInputDialog(this, "Hãy nhập mã khách hàng");
				CustomerInterface customerInterface = (CustomerInterface) Naming
						.lookup("rmi://localhost:1026/Customer");
				ModelCustomer modelCustomer = customerInterface.findCustomer(new ModelCustomer(id));
				if (modelCustomer != null) {
					JOptionPane.showMessageDialog(this, "Mã của khách hàng là:" + modelCustomer.getId());
					JOptionPane.showMessageDialog(this, "Tên của khách hàng là:" + modelCustomer.getName());
					JOptionPane.showMessageDialog(this, "Địa chỉ của khách hàng là:" + modelCustomer.getAddress());
					JOptionPane.showMessageDialog(this, "Loại khách hàng là:" + modelCustomer.getType());
				} else {
					JOptionPane.showMessageDialog(this, "Khách hàng không tồn tại trong danh sách!");
				}
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

		btnRemoveCustomer.addActionListener(e -> {
			try {
				String id = JOptionPane.showInputDialog(this, "Hãy nhập mã khách hàng");
				CustomerInterface customerInterface = (CustomerInterface) Naming
						.lookup("rmi://localhost:1026/Customer");
				JOptionPane.showMessageDialog(this,
						"Đã xóa thành công " + customerInterface.removeCustomer(new ModelCustomer(id)) + " dòng!");

			} catch (Exception e2) {
				// TODO: handle exception
			}
		});

		btnAddCustomer.addActionListener(e -> {
			try {
				CustomerInterface customerInterface = (CustomerInterface) Naming
						.lookup("rmi://localhost:1026/Customer");
				String id = JOptionPane.showInputDialog(this, "Hãy nhập mã khách hàng");
				boolean re = (customerInterface.findCustomer(new ModelCustomer(id)) == null) ? true : false;
				if (re) {
					String name = JOptionPane.showInputDialog(this, "Hãy nhập tên khách hàng");
					String address = JOptionPane.showInputDialog(this, "Hãy nhập địa chỉ khách hàng");
					String type = JOptionPane.showInputDialog(this, "Hãy nhập loại khách hàng");
					JOptionPane.showMessageDialog(this, "Đã thêm thành công "
							+ customerInterface.addCustomer(new ModelCustomer(id, name, address, type)) + " dòng!");
				} else {
					JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại trong danh sách");
				}

			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		});

	}

}
