package TaoFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

class DiChuyenVaCopyFile {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file1 = new File("D:\\File\\File1\\File2\\");
//		file1.mkdirs();
//		file1 = new File("D:\\File\\File1\\File2\\test.exe");
//		try {
//			file1.createNewFile();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		file1 = new File("D:\\File\\File3\\File2\\");
//		file1.mkdirs();
		file1 = new File("D:\\File\\File3\\File2\\test.txt");
//		try {
//			file1.createNewFile();
//		} catch (Exception e) {
//			// TODO: handle exception
//		}

		// Đổi tên tệp
//		File file2 = new File("D:\\File\\File3\\File2\\test.txt");
//		file1.renameTo(file2);

		// Di chuyển tệp
		File file3;
//		try {
//			Files.move(file1.toPath(), file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		file1 = file3;
//		file3 = new File("D:\\\\File\\\\File1\\\\test.txt");
//		try {
//			Files.copy(file1.toPath(), file3.toPath(), StandardCopyOption.REPLACE_EXISTING);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		file1 = new File("D:\\File\\File1");
		file3 = new File("D:\\File\\File3");
		copyThuMuc(file1, file3);
	}

	static void copyThuMuc(File file1, File file2) {

		try {
			Files.copy(file1.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (file1.isDirectory()) {
			File[] mangFile = file1.listFiles();
			for (File file : mangFile) {
				File newFile = new File(file2.getAbsoluteFile() + "\\" + file.getName());
				copyThuMuc(file, newFile);
			}
		}
	}
}
