import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_KhachHang {
	/*public static boolean Save(LinkedList<KhachHang> list, String path) {
		try {
			FileOutputStream fos = new FileOutputStream(path);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(list);
			oos.close();
			fos.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}*/
public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);
	LinkedList<KhachHang> list = new LinkedList<KhachHang>();
	QuanLyKhachHang quanLy = new QuanLyKhachHang();
	int menu = 1;
		while(menu!=0)
		{
			System.out.println();
			System.out.println("1. Nhap danh sach khach hang");
			System.out.println("2. Xuat danh sach khach hang");
			System.out.println("3. Tim kiem khach hang");
			System.out.println("4. Nap tien");
			System.out.println("5. Rut tien");
			System.out.println("6. Sap xep");
			System.out.println("0. Thoat");
			System.out.print("Lua chon cua ban la: ");
			menu = scanner.nextInt();
			switch (menu) {
				case 1: {
					quanLy.NhapThongTin(list);
					break;
				}
				case 2: {
					quanLy.XuatDanhSach(list);
					break;
				}
				case 3: {
					quanLy.TimKiem(list);
					break;
				}
				case 4: {
					quanLy.napTien(list);
					break;
				}
				case 5: {
					quanLy.rutTien(list);
					break;
				}
				case 6: {
					quanLy.SapXepTheoID(list);
					break;
				}
				case 0: {
					System.exit(0);
					break;
				}
			}
		}
	}
}
