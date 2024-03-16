import java.util.Scanner;

public class KiemTraSoDoiXung {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập 1 số nguyên bất kỳ: ");
                                n = sc.nextInt();
                        } while (n < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị vừa nhập không hợp lệ!");
                        return;
                }
                kiemTraSo(n);
                sc.close();
        }
        /**
         * kiemTraSo(int n)
         */
        public static void kiemTraSo(int n) {
                String chuoi = Integer.toString(n);
                String soDoiXung = "";
                for (int i = chuoi.length() - 1; i>=0; i--) {
                        soDoiXung += chuoi.charAt(i);
                }
                System.out.println((chuoi.equals(soDoiXung))
                                ?"Số vừa nhập là số đối xứng!"
                                :"Số vừa nhập không phải là số đối xứng!");
        }
}
