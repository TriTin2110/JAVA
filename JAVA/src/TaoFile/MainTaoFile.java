package TaoFile;

import java.io.File;

class MainTaoFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("D:\\Code\\JAVA\\Test");
//		System.out.println(file1.exists());
//		file1.mkdir();
//		System.out.println(file1.exists());
//
//		File file2 = new File("D:\\Code\\JAVA\\Test\\test.exe");
//		try {
//			file2.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		File file3 = new File("D:\\Zalo");
		// xuatFile(file3, 1);
		xoaFile(file1);
	}

	// Xuất cây thư mục
	static void xuatFile(File f, int bac) {
		for (int i = 0; i < bac; i++) {
			System.out.print(" ");
		}
		System.out.print("|_");
		System.out.println(f.getName());
		if (f.isDirectory() && f.canRead()) {
			File[] mangFile = f.listFiles();
			for (File file : mangFile) {
				xuatFile(file, bac + 1);
			}
		}
	}

	// Xóa thư mục, tập tin
	static void xoaFile(File f) {
		if (f.isFile()) {
			f.deleteOnExit();
		} else {
			File[] mangFile = f.listFiles();
			for (File file : mangFile) {
				xoaFile(file);
			}
			f.deleteOnExit();
		}
	}
}
