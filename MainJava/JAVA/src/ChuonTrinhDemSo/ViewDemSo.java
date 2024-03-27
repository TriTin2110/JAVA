package ChuonTrinhDemSo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ViewDemSo extends JFrame {
	private ModelDemSo modelDemSo = new ModelDemSo();
	JButton jButtonTang = new JButton("Tăng");
	JButton jButtonGiam = new JButton("Giảm");
	JButton jButtonReset = new JButton("Reset");
	JLabel jLabelText = new JLabel(modelDemSo.getGiaTri() + "", JLabel.CENTER);

	public ViewDemSo() {
		// TODO Auto-generated constructor stub
		this.init();
		this.setVisible(true);
	}

	void init() {
		this.setTitle("Chương trình đếm số!");
		this.setSize(300, 300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ControlerDemSo ctr = new ControlerDemSo(this);
		jButtonTang.addActionListener(ctr);
		jButtonGiam.addActionListener(ctr);
		jButtonReset.addActionListener(ctr);
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		jPanel.add(jButtonTang, BorderLayout.WEST);
		jPanel.add(jButtonGiam, BorderLayout.EAST);
		jPanel.add(jButtonReset, BorderLayout.SOUTH);
		jPanel.add(jLabelText, BorderLayout.CENTER);

		this.add(jPanel, BorderLayout.CENTER);
	}

	void tang() {
		this.modelDemSo.tangGiaTri();
		this.jLabelText.setText(modelDemSo.getGiaTri() + "");
	}

	void giam() {
		this.modelDemSo.giamGiaTri();
		this.jLabelText.setText(modelDemSo.getGiaTri() + "");
	}

	void reset() {
		this.modelDemSo.resetGiaTri();
		this.jLabelText.setText(modelDemSo.getGiaTri() + "");
	}
}
