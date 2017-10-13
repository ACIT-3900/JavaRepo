import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String args[]){
        try
        {

            ArrayList<Student> stulist = new ArrayList<>();
            ReadStudentChoices(stulist, "StudentChoices.csv");
            ReadStudentGPA(stulist, "StudentGPA.csv");

            //Print Student List
            for(Student s:stulist){
                System.out.println(s.getID()+"\n"+s.getName()+"\nGPA: "+s.getGPA()+"\n"+s.getPriority()+"\n"+s.getStatus()+"\n"+s.getStudentChoices());
                System.out.println("---------***--------");
            }

        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void ReadStudentChoices(ArrayList<Student> stulist, String filename) throws IOException {

        BufferedReader br;
        String line;
        //Reading CSV file
        br = new BufferedReader(new FileReader(filename));

        //Read to skip the header
        br.readLine();

        //Reading from second line
        while ((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            ArrayList<String> studentChoices = new ArrayList<>();
            if(studentInfo.length>0){

                //save option choices made by student
                studentChoices.add(studentInfo[5]);
                studentChoices.add(studentInfo[6]);
                studentChoices.add(studentInfo[7]);
                studentChoices.add(studentInfo[8]);

                //Save details
                Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[3]), studentInfo[4], studentChoices);
                stulist.add(stu);
            }
        }
    }
    public static void ReadStudentGPA(ArrayList<Student> stulist, String filename) throws IOException {

        String line;
        BufferedReader br;
        br = new BufferedReader(new FileReader("StudentGPA.csv"));
        br.readLine();

        while ((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            if(studentInfo.length>0){

                for (Student s : stulist) {
                    if(s.getID().equals(studentInfo[0])){
                        s.setGPA(Double.parseDouble(studentInfo[1]));
                        break;
                    }
                }
            }
        }
    }
}
