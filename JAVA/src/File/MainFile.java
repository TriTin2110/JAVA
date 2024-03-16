package File;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

class MainFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// File f = new File("D:\\File\\File1\\File2\\File3\\test");
		// f1.mkdirs();
//		try {
//			f1.createNewFile(); //Tạo tệp tin mới
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// f1.deleteOnExit();
		// f.mkdirs();
		// System.out.println(f.exists());
		// xoaThuMuc(f);
		File f1 = new File("D:\\File");
		// f1.mkdirs();
//		try {
//			f1.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		xoaThuMucFiles(f1);
//		try {
//			Files.deleteIfExists(p1);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	static void xoaThuMucFiles(File f) {
		Path p1 = f.toPath();
		if (f.isFile()) {
			System.out.println("Đã xóa file: " + f.getAbsolutePath());
			try {
				Files.delete(p1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (f.isDirectory()) {
			File[] mangFile = f.listFiles();
			for (File file : mangFile) {
				xoaThuMucFiles(file);
			}
			try {
				Files.deleteIfExists(p1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Đã xóa thư mục " + f.getAbsolutePath());
		}
	}

	static void xoaThuMuc(File f) {
		if (f.isFile()) {
			System.out.println("Đã xóa file " + f.getAbsolutePath());
			f.delete();
		} else if (f.isDirectory()) {
			File[] mangFile = f.listFiles();
			for (File file : mangFile) {
				xoaThuMuc(file);
				System.out.println("Đã xóa thư mục " + file.getAbsolutePath());
			}
			// f.delete();
		}
	}
}
