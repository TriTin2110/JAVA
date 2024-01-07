import java.util.Scanner;

/**
 * ChuoiDoiXung
 */
public class ChuoiDoiXung {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                xuLyChuoi(chuoi);
                sc.close();
        }
        /**
         * InnerChuoiDoiXung
         */
        public static void xuLyChuoi(String chuoi) {
                String chuoiDoiXung = "";
                for (int i = chuoi.length() - 1; i >= 0; i--) {
                        chuoiDoiXung += chuoi.charAt(i);
                }
                if (chuoi.equals(chuoiDoiXung)) {
                        System.out.println("Chuỗi vừa nhập là chuỗi đối xứng!");
                } else {
                        System.out.println("Chuỗi vừa nhập không phải là chuỗi đối xứng!");
                }
        }
}