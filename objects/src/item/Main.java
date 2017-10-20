package item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;


public class Main {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws FileNotFoundException {

        try {
            ArrayList<Student> stulist = new ArrayList<>();
            ArrayList<Options> optlist = new ArrayList<>();
            ReadOptionList(optlist, "OptionList2.csv");
            ReadStudentList(stulist, "StudentList2.csv");
            Placement place = new Placement(stulist, optlist);
            place.displayGPA();
            for (Options o : optlist) {
                System.out.println("Course Name: " + o.getCourseName() + "\t" +
                        "Course Capacity: " + o.getCapacity() + "\t" +
                        "Class List: " + o.getClassList() + "\t" +
                                    "Empty Seats: " + o.getEmptySeats());
                        }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void ReadStudentList(ArrayList <Student> stulist, String filename)throws IOException{
        BufferedReader br;
        String line;


        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            ArrayList<String> studentChoices = new ArrayList<>();
            if(studentInfo.length>0){
                int studentInformation = 6;
                while(studentInformation < studentInfo.length){
                    String choice = studentInfo[studentInformation];
                    studentChoices.add(choice);
                    studentInformation++;
                }
                Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[4]), Double.parseDouble(studentInfo[5]), studentChoices, null, studentInfo[3]);
                stulist.add(stu);
            }
        }
    }

    public static void ReadOptionList(ArrayList <Options> optlist, String filename)throws IOException{
        BufferedReader br;
        String line;
        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] optionInfo = line.split(COMMA_DELIMITER);
            if(optionInfo.length>0){
                Options opt = new Options(optionInfo[0], Integer.parseInt(optionInfo[1]));
                optlist.add(opt);
            }
        }
    }
}