package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.QLX_Model;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Rectangle;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class QLX_View extends JFrame {
	private QLX_Model model;
	private JPanel contentPane;
	private JTextField textField_BienSo;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					QLX_View frame = new QLX_View();
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
	public QLX_View() {
		this.setTitle("Danh Sách Bãi Xe");
		this.model = new QLX_Model();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 911, 586);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu menuFile = new JMenu("Tùy Chọn");
		menuFile.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		menuBar.add(menuFile);
		
		JMenu menuOpen = new JMenu("Mở");
		menuOpen.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		menuFile.add(menuOpen);
		
		JMenu menuExit = new JMenu("Thoát");
		menuExit.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		menuFile.add(menuExit);
		
		JMenu menuAbout = new JMenu("Thông tin khác");
		menuAbout.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		menuBar.add(menuAbout);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(6, 0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Label_BienSo = new JLabel("Biển Số:");
		Label_BienSo.setFont(new Font("Tahoma", Font.BOLD, 24));
		Label_BienSo.setBounds(191, 41, 116, 54);
		contentPane.add(Label_BienSo);
		
		textField_BienSo = new JTextField();
		textField_BienSo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textField_BienSo.setBounds(294, 42, 244, 54);
		contentPane.add(textField_BienSo);
		textField_BienSo.setColumns(10);
		
		JButton Button_TimKiem = new JButton("Tìm Kiếm");
		Button_TimKiem.setBackground(new Color(166, 166, 166));
		Button_TimKiem.setForeground(new Color(255, 74, 74));
		Button_TimKiem.setFont(new Font("Tahoma", Font.BOLD, 24));
		Button_TimKiem.setBounds(548, 42, 154, 54);
		contentPane.add(Button_TimKiem);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(Color.BLACK);
		separator.setBounds(10, 109, 887, 2);
		contentPane.add(separator);
		
		JLabel lblDanhSchXe = new JLabel("Danh Sách Xe:");
		lblDanhSchXe.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDanhSchXe.setBounds(20, 109, 142, 54);
		contentPane.add(lblDanhSchXe);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 10));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "T\u00EAn", "Bi\u1EC3n S\u1ED1", "Ng\u00E0y \u0110\u00F3ng Ti\u1EC1n", "S\u1ED1 Ti\u1EC1n \u0110\u00F3ng", "Ng\u00E0y H\u1EBFt H\u1EA1n"
			}
		));
		table.getColumnModel().getColumn(3).setPreferredWidth(94);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 155, 877, 148);
		contentPane.add(scrollPane);
		
		JLabel lblThngTinNgi = new JLabel("Thông Tin Người Gửi: ");
		lblThngTinNgi.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblThngTinNgi.setBounds(10, 298, 216, 54);
		contentPane.add(lblThngTinNgi);
		
		JLabel Label_BienSo_1 = new JLabel("Tên:");
		Label_BienSo_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label_BienSo_1.setBounds(35, 354, 116, 44);
		contentPane.add(Label_BienSo_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setColumns(10);
		textField.setBounds(123, 354, 190, 44);
		contentPane.add(textField);
		
		JLabel Label_BienSo_1_1 = new JLabel("Biển Số:");
		Label_BienSo_1_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label_BienSo_1_1.setBounds(20, 408, 116, 44);
		contentPane.add(Label_BienSo_1_1);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_1.setColumns(10);
		textField_1.setBounds(123, 408, 190, 44);
		contentPane.add(textField_1);
		
		JLabel Label_BienSo_1_2 = new JLabel("Ngày Đóng Tiền:");
		Label_BienSo_1_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label_BienSo_1_2.setBounds(498, 354, 216, 44);
		contentPane.add(Label_BienSo_1_2);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_2.setColumns(10);
		textField_2.setBounds(697, 354, 190, 44);
		contentPane.add(textField_2);
		
		JLabel Label_BienSo_1_3 = new JLabel("Ngày Hết Hạn:");
		Label_BienSo_1_3.setFont(new Font("Tahoma", Font.BOLD, 22));
		Label_BienSo_1_3.setBounds(522, 408, 179, 44);
		contentPane.add(Label_BienSo_1_3);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField_3.setColumns(10);
		textField_3.setBounds(697, 408, 190, 44);
		contentPane.add(textField_3);
		
		JButton Button_TimKiem_1 = new JButton("OK");
		Button_TimKiem_1.setForeground(Color.WHITE);
		Button_TimKiem_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		Button_TimKiem_1.setBackground(Color.GRAY);
		Button_TimKiem_1.setBounds(277, 478, 132, 44);
		contentPane.add(Button_TimKiem_1);
		
		JButton Button_TimKiem_1_1 = new JButton("Thoát");
		Button_TimKiem_1_1.setForeground(Color.WHITE);
		Button_TimKiem_1_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		Button_TimKiem_1_1.setBackground(Color.GRAY);
		Button_TimKiem_1_1.setBounds(462, 478, 132, 44);
		contentPane.add(Button_TimKiem_1_1);
		this.setVisible(true);
	}
}
