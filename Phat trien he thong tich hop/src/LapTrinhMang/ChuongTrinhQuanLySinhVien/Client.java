package LapTrinhMang.ChuongTrinhQuanLySinhVien;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Client extends JFrame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Client().init();
	}

	public void init() {
		ActionListener controller = new Controller(this);
		JFrame jFrame = new JFrame();
		JPanel jPanel = new JPanel();
		jFrame.setLayout(new BorderLayout());
		jFrame.add(jPanel, BorderLayout.CENTER);
		BoxLayout boxLayout = new BoxLayout(jPanel, BoxLayout.Y_AXIS);
		jPanel.setLayout(boxLayout);
		JButton jbtAddStudent = new JButton("Thêm sinh viên");
		jbtAddStudent.setAlignmentX(CENTER_ALIGNMENT);
		jbtAddStudent.addActionListener(controller);
		jPanel.add(jbtAddStudent);

		JButton jbtRemoveStudent = new JButton("Xóa sinh viên");
		jbtRemoveStudent.setAlignmentX(CENTER_ALIGNMENT);
		jbtRemoveStudent.addActionListener(controller);
		jPanel.add(jbtRemoveStudent);

		JButton jbtAlterStudent = new JButton("Chỉnh sửa sinh viên");
		jbtAlterStudent.setAlignmentX(CENTER_ALIGNMENT);
		jbtAlterStudent.addActionListener(controller);
		jPanel.add(jbtAlterStudent);

		JButton jbtFindingStudent = new JButton("Tìm sinh viên");
		jbtFindingStudent.setAlignmentX(CENTER_ALIGNMENT);
		jbtFindingStudent.addActionListener(controller);
		jPanel.add(jbtFindingStudent);

		jFrame.setVisible(true);
		jFrame.setSize(400, 200);
		jFrame.setLocationRelativeTo(null);
	}
}
