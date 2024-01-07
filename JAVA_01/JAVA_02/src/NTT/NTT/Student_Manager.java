package NTT;

import java.util.Scanner;

/**
 * Student_Manager
 */
public class Student_Manager {
    static int n;
    static Scanner scanner = new Scanner(System.in);
    static Student list[] = new Student[100];

    public void Student_List(Student list[]) {
        System.out.println("INPUT INFORMATION OF STUDENT");
        System.out.print("Hay nhap so luong sinh vien ma ban muon them vao danh sach: ");
        n = scanner.nextInt();
        for (int i = 1; i <= n; i++) {
        	list[i] = new Student();
        	scanner.nextLine();
            System.out.print("\nHay nhap ten cua sinh vien thu " + i + ": ");
            list[i].hoten = scanner.nextLine();
            System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + i + ": ");
            list[i].masosinhvien = scanner.nextLine();
            System.out.print("Hay nhap diem cua sinh vien thu " + i + ": ");
            list[i].diem = scanner.nextDouble();
        }
    }
    public void Output_List(Student list[])
    {
    	for(int i = 1; i<=n; i++)
    	{
    		System.out.println("\nTen cua sinh vien thu "+i+" la: "+list[i].getHOTEN());
    		System.out.println("Ma so cua sinh vien thu "+i+" la: "+list[i].getMSSV());
    		System.out.println("Diem cua sinh vien thu "+i+" la: "+list[i].getDIEM());
    		System.out.println("Ket qua cua sinh vien thu "+i+" la: "+list[i].getKQ());
    	}
    }
}