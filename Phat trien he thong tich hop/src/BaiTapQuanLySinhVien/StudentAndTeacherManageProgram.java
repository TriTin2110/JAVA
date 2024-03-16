package BaiTapQuanLySinhVien;

import java.util.Scanner;

import MyAPI.StringController;

class StudentAndTeacherManageProgram {
	static Scanner sc = new Scanner(System.in);
	static boolean validInput = true;
	static Manage<Student> listStudent = new Manage<Student>();
	static Manage<Teacher> listTeacher = new Manage<Teacher>();

	public static void main(String[] args) {
		int choose = 0;

		do {
			try {
				do {
					System.out.println("Hãy nhập lựa chọn của bạn:");
					System.out.println("1. Thêm sinh viên");
					System.out.println("2. In danh sách sinh viên");
					System.out.println("3. Xóa sinh viên");
					System.out.println("4. Cập nhật sinh viên");
					System.out.println("\n--------------------------------------------------------\n");
					System.out.println("5. Thêm giảng viên");
					System.out.println("6. In danh sách giảng viên");
					System.out.println("7. Xóa giảng viên");
					System.out.println("8. Cập nhật giảng viên");
					System.out.println("\n--------------------------------------------------------\n");
					System.out.println("0. Thoát");
					System.out.print("\n==> ");
					choose = sc.nextInt();
					validInput = true;
				} while (choose < 0 || choose > 8);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Lựa chọn của bạn không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();
			if (validInput) {
				processSelected(choose);
			}
		} while (choose != 0 || !validInput);
	}

	public static void processSelected(int choose) {
		switch (choose) {
		// Thêm sinh viên
		case 1:

			Student student = (Student) inputInfo(1);
			listStudent.addPerson(student);
			break;
		// In danh sách sinh viên
		case 2:
			listStudent.printList();
			break;
		// Xóa sinh viên
		case 3:
			deletingId(3);
			break;
		// Cập nhật sinh viên
		case 4:
			updatePerson(4);
			break;
		// Thêm giảng viên
		case 5:
			Teacher teacher = (Teacher) inputInfo(6);
			listTeacher.addPerson(teacher);
			break;
		// In danh sách giảng viên
		case 6:
			listTeacher.printList();
			break;
		// Xóa giảng viên
		case 7:
			deletingId(7);
			break;
		// Cập nhật giảng viên
		case 8:
			updatePerson(8);
			break;
		default:
			break;
		}
	}

	public static Object inputInfo(int cases) {
		String name = "";
		int id = 0, age = 0;
		do {
			try {
				System.out.println("Hãy nhập mã: ");
				id = sc.nextInt();
				sc.nextLine();
				System.out.println("Hãy nhập tên: ");
				name = sc.nextLine();
				System.out.println("Hãy nhập tuổi: ");
				age = sc.nextInt();
				validInput = true;
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Dữ liệu nhập vào không hợp lệ!");
				validInput = false;
			}
			sc.nextLine();
		} while (!validInput);

		if (cases == 1) {
			double GPA = 0;
			String major;
			do {
				try {
					System.out.println("Hãy nhập GPA của sinh viên: ");
					GPA = sc.nextDouble();
					validInput = true;
				} catch (Exception e) {
					// TODO: handle exception
					validInput = false;
				}
				sc.nextLine();
			} while (GPA < 0 || GPA > 10 || !validInput);

			System.out.println("Hãy nhập ngành học của sinh viên: ");
			major = sc.nextLine();
			Student student = new Student(StringController.ucFirst(name), age, id, GPA, major);
			return student;
		}

		else {
			double salary = 0;
			String archievement;
			do {
				try {
					System.out.println("Hãy nhập lương của giảng viên: ");
					salary = sc.nextDouble();
					validInput = true;
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Dữ liệu không hợp lệ!");
					validInput = false;
				}
				sc.nextLine();
			} while (!validInput);

			System.out.println("Hãy nhập trình độ của giảng viên: ");
			archievement = sc.nextLine();
			Teacher teacher = new Teacher(StringController.ucFirst(name), age, id, salary, archievement);
			return teacher;
		}

	}

	public static void deletingId(int cases) {
		if (cases == 3) {
			System.out.println("Hãy nhập id của sinh viên mà bạn muốn xóa: ");
			int id = sc.nextInt();
			listStudent.deletePerson(new Student(id));
		} else {
			System.out.println("Hãy nhập id của giảng viên mà bạn muốn xóa: ");
			int id = sc.nextInt();
			listTeacher.deletePerson(new Teacher(id));
		}

	}

	public static void updatePerson(int cases) {
		if (cases == 4) {
			System.out.println("Hãy nhập id của sinh viên mà bạn muốn cập nhật thông tin: ");
			int id = sc.nextInt();
			listStudent.updatePerson(new Student(id));
		} else {
			System.out.println("Hãy nhập id của giảng viên mà bạn muốn cập nhật thông tin: ");
			int id = sc.nextInt();
			listTeacher.updatePerson(new Teacher(id));
		}
	}
}