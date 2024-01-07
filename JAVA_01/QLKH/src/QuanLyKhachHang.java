import java.util.LinkedList;
import java.util.Scanner;

public class QuanLyKhachHang {
	static int n;
	static String tenKH, maKH;
	static long taiKhoanKH;
	Scanner scanner = new Scanner(System.in);
	public void NhapThongTin(LinkedList<KhachHang> list) {
		System.out.print("Hay nhap so luong khach hang co trong danh sach: ");
		n = scanner.nextInt();
		for(int i =0; i<n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ho ten cua khach hang thu "+(i+1)+": ");
			tenKH = scanner.nextLine();
			System.out.print("Hay nhap ma cua khach hang thu "+(i+1)+": ");
			maKH = scanner.nextLine();
			System.out.println("Hay nhap tai khoan cua khach hang thu "+(i+1)+": ");
			taiKhoanKH = scanner.nextLong();
			list.add(new KhachHang(tenKH, maKH, taiKhoanKH));
			System.out.println();
		}
	}
	public void XuatDanhSach(LinkedList<KhachHang> list) {
		System.out.println();
		System.out.println();
		System.out.printf("%-15s%-30s%-15s%-15s", "MKH", "Ho Ten", "Tai Khoan", "Loai");
		for(int i =0; i<list.size(); i++)
		{
			System.out.println();
			System.out.printf("%-15s%-30s%-15s%-15s", list.get(i).getMaSo(), list.get(i).getHoTen(), list.get(i).getTaiKhoan(), list.get(i).getPhanLoai());
		}
	}
	public int TimID(LinkedList<KhachHang> list, String id) {
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).getMaSo().compareTo(id)==0)
				return i;
		}
		return -1;
	}
	public void TimKiem(LinkedList<KhachHang> list)
	{
		System.out.println();
		scanner.nextLine();
		System.out.println("Hay nhap ma so khach hang ma ban muon tim kiem: ");
		String maTimString = scanner.nextLine();
		if(TimID(list, maTimString)==-1)
			System.out.println("Khach hang ma ban can tim khong ton tai trong danh sach !!!");
		else {
			System.out.printf("%-15s%-30s%-15s%-15s", "MKH", "Ho Ten", "Tai Khoan", "Loai");
			System.out.println();
			System.out.printf("%-15s%-30s%-15s%-15s", list.get(TimID(list, maTimString)).getMaSo(), list.get(TimID(list, maTimString)).getHoTen(), list.get(TimID(list, maTimString)).getTaiKhoan(), list.get(TimID(list, maTimString)).getPhanLoai());
		}
	}
	public void SapXepTheoID(LinkedList<KhachHang> list) {
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				if(list.get(i).getMaSo().compareTo(list.get(j).getMaSo())==-1)
				{
					KhachHang tempHang = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tempHang);
				}
			}
		}
	}
	public void napTien(LinkedList<KhachHang> list) {
		scanner.nextLine();
		System.out.println();
		System.out.print("Nhap ma khach hang ma ban muon nap tien: ");
		String maString = scanner.nextLine();
		if(TimID(list, maString)==-1)
		{
			System.out.println("Khach hang khong ton tai trong danh sach !!!");
		}
		else {
			System.out.print("Hay nhap so tien ma ban muon nap: ");
			long tiennap = scanner.nextLong();
			for(int i = 0; i<list.size(); i++)
			{
				if(maString.compareTo(list.get(i).masoKH)==0)
				{
					list.get(i).taiKhoan += tiennap;
				}
			}
		}
	}
	public void rutTien(LinkedList<KhachHang> list) {
		scanner.nextLine();
		System.out.println();
		System.out.print("Nhap ma khach hang ma ban muon rut tien: ");
		String maString = scanner.nextLine();
		if(TimID(list, maString)==-1)
		{
			System.out.println("Khach hang khong ton tai trong danh sach !!!");
		}
		else {
			System.out.print("Hay nhap so tien ma ban muon rut: ");
			long tienrut = scanner.nextLong();
			for(int i = 0; i<list.size(); i++)
			{
				if(maString.compareTo(list.get(i).masoKH)==0)
				{
					list.get(i).taiKhoan -= tienrut;
				}
			}
		}
	}	
}
