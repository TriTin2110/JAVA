package QuanLySinhVienGiaoDien.QuanLySinhVienView;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import QuanLySinhVienGiaoDien.QuanLySinhVienController.ControllerSinhVien;
import QuanLySinhVienGiaoDien.QuanLySinhVienModel.DanhSachSinhVien;
import QuanLySinhVienGiaoDien.QuanLySinhVienModel.QueQuan;
import QuanLySinhVienGiaoDien.QuanLySinhVienModel.SinhVien;

public class ViewSinhVien extends JFrame {
	QueQuan queQuan = new QueQuan();
	public DanhSachSinhVien danhSachSinhVien = new DanhSachSinhVien();
	private JPanel contentPane;
	private JTextField textFieldLocMaSinhVien;
	public JTable table;
	public JTextField textFieldMaSinhVien;
	public JTextField textFieldHoTen;
	public JTextField textFieldNgaySinh;
	public JTextField textFieldMon1;
	public JTextField textFieldMon2;
	public JTextField textFieldMon3;
	private JLabel lblMaSinhVien;
	private JLabel lblHoTen;
	public JComboBox comboBoxQueQuan;
	public JRadioButton rdbtnNam;
	public JRadioButton rdbtnNu;
	private ButtonGroup buttonGroup;
	ControllerSinhVien controllerSinhVien = new ControllerSinhVien(this);
	private JComboBox comboBoxNoiSinh;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;

	public ViewSinhVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1175, 794);
		this.setTitle("Phần mêm quản lý sinh viên!");
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTepTin = new JMenu("Tệp tin");
		mnTepTin.setForeground(new Color(0, 0, 0));
		mnTepTin.setFont(new Font("Courier New", Font.PLAIN, 17));
		menuBar.add(mnTepTin);

		mntmOpen = new JMenuItem("Mở");
		mntmOpen.addActionListener(controllerSinhVien);
		mntmOpen.setFont(new Font("Arial", Font.PLAIN, 13));
		mnTepTin.add(mntmOpen);

		mntmSave = new JMenuItem("Lưu File");
		mntmSave.addActionListener(controllerSinhVien);
		mntmSave.setFont(new Font("Arial", Font.PLAIN, 13));
		mnTepTin.add(mntmSave);
		// Thiết lập phím tắt
		thietLapPhimTat();

		JSeparator separator = new JSeparator();
		mnTepTin.add(separator);

		JMenuItem mntmExit = new JMenuItem("Thoát");
		mntmExit.addActionListener(controllerSinhVien);
		mntmExit.setFont(new Font("Arial", Font.PLAIN, 13));
		mnTepTin.add(mntmExit);

		JMenu mnAbout = new JMenu("Giới thiệu");
		mnAbout.setFont(new Font("Courier New", Font.PLAIN, 17));
		mnAbout.setForeground(new Color(0, 0, 0));
		menuBar.add(mnAbout);

		JMenuItem mntmAboutOur = new JMenuItem("Về chúng tôi");
		mntmAboutOur.addActionListener(controllerSinhVien);
		mntmAboutOur.setFont(new Font("Arial", Font.PLAIN, 13));
		mnAbout.add(mntmAboutOur);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Box horizontalBoxFilter = Box.createHorizontalBox();
		Font titleFont = new Font("Times new roman", Font.BOLD, 20);
		horizontalBoxFilter.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null),
				"L\u1ECDc sinh vi\u00EAn", TitledBorder.LEADING, TitledBorder.TOP, titleFont, new Color(0, 0, 0)));
		horizontalBoxFilter.setBounds(10, 10, 1141, 105);
		contentPane.add(horizontalBoxFilter);

		JPanel panelFilter = new JPanel();
		panelFilter.setBounds(6, 22, 1129, 83);
		horizontalBoxFilter.add(panelFilter);
		panelFilter.setLayout(null);

		JLabel lblmaSinhVien = new JLabel("Mã sinh viên");
		lblmaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblmaSinhVien.setBounds(428, 25, 133, 30);
		panelFilter.add(lblmaSinhVien);

		JLabel lblNoiSinh = new JLabel("Nơi sinh");
		lblNoiSinh.setBounds(10, 25, 124, 30);
		panelFilter.add(lblNoiSinh);
		lblNoiSinh.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblNoiSinh.setHorizontalAlignment(SwingConstants.TRAILING);

		textFieldLocMaSinhVien = new JTextField();
		textFieldLocMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 21));
		textFieldLocMaSinhVien.setBounds(566, 20, 163, 43);
		panelFilter.add(textFieldLocMaSinhVien);
		textFieldLocMaSinhVien.setColumns(10);

		comboBoxNoiSinh = new JComboBox();
		ArrayList<QueQuan> queQuans = QueQuan.getTinh();
		for (QueQuan queQuan2 : queQuans) {
			comboBoxNoiSinh.addItem(queQuan2.getTenTinhThanh());
		}
		comboBoxNoiSinh.setFont(new Font("Tahoma", Font.PLAIN, 21));
		comboBoxNoiSinh.setBounds(156, 20, 236, 39);
		panelFilter.add(comboBoxNoiSinh);

		JButton btnFilter = new JButton("Lọc sinh viên");
		btnFilter.addActionListener(controllerSinhVien);
		btnFilter.setForeground(Color.RED);
		btnFilter.setBackground(Color.BLACK);
		btnFilter.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnFilter.setBounds(770, 20, 155, 41);
		panelFilter.add(btnFilter);

		JButton btnHuy = new JButton("Hủy");
		btnHuy.addActionListener(controllerSinhVien);
		btnHuy.setForeground(Color.RED);
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnHuy.setBackground(new Color(0, 0, 0));
		btnHuy.setBounds(945, 20, 155, 41);
		panelFilter.add(btnHuy);

		Box horizontalBoxTable = Box.createHorizontalBox();
		horizontalBoxTable.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Danh s\u00E1ch sinh vi\u00EAn",
						TitledBorder.LEADING, TitledBorder.TOP, titleFont, new Color(0, 0, 0)));
		horizontalBoxTable.setBounds(10, 125, 1141, 216);
		contentPane.add(horizontalBoxTable);

		JPanel panelTableTable = new JPanel();
		horizontalBoxTable.add(panelTableTable);
		panelTableTable.setLayout(null);

		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 18));
		table.setBounds(0, 0, 1129, 299);
		table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 20));
		table.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 sinh vi\u00EAn", "T\u00EAn sinh vi\u00EAn", "Qu\u00EA qu\u00E1n",
						"Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "M\u00F4n 1", "M\u00F4n 2", "M\u00F4n 3" }));
		table.setRowHeight(25);
		JScrollPane scrollPaneTable = new JScrollPane(table);
		scrollPaneTable.setBounds(0, 0, 1129, 184);
		panelTableTable.add(scrollPaneTable);

		Box horizontalBoxInfo = Box.createHorizontalBox();
		horizontalBoxInfo.setBorder(
				new TitledBorder(new EtchedBorder(EtchedBorder.RAISED, null, null), "Th\u00F4ng tin sinh vi\u00EAn",
						TitledBorder.LEADING, TitledBorder.TOP, titleFont, new Color(0, 0, 0)));
		horizontalBoxInfo.setBounds(10, 359, 1141, 294);
		contentPane.add(horizontalBoxInfo);

		JPanel panelInfo = new JPanel();
		horizontalBoxInfo.add(panelInfo);
		panelInfo.setLayout(null);

		lblMaSinhVien = new JLabel("Mã sinh viên");
		lblMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMaSinhVien.setBounds(10, 35, 121, 35);
		panelInfo.add(lblMaSinhVien);

		textFieldMaSinhVien = new JTextField();
		textFieldMaSinhVien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMaSinhVien.setBounds(135, 35, 249, 35);
		panelInfo.add(textFieldMaSinhVien);
		textFieldMaSinhVien.setColumns(10);

		lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHoTen.setBounds(10, 87, 121, 35);
		panelInfo.add(lblHoTen);

		textFieldHoTen = new JTextField();
		textFieldHoTen.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldHoTen.setColumns(10);
		textFieldHoTen.setBounds(135, 87, 249, 35);
		panelInfo.add(textFieldHoTen);

		JLabel lblQueQuan = new JLabel("Quê quán");
		lblQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQueQuan.setBounds(10, 147, 121, 35);
		panelInfo.add(lblQueQuan);

		comboBoxQueQuan = new JComboBox();
		ArrayList<QueQuan> queQuan = QueQuan.getTinh();
		for (QueQuan queQuan2 : queQuan) {
			comboBoxQueQuan.addItem(queQuan2.getTenTinhThanh());
		}
		comboBoxQueQuan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBoxQueQuan.setBounds(135, 147, 249, 39);
		panelInfo.add(comboBoxQueQuan);

		textFieldNgaySinh = new JTextField();
		textFieldNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldNgaySinh.setColumns(10);
		textFieldNgaySinh.setBounds(135, 205, 249, 35);
		panelInfo.add(textFieldNgaySinh);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNgaySinh.setBounds(10, 205, 121, 35);
		panelInfo.add(lblNgaySinh);

		JLabel lblGioiTinh = new JLabel("Giới tính");
		lblGioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGioiTinh.setBounds(685, 35, 121, 35);
		panelInfo.add(lblGioiTinh);

		rdbtnNam = new JRadioButton("Nam");
		rdbtnNam.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNam.setBounds(789, 42, 67, 21);
		panelInfo.add(rdbtnNam);

		rdbtnNu = new JRadioButton("Nữ");
		rdbtnNu.setFont(new Font("Tahoma", Font.PLAIN, 20));
		rdbtnNu.setBounds(858, 42, 51, 21);
		panelInfo.add(rdbtnNu);
		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnNam);
		buttonGroup.add(rdbtnNu);

		JLabel lblMon1 = new JLabel("Môn 1");
		lblMon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMon1.setBounds(685, 87, 121, 35);
		panelInfo.add(lblMon1);

		textFieldMon1 = new JTextField();
		textFieldMon1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMon1.setColumns(10);
		textFieldMon1.setBounds(789, 87, 117, 35);
		panelInfo.add(textFieldMon1);

		JLabel lblMon2 = new JLabel("Môn 2");
		lblMon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMon2.setBounds(685, 147, 121, 35);
		panelInfo.add(lblMon2);

		textFieldMon2 = new JTextField();
		textFieldMon2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMon2.setColumns(10);
		textFieldMon2.setBounds(789, 147, 117, 35);
		panelInfo.add(textFieldMon2);

		JLabel lblMon3 = new JLabel("Môn 3");
		lblMon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMon3.setBounds(685, 205, 121, 35);
		panelInfo.add(lblMon3);

		textFieldMon3 = new JTextField();
		textFieldMon3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textFieldMon3.setColumns(10);
		textFieldMon3.setBounds(789, 205, 117, 35);
		panelInfo.add(textFieldMon3);

		JButton btnThem = new JButton("Thêm");
		btnThem.addActionListener(controllerSinhVien);
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnThem.setBounds(10, 680, 138, 43);
		contentPane.add(btnThem);

		JButton btnXoa = new JButton("Xóa");
		btnXoa.addActionListener(controllerSinhVien);
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnXoa.setBounds(264, 680, 138, 43);
		contentPane.add(btnXoa);

		JButton btnCapNhat = new JButton("Cập nhật");
		btnCapNhat.addActionListener(controllerSinhVien);
		btnCapNhat.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnCapNhat.setBounds(510, 680, 138, 43);
		contentPane.add(btnCapNhat);

		JButton btnLuu = new JButton("Lưu");
		btnLuu.addActionListener(controllerSinhVien);
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnLuu.setBounds(763, 680, 138, 43);
		contentPane.add(btnLuu);

		JButton btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.addActionListener(controllerSinhVien);
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnHuyBo.setBounds(1013, 680, 138, 43);
		contentPane.add(btnHuyBo);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	public void thietLapPhimTat() {
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_DOWN_MASK));
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
	}

	public void xoaDuLieuThongTin() {
		this.textFieldMaSinhVien.setText("");
		this.textFieldHoTen.setText("");
		this.textFieldNgaySinh.setText("");
		this.textFieldMon1.setText("");
		this.textFieldMon2.setText("");
		this.textFieldMon3.setText("");
		this.comboBoxQueQuan.setSelectedIndex(0);
		this.buttonGroup.clearSelection();
	}

	public void themSinhVien(SinhVien sv) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (!this.danhSachSinhVien.dssv.contains(sv)) {// Nếu đã trong danh sách chưa tồn tại sinh viên (so sánh theo
														// mã)
			this.danhSachSinhVien.themSinhVien(sv);
			// Hiển thị sinh viên lên bảng
			model.addRow(new Object[] { sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getQueQuan().getTenTinhThanh(),
					sv.getNgaySinh(), (sv.isGioiTinh()) ? "Nam" : "Nữ", sv.getDiem1(), sv.getDiem2(), sv.getDiem3() });
		} else {
			this.danhSachSinhVien.capNhatSinhVien(sv);
			int row = 0;
			for (int j = 0; j < table.getRowCount(); j++) {
				// Tìm kiếm mã sinh viên trong bảng
				if (sv.getMaSinhVien() == Integer.valueOf(model.getValueAt(j, 0) + "")) {
					row = j;
				}
			}
			// Cập nhật lại dữ liệu lên bảng
			model.setValueAt(this.textFieldMaSinhVien.getText(), row, 0);
			model.setValueAt(this.textFieldHoTen.getText(), row, 1);
			model.setValueAt(this.comboBoxQueQuan.getSelectedItem(), row, 2);
			model.setValueAt(this.textFieldNgaySinh.getText(), row, 3);
			model.setValueAt(((rdbtnNam.isSelected()) ? "Nam" : "Nữ"), row, 4);
			model.setValueAt(this.textFieldMon1.getText(), row, 5);
			model.setValueAt(this.textFieldMon2.getText(), row, 6);
			model.setValueAt(this.textFieldMon3.getText(), row, 7);
		}
	}

	public void xoaDongDuLieu(SinhVien sinhVien) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int row = table.getSelectedRow();
		int maSinhVienCanXoa = Integer.valueOf(defaultTableModel.getValueAt(row, 0) + "");
		// Xóa sinh viên trong danh sách
		this.danhSachSinhVien.xoaSinhVien(sinhVien);
		// Xóa sinh viên trong bảng
		defaultTableModel.removeRow(row);
	}

	public boolean kiemTraThongTinRong() {
		if (textFieldMaSinhVien.getText().isEmpty() || textFieldHoTen.getText().isEmpty()
				|| textFieldNgaySinh.getText().isEmpty() || textFieldMon1.getText().isEmpty()
				|| textFieldMon2.getText().isEmpty() || textFieldMon3.getText().isEmpty()
				|| comboBoxQueQuan.getSelectedItem() == "") {
			return true;
		}
		return false;
	}

	// LỌC SINH VIÊN
	public void locSinhVien() {
		// TODO Auto-generated method stub
		// huyLoc();
		String locQueQuan = comboBoxNoiSinh.getSelectedItem() + "";
		String locMaSinhVien = textFieldLocMaSinhVien.getText();
		if (locQueQuan.equals("") && locMaSinhVien.equals("")) {
			JOptionPane.showMessageDialog(this, "Bạn chưa nhập dữ liệu lọc");
		} else {
			if (locQueQuan.equals("")) {
				locTheoNoiSinh(locMaSinhVien);
			} else {
				locTheoNoiSinh(locQueQuan);
			}
		}
	}

	public void locTheoNoiSinh(String dieuKienLoc) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		ArrayList<SinhVien> sinhVienCanXoa = new ArrayList<SinhVien>();
		// Xét điều kiện có chứa bất kỳ chữ số nào hay không
		Pattern parPattern = Pattern.compile("[0-9]");
		Matcher matcher = parPattern.matcher(dieuKienLoc);
		boolean matcherFind = matcher.find();
		for (SinhVien sinhVien : this.danhSachSinhVien.dssv) {
			if (!matcherFind) {
				if (!sinhVien.getQueQuan().getTenTinhThanh().equals(dieuKienLoc)) {
					sinhVienCanXoa.add(sinhVien);
				}
			} else {
				if (sinhVien.getMaSinhVien() != Integer.valueOf(dieuKienLoc)) {
					sinhVienCanXoa.add(sinhVien);
				}
			}
		}
		huyLoc();
		for (SinhVien sinhVien : sinhVienCanXoa) {
			// So sánh mã sinh viên trên table và sinhVienCanXoa
			int row = 0;
			while (row < table.getRowCount()) {
				if (Integer.valueOf(defaultTableModel.getValueAt(row, 0) + "") == sinhVien.getMaSinhVien()) {
					try {
						defaultTableModel.removeRow(row);
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
				row++;
			}
		}
	}

	public void huyLoc() {
		// TODO Auto-generated method stub
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		int row = 0;
		while (row < table.getRowCount()) {
			try {
				defaultTableModel.removeRow(row);
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
		chenDuLieuVaoBang(defaultTableModel, this.danhSachSinhVien.dssv);
	}

	public void chenDuLieuVaoBang(DefaultTableModel model, LinkedList<SinhVien> sinhViens) {
		for (SinhVien sv : sinhViens) {
			model.addRow(new Object[] { sv.getMaSinhVien(), sv.getTenSinhVien(), sv.getQueQuan().getTenTinhThanh(),
					sv.getNgaySinh(), (sv.isGioiTinh()) ? "Nam" : "Nữ", sv.getDiem1(), sv.getDiem2(), sv.getDiem3() });

		}

	}

	public void moFile() {
		// TODO Auto-generated method stub
		JFileChooser jFileChooser = new JFileChooser();
		int moFile = jFileChooser.showOpenDialog(this);

		if (moFile == JFileChooser.APPROVE_OPTION) {
			File file = jFileChooser.getSelectedFile();
			this.danhSachSinhVien.setDuongDan(file.getAbsolutePath());
			moFile(file);
		}
		huyLoc();
	}

	public void moFile(File file) {
		LinkedList<SinhVien> sinhViens = new LinkedList<SinhVien>();
		try {
			this.danhSachSinhVien.xoaDuLieu();
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			SinhVien sv;
			while ((sv = (SinhVien) ois.readObject()) != null) {
				sinhViens.add(sv);
			}
			ois.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
		}
		this.danhSachSinhVien.setDssv(sinhViens);
	}

	public void luuFile() {
		// TODO Auto-generated method stub
		if (this.danhSachSinhVien.getDuongDan().length() > 0) {
			File file = new File(this.danhSachSinhVien.getDuongDan());
			luu(file);
		} else {
			JFileChooser jFileChooser = new JFileChooser();
			int saveConsole = jFileChooser.showSaveDialog(this);
			if (saveConsole == JFileChooser.APPROVE_OPTION) {
				File file = jFileChooser.getSelectedFile();
				luu(file);
			}
		}

	}

	public void luu(File file) {
		try {
			FileOutputStream fos = new FileOutputStream(file);
			this.danhSachSinhVien.setDuongDan(file.getAbsolutePath());
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			for (SinhVien sinhVien : this.danhSachSinhVien.getDssv()) {
				oos.writeObject(sinhVien);
			}
			oos.flush();
			oos.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
