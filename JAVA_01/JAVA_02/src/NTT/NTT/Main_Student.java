package NTT;

import java.util.List;
import java.util.Scanner;

public class Main_Student {
    public static void main(String[] args) {
        Student_Manager manager = new Student_Manager();
        int menu = 1;
        while (menu != 0) {
            System.out.println("=========== DANH SACH SINH VIEN ===========");
            System.out.println("1. Nhap danh sach sinh vien");
            System.out.println("2. Xuat danh sach sinh vien");
            System.out.println("0. Thoat");
            do {
                System.out.println("Moi ban nhap lua chon: ");
                menu = Student_Manager.scanner.nextInt();
            } while (menu > 2 || menu < 0);
            switch (menu) {
                case 1: {
                    manager.Student_List(Student_Manager.list);
                    break;
                }
                case 2: {
                    manager.Output_List(Student_Manager.list);
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        }
    }
}
