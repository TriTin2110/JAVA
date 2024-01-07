package BaiTapQuanLySinhVien;

import java.util.ArrayList;
import java.util.Scanner;

import MyAPI.StringController;

/*Manage là lớp generic nhận */

class Manage<E> implements Functional<E> {
	private ArrayList<E> list;
	private Object object;

	public Manage() {
		this.list = new ArrayList<E>();
	}

	@Override
	public void addPerson(E e) {
		// TODO Auto-generated method stub
		list.add(e);
	}

	@Override
	public void deletePerson(E e) {
		// TODO Auto-generated method stub
		Object object = findingPerson(e);
		if (object == null)
			System.out.println("Sinh viên không tồn tại trong danh sách!");
		else {
			// Kiểm tra object trả về sau khi tìm kiếm là đối tượng nào
			if (object instanceof Student) {
				// Nếu là sinh viên thì sẽ lấy danh sách sinh viên ra và xóa sinh viên khỏi danh
				// sách sinh viên
				ArrayList<Student> listStudent = (ArrayList<Student>) this.list;
				listStudent.remove((Student) object);
				System.out.println("Đã xóa thành công!");
			} else {
				ArrayList<Teacher> listTeacher = (ArrayList<Teacher>) this.list;
				listTeacher.remove((Teacher) object);
				System.out.println("Đã xóa thành công!");
			}
		}
	}

	@Override
	public void updatePerson(E e) {
		// TODO Auto-generated method stub
		// object sẽ = kết quả tìm kiếm
		Object object = findingPerson(e);
		if (object == null) {

			System.out.println("Đối tượng không tồn tại trong danh sách!");
		} else {
			Scanner sc = new Scanner(System.in);
			// Khi đối tượng là sinh viên sẽ tiến hành yêu cầu người dùng nhập thông tin của
			// sinh viên ngoại trừ id
			if (object instanceof Student) {
				// object2 dùng để nhập thông tin sinh viên
				// student dùng để lấy thông tin sinh viên mà người dùng nhập vào
				Student object2 = (Student) object;
				Student student = (Student) inputInformation(object);
				object2.setAge(student.getAge());
				object2.setGPA(student.getGPA());
				object2.setMajor(student.getMajor());
				object2.setName(student.getName());
			}

			else {
				Teacher object2 = (Teacher) object;
				Teacher teacher = (Teacher) inputInformation(object);
				object2.setAge(teacher.getAge());
				object2.setSalary(teacher.getSalary());
				object2.setAchievement(teacher.getAchievement());
				object2.setName(teacher.getName());
			}
		}

	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		this.list.forEach(p -> System.out.println(p.toString()));
	}

	@Override
	public E findingPerson(E e) {
		// TODO Auto-generated method stub
		// Nếu đối tượng truyền vào là student thì sẽ so sánh trên list student
		if (e instanceof Student) {
			Student studentCompare = (Student) e;
			for (Student student : (ArrayList<Student>) list) {
				if (studentCompare.getId() == student.getId()) {
					return (E) student;
				}

			}
		} else {
			Teacher teacherCompare = (Teacher) e;
			for (Teacher teacher : (ArrayList<Teacher>) list) {
				if (teacherCompare.getId() == teacher.getId()) {
					return (E) teacher;
				}

			}
		}
		return null;
	}

	public Object inputInformation(Object object) {
		Scanner sc = new Scanner(System.in);
		if (object instanceof Student) {
			System.out.println("Hãy nhập tên của sinh viên: ");
			String name = sc.nextLine();
			System.out.println("Hãy nhập tuổi của sinh viên: ");
			int age = sc.nextInt();
			System.out.println("Hãy nhập GPA của sinh viên: ");
			double GPA = sc.nextDouble();
			sc.nextLine();
			System.out.println("Hãy nhập ngành học của sinh viên: ");
			String major = sc.nextLine();
			Student student = new Student(StringController.ucFirst(name), age, ((Student) object).getId(), GPA, major);
			return student;
		} else {
			System.out.println("Hãy nhập tên của giảng viên: ");
			String name = sc.nextLine();
			System.out.println("Hãy nhập tuổi của giảng viên: ");
			int age = sc.nextInt();
			System.out.println("Hãy nhập lương của giảng viên: ");
			double salary = sc.nextDouble();
			sc.nextLine();
			System.out.println("Hãy nhập trình độ học vấn của giảng viên: ");
			String archievement = sc.nextLine();
			Teacher teacher = new Teacher(StringController.ucFirst(name), age, ((Teacher) object).getId(), salary,
					archievement);
			return teacher;
		}

	}
}
