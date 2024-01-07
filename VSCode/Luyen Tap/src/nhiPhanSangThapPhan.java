import java.util.Scanner;

public class nhiPhanSangThapPhan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                long nhiPhan;
                try {
                        do {
                                System.out.println("Hãy nhập số nhị phân: ");
                                nhiPhan = sc.nextLong();
                        } while (nhiPhan == 0);
                } catch (Exception e) {
                        System.out.println("Giá trị số thập phân không lệ!");
                        return;
                }
                String check = Long.toString(nhiPhan);
                for (int i = 0; i < check.length(); i++) {
                        if (check.charAt(i) != '1' && check.charAt(i) != '0' && check.charAt(i) != '-') {
                                System.out.println("Giá trị số thập phân không lệ");
                                return;
                        }
                }
                chuyenDoi(nhiPhan);
                sc.close();
        }

        /**
         * chuyenDoi
         */
        public static void chuyenDoi(long nhiPhan) {
                long temp = 0;
                long thapPhan = 0;
                int soMu = 0;
                boolean check = false;
                while (nhiPhan != 0) {
                        if (nhiPhan < 0) {
                                nhiPhan = Math.abs(nhiPhan);
                                check = true;
                        }
                        temp = nhiPhan % 10;
                        thapPhan += temp * Math.pow(2, soMu);
                        soMu++;
                        nhiPhan /= 10;
                }
                System.out.println((check) ? "-" + thapPhan : thapPhan);
        }
}
