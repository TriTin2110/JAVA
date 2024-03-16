package BaiTapQuanLySinhVien;

import java.util.Scanner;

import HandleString.HandleString;

class MainStudent {
	static Scanner sc = new Scanner(System.in);
	static boolean validInput = true;
	static ManageStundents mSAT = new ManageStundents();

	public static void main(String[] args) {

		int choose = 0;
		do {
			try {
				do {
					System.out.println("Hãy nhập lựa chọn của bạn:");
					System.out.println("1. Thêm sinh viên");
					System.out.println("2. In danh sách sinh viên");
					System.out.println("3. Xóa sinh viên");
					System.out.println("4. Chỉnh sửa thông tin sinh viên");
					System.out.println("5. Sắp xếp danh sách sinh viên theo tên");
					System.out.println("6. Sắp xếp danh sách sinh viên theo GPA");
					System.out.println("0. Thoát");
					System.out.print("=> ");
					choose = sc.nextInt();
					validInput = true;
				} while (choose < 0 && choose > 6);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lựa chọn không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();
			if (validInput)
				manageChoose(choose, mSAT);
		} while (choose != 0 || validInput == false);
	}

	private static void manageChoose(int choose, ManageStundents mSAT) {
		// TODO Auto-generated method stub
		switch (choose) {
		case 1:
			addNewStudent();
			break;

		case 2:
			printListStudent();
			break;

		case 3:
			deleteStudent();
			break;

		case 4:
			updateStudent();
			break;

		case 5:
			sortListByName();
			break;

		case 6:
			sortByGPA();
			break;
		}
	}

	private static void addNewStudent() {
		// TODO Auto-generated method stub
		String name = "", subject = "";
		int id = 0, age = 0;
		double GPA = 0;
		long tution = 0;
		do {
			try {
				do {
					System.out.println("Hãy nhập mã sinh viên: ");
					id = sc.nextInt();
					sc.nextLine();
					System.out.println("Hãy nhập tên sinh viên: ");
					name = sc.nextLine();
					System.out.println("Hãy nhập tuổi của sinh viên: ");
					age = sc.nextInt();
					sc.nextLine();
					System.out.println("Hãy nhập ngành học của sinh viên: ");
					subject = sc.nextLine();
					System.out.println("Hãy nhập GPA của sinh viên: ");
					GPA = sc.nextDouble();
					System.out.println("Hãy nhập học phí của sinh viên: ");
					tution = sc.nextLong();
				} while (id < 1000 || id > 9999 || age < 0 || GPA > 10 || GPA < 0 || tution < 0);
				validInput = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Dữ liệu không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();

		} while (!validInput);
		name = HandleString.CapitalFirstLetter(name);
		Student student = new Student(name, age, id, GPA, tution, subject);
		mSAT.addStudent(student);
	}

	private static void printListStudent() {
		// TODO Auto-generated method stub
		mSAT.printList();
	}

	private static void deleteStudent() {
		// TODO Auto-generated method stub
		int id = 0;
		do {
			try {
				System.out.println("Hãy nhập mã số sinh viên bạn muốn xóa: ");
				id = sc.nextInt();
				validInput = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Mã số sinh viên không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();
		} while (!validInput);
		mSAT.deleteStudent(new Student(id));
	}

	private static void updateStudent() {
		// TODO Auto-generated method stub
		int id = 0;
		Student oldStudent;
		do {
			try {
				System.out.println("Hãy nhập mã số sinh viên bạn muốn cập nhật: ");
				id = sc.nextInt();
				validInput = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Mã số sinh viên không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();
		} while (!validInput);

		/*
		 * Nếu tồn tại sinh viên trong danh sách Yêu cầu người dùng nhập thông tin của
		 * sinh viên đó Và ghi đè những thông tin mới lên thông tin cũ
		 */
		if ((oldStudent = mSAT.findingStudent(new Student(id))) != null) {
			String name = "", subject = "";
			int age = 0;
			double GPA = 0;
			long tution = 0;
			do {
				System.out.println("Hãy nhập tên sinh viên: ");
				name = sc.nextLine();
				System.out.println("Hãy nhập tuổi của sinh viên: ");
				age = sc.nextInt();
				sc.nextLine();
				System.out.println("Hãy nhập ngành học của sinh viên: ");
				subject = sc.nextLine();
				System.out.println("Hãy nhập GPA của sinh viên: ");
				GPA = sc.nextDouble();
				System.out.println("Hãy nhập học phí của sinh viên: ");
				tution = sc.nextLong();
			} while (age < 0 || GPA > 10 || GPA < 0 || tution < 0);
			mSAT.updateStudent(new Student(name, age, id, GPA, tution, subject), oldStudent);
		} else {
			System.out.println("Sinh viên không tồn tại trong danh sách!");
		}
	}

	private static void sortListByName() {
		// TODO Auto-generated method stub
		mSAT.sortListByName();
	}

	private static void sortByGPA() {
		// TODO Auto-generated method stub
		mSAT.sortListByGPA();
	}
}
