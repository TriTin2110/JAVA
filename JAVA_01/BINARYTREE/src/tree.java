
public class tree {
	public void ReadNLR(node T) {
		if (T != null) {
			ReadNLR(T.left);
			System.out.print(T.label + " ");
			ReadNLR(T.right);
		}
	}

	public int countnode(node T) {
		if (T == null)
			return 0;
		else
			return 1 + countnode(T.left) + countnode(T.right);
	}

	public int countleaf(node T) {
		if (T == null)
			return 0;
		else if (T.left == null && T.right == null)
			return 1;
		else
			return countleaf(T.left) + countleaf(T.right);
	}

	public int treelevel(node T) {
		if (T == null)
			return 0;
		else if (T.left != null || T.right != null)
			if (treelevel(T.left) > treelevel(T.right))
				return 1 + treelevel(T.left);
			else
				return 1 + treelevel(T.right);
		else
			return 0;
	}

	public node them(node T, int key) {
		if (T == null)
			return new node(key);
		else if (key < T.label) {
			T.left = them(T.left, key);
			return T;
		} else {
			T.right = them(T.right, key);
			return T;
		}
	}
}
