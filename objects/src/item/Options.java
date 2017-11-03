package item;
import java.util.ArrayList;

/**
 * Created by rodne on 2017-10-11.
 */
public class Options {
    private String courseName;
    private int capacity;
    private ArrayList<Student> classList = new ArrayList<>();

    public Options(){
        this.courseName = "";
        this.capacity = 0;
    }
    public Options(String courseName, int capacity) {
        this.courseName = courseName;
        this.capacity = capacity;
    }
    public int getCapacity(){
        return capacity;
    }
    public void setCapacity(int capacity){
        this.capacity = capacity;
    }
    public String getCourseName(){
        return courseName;
    }
    public void setCourseName(String courseName){
        this.courseName = courseName;
    }
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
    public void setClassList(ArrayList<Student> newClassList){
        this.classList = newClassList;
    }
    public int getEmptySeats() {
        if(classList == null){
            return capacity;
        }
        else{
            return capacity - classList.size();
        }
    }
    public void removeStudent(String studentName){
        for(Student s:classList){
            if (s.getName().equals(studentName)){
                classList.remove(s);
                break;
            }
        }
    }
    public void addStudentToList(Student stu){
        classList.add(stu);
    }
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