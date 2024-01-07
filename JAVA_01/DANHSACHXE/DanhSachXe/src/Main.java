import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static boolean Save(LinkedList<BaiXe> list, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutput oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            // TODO: handle exception
        }
        return false;
    }

    public static LinkedList<BaiXe> Read(String path) {
        LinkedList<BaiXe> b = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            b = (LinkedList<BaiXe>) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            // TODO: handle exception
        }
        return b;
    }

    public static void main(String[] args) {
        LinkedList<BaiXe> list = new LinkedList<BaiXe>();
        QuanLi quanLi = new QuanLi();
        Scanner scanner = new Scanner(System.in);
        int menu = 1;
        list = Read("D:\\BX.dat");
        while (menu != 0) {
            System.out.println();
            System.out.println("================***================");
            System.out.println("1. Tao danh sach xe");
            System.out.println("2. Xuat danh sach xe");
            System.out.println("3. Tim kiem");
            System.out.println("4. Them 1 nguoi vao danh sach");
            System.out.println("5. Xoa 1 nguoi ra khoi danh sach");
            System.out.println("6. Thay doi thong tin cua khach");
            System.out.println("9. Luu danh sach xe");
            System.out.println("0. Thoat");
            System.out.print("Lua chon cua ban la: ");
            menu = scanner.nextInt();
            quanLi.SapXepTheoTen(list);
            switch (menu) {
                case 1: {
                    quanLi.NhapDanhSachXe(list);
                    break;
                }
                case 2: {
                    quanLi.XuatDanhSachXe(list);
                    break;
                }
                case 3: {
                    quanLi.TimKiem(list);
                    break;
                }
                case 4: {
                    quanLi.Them(list);
                    break;
                }
                case 5: {
                    quanLi.Xoa(list);
                    break;
                }
                case 6: {
                    quanLi.ThayDoi(list);
                    break;
                }
                case 9: {
                    Save(list, "D:\\BX.dat");
                    break;
                }
                case 0: {
                    System.exit(0);
                }
            }
        }
    }
}
