public class Tree {
    public void Read(node T) {
        if (T != null) {
            Read(T.right);
            Read(T.left);
            System.out.print(T.label + " ");
        }
    }

    public int DemNut(node T) {
        if (T == null)
            return 0;
        else
            return 1 + DemNut(T.left) + DemNut(T.right);
    }

    public int DemLa(node T) {
        if (T == null)
            return 0;
        else if (T.left != null && T.right != null)
            return DemLa(T.left) + DemLa(T.right);
        else
            return 1;
    }

    public int bac(node T) {
        if (T == null)
            return 0;
        else if (T.left != null || T.right != null) {
            if (bac(T.left) > bac(T.right))
                return 1 + bac(T.left);
            else
                return 1 + bac(T.right);
        } else
            return 0;
    }
}
