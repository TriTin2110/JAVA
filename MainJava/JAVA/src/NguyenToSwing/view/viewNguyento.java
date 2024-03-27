package NguyenToSwing.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import NguyenToSwing.controller.controllerNguyenToSwing;

public class viewNguyento extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNhap;
	private JTextArea textAreaKetQua;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewNguyento frame = new viewNguyento();
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
	public viewNguyento() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 881, 657);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textFieldNhap = new JTextField();
		textFieldNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNhap.setBounds(149, 88, 406, 39);
		contentPane.add(textFieldNhap);
		textFieldNhap.setColumns(10);

		controllerNguyenToSwing controllerNguyenToSwing = new controllerNguyenToSwing(this);
		JButton btnGenerate = new JButton("Generate");
		btnGenerate.addActionListener(controllerNguyenToSwing);
		btnGenerate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnGenerate.setBounds(565, 88, 136, 39);
		contentPane.add(btnGenerate);

		JPanel panel = new JPanel();
		panel.setBounds(149, 151, 416, 378);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		textAreaKetQua = new JTextArea();
		JScrollPane jScrollPane = new JScrollPane(textAreaKetQua, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(jScrollPane, BorderLayout.CENTER);
		textAreaKetQua.setFont(new Font("Monospaced", Font.PLAIN, 20));
	}

	public void hienThiKetQua() {
		int tongSo = Integer.parseInt(this.textFieldNhap.getText());
		boolean kiemTra = true;
		int dieuKienDung = 0;
		String ketQua = "";
		int i = 2;
		while (true) {
			if (dieuKienDung == tongSo) {
				break;
			} else {
				kiemTra = true;
				out: for (int j = 2; j <= i; j++) {
					if (i % j == 0 && i != j) {
						kiemTra = false;
						break out;
					}
				}
				if (kiemTra) {
					ketQua += i + "\n";
					dieuKienDung++;
					i++;
				} else {
					i++;
				}
			}
		}
		this.textAreaKetQua.setText(ketQua);
	}
}
