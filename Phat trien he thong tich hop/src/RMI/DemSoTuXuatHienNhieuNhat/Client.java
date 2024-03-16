package RMI.DemSoTuXuatHienNhieuNhat;

import java.rmi.Naming;
import java.util.Scanner;

class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			TuXuatHienInterface tuXuatHienInterface = (TuXuatHienInterface) Naming
					.lookup("rmi://localhost:1026/TuXuatHienNhieuNhat");
			System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
			String str = sc.nextLine();
			System.out.println("Từ xuất hiện nhiều nhất trong chuỗi là: " + tuXuatHienInterface.demSoTu(str));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
