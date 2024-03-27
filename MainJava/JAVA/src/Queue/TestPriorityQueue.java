package Queue;

import java.util.PriorityQueue;

class TestPriorityQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> name = new PriorityQueue<String>();
		name.offer("H"); // h
		name.offer("T"); // h t
		name.offer("L"); // h l t
		name.offer("A"); // a h l t
		name.offer("U");// a h l t u
		name.offer("C");// a c h l t u
		name.offer("V");// a c h l t u v
		int i = 0;
		while (true) {
			// Khi poll thì PriorityQueue mới được sắp xếp
			String ten = name.poll();
			if (ten == null) {
				break;
			}
			System.out.println(ten);
		}
	}

}
