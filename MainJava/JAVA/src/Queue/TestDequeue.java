package Queue;

import java.util.ArrayDeque;
import java.util.Deque;

class TestDequeue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<String> name = new ArrayDeque<String>();
		name.offer("Nguyen Van H");
		name.offer("Nguyen Van A");

		// Chèn ra phía cuối mảng (lúc này mảng đã có 2 phần tử là NVA, NVH)
		name.offerLast("Nguyen Van U");
		name.offer("Nguyen Van C");
		name.offer("Nguyen Van L");

		// Chèn lên trên đầu mảng
		name.offerFirst("Nguyen Van T");
		name.offer("Nguyen Van V");
		for (String string : name) {
			System.out.println(string);
		}
	}

}
