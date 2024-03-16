import java.util.Scanner;

class TinhTongHaiMaTran {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[][] a = new int[2][4];
		int[][] b = new int[2][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Hãy nhập ma trận a giá trị tại hàng " + (i + 1) + " cột " + (j + 1) + ": ");
				a[i][j] = sc.nextInt();
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print("Hãy nhập ma trận b giá trị tại hàng " + (i + 1) + " cột " + (j + 1) + ": ");
				b[i][j] = sc.nextInt();
			}
		}
		System.out.println();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(b[i][j] + "\t");
			}
			System.out.println();
		}
		output(a, b);
		sc.close();
	}

	static void output(int[][] a, int[][] b) {
		System.out.println();
		int[][] sum = new int[2][4];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				sum[i][j] = a[i][j] + b[i][j];
			}
		}
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(sum[i][j] + "\t");
				;
			}
			System.out.println();
		}
	}
}
