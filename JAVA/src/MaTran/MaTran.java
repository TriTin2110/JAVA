package MaTran;

class MaTran {
	int row, column;
	int[][][] a;

	MaTran(int row, int column, int[][][] a) {
		this.row = row;
		this.column = column;
		this.a = a;
	}

	void xuatMaTran() {
		for (int i = 0; i < a.length; i++) {
			System.out.println("Ma trận thứ " + (i + 1));
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					System.out.print(a[i][j][j2] + "\t");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

	void tinhTongMaTran() {
		int[][] sum = new int[row][column];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					sum[j][j2] += a[i][j][j2];
				}
			}
		}
		for (int j = 0; j < row; j++) {
			for (int j2 = 0; j2 < column; j2++) {
				System.out.print(sum[j][j2] + "\t");
			}
			System.out.println();
		}
	}

	void tinhHieuMaTran() {
		int[][] sum = new int[row][column];
		for (int i = 0; i < 1; i++) {
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					sum[j][j2] = a[i][j][j2];
				}
			}
		}
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < row; j++) {
				for (int j2 = 0; j2 < column; j2++) {
					sum[j][j2] -= a[i][j][j2];
				}
			}
		}
		for (int j = 0; j < row; j++) {
			for (int j2 = 0; j2 < column; j2++) {
				System.out.print(sum[j][j2] + "\t");
			}
			System.out.println();
		}
	}
}
