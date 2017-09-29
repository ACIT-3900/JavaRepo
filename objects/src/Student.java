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

    public Student(){
        this.ID =  "A00000000";
        this.firstName = "";
        this.lastName = "";
        this.priority = 0;
        this.GPA = 0;
        this.studentChoices = null;

    }

    public Student(String id, String firstName, String lastName, int priority, double GPA, ArrayList<String> studentChoices){
        this.ID = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.priority = priority;
        this.GPA = GPA;
        this.studentChoices = studentChoices;
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

    public String getStudentChoices() {
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

