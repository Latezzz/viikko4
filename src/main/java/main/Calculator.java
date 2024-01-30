package main;

import java.util.*;

public class Calculator {
    
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Integer> medianList = new ArrayList<>();

    public Calculator(){

    }

    public double getAverageGrade(Student s) {
        double result = 0;
        double i = 0;
        double x = 0;
        grades = s.getGrades();
        if (grades.size() != 0) {
            for (Grade grade : grades) {
                x += grade.getGrade();
                i++;
            }
            result = x/i;
        } else {
            result = 0;
        }

        return result;
    }

    public double getMedianGrade(Student s) {
        double result = 0;

        medianList = s.getIntGrades();
        Collections.sort(medianList);
        // If the list is odd
        if (medianList.size() % 2 == 1) {
            int x = (medianList.size()/2);    // To get the median element of the list (when it's odd) we can divided it by 2 and assign it to int which rounds it downwards ex. 7/2 = 3.5 => 3, , which is median element of the list since list elements start form 0
            result = medianList.get(x);
        } 
        // If the list is even
        else {
            int medianElement = medianList.size()/2;
            double y = medianList.get(medianElement - 1);
            double z = medianList.get(medianElement);
            result = (y + z)/2;
        }
        return result;
    }
}
