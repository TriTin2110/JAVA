import java.util.Scanner;

/**
 * NhanHaiSoJava
 */
public class NhanHaiSoJava {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hãy nhập số thứ nhất: ");
                float a = sc.nextFloat();
                System.out.print("Hãy nhập số thứ hai: ");
                float b = sc.nextFloat();
                System.out.println("Tích của hai số vừa nhập là: "+(a*b));
        }
}