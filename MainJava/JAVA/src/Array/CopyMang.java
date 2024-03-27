package Array;

import java.util.Arrays;

class CopyMang {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] mang = { 1, 2, 3 };
		int[] mang1;
		mang1 = mang;
		mang1[0] = 30;
		System.out.println("mang = " + Arrays.toString(mang));
		System.out.println("mang1 = " + Arrays.toString(mang1));

//Dùng clone()
		int[] mang2 = mang.clone();
		mang2[0] = 15;
		System.out.println("mang2 = " + Arrays.toString(mang2));
//Dùng System.arraycopy(mang_muon_copy_(1), vi_tri_bat_dau_(1), mang_copy_(2), vi_tri_bat_dau(2), so_luong)
		int[] mang3 = new int[mang.length + mang1.length];
		System.arraycopy(mang, 0, mang3, 0, mang.length);
		System.arraycopy(mang1, 0, mang3, mang.length, mang1.length);
		System.out.println("mang3 = " + Arrays.toString(mang3));

//Arrays.deepToString dùng để in ra mảng ĐỐI TƯỢNG
		String[] ten = { "Nguyễn", "Trí", "Tín" };
		String[] ten1 = ten;
		System.out.println("ten = " + Arrays.deepToString(ten));
		ten1[0] = "Trần";
		System.out.println("ten1 = " + Arrays.deepToString(ten1));

		String[] ten2 = ten.clone();
		ten2[0] = "Lý";
		System.out.println("ten2 = " + Arrays.deepToString(ten2));

		String[] ten3 = new String[ten.length];
		System.arraycopy(ten1, 0, ten3, 0, ten1.length);
		ten3[0] = "Hồ";
		System.out.println("ten3 = " + Arrays.deepToString(ten3));

	}

}
