import java.util.Scanner;

public class TinhTongHaiMaTran {
        public static void main(String[] args) {
                int row = 2;
                int column = 4;
                int[][] a = {{1,2,3,4}, {5,6,7,8}};
                int[][] b = {{2,5,8,1}, {1,0,4,2}};
                tinhTong(row, column, a, b);
        }
        /**
         * tinhTong(int row, int column, int[][] a, int[][] b)
         */
        public static void tinhTong(int row, int column, int[][] a, int[][] b) {
                int[][] sum = new int[row][column];
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                sum[i][j] = a[i][j] + b[i][j];
                        }
                }
                for (int i = 0; i < row; i++) {
                        for (int j = 0; j < column; j++) {
                                System.out.print(sum[i][j]+"\t");
                        }
                        System.out.println();
                }
        }
}
