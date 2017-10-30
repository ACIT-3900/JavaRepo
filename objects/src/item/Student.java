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
    public String getID(){
        return ID;
    }
    public void setID(String ID){this.ID=ID;}
    public String getName() {
        return firstName+" "+lastName;
    }
    public void setFirstName(String firstName){this.firstName=firstName;}
    public void setLastName(String lastName){this.lastName=lastName;}
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public double getGPA() {
        return GPA;
    }
    public void setGPA(double GPA) {
        this.GPA = GPA;
    }
    public ArrayList<String> getStudentChoices() {
        return studentChoices;
    }
    public void setStudentChoices(ArrayList<String> studentChoices) {
        this.studentChoices = studentChoices;
    }
    public String getAssignedOption(){
        return assignedOption;
    }
    public void setAssignedOption(String assignedOption) {
        this.assignedOption = assignedOption;
    }
    public String getStatus(){
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getReason(){return reason;}
    public void setReason(String reason){this.reason = reason;}
    public String printStudentChoices() {
        if (studentChoices == null) {
            return null;
        } else {
            String str = "";
            for (int i = 0; i < studentChoices.size(); i++) {
                str += studentChoices.get(i) + "\t";
            }
            return str;
        }
    }
}