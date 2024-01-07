package TaoFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;

class DocFileText {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// Đọc file bằng cách sử dụng Scanner
		File f = new File("D:\\File\\test.txt");
		Scanner sc = null;
		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (sc.hasNextLine()) {
			System.out.println(sc.nextLine());
		}

		// Đọc file bằng cách sử dụng BufferedReader
		try {
			BufferedReader br = Files.newBufferedReader(f.toPath(), StandardCharsets.UTF_8);
			String line = null;
			while (true) {
				line = br.readLine();
				if (line == null) {
					break;
				} else {
					System.out.println(line);
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		// Đọc file bằng cách sử dụng List<String>
		try {
			List<String> listText = Files.readAllLines(f.toPath(), StandardCharsets.UTF_8);
			for (String string : listText) {
				System.out.println(string);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
