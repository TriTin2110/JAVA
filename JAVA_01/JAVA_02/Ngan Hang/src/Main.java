import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static boolean Save(LinkedList<NganHangs> list, String path)
	{
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			ObjectOutputStream oiStream = new ObjectOutputStream(fileOutputStream);
			oiStream.writeObject(list);
			oiStream.close();
			fileOutputStream.close();
			System.out.println("Da luu thanh cong !!!");
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}
	public static LinkedList<NganHangs> Read(String path)
	{
		LinkedList<NganHangs> nganHangs = null;
		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
			Object object = objectInputStream.readObject();
			nganHangs = (LinkedList<NganHangs>) object;
			objectInputStream.close();
			fileInputStream.close();
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return nganHangs;
	}
	static LinkedList<NganHangs> list = new LinkedList<>();
	static QLNH quanly = new QLNH();
	static int menu = 1;
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		while(menu!=0)
		{
			System.out.println();
			System.out.println("1. Tao danh sach khach hang");
			System.out.println("2. Xuat danh sach khach hang");
			System.out.println("3. Tim kiem khach hang");
			System.out.println("4. Sap xep khach hang");
			System.out.println("5. Nap tien");
			System.out.println("6. Rut tien");
			System.out.println("7. Save");
			System.out.println("8. Read");
			System.out.println("0. Thoat");
			System.out.print("Lua chon cua ban la: ");
			menu = scanner.nextInt();
			switch (menu) {
				case 1: {
					quanly.NhapDanhSach(list);
					break;
				}
				case 2: {
					quanly.XuatDanhSach(list);
					break;
				}
				case 3: {
					quanly.TimKiem(list);
					break;
				}
				case 4: {
					quanly.SapXep(list);
					break;
				}
				case 5: {
					quanly.NapTien(list);
					break;
				}
				case 6: {
					quanly.RutTien(list);
					break;
				}
				case 7: {
					Save(list, "D:\\QLNH");
					break;
				}
				case 8: {
					list = Read("D:\\QLNH");
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
