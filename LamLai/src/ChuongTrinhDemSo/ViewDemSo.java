package ChuongTrinhDemSo;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ViewDemSo extends JFrame {

	private ModelDemSo modelDemSo = new ModelDemSo();
	JButton jButtonTang = new JButton("Giảm");
	JButton jButtonGiam = new JButton("Tăng");
	JButton jButtonReset = new JButton("Reset");
	JLabel jLabelResult = new JLabel(modelDemSo.getGiaTri() + "", JLabel.CENTER);

	public ViewDemSo() {
		this.init();
		setVisible(true);
	}

	void init() {
		setTitle("Chương trình đếm số!");
		setSize(800, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ControllerDemSo controllerDemSo = new ControllerDemSo(this);
		jButtonTang.addActionListener(controllerDemSo);
		jButtonGiam.addActionListener(controllerDemSo);
		jButtonReset.addActionListener(controllerDemSo);
		JPanel jPanel = new JPanel(new BorderLayout());
		jPanel.add(jButtonTang, BorderLayout.WEST);
		jPanel.add(jButtonGiam, BorderLayout.EAST);
		jPanel.add(jButtonReset, BorderLayout.SOUTH);
		jPanel.add(jLabelResult, BorderLayout.CENTER);
		add(jPanel, BorderLayout.CENTER);
	}

	void tang() {
		this.modelDemSo.tangGiaTri();
		jLabelResult.setText(modelDemSo.getGiaTri() + "");
	}

	void giam() {
		this.modelDemSo.giamGiaTri();
		jLabelResult.setText(modelDemSo.getGiaTri() + "");
	}

	void reset() {
		this.modelDemSo.resetGiaTri();
		jLabelResult.setText(modelDemSo.getGiaTri() + "");
	}
}
