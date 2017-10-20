package item;
import java.util.ArrayList;

public class Student {
    private String ID;
    private String firstName;
    private String lastName;
    private int priority;
    private double GPA;
    private ArrayList<String> studentChoices;
    private String assignedOption;
    private String status;

    public Student(){
        this.ID =  "A00000000";
        this.firstName = "";
        this.lastName = "";
        this.priority = 0;
        this.GPA = 0;
        this.studentChoices = null;
        this.assignedOption = "";
        this.status = "";

    }

    public Student(String id, String firstName, String lastName, int priority, double GPA, ArrayList<String> studentChoices, String assignedOptionOption, String status) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.GPA = GPA;
        this.studentChoices = studentChoices;
        this.assignedOption = assignedOption;
        this.status = status;
    }

    public String getID(){
        return ID;
    }

    public String getName() {
        return firstName+" "+lastName;
    }

    public int getPriority() {
        return priority;
    }

    public double getGPA() {
        return GPA;
    }

    public String getAssignedOption(){
        return assignedOption;
    }

    public String getStatus(){
        return status;
    }

    public ArrayList<String> getStudentChoices() {
        return studentChoices;
    }

    public String getStudentFirstChoice(){
        if (studentChoices == null) {
            return null;
        } else {
            String str = studentChoices.get(0);
            return str;
        }
    }

    public String getStudentSecondChoice(){
        if (studentChoices == null) {
            return null;
        } else {
            String str = studentChoices.get(1);
            return str;
        }
    }

    public String getStudentThirdChoice(){
        if (studentChoices == null) {
            return null;
        } else {
            String str = studentChoices.get(2);
            return str;
        }
    }

    public String getStudentFourthChoice(){
        if (studentChoices == null) {
            return null;
        } else {
            String str = studentChoices.get(3);
            return str;
        }
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setGPA(double GPA) {
        this.GPA = GPA;
    }

    public void setStudentChoices(ArrayList<String> studentChoices) {
        this.studentChoices = studentChoices;
    }

    public void setAssignedOption(String assignedOption) {
        this.assignedOption = assignedOption;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}