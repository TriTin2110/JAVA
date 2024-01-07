import java.util.Scanner;

/**
 * Student_manager
 */
public class Student_manager {
    static Student list[] = new Student[100];
    static int n;
    Scanner sc = new Scanner(System.in);

    public void InputList(Student list[]) {
        System.out.println("Hay nhap so luong sinh vien co trong danh sach: ");
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Input sinh vien thu " + (i + 1) + ": ");
            String xau[] = sc.nextLine().split("\\s");
            String name = "";
            for (int j = 1; j < xau.length - 1; j++) {
                name = name.concat(xau[j]);
                Double result = Double.parsedouble(xau[xau.length - 1]);
                Student sinhvien = new student(xau[0], name, result);
            }
        }
    }

    public void OutputList(Student list[]) {
        System.out.printf("%-20s%-20s%-20s%-20s", "Ma", "Ten", "Ket Qua", "Xep Loai");
        for (int i = 0; i < n; i++) {
            System.out.println("%-20s%-30s%-20f%-20s%n", list[i].getID(), list[i].getName(), list[i].getResult(),
                    list[i].getRank());
        }
    }
}