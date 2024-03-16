import java.util.Scanner;

public class ChuViVaDienTichHinhTrong {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int banKinh;
                try {
                        do {
                                System.out.println("Hãy nhập bán kính của hình tròn: ");
                                banKinh = sc.nextInt();
                        } while (banKinh < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị bán kính hình tròn không hợp lệ!");
                        return;
                }
                System.out.printf("Chu vi của hình tròn là: %.2f\n",(2*Math.PI * banKinh));
                System.out.printf("Diện tích của hình tròn là: %.2f",(Math.PI * Math.pow(banKinh, 2)));
        }
}
