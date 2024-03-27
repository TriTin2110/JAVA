import java.util.Scanner;

class TinhTongBaMaTran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[2][4];
		int[][] b = new int[2][4];
		int[][] c = new int[2][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Hãy nhập ma trận a giá trị dòng " + (i + 1) + " cột " + (j + 1) + ": ");
				a[i][j] = sc.nextInt();
			}
		}
		System.out.println();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Hãy nhập ma trận b giá trị dòng " + (i + 1) + " cột " + (j + 1) + ": ");
				b[i][j] = sc.nextInt();
			}
		}
		System.out.println();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Hãy nhập ma trận c giá trị dòng " + (i + 1) + " cột " + (j + 1) + ": ");
				c[i][j] = sc.nextInt();
			}
		}
		outPut(a, b, c);
		sc.close();
	}

	static void outPut(int[][] a, int[][] b, int[][] c) {
		int[][] sum = new int[2][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				sum[i][j] = a[i][j] + b[i][j] + c[i][j];
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(sum[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
