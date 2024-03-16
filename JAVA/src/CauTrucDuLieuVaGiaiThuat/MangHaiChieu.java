package CauTrucDuLieuVaGiaiThuat;

import java.util.Random;

/**
 * MangHaiChieu
 */
public class MangHaiChieu {
        
        public static void main(String[] args) {
                MangHaiChieu mangHaiChieu = new MangHaiChieu(5);
                mangHaiChieu.xuatMang(mangHaiChieu.mangA);
                mangHaiChieu.xuatMang(mangHaiChieu.mangB);
                // mangHaiChieu.xuatMang(mangHaiChieu.tongMang());
                mangHaiChieu.xuatMang(mangHaiChieu.tichMang());
        }
        
        private int n;
        private int[][] mangA, mangB;

        public MangHaiChieu(int n) {
                this.n = n;
                this.mangA = new int[n][n];
                this.mangB = new int[n][n];
                taoMang();
        }
        
        public void taoMang()
        {
                Random random = new Random();
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                mangA[i][j] = random.nextInt(10);
                                mangB[i][j] = random.nextInt(10);
                        }
                }
        }

        public void xuatMang(int[][] mang)
        {
                System.out.println("--------------------------");
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                System.out.print(mang[i][j] + "\t");
                        }
                        System.out.println();
                }

        }

        public int[][] tongMang()
        {
                int[][] sum = new int[n][n];
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                sum[i][j] = mangA[i][j] + mangB[i][j];
                        }
                }
                return sum;
        }

        public int[][] tichMang()
        {
                int[][] result = new int[n][n];
                for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                                result[i][j] = 0;
                                for (int j2 = 0; j2 < n; j2++) {
                                        result[i][j] += mangA[i][j2] * mangB[j2][j];
                                }
                        }
                }
                return result; 
        }
}