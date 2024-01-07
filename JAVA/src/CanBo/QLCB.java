package CanBo;

import java.util.Scanner;

class QLCB {

	Scanner sc = new Scanner(System.in);
	CanBo[] cb = new CanBo[1];
	int n;

	void themDanhSachCanBo(int n) {
		this.n = n;
		cb = new CanBo[n];
		String name, gioiTinh, diaChi;
		int tuoi;
		for (int i = 0; i < n; i++) {
			System.out.println();
			System.out.println("Hãy nhập tên của cán bộ thứ " + (i + 1) + ": ");
			name = sc.nextLine();
			System.out.println("Hãy nhập giới tính của cán bộ thứ " + (i + 1) + ": ");
			gioiTinh = sc.nextLine();
			System.out.println("Hãy nhập địa chỉ của cán bộ thứ " + (i + 1) + ": ");
			diaChi = sc.nextLine();
			try {
				do {
					System.out.println("Hãy nhập tuổi của cán bộ thứ " + (i + 1) + ": ");
					tuoi = sc.nextInt();
				} while (tuoi < 1);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Tuổi của cán bộ không hợp lệ!");
				sc.close();
				return;
			}
			cb[i] = new CanBo(name, gioiTinh, diaChi, tuoi);
			sc.nextLine();
			System.out.println("--------------------------");
		}
	}

	void inThongTinDanhSach() {
		for (int i = 0; i < n; i++) {
			System.out.println("Tên của cán bộ thứ " + (i + 1) + " là: " + cb[i].getName());
			System.out.println("Giới tính của cán bộ thứ " + (i + 1) + " là: " + cb[i].getGioiTinh());
			System.out.println("Địa chỉ của cán bộ thứ " + (i + 1) + " là: " + cb[i].getDiaChi());
			System.out.println("Tuổi của cán bộ thứ " + (i + 1) + " là: " + cb[i].getTuoi());
			System.out.println("\n-------------------\n");
		}
	}
}
