import java.util.Scanner;

public class KiemTraChuoiDoiXung {
	public static void main(String[] args) {
		String chuoiKT = "";
		Scanner sc = new Scanner(System.in);
		System.out.print("Hãy nhập 1 chuỗi bất kỳ: ");
		String chuoi = sc.nextLine();		sc.close();
		int lenght = chuoi.length();
		for(int i=lenght-1; i>=0; i--)
		{
			chuoiKT = chuoiKT + chuoi.charAt(i);
		}
		if(chuoi.equals(chuoiKT))
			System.out.println("Chuỗi đối xứng!");
		else {
			System.out.println("Chuỗi không đối xứng!");
		}
	}
}
