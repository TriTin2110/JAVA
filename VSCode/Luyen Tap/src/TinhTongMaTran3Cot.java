import java.util.Scanner;

public class TinhTongMaTran3Cot {
        public static void main(String[] args) {
                int row = 2;
                int column = 3;
                int[][] a = { { 1, 2, 3 }, { 4, 5, 6 } };
                int[][] b = { { 7, 8, 9 }, { 10, 11, 12 } };
                tinhTongMaTran(a, b, row, column);
        }
        /**
         * tinhTongMaTran(int[][] a, int[][] b, int row, int column)
         */
        public static void tinhTongMaTran(int[][] a, int[][] b, int row, int column) {
                int[][] sum = new int[row][column];
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                sum[i][j] = a[i][j]+b[i][j];
                        }
                }
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                System.out.print(sum[i][j]+" ");
                        }
                        System.out.println();
                }
        }
}
