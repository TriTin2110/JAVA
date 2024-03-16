import java.util.Scanner;

public class DoiThoiGianSangSoNguyen {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int gio, phut, giay;
                try {
                        do {
                                System.out.println("Hãy nhập giờ: ");
                                gio = sc.nextInt();
                        } while (gio < 0);
                } catch (Exception e) {
                        System.out.println("Giá trị giờ không hợp lệ!");
                        sc.close();
                        return;
                }

                try {
                        do {
                                System.out.println("Hãy nhập phút: ");
                                phut = sc.nextInt();
                        } while (phut < 0);
                } catch (Exception e) {
                        System.out.println("Giá trị phút không hợp lệ!");
                        sc.close();
                        return;
                }

                try {
                        do {
                                System.out.println("Hãy nhập giây: ");
                                giay = sc.nextInt();
                        } while (giay < 0);
                } catch (Exception e) {
                        System.out.println("Giá trị giây không hợp lệ!");
                        sc.close();
                        return;
                }
                outPut(gio, phut, giay);
                sc.close();
        }

        /**
         * outPut(int gio, int phut, int giay)
         */
        public static void outPut(int gio, int phut, int giay) {
                System.out.println("N = "+((gio*3600)+(phut*60)+giay));
        }
}
