import java.util.Scanner;

public class ChuyenSoThapLucPhanSangThapPhan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                String thapLucPhan;
                System.out.println("Hãy nhập giá trị thập lục phân: ");
                thapLucPhan = sc.nextLine();
                for (int i = 0; i < thapLucPhan.length(); i++) {
                        if (thapLucPhan.charAt(i) > 'F' || thapLucPhan.charAt(i) < 'A'
                                        && !Character.isDigit(thapLucPhan.charAt(i))) {
                                System.out.println("Giá trị đầu vào không hợp lệ!");
                                sc.close();
                                return;
                        }
                }
                output(thapLucPhan);
                sc.close();
        }

        /**
         * output(String thapLucPhan)
         */
        public static void output(String thapLucPhan) {
                int thapPhan = 0;
                out: for (int i = 0; i < thapLucPhan.length(); i++) {
                        thapPhan *= 16;
                        if (Character.isAlphabetic(thapLucPhan.charAt(i))) {
                                switch (thapLucPhan.charAt(i)) {
                                        case 'A':
                                                thapPhan += 10;
                                                break;
                                        case 'B':
                                                thapPhan += 11;
                                                break;
                                        case 'C':
                                                thapPhan += 12;
                                                break;
                                        case 'D':
                                                thapPhan += 13;
                                                break;
                                        case 'E':
                                                thapPhan += 14;
                                                break;
                                        case 'F':
                                                thapPhan += 15;
                                                break;
                                }
                                continue out;
                        } else
                                thapPhan += thapLucPhan.charAt(i) - '0';
                }
                System.out.println(thapPhan);
        }
}
