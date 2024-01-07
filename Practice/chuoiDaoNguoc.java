import java.util.Scanner;

/**
 * chuoiDaoNguoc
 */
public class chuoiDaoNguoc {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                xuLy(chuoi);
                sc.close();
        }

        public static void xuLy(String chuoi) {
                String[] chuoiTach = chuoi.split(" ");
                String chuoiKQ = "";
                for (int i = 0; i < chuoiTach.length; i++) {
                        String chuoiDaoNguoc = "";
                        for (int j = chuoiTach[i].length() - 1; j >= 0; j--) {
                                chuoiDaoNguoc = chuoiDaoNguoc + chuoiTach[i].charAt(j);
                        }
                        chuoiKQ += chuoiDaoNguoc + " ";
                }
                System.out.println(chuoiKQ);
        }

}