import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.event.TableColumnModelListener;

public class QLNH {
	static int n;
	String hotenString;
	String maString;
	String phanloaiString;
	long taikhoan;
	static Scanner scanner = new Scanner(System.in);
	public void NhapDanhSach(LinkedList<NganHangs> list) {
		int kiemtra = 0;
		System.out.print("Hay nhap so luong khach hang: ");
		n = scanner.nextInt();
		for(int i =0; i<n; i++)
		{
			scanner.nextLine();
			System.out.print("Hay nhap ten cua khach hang thu "+(i+1)+": ");
			hotenString = scanner.nextLine();
			System.out.print("Hay nhap ma cua khach hang thu "+(i+1)+": ");
			maString = scanner.nextLine();	
			System.out.print("Hay nhap tai khoan cua khach hang thu "+(i+1)+": ");
			taikhoan = scanner.nextLong();
			list.add(new NganHangs(hotenString, maString, taikhoan));
			System.out.println();
		}
	}
	public void XuatDanhSach(LinkedList<NganHangs> list) {
		System.out.printf("%-10s%-30s%-12s%11s", "Ma So", "Ho Ten", "Tai Khoan", "Phan Loai");
		System.out.println();
		for(int i=0; i<list.size(); i++)
		{
			System.out.printf("%-10s%-30s%-12s%11s", list.get(i).getMaSo(), list.get(i).getHoten(), list.get(i).getTaiKhoan(), list.get(i).getPhanLoai());
			System.out.println();
		}
	}
	public int TimID(LinkedList<NganHangs> list, String id)
	{
		for(int i = 0; i<list.size(); i++)
		{
			if(id.compareTo(list.get(i).getMaSo())==0)
				return i;
		}
		return -1;
	}
	public void TimKiem(LinkedList<NganHangs> list) 
	{
		scanner.nextLine();
		System.out.println("Hay nhap ma so khach hang ma ban can tim: ");
		String macantim = scanner.nextLine();
		if(TimID(list, macantim)==-1)
				System.err.println("Khach hang ban can tim khong ton tai !!!");
		else {
			System.out.printf("%-10s%-30s%-12s%11s", "Ma So", "Ho Ten", "Tai Khoan", "Phan Loai");
			System.out.println();
			System.out.printf("%-10s%-30s%-12s%11s", list.get(TimID(list, macantim)).getMaSo(), list.get(TimID(list, macantim)).getHoten(), list.get(TimID(list, macantim)).getTaiKhoan(), list.get(TimID(list, macantim)).getPhanLoai());
		}
	}
	public void SapXep(LinkedList<NganHangs> list)
	{
		for(int i = 0; i<list.size(); i++)
		{
			for(int j = 0; j<i; j++)
			{
				if(list.get(i).getMaSo().compareTo(list.get(j).getMaSo())==-1)
				{
					NganHangs tempHangs = list.get(i);
					list.set(i, list.get(j));
					list.set(j, tempHangs);
				}
			}
		}
	}
	public void NapTien(LinkedList<NganHangs> list)
	{
		scanner.nextLine();
		System.out.print("Hay nhap ma khach hang muon nap tien: ");
		String manapString = scanner.nextLine();
		if(TimID(list, manapString)==-1)
			System.err.println("Khach hang ban can tim khong ton tai !!!");
		else {
			System.out.println("Hay nhap so tien muon nap: ");
			long tiennap = scanner.nextLong();
			list.add(new NganHangs(list.get(TimID(list, manapString)).getHoten(), manapString, list.get(TimID(list, manapString)).getTaiKhoan() + tiennap));
			list.remove(TimID(list, manapString));
		}
	}
	public void RutTien(LinkedList<NganHangs> list)
	{
		scanner.nextLine();
		System.out.print("Hay nhap ma khach hang muon rut tien: ");
		String marutString = scanner.nextLine();
		if(TimID(list, marutString)==-1)
			System.err.println("Khach hang ban can tim khong ton tai !!!");
		else {
			System.out.println("Hay nhap so tien muon rut: ");
			long tienrut = scanner.nextLong();
			list.add(new NganHangs(list.get(TimID(list, marutString)).getHoten(), marutString, list.get(TimID(list, marutString)).getTaiKhoan() - tienrut));
			list.remove(TimID(list, marutString));
		}
	}
}

