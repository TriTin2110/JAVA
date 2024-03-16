import java.util.Scanner;

/**
 * DoiThapPhanSangBatPhan
 */
public class DoiThapPhanSangBatPhan {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int thapPhan;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị thập phân: ");
                                thapPhan = sc.nextInt();
                        } while (thapPhan < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị bát phân không hợp lệ!");
                        return;
                }
                output(thapPhan);
                sc.close();
        }

        /**
         * output(int thapPhan)
         */
        public static void output(int thapPhan) {
                String batPhan ="";
                while (thapPhan!=0) {
                        batPhan= (thapPhan%8)+batPhan;
                        thapPhan/=8;
                }
                System.out.println(batPhan);
        }
}