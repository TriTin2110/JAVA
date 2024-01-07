import java.util.Scanner;

public class KiemTraDuonngAm {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n =0;
		while(n==0)
		{
			System.out.print("Hãy nhập 1 số nguyên bất kỳ khác 0: ");
			n = sc.nextInt();
			if(n>0)
				System.out.println("Đây là số nguyên dương");
			else if (n<0)
				System.out.println("Đây là số nguyên âm");
			else 
				System.out.println("Hãy nhập lại");
		}
	}
}
