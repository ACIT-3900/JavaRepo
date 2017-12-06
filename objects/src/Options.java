import java.util.ArrayList;

/**
 * Options.java
 *
 * Create Option objects
 *
 * @author Rodney Tran and Mohammed Bajaman
 * @version 1.1, Sept 2017
 */

public class Options {
    private String optionName;
    private int capacity;
    private ArrayList<Student> classList = new ArrayList<>();

    //Default Constructor
    public Options(){
        this.optionName = "";
        this.capacity = 0;
    }

    //Not-Default Constructor
    public Options(String optionName, int capacity) {
        this.optionName = optionName;
        this.capacity = capacity;
    }

    /* GETTERS */

    int getCapacity(){
        return capacity;
    }

    String getOptionName(){
        return optionName;
    }

    String getClassList(){
        if (classList == null) {
            return null;
        } else {
            String str = "";
            for (int i = 0; i < classList.size(); i++) {
                str += classList.get(i).getName() + "\t";
            }
            return str;
        }
    }

    /* SETTERS */

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setOptionName(String optionName){
        this.optionName = optionName;
    }

    public void setClassList(ArrayList<Student> newClassList){
        this.classList = newClassList;
    }

    /* FUNCTIONS */

    //Removes Student object from Option class list
    void removeStudent(String studentName){
        for(Student student:classList){
            if (student.getName().equals(studentName)){
                classList.remove(student);
                break;
            }
        }
    }

    //Adds Student object to Option class list
    void addStudentToList(Student student){
        classList.add(student);
    }

    //Checks if student is inside Option class list
    String checkStudentInClass(String studentID){
        String checker="";
        for(Student student:classList){
            if(student.getID().equals(studentID)){
                checker = "pos";
                break;
            }
        }
        return checker;
    }

    //Returns an integer of empty seats in Option class list
    int getEmptySeats() {
        if(classList == null){
            return capacity;
        }
        else{
            return capacity - classList.size();
        }
    }

}