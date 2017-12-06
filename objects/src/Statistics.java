import java.util.ArrayList;

/**
 * Statistics.java
 *
 * Input: List of Student objects
 * Output: Shows statistics of student list
 *
 * @author Michael Liao
 * @version 1.1, November 2017
 */
public class Statistics {
    private ArrayList<Student> studentList;

    public Statistics(ArrayList<Student> studentList){
        this.studentList = studentList;
    }

    //Calculates the average GPA of all students
    public void averageGPA(ArrayList<Student> studentList){
        Double gpa = 0.0;
        int numberOfStudents = 0;
        double totalGPA;
        for(Student student:studentList){
            gpa += student.getGPA();
            numberOfStudents++;
        }
        totalGPA = Math.round((gpa/numberOfStudents)*100);
        System.out.println("Average GPA of All Students: "+ totalGPA/100+"%");
    }

    //Calculates the lowest GPA
    public void lowestGPA(ArrayList<Student> studentList){
        double lowestGPA = 100.0;
        String studentID = "";
        for(Student student:studentList) {
            if (student.getGPA() < lowestGPA) {
                lowestGPA = student.getGPA();
                studentID = student.getID();
            }
        }
        System.out.println("Student ID: " + studentID);
        System.out.println("Lowest GPA: " + lowestGPA + "%");
    }

    //Calculates the highest GPA
    public void highestGPA(ArrayList<Student> studentList){
        double highestGPA = 0.0;
        String studentID = "";
        for(Student student:studentList) {
            if (student.getGPA() > highestGPA) {
                highestGPA = student.getGPA();
                studentID = student.getID();
            }
        }
        System.out.println("Student ID: " + studentID);
        System.out.println("Highest GPA: "+ highestGPA+"%");
    }

    //Calculates the total number of students
    public void totalStudents(ArrayList<Student> studentList){
        int numberOfStudents = 0;
        for(Student student:studentList){
            numberOfStudents++;
        }
        System.out.println("Total Number of Students: "+ numberOfStudents);
    }

    //Calculates number of students in each priority
    public void groupPriority(ArrayList<Student> studentList){
        int priorityListOne = 0;
        int priorityListTwo = 0;
        int priorityListThree = 0;
        int priorityListFour = 0;
        int noPriority = 0;

        for (Student student:studentList) {
            if (student.getPriority() == 1){
                priorityListOne++;
            } else if (student.getPriority() == 2){
                priorityListTwo++;
            } else if (student.getPriority() == 3){
                priorityListThree++;
            } else if (student.getPriority() == 4){
                priorityListFour++;
            } else{
                noPriority++;
            }
        }

        System.out.println("Students with Priority Level 1: " + priorityListOne);
        System.out.println("Students with Priority Level 2: " + priorityListTwo);
        System.out.println("Students with Priority Level 3: " + priorityListThree);
        System.out.println("Students with Priority Level 4: " + priorityListFour);
        System.out.println("Students with No Priority Level: " + noPriority);
    }
}
