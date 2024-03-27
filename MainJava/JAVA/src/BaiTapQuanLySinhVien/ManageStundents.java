package BaiTapQuanLySinhVien;

import java.util.ArrayList;
import java.util.Collections;

class ManageStundents implements ManageStudentInterface {
	private ArrayList<Student> listStudents;

	public ManageStundents() {
		this.listStudents = new ArrayList<>();
		this.listStudents = new ArrayList<>();
	}

	public ArrayList<Student> getListStudents() {
		return listStudents;
	}

	public void setListStudents(ArrayList<Student> listStudents) {
		this.listStudents = listStudents;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		// Kiểm tra sinh viên đã tồn tại trong danh sách hay chưa
		if (findingStudent(student) == null)
			listStudents.add(student);
		else {
			System.out.println("Không thể thêm sinh viên do trùng id hoặc id không hợp lệ");
		}
	}

	@Override
	public void printList() {
		// TODO Auto-generated method stub
		this.listStudents.forEach(student -> System.out.println(student));
	}

	@Override
	public void deleteStudent(Student student) {
		// TODO Auto-generated method stub
		// Nếu sinh viên tồn tại trong danh sách thì sẽ xóa sinh viên đó khỏi danh sách
		student = findingStudent(student);
		if (student != null) {
			listStudents.remove(student);
		} else {
			System.out.println("Sinh viên không tồn tại trong danh sách!");
		}
	}

	@Override
	public void updateStudent(Student newStudent, Student oldStudent) {
		// TODO Auto-generated method stub
		oldStudent.setAge(newStudent.getAge());
		oldStudent.setName(newStudent.getName());
		oldStudent.setGPA(newStudent.getGPA());
		oldStudent.setSubject(newStudent.getSubject());
		oldStudent.setTuition(newStudent.getTuition());
	}

	@Override
	public Student findingStudent(Student student) {
		for (Student stu : listStudents) {
			if (stu.getId() == student.getId())
				return stu;
		}
		return null;
	}

	// Sắp xếp danh sách theo tên
	@Override
	public void sortListByName() {
		// TODO Auto-generated method stub
		Collections.sort(listStudents, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
	}

	// Sắp xếp danh sách theo GPA
	@Override
	public void sortListByGPA() {
		// TODO Auto-generated method stub
		Collections.sort(listStudents, (o1, o2) -> Double.compare(o1.getGPA(), o2.getGPA()));
	}

}
