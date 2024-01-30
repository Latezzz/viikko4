package main;
import java.io.Serializable;
import java.util.ArrayList;

public class Student implements Serializable{
    private String name;
    private int studentNumber;
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Integer> intGrades = new ArrayList<>();

    Grade newGrade = null;
    public Student(String name, int studentNumber) {
        this.name = name;
        this.studentNumber =  studentNumber;
    }

    public void getInformation() {
        System.out.println(studentNumber + ": " + name);
    }

    public String getName() {
        return name;
    }

    public void addGrade(String course, int grade) {
        newGrade = new Grade(course, grade);
        grades.add(newGrade);
    }

    public void listGradeInformation() {
        for (Grade grade : grades) {
            grade.listInformation();
        }
    }
    // Returns Arraylist containing all the Grade objects
    public ArrayList<Grade> getGrades() {
        return grades;
    }

    // Returns only int values of Grade objects
    public ArrayList<Integer> getIntGrades(){
        for (Grade grade : grades) {
            intGrades.add(grade.getGrade());
        }
        return intGrades;
    }
    


}
