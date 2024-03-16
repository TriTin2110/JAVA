import java.util.Scanner;

public class SapXepChuoi {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n;
                try {
                        do {
                                System.out.println("Hãy nhập số lượng chuỗi: ");
                                n = sc.nextInt();
                        } while (n<=0);
                } catch (Exception e) {
                        // TODO: handle exception
                }
        }
}
