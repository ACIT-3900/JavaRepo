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

        String fileName = "pierecipe.csv";


        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(fileName));

            List<Student> stulist = new ArrayList<>();
            String line ="";

            br.readLine();

            while ((line = br.readLine()) != null){
                String[] studentInfo = line.split(COMMA_DELIMITER);
//                System.out.println("LENGTH  " + studentInfo.length);
//                System.out.println("SECOND  " + String.valueOf(studentInfo.length -6));
//
//                System.out.println("FOURTH  "+line);
//
//                System.out.print(studentInfo[0] + "\n");
//                System.out.print(studentInfo[1] + "\n");
//                System.out.print(studentInfo[2] + "\n");
//                System.out.print(studentInfo[3] + "\n");
//                System.out.print(studentInfo[4] + "\n");
//                System.out.print(studentInfo[5] + "\n");
//                System.out.print(studentInfo[6] + "\n");
//                System.out.print(studentInfo[7] + "\n");
//                System.out.print(studentInfo[8] + "\n");
//                System.out.print(studentInfo[9] + "\n"  + "\n");

                if(studentInfo.length>0){

                    //Variable to include first 6 indexes when reading file. Includes: ID, First Name, Last Name, Status, Priority, and GPA. Made to grab all student choices
                    int SUM_WASTE = 6;
                    int i = 0;


//                    while(SUM_WASTE<studentInfo.length){
//                        String cherry = studentInfo[SUM_WASTE];
//                        list.add(cherry);
//                        SUM_WASTE++;
//                    }

                    List<String> list = new ArrayList<>();
                    list.add("apple");
                    list.add("blue");

                    Student stu = new Student("A00123456", "Bob","Marley",1,12.50,list,null,"failed");
                    Student stu2 = new Student("A00123456", "Trevor","Linden",2,12.50,null,null,null);
                    stulist.add(stu);
                    stulist.add(stu2);
//                    System.out.print(studentInfo[1] + "\n");
//                    System.out.print(studentInfo[2] + "\n");
//                    System.out.print(studentInfo[3] + "\n");
//                    System.out.print(studentInfo[4] + "\n");
//                    System.out.print(studentInfo[5] + "\n");
//                    System.out.print(studentInfo[6] + "\n");
//                    System.out.print(studentInfo[7] + "\n");
//                    System.out.print(studentInfo[8] + "\n");
//                    System.out.print(studentInfo[9] + "\n"  + "\n");
//
//                    Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[4]), Double.parseDouble(studentInfo[5]), list, null, studentInfo[3]);
//                    stulist.add(stu);
                }
            }

            for(Student s:stulist){
                System.out.println("Student ID: "+s.getID()+"\t"+
                        "Student Name: "+s.getName()+"\t"+
                        "Student Status: "+s.getStatus()+"\t"+
                        "Student GPA: "+s.getGPA()+"\t"+
                        "Student Priority: "+s.getPriority()+"\t"+
                        "Student Choices: "+s.getStudentChoices());
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