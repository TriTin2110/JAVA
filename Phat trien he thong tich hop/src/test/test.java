package test;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ModelStudent modelStudent1 = new ModelStudent(4, "NTT", 9);
		StudentDao studentDao = new StudentDao();
		studentDao.updateStudent(modelStudent1);

		for (ModelStudent student : studentDao.getStudentList()) {
			System.out.println(student);
		}
	}

}
