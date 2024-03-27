package GiaoDien.ThucHienPhepToan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ThucHienPhepToanView extends JFrame {
	ThucHienPhepToanModel thucHienPhepToanModel = new ThucHienPhepToanModel();
	JTextField giaTri1TextField = new JTextField();
	JTextField giaTri2TextField = new JTextField();
	JLabel ketQuaTextField = new JLabel();

	public ThucHienPhepToanView() {
		this.setLayout(new BorderLayout());
		this.init();
		setVisible(true);
	}

	void setFontTextField() {
		Font font = new Font("Times new roman", Font.BOLD, 30);
		giaTri1TextField.setFont(font);
		giaTri2TextField.setFont(font);
		ketQuaTextField.setFont(font);
	}

	void setFontLabel(JLabel giaTri1Label, JLabel giaTri2Label, JLabel ketQuaLabel) {
		Font font = new Font("Times new roman", Font.BOLD, 30);
		giaTri1Label.setFont(font);
		giaTri2Label.setFont(font);
		ketQuaLabel.setFont(font);
	}

	void setLabel() {
		JPanel jPanelText = new JPanel(new GridLayout(3, 2, 10, 10));
		JLabel giaTri1Label = new JLabel("Giá trị thứ 1: ", JLabel.CENTER);
		JLabel giaTri2Label = new JLabel("Giá trị thứ 2: ", JLabel.CENTER);
		JLabel ketQuaLabel = new JLabel("Kết quả: ", JLabel.CENTER);

		jPanelText.add(giaTri1Label);
		jPanelText.add(giaTri1TextField);
		jPanelText.add(giaTri2Label);
		jPanelText.add(giaTri2TextField);
		jPanelText.add(ketQuaLabel);
		jPanelText.add(ketQuaTextField);
		setFontLabel(giaTri1Label, giaTri2Label, ketQuaLabel);
		this.setFontTextField();
		this.add(jPanelText, BorderLayout.CENTER);
	}

	void setFontButton(JButton jButtonCong, JButton jButtonTru, JButton jButtonNhan, JButton jButtonChia,
			JButton jButtonMu, JButton jButtonChiaDu) {
		Font font = new Font("Times new roman", Font.BOLD, 30);
		jButtonCong.setFont(font);
		jButtonTru.setFont(font);
		jButtonNhan.setFont(font);
		jButtonChia.setFont(font);
		jButtonMu.setFont(font);
		jButtonChiaDu.setFont(font);
	}

	void setButton() {
		ThucHienPhepToanController thucHienPhepToanController = new ThucHienPhepToanController(this);
		JPanel jPanelButton = new JPanel(new GridLayout(2, 3));
		JButton jButtonCong = new JButton("+");
		jPanelButton.add(jButtonCong);
		jButtonCong.addActionListener(thucHienPhepToanController);
		JButton jButtonTru = new JButton("-");
		jPanelButton.add(jButtonTru);
		jButtonTru.addActionListener(thucHienPhepToanController);
		JButton jButtonNhan = new JButton("*");
		jPanelButton.add(jButtonNhan);
		jButtonNhan.addActionListener(thucHienPhepToanController);
		JButton jButtonChia = new JButton("/");
		jPanelButton.add(jButtonChia);
		jButtonChia.addActionListener(thucHienPhepToanController);
		JButton jButtonMu = new JButton("^");
		jPanelButton.add(jButtonMu);
		jButtonMu.addActionListener(thucHienPhepToanController);
		JButton jButtonChiaDu = new JButton("%");
		jPanelButton.add(jButtonChiaDu);
		jButtonChiaDu.addActionListener(thucHienPhepToanController);
		setFontButton(jButtonCong, jButtonTru, jButtonNhan, jButtonChia, jButtonMu, jButtonChiaDu);
		this.add(jPanelButton, BorderLayout.SOUTH);
	}

	void init() {
		setTitle("Thực hiện phép toán!");
		setSize(400, 300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLabel();
		setButton();
	}

	void phepCong() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.phepCong() + "");
	}

	void phepTru() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.phepTru() + "");
	}

	void phepNhan() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.phepNhan() + "");
	}

	void phepChia() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.phepChia() + "");
	}

	void phepMu() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.tichPhan() + "");
	}

	void phepChiaDu() {
		double giaTri1 = Double.valueOf(this.giaTri1TextField.getText());
		double giaTri2 = Double.valueOf(this.giaTri2TextField.getText());
		this.thucHienPhepToanModel.setGiaTri1(giaTri1);
		this.thucHienPhepToanModel.setGiaTri2(giaTri2);
		this.ketQuaTextField.setText(this.thucHienPhepToanModel.chiaLayDu() + "");
	}
}
