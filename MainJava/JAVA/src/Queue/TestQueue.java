package Queue;

import java.util.LinkedList;
import java.util.Queue;

class TestQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Queue<String> name = new LinkedList<String>();
		name.offer("Nguyen Van H");
		name.offer("Nguyen Van A");
		name.offer("Nguyen Van U");
		name.offer("Nguyen Van C");
		name.offer("Nguyen Van L");
		name.offer("Nguyen Van T");
		name.offer("Nguyen Van V");

		for (String string : name) {
			System.out.println(string);
		}
	}

}
