package main;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args ) {
        Scanner sc = new Scanner(System.in);

        Student newStudent = null;
        University university = new University();
        Calculator calculator = new Calculator();

        boolean exit = false;
        while (!exit) {
            System.out.println("1) Lisää opiskelija, 2) Listaa opiskelijat, 3) Lisää opiskelijalle suorite, 4) Listaa opiskelijan suoritteet, 5) Laske opiskelijan suoritusten keskiarvo, 6) Laske opiskelijan suoritusten mediaani, 7) Tallenna opiskelijat tiedostoon, 8) Lataa opiskelijat tiedostosta, 0) Lopeta ohjelma");

            if (sc.hasNext()) {
                int i =  0;
                String input = sc.nextLine();
                i = Integer.parseInt(input);

                switch (i) {

                    case 1:
                        System.out.println("Anna opiskelijan nimi?");
                        String name = sc.nextLine();
                        System.out.println("Anna opiskelijan opiskelijanumero:");
                        int studentNumber = Integer.parseInt(sc.nextLine());

                        newStudent = new Student(name, studentNumber);
                        university.addStudent(newStudent);

                        break;
                    case 2:
                        System.out.println("Opiskelijat:");
                        university.listStudentInformation();

                        break;
                    case 3:
                        university.listStudents();
                        System.out.println("Mille opiskelijalle suorite lisätään?");
                        int id = Integer.parseInt(sc.nextLine());
                        Student s = university.getStudentById(id);
                        
                        System.out.println("Mille kurssille suorite lisätään?");
                        String courseName = sc.nextLine();
                        System.out.println("Mikä arvosana kurssille lisätään?");
                        int courseGrade =Integer.parseInt( sc.nextLine());
                        
                        s.addGrade(courseName, courseGrade);              

                        break;
                    case 4:
                        university.listStudents();
                        System.out.println("Minkä opiskelijan suoritteet listataan?");
                        int id2 = Integer.parseInt(sc.nextLine());
                        Student s2 = university.getStudentById(id2);

                        s2.listGradeInformation();

                        break;
                    case 5:
                        university.listStudents();
                        System.out.println("Minkä opiskelijan suoritteiden keskiarvo lasketaan?");
                        int id3 = Integer.parseInt(sc.nextLine());
                        Student s3 = university.getStudentById(id3);                        
                        
                        double average = calculator.getAverageGrade(s3);
                        System.out.println("Keskiarvo on " + average);
                        break;
                    case 6:
                        university.listStudents();
                        System.out.println("Minkä opiskelijan suoritteiden mediaani lasketaan?");
                        int id4 = Integer.parseInt(sc.nextLine());
                        Student s4 = university.getStudentById(id4);

                        double median = calculator.getMedianGrade(s4);
                        System.out.println("Mediaani on " + median);
                        break;
                    case 7:
                        university.saveStudents();

                        break;
                    case 8:
                        university.loadStudents();

                        break;
                    case 0:
                        System.out.println("Kiitos ohjelman käytöstä.");
                        exit = true;

                        break;                          
                    default:
                        System.out.println("Syöte oli väärä");

                        break;
                }

            }

        }
        sc.close();
    }

}
