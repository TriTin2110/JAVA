import java.util.Scanner;

public class InHoa {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
                String chuoi = sc.nextLine();
                inHoa(chuoi);
                sc.close();
        }

        /**
         * InnerInHoa
         */
        public static void inHoa(String chuoi) {
                boolean khoangTrang = true;
                char[] kyTu = chuoi.toCharArray();
                for (int i = 0; i < chuoi.length(); i++) {
                        if (Character.isLetter(kyTu[i])) {
                                if (khoangTrang) {
                                        kyTu[i] = Character.toUpperCase(kyTu[i]);
                                        khoangTrang = false;
                                }
                        } else {
                                khoangTrang = true;
                        }
                }
                System.out.println(chuoi.valueOf(kyTu));
        }
}
