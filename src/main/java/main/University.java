package main;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class University {
    final private String FILENAME;
    private ArrayList<Student> students = new ArrayList<>();

    public University(){
        FILENAME = "students.data";
    }

    public void addStudent(Student student) {
        students.add(student);
    }
    public Student getStudentById(int id) {
        return students.get(id);
    }

    public void listStudents() {
        int i = 0;
        for (Student student : students) {
            System.out.println(i + ": " + student.getName());
            i++;
        }
    }

    public void listStudentInformation() {
        for (Student student : students) {
            student.getInformation();
        }
    }

    public void saveStudents() {
        try {
            ObjectOutputStream studentWriter = new ObjectOutputStream(new FileOutputStream(FILENAME));
            studentWriter.writeObject(students);
            studentWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("Virhe tiedoston kirjoittamisessa");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Virhe tiedoston kirjoittamisessa");
            e.printStackTrace();
        }
    }

    public void loadStudents() {
        try {
            ObjectInputStream studentLoader = new ObjectInputStream(new FileInputStream(FILENAME));
            students = (ArrayList<Student>) studentLoader.readObject();
            studentLoader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Virhe tiedoston lataamisessa");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Virhe tiedoston lataamisessa");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Virhe tiedoston lataamisessa");
            e.printStackTrace();
        }
    }
}
