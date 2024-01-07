import	java.util.Scanner;
public class TinhTongMauSo {
	public static void main(String[] args) {
		//S=1+1/2+1/4+1/6+...1/n
		Scanner scanner = new Scanner(System.in);
		System.out.print("Hãy nhập 1 số nguyên bất kỳ: ");
		int n = scanner.nextInt();
		float tong = 1;
		for(float i = 2; i<=n; i+=2)
		{
			if(n-i==1)
			{
				tong+=1/n;
			}
			else
			 tong+=1/i;
		}
		System.out.println(tong);
	}
}
