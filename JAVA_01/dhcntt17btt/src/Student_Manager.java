package dhcntt17btt;
import java.util.Scanner;

public class Student_Manager {

static int num;
static Scanner input = new Scanner(System.in);
public void InputStudentList(Student list[])
{
	System.out.println("INPUT STUDENT LIST");
	System.out.println("Input number of students: ");
	num = input.nextInt();
	input.nextLine();
	for (int i=0;i<num;i++) {
		System.out.println("Input student information: ");
		String xau[] = Student_Manager.input.nextLine().split("\\s");
		String name = "";
		double result = Double.parseDouble(xau[xau.length-1]);
		for (int j=1;j<xau.length-1;j++) {
			name = name.concat(xau[j]);
			name = name.concat(" ");
		}
	    list[i]= new Student(xau[0],name,result);
		
		}
	
	
}
public void OutputStudentList(Student list[])
{
	System.out.println("OUTPUT STUDENT LIST");
	System.out.printf("%-20s%-20s%-20s%-20s%n","Student_ID","Student_name","Result","Rank");
	for (int i=0;i<num;i++) {
		System.out.printf("%-20s%-20s%-20.1f%-20s%n",list[i].getID(),list[i].getName(),list[i].getResult(),list[i].getRank());
	}
}
public int SearchbyID(Student list[],String id)
{
	for (int i=0;i<num;i++) if (list[i].getID().compareTo(id)==0) return i;
	return -1;
}
public int SearchbyName(Student list[],String name)
{
	for (int i=0;i<num;i++) if (list[i].getName().compareTo(name)==0) return i;
	return -1;
}
public void SearchStudent(Student list[])
{
	System.out.println("Find student by: (id/name)?");
	String tk = input.nextLine();
	if (tk.compareTo("id")==0) {
		System.out.println("Input student id: ");
		String id = input.nextLine();
		if (SearchbyID(list,id)==-1) System.out.println("No student id in the list");
		else System.out.println(list[SearchbyID(list,id)]);
	}
	if (tk.compareTo("name")==0) {
		System.out.println("Input student name: ");
		String name = input.nextLine();
		if (SearchbyID(list,name)==-1) System.out.println("No student name in the list");
		else System.out.println(list[SearchbyName(list,name)]);
	}
}
public void SortbyResult(Student list[])
{
	for (int i = 0; i<num-1; i++)
		for (int j =i+1;j<num;j++)
		{
			if (list[i].getResult()>list[j].getResult()) {
				Student temp = list[i];
				list[i]=list[j];
				list[j]=temp;
			}
		}
}
public void SortbyName(Student list[])
{
	for (int i = 0; i<num-1; i++)
		for (int j =i+1;j<num;j++)
		{
			if (list[i].getLastname().compareTo(list[j].getLastname())>0) {
				Student temp = list[i];
				list[i]=list[j];
				list[j]=temp;
			}
		}
}
public void Sort(Student list[])
{
	System.out.println("Sort student by: (result/name)?");
	String sb = input.nextLine();
	if (sb.compareTo("result")==0) SortbyResult(list);
	if (sb.compareTo("name")==0) SortbyName(list);
}
public void deleteStudent(Student list[])
{
	System.out.println("Input Studen id: ");
	String id = input.nextLine();
	if (SearchbyID(list,id)==-1) System.out.println("No student in the list");
	else if (SearchbyID(list,id)==num-1) num--;
	else {
		for (int i=SearchbyID(list,id);i<num-1;i++) list[i]=list[i+1];
		num--;
	}
}
public void AddStudent(Student list[])
{
	System.out.println("Input student information: ");
	String xau[] = Student_Manager.input.nextLine().split("\\s");
	String name = "";
	double result = Double.parseDouble(xau[xau.length-1]);
	for (int j=1;j<xau.length-1;j++) {
		name = name.concat(xau[j]);
		name = name.concat(" ");
	}
    list[num]= new Student(xau[0],name,result);
    num++;
	
	}
}

