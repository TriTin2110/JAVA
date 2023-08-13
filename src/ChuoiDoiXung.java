import java.util.Scanner;

public class ChuoiDoiXung {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                chuoiDX(chuoi);
                sc.close();
        }

        /**
         * ChuoiDoiXung
         */
        public static void chuoiDX(String chuoi) {
                String chuoiDoiXung = "";
                for (int i = chuoi.length() - 1; i >= 0; i--) {
                        chuoiDoiXung += chuoi.charAt(i);
                }
                System.out.println((chuoi.equals(chuoiDoiXung))
                                ? "Chuỗi vừa nhập là chuỗi đối xứng!"
                                : "Chuỗi vừa nhập không phải là chuỗi đối xứng!");
        }
}
