import java.util.Scanner;

public class TaoSoNgauNhien {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int n = (int) (Math.random() * 50);
                System.out.println();
                for (int i = 1; i <= n; i++) {
                        int random = (int) (Math.random() * 100);
                        System.out.print(random + "\t");
                        if (i % 10 == 0) {
                                System.out.println("\n");
                        }
                }
        }
}
