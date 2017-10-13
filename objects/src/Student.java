import java.util.ArrayList;

/**
 * Created by mohd on 2017-09-29.
 */
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


    Student(String id, String firstName, String lastName, int priority, String status, ArrayList<String> studentChoices){
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        if(status.equals("")) {
            this.status = "Eligible";
        }
        this.studentChoices = studentChoices;

    }

    Student(String id, double GPA, String lastName, String firstName){
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.GPA = GPA;

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAssignedOption() {
        return assignedOption;
    }

    public String getStatus() {
        return status;
    }

    String getID(){
        return ID;
    }

    String getName() {
        return firstName+" "+lastName;
    }

    int getPriority() {
        return priority;
    }

    double getGPA() {
        return GPA;
    }

    String getStudentChoices() {
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

