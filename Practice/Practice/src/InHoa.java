import java.util.Scanner;

/**
 * InHoa
 */
public class InHoa {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                boolean khoangTrang = true;
                xuLy(chuoi, khoangTrang);
                sc.close();
        }

        /**
         * InnerInHoa
         */
        public static void xuLy(String chuoi, boolean khoangTrang) {
                char[] kyTu = chuoi.toCharArray();
                for (int i = 0; i < chuoi.length(); i++) {
                        if (Character.isLetter(kyTu[i])) {
                                if (khoangTrang == true) {
                                        kyTu[i] = Character.toUpperCase(kyTu[i]);
                                        khoangTrang = false;
                                }
                        }
                        else
                        {
                                khoangTrang = true;
                        }
                }
                chuoi = String.valueOf(kyTu);
                System.out.println(chuoi);
        }
}