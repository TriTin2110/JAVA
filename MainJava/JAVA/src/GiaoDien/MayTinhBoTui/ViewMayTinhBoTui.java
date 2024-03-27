package GiaoDien.MayTinhBoTui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ViewMayTinhBoTui extends JFrame {
	ModelMayTinhBoTui modelMayTinhBoTui = new ModelMayTinhBoTui();
	JLabel jLabelKetQua = new JLabel(" ");
	String hienThi = "";
	boolean daCoGiaTri = false;
	boolean nhapKyTuDelSauKhiCoGiaTri = false;
	String phepTinh = "";
	int kiemTra = 0;
	int thuTuCuaPhepTinh = 0;

	public ViewMayTinhBoTui() {
		jLabelKetQua.setLayout(new FlowLayout(FlowLayout.RIGHT));
		this.setLayout(new BorderLayout(10, 50));
		this.init();
		this.setVisible(true);
	}

	void setFontKetQua() {
		Font font = new Font("Times new roman", Font.BOLD, 30);
		jLabelKetQua.setFont(font);
		this.add(jLabelKetQua, BorderLayout.NORTH);
	}

	void setButton() {
		// Set ActionListener
		ControllerMayTinhBoTui controllerMayTinhBoTui = new ControllerMayTinhBoTui(this);
		Font font = new Font("Times new roman", Font.BOLD, 30);
		JPanel jPanelButton = new JPanel(new GridLayout(7, 3, 10, 10));
		JButton jButton1 = new JButton("1");
		jPanelButton.add(jButton1);
		jButton1.setFont(font);
		jButton1.addActionListener(controllerMayTinhBoTui);

		JButton jButton2 = new JButton("2");
		jPanelButton.add(jButton2);
		jButton2.setFont(font);
		jButton2.addActionListener(controllerMayTinhBoTui);

		JButton jButtonCong = new JButton("+");
		jPanelButton.add(jButtonCong);
		jButtonCong.setFont(font);
		jButtonCong.addActionListener(controllerMayTinhBoTui);

		JButton jButton3 = new JButton("3");
		jPanelButton.add(jButton3);
		jButton3.setFont(font);
		jButton3.addActionListener(controllerMayTinhBoTui);

		JButton jButton4 = new JButton("4");
		jPanelButton.add(jButton4);
		jButton4.setFont(font);
		jButton4.addActionListener(controllerMayTinhBoTui);

		JButton jButtonTru = new JButton("-");
		jPanelButton.add(jButtonTru);
		jButtonTru.setFont(font);
		jButtonTru.addActionListener(controllerMayTinhBoTui);

		JButton jButton5 = new JButton("5");
		jPanelButton.add(jButton5);
		jButton5.setFont(font);
		jButton5.addActionListener(controllerMayTinhBoTui);

		JButton jButton6 = new JButton("6");
		jPanelButton.add(jButton6);
		jButton6.setFont(font);
		jButton6.addActionListener(controllerMayTinhBoTui);

		JButton jButtonNhan = new JButton("*");
		jPanelButton.add(jButtonNhan);
		jButtonNhan.setFont(font);
		jButtonNhan.addActionListener(controllerMayTinhBoTui);

		JButton jButton7 = new JButton("7");
		jPanelButton.add(jButton7);
		jButton7.setFont(font);
		jButton7.addActionListener(controllerMayTinhBoTui);

		JButton jButton8 = new JButton("8");
		jPanelButton.add(jButton8);
		jButton8.setFont(font);
		jButton8.addActionListener(controllerMayTinhBoTui);

		JButton jButtonChia = new JButton("/");
		jPanelButton.add(jButtonChia);
		jButtonChia.setFont(font);
		jButtonChia.addActionListener(controllerMayTinhBoTui);

		JButton jButton9 = new JButton("9");
		jPanelButton.add(jButton9);
		jButton9.setFont(font);
		jButton9.addActionListener(controllerMayTinhBoTui);

		JButton jButton0 = new JButton("0");
		jPanelButton.add(jButton0);
		jButton0.setFont(font);
		jButton0.addActionListener(controllerMayTinhBoTui);

		JButton jButtonLuyThua = new JButton("^");
		jPanelButton.add(jButtonLuyThua);
		jButtonLuyThua.setFont(font);
		jButtonLuyThua.addActionListener(controllerMayTinhBoTui);

		JButton jButtonCan = new JButton("√");
		jPanelButton.add(jButtonCan);
		jButtonCan.setFont(font);
		jButtonCan.addActionListener(controllerMayTinhBoTui);

		JButton jButtonAC = new JButton("AC");
		jPanelButton.add(jButtonAC);
		jButtonAC.setFont(font);
		jButtonAC.addActionListener(controllerMayTinhBoTui);

		JButton jButtonDEL = new JButton("DEL");
		jPanelButton.add(jButtonDEL);
		jButtonDEL.setFont(font);
		jButtonDEL.addActionListener(controllerMayTinhBoTui);

		JButton jButtonBang = new JButton("=");
		jPanelButton.add(jButtonBang);
		jButtonBang.setFont(font);
		jButtonBang.addActionListener(controllerMayTinhBoTui);

		this.add(jPanelButton, BorderLayout.CENTER);
	}

	void init() {
		this.setTitle("Máy tính bỏ túi!");
		this.setSize(300, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setFontKetQua();
		this.setButton();
	}

	void phepTinhKhongHopLe() {
		this.jLabelKetQua.setText(hienThi);
	}

	void hienThi(String jButtonKyTuNhap) {
		boolean check = false;

		// Kiểm tra ký tự đã tồn tại trên phần hiển thị chưa
		if (chuaKyTu(jButtonKyTuNhap) && !Character.isDigit(jButtonKyTuNhap.charAt(0))) {
			check = true;
		}
		if (check) {
// Tồn tại rồi thì sẽ không thêm vào
			this.hienThi += "";
			this.jLabelKetQua.setText(hienThi);
		} else {
// Nếu lựa chọn không phải Del thì thêm vào
			if (jButtonKyTuNhap != "DEL") {
// Hiển thị ra màn hình cho lần tiếp theo
				if (daCoGiaTri) {
// Khi người dùng nhập ký tự Del và biến ketQua != null
					if (nhapKyTuDelSauKhiCoGiaTri == true) {
// Chỉ chấp nhận số và không chấp nhận phép toán
						if (chuaKyTu(jButtonKyTuNhap) == true && Character.isDigit(jButtonKyTuNhap.charAt(0))) {
							this.hienThi += jButtonKyTuNhap;
							this.jLabelKetQua.setText(hienThi);
							daCoGiaTri = false;
						}

					} else {
						if (this.kiemTra > 0) {
							this.hienThi += jButtonKyTuNhap;

						} else {
							this.resetGiaTri();
							this.hienThi = this.modelMayTinhBoTui.getKetQua() + jButtonKyTuNhap;
						}
						this.jLabelKetQua.setText(hienThi);
						daCoGiaTri = false;

					}
					// Hiển thị ra màn hình lần đầu
				} else {
					this.hienThi += jButtonKyTuNhap;
					this.jLabelKetQua.setText(hienThi);
				}

			}
		}
	}

	void xuatKetQua() {
		// lấy giá trị từ đầu chuỗi cho đến phép tính
		Double gt1 = Double.valueOf(hienThi.substring(0, thuTuCuaPhepTinh));
		// lấy giá trị từ sau phép tính đến cuối chuỗi
		Double gt2 = Double.valueOf(hienThi.substring(thuTuCuaPhepTinh + 1, hienThi.length()));
		double giaTri1 = gt1;
		double giaTri2 = gt2;
		this.modelMayTinhBoTui.setGiaTri1(giaTri1);
		this.modelMayTinhBoTui.setGiaTri2(giaTri2);

		switch (phepTinh) {
		case "+":
			jLabelKetQua.setText(this.modelMayTinhBoTui.phepCong() + "");
			break;
		case "-":
			jLabelKetQua.setText(this.modelMayTinhBoTui.phepTru() + "");
			break;
		case "*":
			jLabelKetQua.setText(this.modelMayTinhBoTui.phepNhan() + "");
			break;
		case "/":
			jLabelKetQua.setText(this.modelMayTinhBoTui.phepChia() + "");
			break;
		case "^":
			jLabelKetQua.setText(this.modelMayTinhBoTui.tinhLuyThua() + "");
			break;
		case "√":
			if (giaTri1 == 2) {
				jLabelKetQua.setText(this.modelMayTinhBoTui.tinhCanBac2() + "");
				break;
			} else if (giaTri1 == 3) {
				jLabelKetQua.setText(this.modelMayTinhBoTui.tinhCanBac3() + "");
				break;
			} else {
				jLabelKetQua.setText(this.modelMayTinhBoTui.getGiaTri2() + "");
				break;
			}

		}
		kiemTra = 0;
		nhapKyTuDelSauKhiCoGiaTri = false;
		daCoGiaTri = true;
	}

	// Kiểm tra phần hiển thị đã xuất hiện phép toán nào hay chưa
	boolean chuaKyTu(String jButtonKyTuNhap) {
		boolean daChua = false;
		String[] cacPhepTinh = { "+", "-", "*", "/", "^", "√" };
		out: for (String string : cacPhepTinh) {
			if (hienThi.contains(string)) {
				// Nếu chứa phép tính thì sẽ đặt phepTinh = string
				if (hienThi.indexOf("-") == 0 && string.equals("-")) {
					continue out;
				}
				this.phepTinh = string;
				thuTuCuaPhepTinh = hienThi.indexOf(string);
				// Nếu hiển thị đã chứa 1 phép toán bất kỳ rồi thì sẽ trả về true và thoát khỏi
				// vòng lặp
				if (daCoGiaTri == false) {
					daChua = true;
					break out;
				}

				else if (nhapKyTuDelSauKhiCoGiaTri == true) {
					daChua = true;
					break out;
				}
			}
		}
		return daChua;
	}

	void resetGiaTri() {
		this.hienThi = "";
		jLabelKetQua.setText(hienThi);
	}

	void xoaGiaTri() {

		Double giaTri = this.modelMayTinhBoTui.getKetQua();
		String temp = hienThi;
		hienThi = "";
		for (int i = 0; i < temp.length() - 1; i++) {
			hienThi += temp.charAt(i);
		}
		jLabelKetQua.setText(hienThi);
		if (giaTri != null && kiemTra == 0) {
			nhapKyTuDelSauKhiCoGiaTri = true;
			kiemTra++;
		} else {
			nhapKyTuDelSauKhiCoGiaTri = false;
		}
	}
}
