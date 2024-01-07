import java.util.Scanner;
public class Test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a, b;
        System.out.print("Hay nhap vao so nguyen a: ");
        a = sc.nextInt();
        System.out.print("Hay nhap so nguyen b: ");
        b = sc.nextInt();
        System.out.printf("%d + %d = %d\n", a, b, a+b);
        System.out.printf("%d - %d = %d\n", a, b, a-b);
        System.out.printf("%d * %d = %d\n", a, b, a*b);
        System.out.printf("%.2f / %.2f = %.2f\n", (float)a, (float)b, (float)a/b);
        System.out.printf("%d %% %d = %d", a, b, a%b);
        sc.close();
    }
}
