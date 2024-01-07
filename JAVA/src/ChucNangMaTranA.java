
class ChucNangMaTranA {
	private int[][] maTran;
	private int row, column;

	public ChucNangMaTranA(int[][] maTran, int row, int column) {
		// TODO Auto-generated constructor stub
		this.maTran = maTran;
		this.row = row;
		this.column = column;
	}

//Tìm phần tử lớn nhất
	void timPhanTuLonNhat() {
		int phanTuLonNhat = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				phanTuLonNhat = (phanTuLonNhat < maTran[i][j]) ? maTran[i][j] : phanTuLonNhat;
			}
		}
		System.out.println("Phần tử lớn nhất của ma trận là: " + phanTuLonNhat);
	}

//In phần tử là số nguyên tố
	int[] timSoNguyenTo() {
		int[] soNguyenTo = new int[row * column];
		int dem = 0;
		for (int i = 0; i < row; i++) {
			col: for (int j = 0; j < column; j++) {
				boolean kiemTraSoNguyenTo = true;
				if (maTran[i][j] == 2) {
					soNguyenTo[dem] = maTran[i][j];
					dem++;
				} else if (maTran[i][j] == 1) {
					continue col;
				}
				for (int j2 = 2; j2 < maTran[i][j]; j2++) {
					if (maTran[i][j] % j2 == 0) {
						kiemTraSoNguyenTo = false;
						continue col;
					}
				}
				if (kiemTraSoNguyenTo == true) {
					for (int h = 0; h < soNguyenTo.length; h++) {
						if (maTran[i][j] == soNguyenTo[h]) {
							continue col;
						}
					}
					soNguyenTo[dem] = maTran[i][j];
					dem++;
				}
			}
		}
		return soNguyenTo;
	}

	void inSoNguyenTo() {
		System.out.println("Các số nguyên tố có trong ma trận là:");
		for (int i : timSoNguyenTo()) {
			System.out.print((i != 0) ? i + "\t" : "");
		}
		System.out.println();
	}

//Sắp xếp tăng dần theo cột
	void sapXepTangDanTheoCot() {
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row - 1; j++) {
				for (int j2 = j + 1; j2 < row; j2++) {
					maTran[j][i] = (maTran[j][i] > maTran[j2][i]) ? hoanDoi(maTran[j2][i], maTran[j2][i] = maTran[j][i])
							: maTran[j][i];
				}
			}
		}
		System.out.println("Ma trận sau khi được sắp xếp theo thứ tự tăng dần của cột là:");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(maTran[i][j] + "\t");
			}
			System.out.println();
		}
	}

	int hoanDoi(int a, int b) {
		return a;
	}

//void TimCotCoNhieuSoNguyenTo
	// cotNT = tim cot co so nguyen to lon nhat
	// tim cot co so nguyen to = cotNT
	// In ra cot

	void timCotCoNhieuSoNguyenTo() {
		System.out.println("Cột có nhiếu số nguyên tố nhất là:");
		int soNguyenTo[] = new int[column];
		int dem = 0;
		for (int i = 0; i < column; i++) {
			for (int j = 0; j < row; j++) {
				for (int h : timSoNguyenTo()) {
					if (maTran[j][i] == h)
						soNguyenTo[dem]++;

				}
			}
			dem++;
		}
		int soNTLN = 0;
		for (int i = 0; i < soNguyenTo.length; i++) {
			soNTLN = (soNTLN < soNguyenTo[i]) ? soNguyenTo[i] : soNTLN;
		}
		for (int i = 0; i < column; i++) {
			int demLX = 0;
			int cot = i;
			for (int j = 0; j < row; j++) {
				for (int h : timSoNguyenTo()) {
					if (maTran[j][i] == h)
						demLX++;
				}
			}
			if (demLX == soNTLN) {
				for (int j2 = 0; j2 < row; j2++) {
					System.out.println(maTran[j2][cot]);
				}
			}
		}
	}
}
