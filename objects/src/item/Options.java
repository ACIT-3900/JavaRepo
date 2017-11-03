package item;
import java.util.ArrayList;

/**
 * Created by rodne on 2017-10-11.
 */
public class Options {
    private String courseName;
    private int capacity;
    private ArrayList<Student> classList = new ArrayList<>();

    //Default constructor
    public Options(){
        this.courseName = "";
        this.capacity = 0;
    }
    //Not Default constructor
    public Options(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
    }
    //Returns capacity of Option course
    public int getCapacity(){
        return capacity;
    }
    //Sets capacity of Option course
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    //Returns name of Option course
    public String getCourseName(){
        return courseName;
    }
    //Sets name of Option course
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
    //Returns class list of Option course
    public String getClassList(){
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
    //Sets class list of Option course
    public void setClassList(ArrayList<Student> newClassList){
        this.classList = newClassList;
    }
    //Returns all empty seats of the Option course
    public int getEmptySeats() {
        if(classList == null){
            return capacity;
        }
        else{
            return capacity - classList.size();
        }
    }
    //Removes student from Option course
    public void removeStudent(String studentName){
        for(Student s:classList){
            if (s.getName().equals(studentName)){
                classList.remove(s);
                break;
            }
        }
    }
    //Adds student to class list of Option course
    public void addStudentToList(Student stu){
        classList.add(stu);
    }
    //Checks if student is in Option course
    public String checkStudentInClass(String stuID){
        String checker="";
        for(Student s:classList){
            if(s.getID().equals(stuID)){
                checker = "pos";
                break;
            }
        }
        return checker;
    }
}