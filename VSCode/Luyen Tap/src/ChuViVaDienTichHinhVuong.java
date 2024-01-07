import java.util.Scanner;

public class ChuViVaDienTichHinhVuong {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int canh;
                try {
                        do {
                                System.out.println("Hãy nhập độ dài cạnh hình vuông: ");
                                canh = sc.nextInt();
                        } while (canh < 1);
                } catch (Exception e) {
                        System.out.println("Chiều dài cạnh của hình vuông không hợp lệ!");
                        return;
                }
                System.out.println("Chu vi của hình vuông là: "+(canh * 4));
                System.out.println("Diện tích của hình vuông là: "+(canh*canh));
                sc.close();
        }
}
