package dhcntt17btt;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main_StudentProgram {
	public static boolean save_to_file(LinkedList<Student> ds, String path) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ds);
            oos.close();
            fos.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    @SuppressWarnings("unchecked")
	public static LinkedList<Student> read_from_file(String path) {
        
        LinkedList<Student> s=null;
		try {
            FileInputStream fis = new FileInputStream(path);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            s = (LinkedList<Student>) o;
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Student_Manager quanly = new Student_Manager(); Student list[] = new
		 * Student[100];
		 */
		/*
		 * Student_Manager_AL quanly = new Student_Manager_AL(); ArrayList<Student> list
		 * = new ArrayList<Student>();
		 */
		 
		 Student_Manager_LL quanly = new Student_Manager_LL(); 
		 LinkedList<Student> list = new LinkedList<Student>();
		 int menu = 1;
		while (menu!=7)
		{
			System.out.println("MAIN STUDENT MANAGEMENT PROGRAM");
			System.out.println("0:Open|1:Input|2:Output|3:Search|4:Sort|5:Delete|6:Save|7:Exit");
			menu = Student_Manager.input.nextInt();
			Student_Manager.input.nextLine();
			switch (menu) {
			case 0: {list=read_from_file("DSSinhvien.dat");break;}
			case 1: {quanly.InputStudentList(list);break;}
			case 2: {quanly.OutputStudentList(list);break;}
			case 3: {quanly.SearchStudent(list);break;}
			case 4: {quanly.Sort(list);break;}
			case 5: {quanly.deleteStudent(list);break;}
			case 6: {save_to_file(list,"DSSinhvien.dat");break;}
			case 7: {break;}
			}
		}
	
		
	}

}
