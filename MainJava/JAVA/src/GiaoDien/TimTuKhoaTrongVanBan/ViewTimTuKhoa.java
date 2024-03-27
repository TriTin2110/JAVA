package GiaoDien.TimTuKhoaTrongVanBan;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

public class ViewTimTuKhoa extends JFrame {
	ModelTimTuKhoa modelTimTuKhoa = new ModelTimTuKhoa();
	JLabel jLabelVanBan = new JLabel("Văn bản");
	JLabel jLabeltuKhoa = new JLabel("Từ khóa");
	JLabel jLabelKetQua = new JLabel(" ");
	JTextField jTextField = new JTextField();
	JTextArea jTextArea = new JTextArea(10, 10);

	public ViewTimTuKhoa() {
		this.setLayout(new BorderLayout());
		this.init();
		this.setVisible(true);
	}

	void setTuKhoa() {
		JButton jButton = new JButton("Thống kê");
		JPanel jPanel = new JPanel(new GridLayout(4, 1));
		ControllerTimTuKhoa controllerTimTuKhoa = new ControllerTimTuKhoa(this);
		jButton.addActionListener(controllerTimTuKhoa);

		jPanel.add(jLabeltuKhoa);
		jPanel.add(jTextField);
		jPanel.add(jButton);
		jPanel.add(jLabelKetQua);
		this.add(jPanel, BorderLayout.SOUTH);
	}

	void setVanBan() {
		// Thêm thanh cuộn dọc
		JScrollPane jScrollPane = new JScrollPane(jTextArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Font font = new FontUIResource("Times new roman", Font.BOLD, 20);
		jTextArea.setFont(font);
		this.add(jScrollPane, BorderLayout.CENTER);
	}

	private void init() {
		// TODO Auto-generated method stub
		this.setTitle("Tìm từ khóa");
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.add(jLabelVanBan, BorderLayout.NORTH);
		setVanBan();
		setTuKhoa();
	}

	void timTuKhoa() {
		this.modelTimTuKhoa.setVanBan(this.jTextArea.getText());
		this.modelTimTuKhoa.setTuKhoa(this.jTextField.getText());
		this.jLabelKetQua.setText(this.modelTimTuKhoa.timTuKhoa());
	}
}
