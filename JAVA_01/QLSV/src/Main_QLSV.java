import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Main_QLSV{
	public static boolean Save(LinkedList<SinhVien> list, String path)
	{
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
			objectOutputStream.writeObject(list);
			objectOutputStream.close();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public static LinkedList<SinhVien> Read(String path)
	{
		LinkedList<SinhVien> sv = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			sv = (LinkedList<SinhVien>) object;
			objectInputStream.close();
			fileInputStream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return sv;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		QuanLySinhVien quanly = new QuanLySinhVien();
		LinkedList<SinhVien> list = new LinkedList<SinhVien>();
		int menu = 1;
		while(menu!=0)
		{
			System.out.println();
			System.out.println("1. Tao danh sach sinh vien");
			System.out.println("2. Hien thi danh sach sinh vien");
			System.out.println("3. Tim kiem sinh vien");
			System.out.println("4. Them 1 sinh vien vao danh sach sinh vien");
			System.out.println("5. Xoa 1 sinh vien ra khoi danh sach sinh vien");
			System.out.println("6. Chinh sua thong tin 1 sinh vien");
			System.out.println("7. Sap xep sinh vien");
			System.out.println("8. Luu danh sach");
			System.out.println("9. Doc danh sach");
			System.out.println("0. Thoat");
			System.out.println("Hay nhap lua chon cua ban: ");
			menu = scanner.nextInt();
			switch (menu) {
				case 1: {
					quanly.NhapSinhVien(list);
					break;
				}
				case 2: {
					quanly.XuatSinhVien(list);
					break;
				}
				case 3: {
					quanly.TimKiem(list);
					break;
				}
				case 4: {
					quanly.ThemSinhVien(list);
					break;
				}
				case 5: {
					quanly.XoaSinhVien(list);
					break;
				}
				case 6: {
					quanly.ChinhSuaThongTin(list);
					break;
				}
				case 7:
				{
					quanly.SapXep(list);
					break;
				}
				case 8:
				{
					Save(list, "D:\\ListSinhVien.dat");
					break;
				}
				case 9:
				{
					list = Read("D:\\ListSinhVien.dat");
					break;
				}
				case 0: {
					System.exit(0);;
					break;
				}
			}
		}
	}
}
