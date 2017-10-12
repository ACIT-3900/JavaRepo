package item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws FileNotFoundException {

        //Student ID, Name, Status, Priority, and GPA. Does not include choices.
        int studentInformation = 6;

        //Filenames
        String studentFileName = "StudentList.csv";
        String optionsFileName = "OptionList.csv";

        BufferedReader br1 = null;
        BufferedReader br2 = null;
        try{
            br1 = new BufferedReader(new FileReader("StudentList.csv"));
            br2 = new BufferedReader(new FileReader("OptionList.csv"));

            List<Options> optlist = new ArrayList<>();
            List<Student> stulist = new ArrayList<>();

            String line1 = "";
            String line2 = "";

            //Skips first line
            br1.readLine();
            br2.readLine();

            while ((line1 = br1.readLine()) != null){

                String[] studentInfo = line1.split(COMMA_DELIMITER);

                if(studentInfo.length>0){

                    ArrayList list = new ArrayList();

                    //Puts all choices in an ArrayList
                    while(studentInformation<studentInfo.length){
                        String ch = studentInfo[studentInformation];
                        list.add(ch);
                        studentInformation++;
                    }

                    //Adds student objects to student list
                    Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[4]), Double.parseDouble(studentInfo[5]), list, null, studentInfo[3]);
                    stulist.add(stu);
                }
                //Prints out student information
                for(Student s:stulist){
                System.out.println("Student ID: "+s.getID()+"\t"+
                        "Student Name: "+s.getName()+"\t"+
                        "Student Status: "+s.getStatus()+"\t"+
                        "Student GPA: "+s.getGPA()+"\t"+
                        "Student Priority: "+s.getPriority()+"\t"+
                        "Student Choices: "+s.getStudentChoices());
                }

            }

//            while ((line1 = br1.readLine()) != null || (line2 = br2.readLine()) != null){
//                if (line1 == null){
//                    line1 = "";
//                }
//                if (line2 == null){
//                    line2 = "";
//                }
//
//                String[] studentInfo = line1.split(COMMA_DELIMITER);
//                String[] optionInfo = line2.split(COMMA_DELIMITER);
//
//                System.out.println(line1);
//                System.out.println(line2);
//
//                if(optionInfo.length>0){
//
//                    Options opt = new Options(optionInfo[0], Integer.parseInt(optionInfo[1]), null);
//                    optlist.add(opt);
//                }
//
//                if(studentInfo.length>0){
//
//                    ArrayList list = new ArrayList();
//
//                    //Variable to acquire the number of choices
//                    int CHOICES = studentInfo.length - studentInformation;
//
//                    //Puts all choices in an ArrayList
//                    while(studentInformation<studentInfo.length){
//                        String ch = studentInfo[studentInformation];
//                        list.add(ch);
//                        studentInformation++;
//                    }
//
//                    //Adds student objects to student list
//                    Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[4]), Double.parseDouble(studentInfo[5]), list, null, studentInfo[3]);
//                    stulist.add(stu);
//                }
//            }
//
//            //Prints out Options information
//            for(Options o:optlist){
//                System.out.println("Name: "+o.getCourseName()+"\t"+
//                        "Capacity: "+o.getCapacity()+"\t"+
//                        "Class List: "+o.getClassList()+"\t");
//            }

//            //Prints out student information
//            for(Student s:stulist){
//                System.out.println("Student ID: "+s.getID()+"\t"+
//                        "Student Name: "+s.getName()+"\t"+
//                        "Student Status: "+s.getStatus()+"\t"+
//                        "Student GPA: "+s.getGPA()+"\t"+
//                        "Student Priority: "+s.getPriority()+"\t"+
//                        "Student Choices: "+s.getStudentChoices());
//            }

        }
        catch(Exception ee){
            ee.printStackTrace();
        }
        finally{
            try
            {
                br1.close();
                br2.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occurred while closing BufferReader");
                ie.printStackTrace();
            }
        }
    }
}