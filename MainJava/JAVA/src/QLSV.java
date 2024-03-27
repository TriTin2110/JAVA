import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

class Student extends Person {
    String studentId;

    Student(String name, int age, String studentId) {
        super(name, age);
        this.studentId = studentId;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Student ID: " + studentId);
    }
}

class Teacher extends Person {
    String faculty;

    Teacher(String name, int age, String faculty) {
        super(name, age);
        this.faculty = faculty;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Faculty: " + faculty);
    }
}

public class QLSV {
    public static void main(String[] args) {
        ArrayList<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Thêm sinh viên và giảng viên vào danh sách
        people.add(new Student("Student1", 20, "S001"));
        people.add(new Teacher("Teacher1", 30, "Mathematics"));

        // Hiển thị thông tin của tất cả người trong danh sách
        for (Person person : people) {
            person.displayInfo();
            System.out.println("---------------");
        }

        // Đóng Scanner
        scanner.close();
    }
}