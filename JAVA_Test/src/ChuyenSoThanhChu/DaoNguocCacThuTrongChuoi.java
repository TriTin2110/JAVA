package ChuyenSoThanhChu;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class DaoNguocCacThuTrongChuoi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Hãy nhập 1 chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();
		String chuoiKetQua = "";
		String[] chuoiTach = chuoi.split(" ");/*Tách chuỗi ban đầu thành các thành phần 
												trong mảng array[string, string]*/
		for(int i =0; i<chuoiTach.length; i++)
		{
			String kyTu = chuoiTach[i]; /*Khai báo chuỗi kyTu lần lượt trở thành các thành phần trong mảng*/
			String chuoiDaoNguoc = ""; /*Khai báo chuỗi dao ngược (!!!Lưu ý vị trí đặt biến!!!)*/
			for(int j = kyTu.length()-1; j>=0; j--)
			{
				chuoiDaoNguoc = chuoiDaoNguoc + kyTu.charAt(j);
			}
			chuoiKetQua =chuoiKetQua + chuoiDaoNguoc + " ";

		}
		System.out.println(chuoiKetQua);
		}
}
