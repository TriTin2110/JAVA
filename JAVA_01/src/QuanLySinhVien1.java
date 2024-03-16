import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class QuanLySinhVien1 {
	static int n;
	Scanner scanner = new Scanner(System.in);
	String tenString;
	String maString;
	double diem;
	public void NhapDanhSachSinhVien(LinkedList<SinhVien> list) {
		int kiemtra = 0;
		System.out.print("Nhap so luong sinh vien co trong danh sach: ");
		n = scanner.nextInt();
		for(int i =0; i<n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ten cua sinh vien thu "+(i+1)+": ");
			tenString = scanner.nextLine();
			do {
				kiemtra = 0;
				System.out.print("Hay nhap ma so cua sinh vien thu "+(i+1)+": ");
				maString = scanner.nextLine();
				for(int j = 0; i<i; j++)
				{
					if(maString.compareTo(list.get(j).maso)==0)
					{
						kiemtra++;
					}
				}
			} while (kiemtra>0);
			System.out.print("Hay nhap diem cua sinh vien thu "+(i+1)+": ");
			diem = scanner.nextDouble();
			list.add(new SinhVien(tenString, maString, diem));
		}
	}
	public void XuatDanhSachSinhVien(LinkedList<SinhVien> list) {
		System.out.println();
		System.out.printf("%-15s%-30s%-8s%-30s", "MSSV", "Ho Ten", "Diem", "Xep Loai");
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println();
			System.out.printf("%-15s%-30s%-8.2f%-30s", list.get(i).getMaSo(), list.get(i).getHoTen(), list.get(i).getDiem(), list.get(i).getKetQua());
		}
	}
	public void SapXepTheoDiem(LinkedList<SinhVien> list)
	{
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				if(list.get(i).diem<list.get(j).diem)
				{
					SinhVien tempSinhVien = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tempSinhVien);
				}
			}
		}
	}
	public void SapXepTheoTen(LinkedList<SinhVien> list)
	{
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)	
			{
				if(list.get(i).getTen().compareTo(list.get(j).getTen())>0)
				{
					SinhVien temp = list.get(j);
					list.set(j, list.get(i));
					list.set(i, temp);
				}
			}
		}
	}
	public void ThemSinhVien(LinkedList<SinhVien> list) {
		n = list.size();
		int kiemtra = 0;
		for(int i = n; i<=n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ten cua sinh vien thu "+(i+1)+": ");
			tenString = scanner.nextLine();
			do {
				kiemtra = 0;
				System.out.print("Hay nhap ma so cua sinh vien thu "+(i+1)+": ");
				maString = scanner.nextLine();
				for(int j = 0; i<i; j++)
				{
					if(maString.compareTo(list.get(j).maso)==0)
					{
						kiemtra++;
					}
				}
			} while (kiemtra>0);
			System.out.print("Hay nhap diem cua sinh vien thu "+(i+1)+": ");
			diem = scanner.nextDouble();
			list.add(new SinhVien(tenString, maString, diem));
		}
	}
	public void XoaSinhVien(LinkedList<SinhVien> list)
	{
		int kiemtra = 0;
		scanner.nextLine();
		System.out.print("Hay nhap ma cua sinh vien ma ban muon xoa: ");
		String mamuonxoaString = scanner.nextLine();
			if(TimKiemID(list, mamuonxoaString)==-1)
			{
				System.out.println("Sinh vien ma ban muon xoa khong ton tai !!!");
			}
			else {
				list.remove(TimKiemID(list, mamuonxoaString));
			}
	}
	public void ThayDoiThongTin(LinkedList<SinhVien> list) {
		int kiemtra = 0;
		scanner.nextLine();
		System.out.print("Hay nhap ma so cua sinh vien ma ban muon thay doi thong tin: ");
		String masoString = scanner.nextLine();
		if(TimKiemID(list, masoString)==-1)
			System.out.println("Khong ton tai sinh vien co trong danh sach !!!");
		else {
			list.remove(TimKiemID(list, masoString));
			System.out.print("Hay nhap ten cua sinh vien : ");
			tenString = scanner.nextLine();
			do {
				kiemtra = 0;
				System.out.print("Hay nhap ma so sinh vien cua sinh vien: ");
				masoString = scanner.nextLine();
				for(int j = 0; j<list.size(); j++)
				{
					if(masoString.compareTo(list.get(j).maso)==0)
						kiemtra++;
				}
			} while (kiemtra != 0);
			System.out.print("Hay nhap diem cua sinh vien: ");
			diem = scanner.nextDouble();
			list.add(new SinhVien(tenString, masoString, diem));
		}
	}
		
	
	public int TimKiemID(LinkedList<SinhVien> list, String id) {
		for(int i = 0; i<list.size(); i++)
		{
			if(list.get(i).maso.compareTo(id)==0)
				return i;
		}
		return -1;
	}
	public int TimKiemTheoTen(LinkedList<SinhVien> list, String name) {
		for(int i = 1; i<=list.size(); i++)
		{
			if(list.get(i).getTen().compareTo(name)==0)
				return i;
		}
		return -1;
	}
	public void TimKiem(LinkedList<SinhVien> list) {
		scanner.nextLine();
		String traloiString;
		do {
			System.out.print("Tim kiem sinh vien qua id/name ???: ");
			traloiString = scanner.nextLine();
		} while (traloiString.compareTo("id")!=0&&traloiString.compareTo("name")!=0);
		if(traloiString.compareTo("id")==0)
		{
			System.out.print("Hay nhap ma so sinh vien ma ban muon tim kiem: ");
			String masoString = scanner.nextLine();
			if(TimKiemID(list, masoString)==-1)
			{
				System.out.println("Sinh vien ma ban muon tim kiem khong ton tai trong danh sach !!!");
			}
			else {
				System.out.printf("%-15s%-30s%-8s%-30s", "MSSV", "Ho Ten", "Diem", "Xep Loai");
				System.out.println();
				int i = TimKiemTheoTen(list, masoString);
				System.out.printf("%-15s%-30s%-8.2f%-30s", list.get(i).getMaSo(), list.get(i).getHoTen(), list.get(i).getDiem(), list.get(i).getKetQua());
			}
		}
		else {
			System.out.print("Hay nhap ten sinh vien ma ban muon tim kiem: ");
			String tenString = scanner.nextLine();
			if(TimKiemTheoTen(list, tenString)==-1)
				System.out.println("Sinh vien ban muon tim khong ton tai trong danh sach !!!");
			else {
				System.out.printf("%-15s%-30s%-8s%-30s", "MSSV", "Ho Ten", "Diem", "Xep Loai");
				System.out.println();
				int i = TimKiemTheoTen(list, tenString);
				System.out.printf("%-15s%-30s%-8.2f%-30s", list.get(i).getMaSo(), list.get(i).getHoTen(), list.get(i).getDiem(), list.get(i).getKetQua());
			}
		}
			
	}
}
