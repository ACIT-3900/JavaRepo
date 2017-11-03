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
    private String reason;

    //Default Constructor
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
    //Not-Default Constructor
    public Student(String id, String firstName, String lastName, int priority, double GPA, ArrayList<String> studentChoices, String assignedOption, String status, String reason) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.GPA = GPA;
        this.studentChoices = studentChoices;
        this.assignedOption = assignedOption;
        this.status = status;
        this.reason = reason;
    }
    //Returns the ID of the student
    public String getID(){
        return ID;
    }
    //Sets the ID of the student
    public void setID(String ID){this.ID=ID;}
    //Returns first and last name of the student
    public String getName() {
        return firstName+" "+lastName;
    }
    //Sets the first name of the student
    public void setFirstName(String firstName){this.firstName=firstName;}
    //Sets the last name of the student
    public void setLastName(String lastName){this.lastName=lastName;}
    //Returns the priority of the student
    public int getPriority() {
        return priority;
    }
    //Sets the priority of the student
    public void setPriority(int priority) {
        this.priority = priority;
    }
    //Returs the GPA of the student
    public double getGPA() {
        return GPA;
    }
    //Set GPA of the student
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    //Returns student choices
    public ArrayList<String> getStudentChoices() {
        return studentChoices;
    }
    //Sets student choices
    public void setStudentChoices(ArrayList<String> studentChoices) {
        this.studentChoices = studentChoices;
    }
    //Returns assigned option course of student
    public String getAssignedOption(){
        return assignedOption;
    }
    //Sets assigned option course of student
    public void setAssignedOption(String assignedOption) {
        this.assignedOption = assignedOption;
    }
    //Returns status of student
    public String getStatus(){
        return status;
    }
    //Sets status of student
    public void setStatus(String status) {
        this.status = status;
    }
    //Returns reason why student did not get placed in Options
    public String getReason(){return reason;}
    //Sets reason why student did not get placed in Options
    public void setReason(String reason){this.reason = reason;}
}