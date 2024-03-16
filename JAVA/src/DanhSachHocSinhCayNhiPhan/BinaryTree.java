package DanhSachHocSinhCayNhiPhan;

public class BinaryTree {
	Node root;
	int size;

	public BinaryTree() {
	}

	public BinaryTree(Node root) {
		this.root = null;
	}

	public void insert(Node node) {
		this.root = insert(this.root, node);
	}

	public Node insert(Node node, Node newNode) {
		if (node == null) {
			return newNode;
		}

		if (newNode.lessThanOrEqual(node.node)) {
			node.Prev = insert(node.Prev, newNode);
		} else {
			node.Next = insert(node.Next, newNode);
		}
		return newNode;

	}

	public void print() {
		print(root);
	}

	public void print(Node node) {
		if (node == null)
			return;
		else {
			node.printData();
			print(node.Prev);
			print(node.Next);
		}

	}
}
