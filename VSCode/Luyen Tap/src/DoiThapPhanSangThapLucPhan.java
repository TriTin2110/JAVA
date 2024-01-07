import java.util.Scanner;

public class DoiThapPhanSangThapLucPhan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị của số thập phân: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị của số thập phân không hợp lệ!");
                        sc.close();
                        return;
                }
                output(n);
                sc.close();
        }

        /**
         * output(int thapPhan)
         */
        public static void output(int thapPhan) {
                String soThapLucPhan = "";
                char kyTu = ' ';
                out: while (thapPhan != 0) {
                        if (thapPhan % 16 > 9) {
                                switch (thapPhan % 16) {
                                        case 10:
                                                kyTu = 'A';
                                                break;
                                        case 11:
                                                kyTu = 'B';
                                                break;
                                        case 12:
                                                kyTu = 'C';
                                                break;
                                        case 13:
                                                kyTu = 'D';
                                                break;
                                        case 14:
                                                kyTu = 'E';
                                                break;
                                        case 15:
                                                kyTu = 'F';
                                                break;
                                }
                                soThapLucPhan = kyTu + soThapLucPhan;
                                thapPhan /= 16;
                                continue out;
                        }
                        soThapLucPhan = (thapPhan % 16) + soThapLucPhan;
                        thapPhan /= 16;
                }
                System.out.println(soThapLucPhan);
        }
}
