package item;
import java.util.ArrayList;


/**
 * Created by rodne on 2017-10-11.
 */
public class Options {
    private String courseName;
    private int capacity;
    private ArrayList<Student> classList = new ArrayList<Student>();

    public Options(String courseName, int capacity){
        this.courseName =  "";
        this.capacity = 0;
    }

    public Options(String courseName, int capacity, ArrayList<Student> classList) {
        this.courseName = courseName;
        this.capacity = capacity;
        this.classList = classList;
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
            int emptySeats = capacity - classList.size();
            return emptySeats;
        }
    }

    public void setClassList(ArrayList<Student> newList){
        this.classList = newList;
    }

    public void addStudentToList(Student student){
        if(student == null){
            System.out.println("suck all");
        }
        else{
            this.classList.add(student);
        }
    }
}

/**
    I would create an “Option” Class. This class would have a ‘classlist’, and option name, a capacity etc..
        When the  program starts I would read the ‘optiondata’ from wherever it is stored, and create a list of valid options with empty classlists.
        Then as I process students I would do ‘option.add(Student)’. Etc
 */