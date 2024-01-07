package src;

public class Tree {
	public void xuatnut(node T)
	{
		if(T!=null)
		{
			xuatnut(T.right);
			xuatnut(T.left);
			System.out.print(T.label+" ");
		}
	}
}
