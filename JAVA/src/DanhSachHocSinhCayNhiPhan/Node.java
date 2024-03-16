package DanhSachHocSinhCayNhiPhan;

public class Node {
	Student node;
	Node Prev;
	Node Next;

	public Node(Student node) {
		this.node = node;
		Prev = null;
		Next = null;
	}

	public boolean lessThanOrEqual(Student aNode) {
		return this.node.getStudent_ID() <= aNode.getStudent_ID();
	}

	public boolean Equal(Student aNode) {
		return this.node.getStudent_ID() == aNode.getStudent_ID();
	}

	public void printData() {
		node.printData();
	}
}
