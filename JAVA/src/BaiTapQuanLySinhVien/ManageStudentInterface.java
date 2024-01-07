package BaiTapQuanLySinhVien;

/*interface ManageStudentInterface dùng để tạo những phương thức quản lý sinh viên
 * Sau đó lớp ManageStundentsAndTeachers sẽ hiện thực lại những phương thức này*/
interface ManageStudentInterface {
	public void addStudent(Student student);

	public void printList();

	public void deleteStudent(Student student);

	public void updateStudent(Student student, Student oldStudent);

	public Student findingStudent(Student student);

	public void sortListByName();

	public void sortListByGPA();
}
