package test;

import java.util.List;

interface StudentDaoInterface<T> {
	public void insertStudent(T t);

	public void deleteStudent(T t);

	public void updateStudent(T t);

	public List<T> getStudentList();
}
