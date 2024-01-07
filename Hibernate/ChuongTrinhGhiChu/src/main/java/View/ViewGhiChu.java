package View;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.hibernate.Session;

import Controller.Controller;
import Controller.FileController;
import HibernateUtil.HibernateUtil;
import model.modelGhiChu;
import model.modelTaiKhoan;

public class ViewGhiChu extends JFrame {

	private JPanel contentPaneNoiDung;
	private JTextField textFieldKichCoChu;
	public JTextField textFieldTieuDe;
	public JTextArea textAreaNoiDung;
	private modelGhiChu modelGhiChu;
	private JMenuItem mntmMoGhiChu;
	FileController fileController = new FileController();
	modelTaiKhoan modelTaiKhoanDangTruyCap = null;
	private JLabel lblSoTu;
	public JLabel lblTrangThai;

	public ViewGhiChu() {
		Controller controller = new Controller(this);
		int doRong = 806, doCao = 504;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 806, 504);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnTepTin = new JMenu("Tệp tin");
		menuBar.add(mnTepTin);

		mntmMoGhiChu = new JMenuItem("Mở ghi chú");
		mnTepTin.add(mntmMoGhiChu);
		mntmMoGhiChu.addActionListener(controller);

		JMenuItem mntmLuuGhiChu = new JMenuItem("Lưu ghi chú");
		mnTepTin.add(mntmLuuGhiChu);
		mntmLuuGhiChu.addActionListener(controller);

		JSeparator separator = new JSeparator();
		mnTepTin.add(separator);

		JMenuItem mntmXoaGhiChu = new JMenuItem("Xóa ghi chú");
		mnTepTin.add(mntmXoaGhiChu);
		mntmXoaGhiChu.addActionListener(controller);

		JMenu mnChinhSua = new JMenu("Chỉnh sửa");
		menuBar.add(mnChinhSua);

		JMenu mnKichCoChu = new JMenu("Kích cỡ chữ");
		mnChinhSua.add(mnKichCoChu);

		JMenu mnKieuFontChu = new JMenu("Kiểu font chữ");
		mnChinhSua.add(mnKieuFontChu);

		JSeparator separator_1 = new JSeparator();
		mnChinhSua.add(separator_1);

		JMenu mnMauNen = new JMenu("Màu nền");
		mnChinhSua.add(mnMauNen);

		JMenu mnMauChu = new JMenu("Màu chữ");
		mnChinhSua.add(mnMauChu);

		JMenu mnGioiThieu = new JMenu("Giới thiệu");
		menuBar.add(mnGioiThieu);

		JMenuItem mntmVePhanMem = new JMenuItem("Về phần mềm");
		mnGioiThieu.add(mntmVePhanMem);

		JMenuItem mntmTacGia = new JMenuItem("Tác giả");
		mnGioiThieu.add(mntmTacGia);
		contentPaneNoiDung = new JPanel();
		contentPaneNoiDung.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPaneNoiDung);
		contentPaneNoiDung.setLayout(new BorderLayout(0, 0));

		JPanel panelHeader = new JPanel();
		contentPaneNoiDung.add(panelHeader, BorderLayout.NORTH);
		panelHeader.setLayout(new BorderLayout(5, 0));
		panelHeader.setPreferredSize(new Dimension(806, 30));

		JPanel panelKichCoFont = new JPanel();
		panelHeader.add(panelKichCoFont, BorderLayout.WEST);
		panelKichCoFont.setLayout(new BorderLayout(0, 0));
		panelKichCoFont.setPreferredSize(new Dimension(100, 10));
		JButton btnCong = new JButton("+");
		panelKichCoFont.add(btnCong, BorderLayout.EAST);

		JButton btnTru = new JButton("-");
		panelKichCoFont.add(btnTru, BorderLayout.WEST);

		textFieldKichCoChu = new JTextField();
		panelKichCoFont.add(textFieldKichCoChu, BorderLayout.CENTER);
		textFieldKichCoChu.setColumns(10);

		JComboBox comboBoxKieuFont = new JComboBox();
		panelHeader.add(comboBoxKieuFont, BorderLayout.EAST);

		Box horizontalBox = Box.createHorizontalBox();
		horizontalBox.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelHeader.add(horizontalBox, BorderLayout.CENTER);

		textFieldTieuDe = new JTextField();
		horizontalBox.add(textFieldTieuDe);
		textFieldTieuDe.setColumns(10);

		JScrollPane scrollPaneCenter = new JScrollPane();
		scrollPaneCenter.setEnabled(true);
		contentPaneNoiDung.add(scrollPaneCenter, BorderLayout.CENTER);

		textAreaNoiDung = new JTextArea();
		textAreaNoiDung.setLineWrap(true);
		textAreaNoiDung.setWrapStyleWord(true);
		scrollPaneCenter.setViewportView(textAreaNoiDung);

		JPanel panelFooter = new JPanel();
		contentPaneNoiDung.add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new BorderLayout(0, 0));

		java.sql.Date ngay = new java.sql.Date(System.currentTimeMillis());
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		String ngayDaFormat = df.format(ngay);
		JLabel lblNgay = new JLabel("Ngày: " + ngayDaFormat);
		panelFooter.add(lblNgay, BorderLayout.EAST);

		JPanel panelThongTin = new JPanel();
		panelFooter.add(panelThongTin, BorderLayout.WEST);

		lblSoTu = new JLabel("Số từ: ");
		panelThongTin.add(lblSoTu, BorderLayout.WEST);
		xuLyThayDoi();

		JLabel lblDongSo = new JLabel("Dòng số: ");
		panelThongTin.add(lblDongSo, BorderLayout.EAST);

		JPanel panelTrangThai = new JPanel();
		panelFooter.add(panelTrangThai, BorderLayout.CENTER);

		lblTrangThai = new JLabel("Trạng thái:");
		panelTrangThai.add(lblTrangThai);
		this.setTitle("Chương trình ghi chú beta v2.0");
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	public void themGhiChuMoi(modelTaiKhoan taiKhoan) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		this.modelTaiKhoanDangTruyCap = taiKhoan;
		modelTaiKhoan modelTaiKhoan = session.get(taiKhoan.getClass(), taiKhoan.getTaiKhoan());
		modelGhiChu modelGhiChu = new modelGhiChu();
		modelGhiChu.setNoiDung("Hãy nhập nội dung tại đây!");
		modelGhiChu.setTieuDe("Hãy nhập tiêu đề tại đây");
		modelGhiChu.setTaiKhoan(modelTaiKhoan);
		modelGhiChu.setChayLanDau(true);
		session.beginTransaction();
		session.save(modelGhiChu);
		session.getTransaction().commit();
		session.close();
	}

	// Lấy nội dung ghi chú đã đc lưu trong db dựa trên kháo ngoại là taiKhoan
	public List<modelGhiChu> layDanhSach() {
		// Tạo truy vấn
		Session session = HibernateUtil.getSessionFactory().openSession();
		CriteriaBuilder builder = session.getCriteriaBuilder();
		CriteriaQuery<modelGhiChu> criteriaQuery = builder.createQuery(modelGhiChu.class);
		Root<modelGhiChu> root = criteriaQuery.from(modelGhiChu.class);
		criteriaQuery = criteriaQuery.select(root);

		Query query = session.createQuery(criteriaQuery);
		List<modelGhiChu> list = query.getResultList();
		session.close();
		return list;
	}

	// Lấy tài khoản đã đăng nhập thành công
	public modelGhiChu layNoiDung(modelTaiKhoan taiKhoan) {
		this.modelTaiKhoanDangTruyCap = taiKhoan;
		for (modelGhiChu md : layDanhSach()) {

			if (md.getTaiKhoan().getTaiKhoan().equals(taiKhoan.getTaiKhoan())) {
				hienThiNoiDung(md);
				this.modelGhiChu = md;
				return md;
			}
		}
		return null;
	}

	public void hienThiNoiDung(modelGhiChu modelGhiChu) {
		textFieldTieuDe.setText(modelGhiChu.getTieuDe());
		textAreaNoiDung.setText(modelGhiChu.getNoiDung());
		kiemTra(modelGhiChu);
		lblSoTu.setText("Số từ: " + textAreaNoiDung.getText().length());
	}

	public void kiemTra(modelGhiChu modelGhiChu) {
		if (textAreaNoiDung.getText().equals("Hãy nhập nội dung tại đây!") && !mntmMoGhiChu.isSelected()
				&& modelGhiChu.isChayLanDau()) {
			xoaDongChuNoiDung();
			modelGhiChu.setChayLanDau(false);
		}
	}

//	Lưu nội dung
	public void luuNoiDung() {
		modelGhiChu modelGhiChu = this.modelGhiChu;
		Session session = HibernateUtil.getSessionFactory().openSession();
		modelGhiChu modelGC = session.get(modelGhiChu.getClass(), modelGhiChu.getId());
		modelGC.setTieuDe(textFieldTieuDe.getText());
		modelGC.setNoiDung(textAreaNoiDung.getText());
		modelGC.setChayLanDau(false);
		modelGC.setTaiKhoan(modelGhiChu.getTaiKhoan());
		session.beginTransaction();
		session.save(modelGC);
		session.getTransaction().commit();
		session.close();
	}

	// Lưu nội dung trong file txt
	public void luuFile() {
		fileController.luuFileVaoDB(fileController.luuFile(modelGhiChu, this), this.modelGhiChu,
				this.modelTaiKhoanDangTruyCap);
	}

	// Đọc nội dung từ file txt
	public void docFile() {
		fileController.docFile(this.modelGhiChu, this, this.modelTaiKhoanDangTruyCap);
	}

	public void xoaFile() {
		fileController.luaChonXoaFile(this, this.modelGhiChu, this.modelTaiKhoanDangTruyCap);
	}

	// Xóa dòng chữ lúc ban đầu khi tạo tài khoản
	public void xoaDongChuNoiDung() {
		textAreaNoiDung.addMouseListener(new MouseAdapter() {
			boolean xoaNoiDung = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (xoaNoiDung) {
					textAreaNoiDung.setText("");
					xoaNoiDung = false;
				}
			}
		});
		textFieldTieuDe.addMouseListener(new MouseAdapter() {
			boolean xoaNoiDung = true;

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				if (xoaNoiDung) {
					textFieldTieuDe.setText("");
					xoaNoiDung = false;
				}
			}
		});
	}

	public void xuLyThayDoi() {
		// Mỗi lần độ dài textArea thay đổi thì sẽ tiến hành cập nhật số từ
		textAreaNoiDung.addFocusListener(new FocusListener() {

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				textAreaNoiDung.getDocument().addDocumentListener(new DocumentListener() {

					@Override
					public void removeUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						lblSoTu.setText("Số từ: " + textAreaNoiDung.getText().length());
						lblTrangThai.setText("Trạng thái: Chưa lưu");
					}

					@Override
					public void insertUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
						lblSoTu.setText("Số từ: " + textAreaNoiDung.getText().length());
						lblTrangThai.setText("Trạng thái: Chưa lưu");
					}

					@Override
					public void changedUpdate(DocumentEvent e) {
						// TODO Auto-generated method stub
					}
				});
			}
		});
	}
}