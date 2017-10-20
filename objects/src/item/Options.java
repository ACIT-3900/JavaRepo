package item;
import java.util.ArrayList;

/**
 * Created by rodne on 2017-10-11.
 */
public class Options {
    private String courseName;
    private int capacity;
    private ArrayList<Student> classList = new ArrayList<>();

    public Options(String courseName, int capacity) {

        this.courseName = courseName;
        this.capacity = capacity;
    }

    public void setCourseName(String courseName){
        this.courseName = courseName;
    }

    public void setCapacity(int capacity){
        this.capacity = capacity;
    }

    public void setClassList(ArrayList<Student> newClassList){
        this.classList = newClassList;
    }

    public String getCourseName(){
        return courseName;
    }

    public int getCapacity(){
        return capacity;
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

    public int getEmptySeats() {
        if(classList == null){
            return capacity;
        }
        else{
            return capacity - classList.size();
        }
    }

    public void addStudentToList(Student stu){
        classList.add(stu);
    }
}