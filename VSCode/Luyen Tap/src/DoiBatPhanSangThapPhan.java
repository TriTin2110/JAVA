import java.util.Scanner;

public class DoiBatPhanSangThapPhan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int batPhan;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số bát phân bất kỳ: ");
                                batPhan = sc.nextInt();
                        } while (batPhan == 0);
                } catch (Exception e) {
                        System.out.println("Giá trị của số bát phân không hợp lệ!");
                        return;
                }

                String chuoi = Integer.toString(batPhan);
                for (int i = 0; i < chuoi.length(); i++) {
                        if (chuoi.charAt(i) > '7') {
                                System.out.println("Giá trị của số bát phân không hợp lệ");
                                return;
                        }
                }
                output(batPhan);
                sc.close();
        }

        /**
         * output(int batPhan)
         */
        public static void output(int batPhan) {
                int temp = 0;
                int thapPhan = 0;
                int dem = 0;
                boolean kiemTraSoAm = false;
                while (batPhan != 0) {
                        if (batPhan < 0) {
                                batPhan = Math.abs(batPhan);
                                kiemTraSoAm = true;
                        }
                        temp = (batPhan % 10);
                        thapPhan += temp * Math.pow(8, dem);
                        dem++;
                        batPhan /= 10;
                }
                System.out.println((kiemTraSoAm)
                                ? "-" + thapPhan
                                : thapPhan);
        }
}
