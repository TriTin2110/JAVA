package GiaiPTBac2Lambda;

import java.util.Scanner;

public class MainPTBac2 implements interfacePTBac2 {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập a: ");
                double a = sc.nextDouble();
                System.out.println("Hãy nhập b: ");
                double b = sc.nextDouble();
                System.out.println("Hãy nhập c: ");
                double c = sc.nextDouble();

                interfacePTBac2 interfacePTBac2 = (a1, b1, c1) -> {
                        double delta = Math.pow(b1, 2) - (4 * a1 * c1);
                        if (delta < 0)
                                System.out.println("Phương trình vô nghiệm!");
                        else if (delta == 0) {
                                System.out.println("Phương trình có 1 nghiệm kép!");
                                System.out.println("x0 = " + ((-b1) / (2 * a1)));
                        } else {
                                System.out.println("Phương trình có 2 nghiệm phân biệt!");
                                System.out.println("x1 = " + ((-b1 + Math.sqrt(delta)) / (2 * a1)));
                                System.out.println("x2 = " + ((-b1 - Math.sqrt(delta)) / (2 * a1)));
                        }
                };
                interfacePTBac2.giaiPT(a, b, c);
                sc.close();
        }
}
