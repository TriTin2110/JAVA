package dhcntt17btt;

import java.util.ArrayList;
import java.util.Scanner;

public class Student_Manager_AL {
	static Scanner input = new Scanner(System.in);
	public void InputStudentList(ArrayList<Student> list)
	{
		System.out.println("INPUT STUDENT LIST");
			String nhap = "ok";
			while (nhap.compareTo("")!=0)
			{
			System.out.println("Input student information: ");
			nhap = input.nextLine();
			if (nhap.compareTo("")!=0)
			{
			String xau[] = nhap.split("\\s");
			String name = "";
			double result = Double.parseDouble(xau[xau.length-1]);
			for (int j=1;j<xau.length-1;j++) {
				name = name.concat(xau[j]);
				name = name.concat(" ");
			}
		    list.add(new Student(xau[0],name,result));
			}
			}
	}
	public void OutputStudentList(ArrayList<Student> list)
	{
		System.out.println("OUTPUT STUDENT LIST");
		System.out.printf("%-20s%-20s%-20s%-20s%n","Student_ID","Student_name","Result","Rank");
		for (int i=0;i<list.size();i++) {
			System.out.printf("%-20s%-20s%-20.1f%-20s%n",list.get(i).getID(),list.get(i).getName(),list.get(i).getResult(),list.get(i).getRank());
		}
	}
	public int SearchbyID(ArrayList<Student> list,String id)
	{
		for (int i=0;i<list.size();i++) if (list.get(i).getID().compareTo(id)==0) return i;
		return -1;
	}
	public int SearchbyName(ArrayList<Student> list,String name)
	{
		for (int i=0;i<list.size();i++) if (list.get(i).getName().compareTo(name)==0) return i;
		return -1;
	}
	public void SearchStudent(ArrayList<Student> list)
	{
		System.out.println("Find student by: (id/name)?");
		String tk = input.nextLine();
		if (tk.compareTo("id")==0) {
			System.out.println("Input student id: ");
			String id = input.nextLine();
			if (SearchbyID(list,id)==-1) System.out.println("No student id in the list");
			else System.out.println(list.get(SearchbyID(list,id)));
		}
		if (tk.compareTo("name")==0) {
			System.out.println("Input student name: ");
			String name = input.nextLine();
			if (SearchbyName(list,name)==-1) System.out.println("No student name in the list");
			else System.out.println(list.get(SearchbyName(list,name)));
		}
	}
	public void Sort(ArrayList<Student> list)
	{
		System.out.println("Sort student by: (result/name)?");
		String sb = input.nextLine();
		if (sb.compareTo("result")==0) SortbyResult(list);
		if (sb.compareTo("name")==0) SortbyName(list);
	}
public void SortbyResult(ArrayList<Student> list)
	{
		for (int i = 0; i<list.size()-1; i++)
			for (int j =i+1;j<list.size();j++)
			{
				if (list.get(i).getResult()>list.get(j).getResult()) {
					Student temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
	}
	public void SortbyName(ArrayList<Student> list)
	{
		for (int i = 0; i<list.size(); i++) {
			for (int j =i+1;j<list.size();j++)
			{
				if (list.get(i).getLastname().compareTo(list.get(j).getLastname())>0) {
					Student temp = list.get(i);
					list.set(i,list.get(j));
					list.set(j,temp);
				}
			}
		}
	}
	public void deleteStudent(ArrayList<Student> list)
	{
		System.out.println("Input Studen id: ");
		String id = input.nextLine();
		if (SearchbyID(list,id)==-1) System.out.println("No student in the list");
		else list.remove(SearchbyID(list,id));
		
	}	
}

