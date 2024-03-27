package LapTrinhMang.NameCard;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class ViewNameCard extends JFrame {

	private JPanel contentPane;
	public JTextField textFieldName;
	public JTextField textFieldAddress;
	public JTextField textFieldPhone;
	public JTextField textFieldEmail;
	private ModelNameCard modelNameCard;
	private String picFileExtension;
	private JLabel lblPic;
	private File picFile;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewNameCard frame = new ViewNameCard();
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
	public ViewNameCard() {
		ControllerNameCard controllerNameCard = new ControllerNameCard(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 674, 358);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblName = new JLabel("Họ và tên:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(197, 39, 105, 31);
		contentPane.add(lblName);

		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldName.setBounds(312, 39, 336, 31);
		contentPane.add(textFieldName);
		textFieldName.setColumns(10);

		JLabel lblAddress = new JLabel("Địa chỉ:");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAddress.setBounds(225, 93, 105, 31);
		contentPane.add(lblAddress);

		textFieldAddress = new JTextField();
		textFieldAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(312, 93, 336, 31);
		contentPane.add(textFieldAddress);

		JLabel lblPhone = new JLabel("SĐT:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPhone.setBounds(249, 149, 105, 31);
		contentPane.add(lblPhone);

		textFieldPhone = new JTextField();
		textFieldPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldPhone.setColumns(10);
		textFieldPhone.setBounds(312, 149, 336, 31);
		contentPane.add(textFieldPhone);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEmail.setBounds(238, 206, 105, 31);
		contentPane.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(312, 206, 336, 31);
		contentPane.add(textFieldEmail);

		JButton btnSave = new JButton("Lưu danh thiếp");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnSave.setBounds(249, 269, 177, 33);
		contentPane.add(btnSave);
		btnSave.addActionListener(controllerNameCard);

		JButton btnRead = new JButton("Nhập danh thiếp");
		btnRead.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRead.setBounds(451, 269, 186, 33);
		contentPane.add(btnRead);
		btnRead.addActionListener(controllerNameCard);

		JButton btnChoosePic = new JButton("Chọn ảnh");
		btnChoosePic.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChoosePic.setBounds(10, 250, 177, 33);
		contentPane.add(btnChoosePic);
		btnChoosePic.addActionListener(controllerNameCard);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		horizontalBox.setBounds(30, 39, 146, 198);
		contentPane.add(horizontalBox);

		lblPic = new JLabel("");
		horizontalBox.add(lblPic);
	}

	public void setDanhThiep() {
		String name = this.textFieldName.getText();
		String address = this.textFieldAddress.getText();
		String phone = this.textFieldPhone.getText();
		String email = this.textFieldEmail.getText();
		String pic = null;
		// Lưu ảnh vào tệp với cách mã hóa = Base 64
		try {
			File f = this.picFile;
			FileInputStream fin = new FileInputStream(f);
			// tạo mảng byte có độ lớn = độ lớn của file
			byte imagebytearray[] = new byte[(int) f.length()];
			fin.read(imagebytearray);
			pic = Base64.getEncoder().encodeToString(imagebytearray);
			fin.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		this.modelNameCard = new ModelNameCard(name, address, phone, email, pic);
		save();
	}

	public void save() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		int result = jFileChooser.showSaveDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			try {
				if (!file.exists())
					file.createNewFile();
				ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
				oos.writeObject(this.modelNameCard);
				oos.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

	public void read() {
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(jFileChooser.getSelectedFile()));
				this.modelNameCard = (ModelNameCard) ois.readObject();
				ois.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		getDanhThiep();
	}

	public void getDanhThiep() {
		this.textFieldName.setText(this.modelNameCard.getName());
		this.textFieldAddress.setText(this.modelNameCard.getAddress());
		this.textFieldPhone.setText(this.modelNameCard.getPhone());
		this.textFieldEmail.setText(this.modelNameCard.getEmail());
		// Đọc hình ảnh từ file
		try {
			byte[] b = Base64.getDecoder().decode(this.modelNameCard.getPicture());
			ByteArrayInputStream bis = new ByteArrayInputStream(b);
			Image i = ImageIO.read(bis);
			this.lblPic.setIcon(new ImageIcon(i));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void showPic() {
		// TODO Auto-generated method stub
		JFileChooser jFileChooser = new JFileChooser();
		jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		int result = jFileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			this.picFile = jFileChooser.getSelectedFile();
			String picFile = jFileChooser.getSelectedFile().getName();
			this.picFileExtension = picFile.substring(picFile.lastIndexOf(".") + 1);
			// Tạo icon và gán vào danh thiếp
			this.lblPic.setIcon(new ImageIcon(jFileChooser.getSelectedFile().getAbsolutePath()));
		}
	}
}
