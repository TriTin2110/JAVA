package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHangGiaoDien;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class ViewSanXuatVaMuaHang extends JFrame {

	private JPanel contentPane;
	public JLabel lblSoLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					ViewSanXuatVaMuaHang frame = new ViewSanXuatVaMuaHang();
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
	public ViewSanXuatVaMuaHang() {
		Controller controller = new Controller(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 966, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblSoLuongHang = new JLabel("Số lượng hàng");
		lblSoLuongHang.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSoLuongHang.setBounds(342, 56, 263, 76);
		contentPane.add(lblSoLuongHang);

		lblSoLuong = new JLabel("...", SwingConstants.CENTER);
		lblSoLuong.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblSoLuong.setBounds(342, 167, 263, 88);
		contentPane.add(lblSoLuong);

		JLabel lblNhaSanXuat = new JLabel("Nhà sản xuất");
		lblNhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNhaSanXuat.setBounds(10, 117, 263, 76);
		contentPane.add(lblNhaSanXuat);

		JLabel lblKhchHng = new JLabel("Khách hàng");
		lblKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblKhchHng.setBounds(734, 117, 208, 76);
		contentPane.add(lblKhchHng);

		JButton btnBatDauNhaSanXuat = new JButton("Bắt đầu sản xuất");
		btnBatDauNhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBatDauNhaSanXuat.setBounds(37, 213, 181, 42);
		contentPane.add(btnBatDauNhaSanXuat);
		btnBatDauNhaSanXuat.addActionListener(controller);

		JButton btnKetThucNhaSanXuat = new JButton("Kết thúc sản xuất");
		btnKetThucNhaSanXuat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKetThucNhaSanXuat.setBounds(25, 305, 208, 42);
		contentPane.add(btnKetThucNhaSanXuat);
		btnKetThucNhaSanXuat.addActionListener(controller);

		JButton btnBatDauKhachHang = new JButton("Bắt đầu mua");
		btnBatDauKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnBatDauKhachHang.setBounds(754, 213, 152, 42);
		contentPane.add(btnBatDauKhachHang);
		btnBatDauKhachHang.addActionListener(controller);

		JButton btnKetThucKhachHang = new JButton("Kết thúc mua");
		btnKetThucKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnKetThucKhachHang.setBounds(754, 305, 152, 42);
		contentPane.add(btnKetThucKhachHang);
		btnKetThucKhachHang.addActionListener(controller);
	}
}
