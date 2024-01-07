import java.util.Scanner;

/**
 * SapXepChuoi
 */
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
                        System.out.println("Số lượng chuỗi không hợp lệ!");
                        return;
                }
                sc.nextLine();
                String[] chuoi = new String[n];
                for (int i = 0; i < n; i++) {
                        System.out.println("Hãy nhập chuỗi thứ "+(i+1)+": ");
                        chuoi[i] = sc.nextLine();
                }
                sapXep(chuoi, n);
                sc.close();
        }
        /**
         * InnerSapXepChuoi
         */
        public static void sapXep(String[] chuoi, int n) {
                String temp = "";
                for (int i = 0; i < n-1; i++) {
                        for (int j = i+1; j < n; j++) {
                                if (chuoi[i].compareTo(chuoi[j]) > 0) {
                                        temp = chuoi[i];
                                        chuoi[i] = chuoi[j];
                                        chuoi[j] = temp;
                                }
                        }
                }
                for (int i = 0; i < n; i++) {
                        System.out.println(chuoi[i]);
                }
        }
}