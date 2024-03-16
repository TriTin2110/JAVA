package RMI.KiemTraSoNguyenTo;

import java.rmi.Naming;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner sc = new Scanner(System.in);
			CheckPrime checkPrime = (CheckPrime) Naming.lookup("rmi://localhost:1026/checkPrime");
			System.out.println("Hãy nhập 1 số nguyên bất kỳ:  ");
			int i = sc.nextInt();
			System.out.println(
					(checkPrime.checkingPrime(i)) ? i + " là số nguyên tố" : i + " không phải là số nguyên tố");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
