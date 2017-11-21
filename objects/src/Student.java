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
    private int statusChecker;

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
        this.statusChecker = 0;
    }

    //Not-Default Constructor
    public Student(String id, String firstName, String lastName, int priority, double GPA, ArrayList<String> studentChoices, String assignedOption, String status, String reason, int statusChecker) {
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.GPA = GPA;
        this.studentChoices = studentChoices;
        this.assignedOption = assignedOption;
        this.status = status;
        this.reason = reason;
        this.statusChecker = statusChecker;
    }

    /* GETTERS */

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

    public ArrayList<String> getStudentChoices() {
        return studentChoices;
    }

    public String getAssignedOption(){
        return assignedOption;
    }

    public String getStatus(){
        return status;
    }

    public String getReason(){return reason;}

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getStatusChecker(){
        return statusChecker;
    }

    /* SETTERS */

    public void setID(String ID){
        this.ID=ID;
    }

    public void setFirstName(String firstName){
        this.firstName=firstName;
    }

    public void setLastName(String lastName){
        this.lastName=lastName;
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

    public void setReason(String reason){
        this.reason = reason;
    }

    public void setStatusChecker(int checker){
        this.statusChecker = checker;
    }

}