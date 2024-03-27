package LapTrinhMang.TaoCayThuMuc;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class TaoCayThuMuc extends JFrame {

	private JPanel contentPane;
	public JTextField jTextFieldFile;
	private JTextArea textArea;
	private File fileLog;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			// TODO: handle exception
		}

		EventQueue.invokeLater(new Runnable() {

			public void run() {
				try {
					TaoCayThuMuc frame = new TaoCayThuMuc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void moFileLog() {
		this.fileLog = new File("D:\\ViewLog.txt");
		if (!this.fileLog.exists()) {
			try {
				this.fileLog.createNewFile();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public TaoCayThuMuc() {
		moFileLog();
		ControllerTaoCayThuMuc controllerTaoCayThuMuc = new ControllerTaoCayThuMuc(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 772, 508);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblFile = new JLabel("File");
		lblFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFile.setBounds(86, 49, 55, 33);
		contentPane.add(lblFile);

		jTextFieldFile = new JTextField();
		jTextFieldFile.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jTextFieldFile.setBounds(138, 48, 427, 36);
		contentPane.add(jTextFieldFile);
		jTextFieldFile.setColumns(10);

		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFind.setBounds(588, 47, 121, 37);
		contentPane.add(btnFind);
		btnFind.addActionListener(controllerTaoCayThuMuc);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 107, 691, 309);
		contentPane.add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDelete.setBounds(588, 426, 121, 37);
		contentPane.add(btnDelete);
		btnDelete.addActionListener(controllerTaoCayThuMuc);

		JButton btnRename = new JButton("Rename");
		btnRename.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRename.setBounds(433, 426, 121, 37);
		contentPane.add(btnRename);

		JButton btnCopy = new JButton("Copy");
		btnCopy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCopy.setBounds(229, 426, 121, 37);
		contentPane.add(btnCopy);

		JButton btnFileLog = new JButton("File Log");
		btnFileLog.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnFileLog.setBounds(46, 426, 121, 37);
		btnFileLog.addActionListener(controllerTaoCayThuMuc);
		contentPane.add(btnFileLog);
		btnCopy.addActionListener(controllerTaoCayThuMuc);
		btnRename.addActionListener(controllerTaoCayThuMuc);

	}

	public void findingFile() {
		// TODO Auto-generated method stub
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			String path = jFileChooser.getSelectedFile().toString();
			jTextFieldFile.setText(path);
			textArea.setText(showFileTree(path, 0));

		}
		luuFileLog(layNgayGio() + " " + "user " + "mở file " + jTextFieldFile.getText());
	}

	public String showFileTree(String path, int level) {
		File file = new File(path);
		// Trường hợp file không tồn tại
		if (!file.exists())
			return "";

		// Trường hợp file tồn tại
		String result = "|_" + file.getName();
		for (int i = 0; i < level; i++) {
			result = "   " + result;
		}
		if (file.isFile())
			return result;

		for (File f : file.listFiles()) {
			result += "\n" + showFileTree(f.getAbsolutePath(), level + 1);
		}
		return result;
	}

	public void deletingFile(String path) {
		File file = new File(path);
		if (file.isDirectory()) {

			for (File f : file.listFiles()) {
				deletingFile(f.getAbsolutePath());
			}
		}
		file.delete();
		luuFileLog(layNgayGio() + " " + "user " + "xóa file " + jTextFieldFile.getText());
	}

	// Đổi tên thư mục
	public void renameFile(String path) {
		String newPath = "";
		try {
			String name = JOptionPane.showInputDialog(this, "Hãy nhập tên file mà bạn muốn đổi: ");
			File file = new File(path);
			newPath = file.getParent() + "\\" + name;
			file.renameTo(new File(newPath));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		luuFileLog(layNgayGio() + " " + "user " + "đổi tên file " + jTextFieldFile.getText());
		jTextFieldFile.setText(newPath);
	}

	public void copyFile() {
		// TODO Auto-generated method stub
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File fileNguon, fileDich;
			fileNguon = new File(jTextFieldFile.getText());
			fileDich = jFileChooser.getSelectedFile();
			copy(fileNguon, fileDich);
		}
		luuFileLog(layNgayGio() + " " + "user " + "copy file/folder " + jTextFieldFile.getText());
	}

	public void copy(File fileNguon, File fileDich) {
		try {
			// Đầu tiên sẽ copy file/folder từ địa chỉ nguồn đến địa chỉ đích
			// resolve(getName()) dùng để nối tên của file/folder vào đường dẫn mới
			Files.copy(fileNguon.toPath(), fileDich.toPath().resolve(fileNguon.getName()),
					StandardCopyOption.REPLACE_EXISTING);

//			Nếu file đang đứng là tập tin sẽ liệt kê tất cả các file con của nó ròi tiến
//			hành copy từng file con
			if (fileNguon.isDirectory()) {
				for (File f : fileNguon.listFiles()) {
					copy(f, new File(fileDich.getAbsolutePath() + "\\" + fileNguon.getName()));
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		luuFileLog(getName());
	}

	public void luuFileLog(String tinNhan) {
		try {
			FileOutputStream fos = new FileOutputStream(this.fileLog, true);
			OutputStreamWriter osw = new OutputStreamWriter(fos, StandardCharsets.UTF_8);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.append(tinNhan);
			bw.newLine();
			bw.flush();
			bw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void docFileLog() {
		try {
			InputStreamReader isr = new InputStreamReader(new FileInputStream(this.fileLog), StandardCharsets.UTF_8);
			BufferedReader br = new BufferedReader(isr);
			String noiDung = "";
			String dong = "";
			while ((dong = br.readLine()) != null) {
				noiDung += dong;
				noiDung += "\n";
			}
			textArea.setText(noiDung);
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public String layNgayGio() {
		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy");
		return ldt.format(dtf);
	}
}
