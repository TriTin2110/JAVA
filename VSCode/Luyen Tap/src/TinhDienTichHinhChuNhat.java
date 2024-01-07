import java.util.Scanner;

public class TinhDienTichHinhChuNhat {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int dai, rong;
                try {
                        do {
                                System.out.println("Hãy nhập chiều rộng của hình chữ nhật: ");
                                rong = sc.nextInt();
                        } while (rong < 1);
                } catch (Exception e) {
                        System.out.println("Chiều rộng không hợp lệ!");
                        return;
                }
                try {
                        do {
                                System.out.println("Hãy nhập chiều dài của hình chữ nhật: ");
                                dai = sc.nextInt();
                        } while (rong < 1);
                } catch (Exception e) {
                        System.out.println("Chiều dài không hợp lệ!");
                        return;
                }
                inDienTichHinhChuNhat(dai, rong);
                sc.close();
        }
        /**
         * inDienTichHinhChuNhat(int dai, int rong)
         */
        public static void inDienTichHinhChuNhat(int dai, int rong) {   
                System.out.println("Diện tích của hình chữ nhật là: "+(dai * rong));
        }
}
