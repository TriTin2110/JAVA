import java.io.File;
import java.util.Scanner;

class TestFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int luaChon = 0;
		System.out.println("Nhập đường dẫn của file: ");
		String path = sc.nextLine();
		TestFile file = new TestFile(path);
		do {

			do {
				System.out.println("Hãy nhập lựa chọn của bạn: ");
				System.out.println("1. Kiểm tra xem file có thể thực thi hay không");
				System.out.println("2. Kiểm tra xem file có thể đọc hay không");
				System.out.println("3. Kiểm tra xem file có thể ghi hay không");
				System.out.println("4. In tên của file");
				System.out.println("5. Kiểm tra file/thư mục");
				System.out.println("6. In đường dẫn");
				System.out.println("7. In thư mục con trong thư mục");
				System.out.print("==> ");
				luaChon = sc.nextInt();
			} while (luaChon < 0);
			sc.nextLine();
			switch (luaChon) {
			case 1: {
				System.out.println(file.kiemTraFileThucThi());
				break;
			}
			case 2: {
				System.out.println(file.kiemTraFileDoc());
				break;
			}
			case 3: {
				System.out.println(file.kiemTraFileGhi());
				break;
			}
			case 4: {
				file.inTenFile();
				break;
			}
			case 5: {
				file.kiemTraLoaiFile();
				break;
			}
			case 6: {
				file.inDuongDan();
				break;
			}
			case 7: {
				file.kiemTraFileCon();
				break;
			}
			}
		} while (luaChon != 0);
		sc.close();
	}

	File file;

	public TestFile(String path) {
		// TODO Auto-generated constructor stub
		file = new File(path);

	}

	boolean kiemTraFileThucThi() {
		return file.canExecute();
	}

	boolean kiemTraFileDoc() {
		return file.canRead();
	}

	boolean kiemTraFileGhi() {
		return file.canWrite();
	}

	void inDuongDan() {
		System.out.println(file.getAbsolutePath());
	}

	void inTenFile() {
		System.out.println(file.getName());
	}

	void kiemTraLoaiFile() {
		if (file.isDirectory()) {
			System.out.println("Đây là thư mục!");
		} else {
			System.out.println("Đây là tập tin!");
		}
	}

	void kiemTraFileCon() {

		inFileCon(this.file, 1);
	}

	void inFileCon(File f, int bac) {
		for (int i = 0; i < bac; i++) {
			System.out.print(" ");
		}
		System.out.print("|_");
		System.out.println(f.getName());
		if (f.isDirectory() && f.canRead()) {
			File[] mang = f.listFiles();
			for (File file : mang) {
				inFileCon(file, bac + 1);
			}
		}

	}
}
