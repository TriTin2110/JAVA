import java.util.Scanner;

public class ThapPhanSangNhiPhan {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int thapPhan;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số thập phân: ");
                                thapPhan = sc.nextInt();
                        } while (thapPhan == 0);
                } catch (Exception e) {
                        System.out.println("Giá trị thập phân không hợp lệ!");
                        return;
                }
                chuyenDoi(thapPhan);
                sc.close();
        }
        /**
         * chuyenDoi(int thapPhan)
         */
        public static void chuyenDoi(int thapPhan) {
                String nhiPhan = "";
                boolean check = false;
                while (thapPhan!=0) {
                        if (thapPhan < 0) {
                                thapPhan = Math.abs(thapPhan);
                                check = true;
                        }
                        nhiPhan = (thapPhan%2)+nhiPhan;
                        thapPhan/=2;
                }
                System.out.println((check)?"-"+nhiPhan:nhiPhan);
        }
}
