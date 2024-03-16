import java.util.Scanner;

public class PhuongTrinhBacHai {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                double a, b, c;
                try {
                        do {
                                System.out.println("Hãy nhập giá trị a: ");
                                a = sc.nextDouble();
                        } while (a == 0);
                } catch (Exception e) {
                        System.out.println("Giá trị a không hợp lệ!");
                        return;
                }
                try {
                        System.out.println("Hãy nhập giá trị b: ");
                        b = sc.nextDouble();
                } catch (Exception e) {
                        System.out.println("Giá trị b không hợp lệ");
                        return;
                }
                try {
                        System.out.println("Hãy nhập giá trị c: ");
                        c = sc.nextDouble();
                } catch (Exception e) {
                        System.out.println("Giá trị c không hợp lệ");
                        return;
                }
                giaiPT(a, b, c);
                sc.close();
        }
        /**
         * giaiPT(double a, double b, double c)
         */
        public static void giaiPT(double a, double b, double c) {
                double delta = Math.pow(b, 2) - (4*a*c);
                if (delta < 0) {
                        System.out.println("Phương trình vô nghiệm!");
                }
                else if (delta == 0)
                {
                        System.out.println("Phương trình có 1 nghiệm kép:");
                        System.out.println("x0 = "+((-b)/(2*a)));
                }
                else
                {
                        System.out.println("Phương trình có 2 nghiệm!");
                        System.out.println("x1 = "+((-b+Math.sqrt(delta))/(2*a)));
                        System.out.println("x2 = "+((-b-Math.sqrt(delta))/(2*a)));
                }
                
        }
}
