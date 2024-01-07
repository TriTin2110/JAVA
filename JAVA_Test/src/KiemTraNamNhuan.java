import java.util.Scanner;

/**
 * KiemTraNamNhuan
 */
public class KiemTraNamNhuan {

        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 nam bat ky: ");
                int nam = sc.nextInt();
                if(nam%4==0 && nam%100!=0)
                {
                        System.out.println(nam+" la nam nhuan");
                }
                else
                {
                        System.out.println(nam + " khong phai la nam nhuan");
                }
        }
}