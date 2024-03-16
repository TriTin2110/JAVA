import java.util.LinkedList;
import java.util.Scanner;

public class MainSinhVien {
	public static void main(String[] args) {
		LinkedList<SinhVien> list = new LinkedList<SinhVien>();
		QuanLySinhVien1 quanly = new QuanLySinhVien1();
		Scanner scanner = new Scanner(System.in);
		int menu = 1;
		while(menu != 0)
		{
			System.out.println();
			System.out.println("1. Nhap danh sach sinh vien");
			System.out.println("2. Xuat danh sach sinh vien");
			System.out.println("3. Sap xep danh sach sinh vien (theo diem)");
			System.out.println("4. Sap xep danh sach sinh vien (theo ten)");
			System.out.println("5. Them 1 sinh vien vao danh sach sinh vien ");
			System.out.println("6. Xoa 1 sinh vien ra khoi danh sach sinh vien ");
			System.out.println("7. Chinh sua thong tin cua 1 sinh vien");
			System.out.println("8. Tim kiem sinh vien trong danh sach");
			System.out.println("0. Thoat");
			System.out.print("Lua chon cua ban la: ");
			menu = scanner.nextInt();
			switch(menu)
			{
				case 1:
				{
					quanly.NhapDanhSachSinhVien(list);
					break;
				}
				case 2:
				{
					quanly.XuatDanhSachSinhVien(list);
					break;
				}
				case 3:
				{
					quanly.SapXepTheoDiem(list);
					quanly.XuatDanhSachSinhVien(list);
					break;
				}
				case 4:
				{
					quanly.SapXepTheoTen(list);
					quanly.XuatDanhSachSinhVien(list);
					break;
				}
				case 5:
				{
					quanly.ThemSinhVien(list);
					break;
				}
				case 6:
				{
					quanly.XoaSinhVien(list);
					break;
				}
				case 7:
				{
					quanly.ThayDoiThongTin(list);
					break;
				}
				/*case 8:
				{
					quanly.TimKiem(QuanLySinhVien1.list);
					break;
				}*/
				case 0:
				{
					System.exit(0);
				}
			}
		}
	}
}
