import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class QuanLySinhVien {
	Scanner scanner = new Scanner(System.in);
	static int n;
	String hotenString;
	String maString;
	double diem;
	public void NhapSinhVien(LinkedList<SinhVien> list) {
		System.out.print("Hay nhap so luong sinh vien co trong danh sach: ");
		int n = scanner.nextInt();
		for(int i = 0; i<n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ten cua sinh vien thu "+(i+1)+": ");
			hotenString = scanner.nextLine();
			System.out.print("Hay ma so cua sinh vien thu "+(i+1)+": ");
			maString = scanner.nextLine();
			System.out.print("Hay diem cua sinh vien thu "+(i+1)+": ");
			diem = scanner.nextDouble();
			list.add(new SinhVien(hotenString, maString, diem));
			System.out.println();
		}
	}
	public void XuatSinhVien(LinkedList<SinhVien> list) {
		System.out.println();
		System.out.printf("%-15s%-30s%-10s%-20s", "MSSV", "Ho Ten", "Diem", "Ket Qua");
		for(int i = 0; i<list.size(); i++)
		{
			System.out.println();
			System.out.printf("%-15s%-30s%-10s%-20s", list.get(i).getMaSo(), list.get(i).getHoTen(), list.get(i).getDiem(), list.get(i).getKetQua());
		}
	}
	public void SapXepTheoDiem(LinkedList<SinhVien> list) {
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				if(list.get(i).diem<list.get(j).diem)
				{
					SinhVien temSinhVien = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temSinhVien);
					
				}
			}
		}
	}
	public void SapXepTheoTen(LinkedList<SinhVien> list) {
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				System.out.println(list.get(i).getTen());
				if(list.get(j).getTen().compareTo(list.get(i).getTen())>0)
				{
					SinhVien temSinhVien = list.get(i);
					list.set(i, list.get(j));
					list.set(j, temSinhVien);
				}
			}
		}
	}
	public void SapXep(LinkedList<SinhVien> list) {
		scanner.nextLine();
		System.out.print("Sap xep theo ten/diem ???: ");
		String traString = scanner.nextLine();
		if(traString.compareTo("ten")==0)
			SapXepTheoTen(list);
		else {
			SapXepTheoDiem(list);
		}
	}
	public int timID(LinkedList<SinhVien> list, String id)
	{
		for(int i = 0; i<list.size(); i++)
		{
			if(id.compareTo(list.get(i).getMaSo())==0)
				return i;
		}
		return -1;
	}
	public int timTen(LinkedList<SinhVien> list, String ten)
	{
		for(int i = 0; i<list.size(); i++)
		{
			if(ten.compareTo(list.get(i).getTen())==0)
				return i;
		}
		return -1;
	}
	public void TimKiem(LinkedList<SinhVien> list) {
		scanner.nextLine();
		System.out.print("Tim kiem theo name/id ???: ");
		String traloiString = scanner.nextLine();
		if(traloiString.compareTo("name")==0)
		{
			System.out.print("Hay nhap ten cua sinh vien ma ban muon tim: ");
			String tenString = scanner.nextLine();
			if(timTen(list, tenString) == -1)
				System.out.println("Sinh vien ban muon tim kiem khong ton tai !!!");
			else {
				System.out.printf("%-15s%-30s%-10s%-20s", "MSSV", "Ho Ten", "Diem", "Ket Qua");
				System.out.println();
				System.out.printf("%-15s%-30s%-10s%-20s", list.get(timTen(list, tenString)).getMaSo(), list.get(timTen(list, tenString)).getHoTen(), list.get(timTen(list, tenString)).getDiem(), list.get(timTen(list, tenString)).getKetQua());
			}
		}
		else {
			System.out.print("Hay nhap ma so cua sinh vien ma ban muon tim: ");
			String maString = scanner.nextLine();
			if(timID(list, maString) == -1)
				System.out.println("Sinh vien ban muon tim kiem khong ton tai !!!");
			else {
				System.out.printf("%-15s%-30s%-10s%-20s", "MSSV", "Ho Ten", "Diem", "Ket Qua");
				System.out.println();
				System.out.printf("%-15s%-30s%-10s%-20s", list.get(timID(list, maString)).getMaSo(), list.get(timID(list, maString)).getHoTen(), list.get(timID(list, maString)).getDiem(), list.get(timID(list, maString)).getKetQua());
			}
		}
	}
	public void ThemSinhVien(LinkedList<SinhVien> list) {
		n = list.size();
		for(int i = n; i<=n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ten cua sinh vien thu "+(i+1)+": ");
			hotenString = scanner.nextLine();
			System.out.print("Hay ma so cua sinh vien thu "+(i+1)+": ");
			maString = scanner.nextLine();
			System.out.print("Hay diem cua sinh vien thu "+(i+1)+": ");
			diem = scanner.nextDouble();
			list.add(new SinhVien(hotenString, maString, diem));
			System.out.println();
		}
	}
	public void XoaSinhVien(LinkedList<SinhVien> list) {
		scanner.nextLine();
		System.out.print("Hay nhap ma cua sinh vien ma ban muon xoa: ");
		String mamuonxoaString = scanner.nextLine();
		if(timID(list, mamuonxoaString)==-1)
			System.out.println("Sinh vien ban muon xoa khong ton tai trong danh sach !!!");
		else {
			list.remove(timID(list, mamuonxoaString));
		}
	}
	public void ChinhSuaThongTin(LinkedList<SinhVien> list) {
		scanner.nextLine();
		System.out.println("Nhap ma sinh vien ma ban muon chinh sua: ");
		String mamuonsuaString = scanner.nextLine();
		if(timID(list, mamuonsuaString)==-1)
			System.out.println("Sinh vien ban muon chinh sua khong ton tai trong danh sach !!!");
		else {
				list.remove(timID(list, mamuonsuaString));
				System.out.print("Hay nhap ten cua sinh vien: ");
				hotenString = scanner.nextLine();
				System.out.print("Hay nhap ma so cua sinh vien: ");
				maString = scanner.nextLine();
				System.out.print("Hay nhap diem cua sinh vien: ");
				diem = scanner.nextDouble();
				list.add(new SinhVien(hotenString, maString, diem));
			}
		}
}
