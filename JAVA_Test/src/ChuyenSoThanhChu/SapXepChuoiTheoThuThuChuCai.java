package ChuyenSoThanhChu;

import java.util.Scanner;

public class SapXepChuoiTheoThuThuChuCai {
public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	System.out.print("Hãy nhập số lượng chuỗi muốn nhập: ");
	int n = sc.nextInt();
	sc.nextLine();
	String[] chuoi = new String[n];
	for(int i = 0; i<n; i++)
	{
		System.out.print("Hãy nhập chuỗi thứ "+(i+1)+": ");
		chuoi[i] = sc.nextLine();
	}
	String temp = "";
	for(int i = 0; i<n-1; i++)
	{
		for(int j = i+1; j<n; j++)
		{
			if(chuoi[i].compareTo(chuoi[j])>0)
			{
				temp = chuoi[i];
				chuoi[i] = chuoi[j];
				chuoi[j] = temp;
			}
		}
	}
	for(int i = 0; i<n; i++)
	{
		System.out.print(chuoi[i]+", ");
	}
}
}
