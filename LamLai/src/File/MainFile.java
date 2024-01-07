package File;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

class MainFile {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo file mới (x)
		// Ghi file
		// Đọc file
		// Copy file và dán vào thư mục khác
		File file = new File("D:\\DirectoryTest");
		// file.mkdir();
		file = new File("D:\\\\DirectoryTest\\\\test.txt");
//		try {
//			file.createNewFile();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		ghiFile(file);
		docFile(file);
		copyFile(file);

	}

	static void ghiFile(File file) {
		System.out.println("Hãy nhập nội dung mà bạn muốn thêm vào file: ");
		String noiDungThem = sc.nextLine();
		try {
			PrintWriter pw = new PrintWriter(file, StandardCharsets.UTF_8);
			pw.print(noiDungThem);
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void docFile(File file) {
		try {
			Scanner docFile = new Scanner(file);
			while (docFile.hasNextLine()) {
				System.out.println(docFile.nextLine());
			}
			docFile.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	static void copyFile(File file) {
		File fileDich = new File("D:\\test.txt");
		try {
			Files.copy(file.toPath(), fileDich.toPath(), StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
