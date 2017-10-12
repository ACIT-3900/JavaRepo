package item;
import java.util.ArrayList;

/**
 * Created by rodne on 2017-10-11.
 */
public class Options {
    private String courseName;
    private int capacity;
    private ArrayList<String> classList;

    public Options(String courseName, int capacity, Object classList){
        this.courseName =  "";
        this.capacity = 0;
        this.classList = null;
    }

    public Options(String courseName, int capacity, ArrayList<String> classList) {
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
                str += classList.get(i) + "\t";
            }
            return str;
        }
    }
}

/**
    I would create an “Option” Class. This class would have a ‘classlist’, and option name, a capacity etc..
        When the  program starts I would read the ‘optiondata’ from wherever it is stored, and create a list of valid options with empty classlists.
        Then as I process students I would do ‘option.add(Student)’. Etc
 */