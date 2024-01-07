package Set;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class InSoNguyen {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> test = new ArrayList<Integer>();
		test.add(10);
		test.add(15);
		test.add(10);
		test.add(20);

		// Collections.replaceAll(test, 15, 25); // Thay thế giá trị trong "ArrayList"
		Collections.rotate(test, 3);
		Iterator<Integer> iterator = test.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}

}
