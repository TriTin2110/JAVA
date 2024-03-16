package dhcntt17btt;
import java.io.Serializable;

public class Student implements Serializable{
/**
	 * 
	 */
private static final long serialVersionUID = 1L;
private String Student_ID;
private String Student_Name;
private double result;
private String Student_Rank;
public Student()
{
	this.Student_ID = "";
	this.Student_Name = "";
	this.result = 10;
	this.Student_Rank = "";
}
public Student(String id, String name, double result)
{
	this.Student_ID = id;
	this.Student_Name = name;
	this.result = result;
	if (result<5) this.Student_Rank = "Fail";
	else this.Student_Rank = "Pass";
}
public String getID()
{
	return this.Student_ID;
}
public String getName()
{
	return this.Student_Name;
}
public double getResult()
{
	return this.result;
}
public String getRank()
{
	return this.Student_Rank;
}
//.....................
public void getID(String id)
{
	this.Student_ID=id;
}
public void setName(String name)
{
	this.Student_Name = name;
}
public void setResult(double result)
{
	this.result  =result;
	if (result<5) this.Student_Rank = "Fail";
	else this.Student_Rank = "Pass";
}

public String getLastname()
{
	String xau[]=this.Student_Name.split("\\s");
	return xau[xau.length-1];
}
public String toString() { 
	 return "Student_ID: "+this.Student_ID+" Student_Name: "+this.Student_Name+" Result: "+this.result+" Rank: "+this.Student_Rank; 
	 }
}
