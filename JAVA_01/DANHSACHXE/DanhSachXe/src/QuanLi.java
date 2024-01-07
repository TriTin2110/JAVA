import java.util.LinkedList;
import java.util.Scanner;

/**
 * QuanLi
 */
public class QuanLi {
    static int n;
    static Scanner scanner = new Scanner(System.in);
    static String hoten;
    static String bienso;
    static String ngay;
    static long sotien;

    public void NhapDanhSachXe(LinkedList<BaiXe> list) {
        System.out.print("Hay nhap so luong xe co trong bai: ");
        n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            scanner.nextLine();
            System.out.println();
            System.out.print("Hay nhap ten cua nguoi thu " + (i + 1) + ": ");
            hoten = scanner.nextLine();
            System.out.print("Hay nhap bien so xe: ");
            bienso = scanner.nextLine();
            System.out.print("Hay nhap ngay gui xe: ");
            ngay = scanner.nextLine();
            System.out.print("Hay nhap so tien xe: ");
            sotien = scanner.nextLong();
            list.add(new BaiXe(hoten, bienso, ngay, sotien));
        }
    }

    public void XuatDanhSachXe(LinkedList<BaiXe> list) {
        System.out.println();
        System.out.printf("%-10s%-30s%-12s%-10s", "Bien So", "Ho Ten", "Ngay Gui", "Tien Gui");
        for (int i = 0; i < list.size(); i++) {
            System.out.println();
            System.out.printf("%-10s%-30s%-12s%-10d", list.get(i).getBienSo(), list.get(i).getHoTen(),
                    list.get(i).getNgayGui(), list.get(i).getTienDong());
        }
    }

    public int TimBienSo(String bs, LinkedList<BaiXe> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(0).getBienSo().compareTo(bs) == 0)
                return i;
            else if (list.get(i).getBienSo().compareTo(bs) == 0)
                return i;
        }
        return -1;
    }

    public void SapXepTheoTen(LinkedList<BaiXe> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j).getTen().compareTo(list.get(i).getTen()) > 0) {
                    BaiXe temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }
    }

    public void TimKiem(LinkedList<BaiXe> list) {
        scanner.nextLine();
        System.out.print("Hay nhap bien so cua nguoi ban muon tim: ");
        String bienso = scanner.nextLine();
        if (TimBienSo(bienso, list) == -1) {
            System.out.println(
                    "Danh sach khong ton tai nguoi co bien so ma ban vua nhap");
        } else {
            System.out.println();
            System.out.println("Da tim thay !!!");
            System.out.printf("%-10s%-30s%-12s%-10s", "Bien So", "Ho Ten", "Ngay Gui", "Tien Gui");
            System.out.println();
            System.out.printf("%-10s%-30s%-12s%-10d", list.get(TimBienSo(bienso, list)).getBienSo(),
                    list.get(TimBienSo(bienso, list)).getHoTen(),
                    list.get(TimBienSo(bienso, list)).getNgayGui(), list.get(TimBienSo(bienso, list)).getTienDong());
        }
    }

    public void Them(LinkedList<BaiXe> list) {
        scanner.nextLine();
        System.out.print("Hay nhap ten cua nguoi gui xe: ");
        hoten = scanner.nextLine();
        System.out.print("Hay nhap bien so xe: ");
        bienso = scanner.nextLine();
        System.out.print("Hay nhap ngay gui xe: ");
        ngay = scanner.nextLine();
        System.out.print("Hay nhap so tien xe: ");
        sotien = scanner.nextLong();
        list.add(new BaiXe(hoten, bienso, ngay, sotien));
    }

    public void Xoa(LinkedList<BaiXe> list) {
        scanner.nextLine();
        System.out.print("Hay nhap bien so cua nguoi ban muon xoa: ");
        String ngmuonxoa = scanner.nextLine();
        if (TimBienSo(ngmuonxoa, list) == -1) {
            System.out.println(
                    "Danh sach khong ton tai nguoi co bien ma ban vua nhap");
        } else {
            list.remove(TimBienSo(ngmuonxoa, list));
            System.out.println("Da xoa thanh cong!!!");
        }
    }

    public void ThayDoi(LinkedList<BaiXe> list) {
        scanner.nextLine();
        System.out.println("Hay nhap bien so xe ma ban muon thay doi thong tin: ");
        String bienso = scanner.nextLine();
        if (TimBienSo(bienso, list) == -1) {
            System.out.println("Danh sach khong ton tai nguoi co bien ma ban vua nhap");
        } else {
            list.remove(TimBienSo(bienso, list));
            System.out.print("Hay nhap ten cua nguoi gui xe: ");
            hoten = scanner.nextLine();
            System.out.print("Hay nhap bien so xe: ");
            bienso = scanner.nextLine();
            System.out.print("Hay nhap ngay gui xe: ");
            ngay = scanner.nextLine();
            System.out.print("Hay nhap so tien xe: ");
            sotien = scanner.nextLong();
            list.add(new BaiXe(hoten, bienso, ngay, sotien));
        }
    }
}