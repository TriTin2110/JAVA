package LapTrinhMang.TaoFile;

import java.awt.Font;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ViewTaoFile extends JFrame {

	private JPanel contentPane;
	private JTextField jTextFoleder;
	private JTextField jTextFileName;

	/**
	 * Create the frame.
	 */
	public ViewTaoFile() {
		ControllerTaoFile controllerTaoFile = new ControllerTaoFile(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 782, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Folder");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblNewLabel.setBounds(56, 29, 95, 33);
		contentPane.add(lblNewLabel);

		jTextFoleder = new JTextField();
		jTextFoleder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jTextFoleder.setBounds(161, 29, 387, 33);
		contentPane.add(jTextFoleder);
		jTextFoleder.setColumns(10);

		JLabel lblFile = new JLabel("File name");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblFile.setBounds(44, 114, 107, 33);
		contentPane.add(lblFile);

		jTextFileName = new JTextField();
		jTextFileName.setFont(new Font("Tahoma", Font.PLAIN, 22));
		jTextFileName.setColumns(10);
		jTextFileName.setBounds(161, 114, 387, 33);
		contentPane.add(jTextFileName);

		JButton btnChoose = new JButton("Choose");
		btnChoose.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnChoose.setBounds(595, 29, 107, 33);
		contentPane.add(btnChoose);
		btnChoose.addActionListener(controllerTaoFile);

		JButton btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCreate.setBounds(595, 114, 107, 33);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(controllerTaoFile);

		this.setTitle("Tạo file");
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void openFolder() {
		JFileChooser jFileChooser = new JFileChooser();
		// Chỉ cho phép chọn folder
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		// Kiểm tra folder nhập vào có hợp lệ hay không
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			String path = jFileChooser.getSelectedFile().getAbsolutePath();
			this.jTextFoleder.setText(path);
		}
	}

	public void createFile() {
		// TODO Auto-generated method stub
		File file = new File(this.jTextFoleder.getText() + "\\" + jTextFileName.getText());
		try {
			if (!file.exists()) {
				file.createNewFile();
				JOptionPane.showMessageDialog(this, "Đã tạo file thành công!");
				System.exit(0);
			} else if (jTextFileName.getText().trim().length() == 0)
				JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên file", "Lỗi", JOptionPane.ERROR_MESSAGE);
			else if (file.exists())
				JOptionPane.showMessageDialog(this, "File đã tồn tại", "Lỗi", JOptionPane.ERROR_MESSAGE);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
