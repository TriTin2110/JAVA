package GiaoDien.KeoThaGiaoDien.GhiChu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class GhiChuView extends JFrame {
	GhiChuModel ghiChuModel = new GhiChuModel();
	private JPanel contentPane;
	JTextArea textArea;

	/**
	 * Create the frame.
	 */
	public GhiChuView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 964, 567);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		GhiChuController ghiChuController = new GhiChuController(this);

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		JScrollPane jScrollPane = new JScrollPane(textArea);
		contentPane.add(jScrollPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setPreferredSize(new Dimension(1, 50));
		panel.setLayout(null);

		JLabel lblPath = new JLabel("Path");
		lblPath.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPath.setBounds(10, 10, 428, 30);
		panel.add(lblPath);

		JButton btnOpen = new JButton("Mở");
		btnOpen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOpen.addActionListener(ghiChuController);
		btnOpen.setBounds(655, 8, 102, 35);
		panel.add(btnOpen);

		JButton btnSave = new JButton("Lưu");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSave.setBounds(803, 10, 102, 35);
		panel.add(btnSave);
		btnSave.addActionListener(ghiChuController);

		this.setVisible(true);
	}
}
