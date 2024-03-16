package src;

import java.util.Scanner;

public class NhapTen {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                System.out.println("Hãy nhập tên của bạn: ");
                String ten = sc.nextLine();
                System.out.println(ten);
                sc.close();
        }
}
