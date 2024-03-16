import java.util.LinkedList;

public class chuongtrinhtimduongdingannhat {
	public static char[][] mt = new char[10][10];
	public static int[][] kiemtra = new int[10][10];
	public static LinkedList ds = new LinkedList<cell>();

	public static void xuatmt(char[][] mt) {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++)
				System.out.print(mt[i][j] + " ");
			System.out.println();
		}
	}

	public static void khoitaomatran(char[][] mt) {
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 9; j++) {
				mt[i][j] = '.';
				kiemtra[i][j] = 1;
			}
		mt[0][0] = 'S';
		kiemtra[0][0] = 0;
		mt[3][4] = 'D';// kiemtra[9][9]=0;
		// for (int j=0;j<9;j++) {mt[8][j]='X';kiemtra[8][j]=0;}
		for (int i = 2; i < 9; i++) {
			mt[i][5] = 'X';
			kiemtra[i][5] = 0;
		}
		for (int i = 2; i < 7; i++) {
			mt[i][3] = 'X';
			kiemtra[i][3] = 0;
		}
		mt[2][4] = 'X';
		kiemtra[2][4] = 0;
		for (int j = 0; j < 3; j++) {
			mt[6][j] = 'X';
			kiemtra[6][j] = 0;
		}

	}

	public static void xuatduongdi(cell curent) {
		mt[curent.x][curent.y] = '*';
		if (curent.parent != null)
			xuatduongdi(curent.parent);
	}

	public static void searchBFS(LinkedList ds) {
		if (ds.isEmpty())
			System.out.println("Khong tim thay");
		else {
			cell curent = (cell) ds.getLast();
			ds.removeLast();
			kiemtra[curent.x][curent.y] = 0;
			mt[curent.x][curent.y] = '.';
			// System.out.println();
			// xuatmt(mt);
			if (curent.x == 3 && curent.y == 4)
				xuatduongdi(curent);
			else {
				if (curent.x - 1 >= 0 && kiemtra[curent.x - 1][curent.y] == 1) {
					curent.left = new cell(curent.x - 1, curent.y);
					curent.left.parent = curent;
					ds.addFirst(curent.left);
				}
				if (curent.y - 1 >= 0 && kiemtra[curent.x][curent.y - 1] == 1) {
					curent.up = new cell(curent.x, curent.y - 1);
					curent.up.parent = curent;
					ds.addFirst(curent.up);
				}
				if (curent.x + 1 < 10 && kiemtra[curent.x + 1][curent.y] == 1) {
					curent.right = new cell(curent.x + 1, curent.y);
					curent.right.parent = curent;
					ds.addFirst(curent.right);

				}
				if (curent.y + 1 < 10 && kiemtra[curent.x][curent.y + 1] == 1) {
					curent.bottom = new cell(curent.x, curent.y + 1);
					curent.bottom.parent = curent;
					ds.addFirst(curent.bottom);

				}
				// cell newcurent = (cell) ds.getFirst();
				searchBFS(ds);

			}

		}
	}

	public static void searchDFS(cell curent) {
		kiemtra[curent.x][curent.y] = 0;
		mt[curent.x][curent.y] = '.';
		System.out.println();
		xuatmt(mt);
		if (curent.x == 9 && curent.y == 0)
			xuatduongdi(curent);
		else {
			if (curent.x - 1 >= 0 && kiemtra[curent.x - 1][curent.y] == 1) {
				curent.left = new cell(curent.x - 1, curent.y);
				curent.left.parent = curent;
				searchDFS(curent.left);
			}
			if (curent.y - 1 >= 0 && kiemtra[curent.x][curent.y - 1] == 1) {
				curent.up = new cell(curent.x, curent.y - 1);
				curent.up.parent = curent;
				searchDFS(curent.up);
			}
			if (curent.x + 1 < 10 && kiemtra[curent.x + 1][curent.y] == 1) {
				curent.right = new cell(curent.x + 1, curent.y);
				curent.right.parent = curent;
				searchDFS(curent.right);
			}
			if (curent.y + 1 < 10 && kiemtra[curent.x][curent.y + 1] == 1) {
				curent.bottom = new cell(curent.x, curent.y + 1);
				curent.bottom.parent = curent;
				searchDFS(curent.bottom);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		khoitaomatran(mt);
		xuatmt(mt);
		cell start = new cell(0, 0);
		ds.add(start);
		// searchDFS(start);
		searchBFS(ds);
		mt[0][0] = 'S';
		mt[3][4] = 'D';
		System.out.println();
		xuatmt(mt);

	}

}
