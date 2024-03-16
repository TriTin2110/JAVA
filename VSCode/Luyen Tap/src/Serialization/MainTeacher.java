package Serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MainTeacher {
        public static void main(String[] args) {
                // Teacher teacher = new Teacher("Nguyễn Trí Tín", 1);
                File file = new File("D:\\Code\\JAVA\\VSCode\\Luyen Tap\\src\\Serialization\\text.txt");
                // if (!file.exists()) {
                // try {
                // file.createNewFile();

                // } catch (Exception e) {
                // e.printStackTrace();
                // }
                // }

                // try {
                // ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
                // oos.writeObject(teacher);
                // oos.flush();
                // oos.close();
                // } catch (Exception e) {
                // // TODO Auto-generated catch block
                // e.printStackTrace();
                // }

                Teacher teacher = null;
                try {
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
                        teacher = (Teacher) ois.readObject();
                        ois.close();
                } catch (Exception e) {
                        // TODO: handle exception
                        e.printStackTrace();
                }
                System.out.println(teacher.getTenGiaoVien());

        }
}
