import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

interface congHaiSo
{
	int add(int a, int b);
}

public class Lambda {
	public static void main(String[] args) {
		//In danh sách sử dụng lambda
		List<Integer> list = Arrays.asList(6,3,1,7,45,3,4);
//		list.forEach(n -> System.out.println(n));
//		
//		//Cộng hai số sử dụng lambda
//		congHaiSo congHaiSo = (a, b) -> (a+b);
//		System.out.println(congHaiSo.add(1, 2));
		
//		//Sắp xếp danh sách
//		Collections.sort(list, (o1, o2) -> o1-o2);
//		list.forEach(n-> System.out.println(n));
		
		//Lọc danh sách (n>10)
		list.stream().filter(n -> n>10).forEach(n -> System.out.println(n));
	}
}
