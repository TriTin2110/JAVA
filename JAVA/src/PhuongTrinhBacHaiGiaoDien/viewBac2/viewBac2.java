package PhuongTrinhBacHaiGiaoDien.viewBac2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import PhuongTrinhBacHaiGiaoDien.controllerBac2.ControllerBac2;

public class viewBac2 extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldA;
	private JTextField textFieldB;
	private JTextField textFieldC;
	private JLabel lblKtQuaOutput;
	private JLabel lblx1;
	private JLabel lblx2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewBac2 frame = new viewBac2();
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
	public viewBac2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 879, 581);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(5, 5, 850, 99);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblTittle = new JLabel("Giải phương trình bậc 2");
		lblTittle.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblTittle.setBounds(240, 24, 366, 45);
		panel.add(lblTittle);

		textFieldA = new JTextField();
		textFieldA.setFont(new Font("Tahoma", Font.PLAIN, 29));
		textFieldA.setBounds(378, 164, 175, 44);
		contentPane.add(textFieldA);
		textFieldA.setColumns(10);

		JLabel lblNewLabel = new JLabel("a:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblNewLabel.setBounds(334, 164, 34, 34);
		contentPane.add(lblNewLabel);

		textFieldB = new JTextField();
		textFieldB.setFont(new Font("Tahoma", Font.PLAIN, 29));
		textFieldB.setColumns(10);
		textFieldB.setBounds(378, 241, 175, 44);
		contentPane.add(textFieldB);

		JLabel lblB = new JLabel("b:");
		lblB.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblB.setBounds(334, 241, 34, 34);
		contentPane.add(lblB);

		textFieldC = new JTextField();
		textFieldC.setFont(new Font("Tahoma", Font.PLAIN, 29));
		textFieldC.setColumns(10);
		textFieldC.setBounds(378, 316, 175, 44);
		contentPane.add(textFieldC);

		JLabel lblC = new JLabel("c:");
		lblC.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblC.setBounds(334, 316, 34, 34);
		contentPane.add(lblC);

		JLabel lblKtQua = new JLabel("Kết quả:");
		lblKtQua.setFont(new Font("Tahoma", Font.PLAIN, 29));
		lblKtQua.setBounds(253, 401, 115, 34);
		contentPane.add(lblKtQua);

		lblKtQuaOutput = new JLabel("");
		lblKtQuaOutput.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblKtQuaOutput.setBounds(378, 401, 439, 26);
		contentPane.add(lblKtQuaOutput);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBounds(10, 459, 845, 75);
		contentPane.add(horizontalBox);
		Font fontTittleBox = new Font("Times new roman", Font.PLAIN, 20);
		horizontalBox.setBorder(new TitledBorder(null, "Ch\u1ECDn t\u00E1c v\u1EE5", TitledBorder.LEADING,
				TitledBorder.TOP, fontTittleBox, Color.BLACK));

		JPanel panel_footer = new JPanel();
		panel_footer.setBounds(10, 0, 845, 75);
		horizontalBox.add(panel_footer);
		panel_footer.setLayout(null);

		ControllerBac2 controllerBac2 = new ControllerBac2(this);

		JButton btnGiai = new JButton("Giải");
		btnGiai.addActionListener(controllerBac2);
		btnGiai.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnGiai.setBounds(190, 0, 145, 34);
		panel_footer.add(btnGiai);

		JButton btnXaRong = new JButton("Xóa rỗng");
		btnXaRong.addActionListener(controllerBac2);
		btnXaRong.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnXaRong.setBounds(368, 0, 145, 34);
		panel_footer.add(btnXaRong);

		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(controllerBac2);
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnThoat.setBounds(549, 0, 145, 34);
		panel_footer.add(btnThoat);

		lblx1 = new JLabel("");
		lblx1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblx1.setBounds(378, 437, 175, 26);
		contentPane.add(lblx1);

		lblx2 = new JLabel("");
		lblx2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblx2.setBounds(579, 437, 175, 26);
		contentPane.add(lblx2);
	}

	public void hienThiKetQua() {
		double giaTriA = Double.parseDouble(textFieldA.getText());
		double giaTriB = Double.parseDouble(textFieldB.getText());
		double giaTriC = Double.parseDouble(textFieldC.getText());
		double delta = Math.pow(giaTriB, 2) - (4 * giaTriA * giaTriC);
		if (delta < 0) {
			this.lblKtQuaOutput.setText("Phương trình vô nghiệm!");

		} else if (delta == 0) {
			this.lblKtQuaOutput.setText("Phương trình có nghiệm kép!");
			this.lblx1.setText("x0 = " + (-giaTriB / (2 * giaTriA)));
		} else {
			this.lblKtQuaOutput.setText("Phương trình có nghiệm phân biệt!");
			this.lblx1.setText("x1 = " + ((-giaTriB + Math.sqrt(delta)) / (2 * giaTriA)));
			this.lblx2.setText("x2 = " + ((-giaTriB - Math.sqrt(delta)) / (2 * giaTriA)));
		}
	}

	public void resetGiaTri() {
		this.textFieldA.setText("");
		this.textFieldB.setText("");
		this.textFieldC.setText("");
		this.lblKtQuaOutput.setText("");
		this.lblx1.setText("");
		this.lblx2.setText("");
	}

}
