import java.util.Scanner;

public class TongHaiMaTran {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int row = 2;
                int column = 4;
                int[][] maTranA = { { 1, 1, 1, 1 } /* hàng 0 */, { 2, 3, 5, 2 } /* hàng 1 */ };
                int[][] maTranB = { { 2, 3, 4, 5 }/* hàng 0 */, { 2, 2, 4, -4 } /* hàng 1 */ };
                tinhTong(maTranA, maTranB, row, column);
                sc.close();
        }

        /**
         * tinhTong(int[][] a, int[][] b)
         */
        public static void tinhTong(int[][] a, int[][] b, int row, int column) {
                int[][] sum = new int[row][column];
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                sum[i][j] = a[i][j] + b[i][j];
                        }
                }
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                System.out.print(sum[i][j] + " ");
                        }
                        System.out.println();
                }
        }
}
