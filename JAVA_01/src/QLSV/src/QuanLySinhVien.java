import java.util.Scanner;

public class QuanLySinhVien {
	static SinhVien list[] = new SinhVien[100];
	static Scanner scanner =  new Scanner(System.in);
	static int n;
	public void NhapSinhVien(SinhVien list[]) {
		int kiemtra =0;
		System.out.println("Hay nhap so luong sinh vien co trong danh sach: ");
		n = scanner.nextInt();
		for(int i = 1; i<=n; i++)
		{
			System.out.println();
			list[i] = new SinhVien();
			scanner.nextLine();
			System.out.print("Hay nhap ho ten cua sinh thu "+i+": ");
			list[i].hoten = scanner.nextLine();
			do {
				kiemtra = 0;
				System.out.print("Hay nhap MSSV cua sinh thu "+i+": ");
				list[i].mssv = scanner.nextLine();
				for(int j = 1; j<i; j++)
				{
					if(list[i].mssv.compareTo(list[j].mssv)==0)
						kiemtra++;
				}
			} while (kiemtra>0);
			System.out.print("Hay nhap diem cua sinh thu "+i+": ");
			list[i].diem = scanner.nextDouble();
			SinhVien sVien = new SinhVien(list[i].hoten, list[i].mssv, list[i].diem);
			list[i] = sVien;
		}
		System.out.println();
	}
	public void XuatSinhVien(SinhVien list[]) {
		System.out.printf("%-15s%-30s%-10s%-20s", "MSSV", "Ho Ten", "Diem", "Ket Qua");
		for(int i = 1; i<=n; i++)
		{
			System.out.println();
			System.out.printf("%-15s%-30s%-10s%-20s", list[i].getMS(), list[i].getHoTen(), list[i].diem, list[i].ketQua);
		}
	}
	public void SapXepTheoDiem(SinhVien list[])
	{
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<i; j++)
			{
				if(list[j].getDiem()>list[i].getDiem())
				{
					SinhVien temp = list[j];
					list[j] = list[i];
					list[i] = temp;
				}
					
			}
		}
	}
	public void SapXepTheoTen(SinhVien list[])
	{
		for(int i = 1; i<=n; i++)
		{
			for(int j = 1; j<i; j++)
			{
				if(list[i].getTen().compareTo(list[j].getTen())<0)
				{
					SinhVien temp = list[i];
					list[i] = list[j];
					list[j] = temp;
				}
			}
		}
	}
	public void ThemSinhVien(SinhVien list[])
	{
		int kiemtra = 0;
		n++;
		for(int i = n; i<=n; i++)
		{
			System.out.println();
			list[i] = new SinhVien();
			scanner.nextLine();
			System.out.print("Hay nhap ho ten cua sinh thu "+i+": ");
			list[i].hoten = scanner.nextLine();
			do {
				kiemtra = 0;
				System.out.print("Hay nhap MSSV cua sinh thu "+i+": ");
				list[i].mssv = scanner.nextLine();
				for(int j = 1; j<i; j++)
				{
					if(list[i].mssv.compareTo(list[j].mssv)==0)
						kiemtra++;
				}
			} while (kiemtra>0);
			System.out.print("Hay nhap diem cua sinh thu "+i+": ");
			list[i].diem = scanner.nextDouble();
			SinhVien sVien = new SinhVien(list[i].hoten, list[i].mssv, list[i].diem);
			list[i] = sVien;
		}
	}
	public void XoaSinhVien(SinhVien list[])
	{
		int kiemtra = 0;
		scanner.nextLine();
		System.out.print("Hay nhap MSSV cua sinh vien ma ban muon xoa: ");
		String masinhvien = scanner.nextLine();
		for(int i = 1; i<=n; i++)
		{
			if(masinhvien.compareTo(list[i].mssv)==0)
			{
				for(int j = i ; j<=n; j++)
				{
					SinhVien temp = list[j];
					list[j] = list[j+1];	
				}
				n--;
				kiemtra++;
			}
		}
		if(kiemtra == 0)
			System.out.println("Sinh vien ma ban muon xoa khong ton tai !!!");
	}
	public void ThayDoiThongTin(SinhVien list[])
	{
		int kiemtra = 0;
		int check = 0;
		scanner.nextLine();
		System.out.print("Hay nhap ma so sinh vien ma ban muon thay doi thong tin: ");
		String masosinhvien = scanner.nextLine();
		for(int i = 1; i<=n; i++)
		{
			if(masosinhvien.compareTo(list[i].mssv)==0)
			{
				list[i] = new SinhVien();
				System.out.print("Hay nhap ho ten cua sinh thu "+i+": ");
				list[i].hoten = scanner.nextLine();
				do {
					check = 0;
					System.out.print("Hay nhap MSSV cua sinh thu "+i+": ");
					list[i].mssv = scanner.nextLine();
					for(int j = 1; j<i; j++)
					{
						if(list[i].mssv.compareTo(list[j].mssv)==0)
							kiemtra++;
					}
				} while (check>0);
				System.out.print("Hay nhap diem cua sinh thu "+i+": ");
				list[i].diem = scanner.nextDouble();
				SinhVien sVien = new SinhVien(list[i].hoten, list[i].mssv, list[i].diem);
				list[i] = sVien;
				kiemtra++;
			}
		}
		if(kiemtra == 0)
		{
			System.out.println("Sinh vien ban muon thay doi thong tin khong ton tai !!!");
		}
	}
	public int TimID(SinhVien list[], String id)
	{
		for(int i = 1; i<=n; i++)
			if(list[i].mssv.compareTo(id)==0)
				return i;
		return -1;
	}
	public void TimKiemSinhVien(SinhVien list[])
	{
		scanner.nextLine();
		System.out.println("Hay nhap ma so cua sinh vien ma ban muon tim kiem: ");
		String masoString = scanner.nextLine();
		if(TimID(list, masoString)==-1)
			System.out.println("Sinh vien ma ban muon tim kiem khong ton tai !!!");
		else {
			System.out.println(list[TimID(list, masoString)]);
		}
	}
}
