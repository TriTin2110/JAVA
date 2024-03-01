package MyClass;

import java.util.Scanner;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Hãy nhập 1 chuỗi bất kỳ: ");
		String str = sc.nextLine();
		System.out.println(StringController.UppercaseFirstLetter(str));

	}

}
