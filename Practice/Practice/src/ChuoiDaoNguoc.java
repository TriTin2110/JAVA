import java.util.Scanner;

public class ChuoiDaoNguoc {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                xuLyChuoi(chuoi);
                sc.close();
        }

        /**
         * InnerChuoiDaoNguoc
         */
        public static void xuLyChuoi(String chuoi) {
                String[] chuoiTach = chuoi.split(" ");
                String chuoiKQ = "";
                for (int i = 0; i < chuoiTach.length; i++) {
                        String chuoiDaoNguoc = "";
                        for (int j = chuoiTach[i].length() - 1; j >= 0; j--) {
                                chuoiDaoNguoc += chuoiTach[i].charAt(j);
                        }
                        chuoiKQ += chuoiDaoNguoc + " ";
                }
                System.out.println(chuoiKQ);
        }
}
