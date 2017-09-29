import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCSVFile {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String args[]){
        BufferedReader br = null;
        try
        {
            //Reading CSV file
            br = new BufferedReader(new FileReader("StudentGPA.csv"));

            List<Student> stulist = new ArrayList<>();

            String line = "";
            //Read to skip the header
            br.readLine();
            //Reading from second line
            while ((line = br.readLine()) != null){
                String[] studentInfo = line.split(COMMA_DELIMITER);

                if(studentInfo.length>0){

                    //Save details
                    Student stu = new Student(studentInfo[0], studentInfo[3], studentInfo[2], 0, Float.parseFloat(studentInfo[1]), null);
                    stulist.add(stu);
                }
            }

            //Lets print Student list
            for(Student s:stulist){
                System.out.println(s.getID()+"\t"+s.getName()+"\t"+s.getGPA()+"\t"+s.getPriority()+"\t"+s.getStudentChoices());
            }
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        finally{

            try
            {
                br.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occurred while closing BufferReader");
                ie.printStackTrace();
            }
        }
    }
}
