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
            //ArrayList of Student Objects
            ArrayList<Student> stulist = new ArrayList<>();
            //ArrayList of Options Objects
            ArrayList<Options> optlist = new ArrayList<>();
            //HashSet of Students not placed in a course
            HashSet<Student> nullList = new HashSet<>();
            //Set List of Option names
            Set<String> optName = new HashSet<String>();
            //Set List of Student IDs
            Set<String> stuID = new HashSet<String>();
            //Set List of Null Student IDs
            Set<String> nullStuID = new HashSet<String>();

            ReadOptionList(optlist, "OptionSelectionControl.csv", optName);
            ReadStudentChoices(stulist, "StudentChoices.csv");
            ReadStudentGPA(stulist, "StudentGPA.csv", stuID);
            Placement place = new Placement(stulist, optlist, nullList);
            System.out.println("Speadsheet Statistics");
            place.displayGPA();
            place.averageGPA(stulist);
            place.totalStudents(stulist);
            place.groupPriority(stulist);
            CreateNullStudentIDLIst(nullStuID, nullList);

            Scanner scan = new Scanner(System.in);
            AdminMenu();
            String answer = scan.nextLine();
            while(!answer.equals("q") || !answer.equals("quit")){
                if("a".equals(answer)){
                    StudentMenu();
                    answer = scan.nextLine();
                    while(!answer.equals("d")){
                        if("a".equals(answer)){
                            ViewStudents(stulist);
                        }else if("b".equals(answer)){
                            NullStudents(nullList);
                        }else if("c".equals(answer)){
                            SearchStudent(stulist, stuID, optlist, nullList, optName, nullStuID);
                        }else{
                            System.out.println("Invalid Choice");
                        }
                        StudentMenu();
                        answer = scan.nextLine();
                    }
                }else if("b".equals(answer)){
                    OptionMenu();
                    answer = scan.nextLine();
                    while(!answer.equals("c")){
                        if("a".equals(answer)){
                            ViewOptions(optlist);
                        }else if("b".equals(answer)){
                            SearchOption(optlist, stulist, nullList, stuID, nullStuID);
                        }else{
                            System.out.println("Invalid Choice");
                        }
                        OptionMenu();
                        answer = scan.nextLine();
                    }
                }else{
                    System.out.println("Incorrect choice");
                    break;
                }
                AdminMenu();
                answer = scan.nextLine();
            }
            scan.close();
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }

    //Reads Option CSV file and creates Option objects
    public static void ReadOptionList(ArrayList<Options> optlist, String filename, Set<String> optName)throws IOException{

        BufferedReader br;
        String line;
        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] optionInfo = line.split(COMMA_DELIMITER);
            if(optionInfo.length>0){
                Options opt = new Options(optionInfo[0], Integer.parseInt(optionInfo[1]));
                optlist.add(opt);
                optName.add(optionInfo[0]);
            }
        }
    }
    //Reads Student Choice CSV file and creates Student objects
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
                Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[3]), 0, studentChoices, "", studentInfo[4], "");
                stulist.add(stu);
            }
        }
    }
    //Reads Student GPA CSV file and adds GPA to Student objects
    public static void ReadStudentGPA(ArrayList<Student> stulist, String filename, Set<String> stuID) throws IOException {

        String line;
        BufferedReader br;
        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while ((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            if(studentInfo.length>0){
                for (Student s:stulist) {
                    if(s.getID().equals(studentInfo[0])){
                        Double dbl = Double.parseDouble(studentInfo[1]);
                        s.setGPA(dbl);
                        stuID.add(s.getID());
                        break;
                    }
                }
            }
        }
    }
    //Creates a Set List of null Student IDs
    public static void CreateNullStudentIDLIst(Set<String> nullStuID, HashSet<Student> nullList){
        for(Student stu:nullList){
            nullStuID.add(stu.getID());
        }
    }

    //Admin Menu Method
    public static void AdminMenu(){
        System.out.println("Administrator Menu");
        System.out.println("A) Student Menu");
        System.out.println("B) Option Menu");
        System.out.println("Q) Quit");
    }

    //Student Menu Method
    public static void StudentMenu(){
        System.out.println("Student Menu");
        System.out.println("A) View all students");
        System.out.println("B) View student's who were not placed");
        System.out.println("C) Search for a student");
        System.out.println("D) Go back");
    }
    //Prints all student information
    public static void ViewStudents(ArrayList<Student> stulist){
        for(Student stu:stulist){
            System.out.println("Student ID: "+stu.getID()+"\n"+
                    "Student Name: "+stu.getName()+"\n"+
                    "Student GPA: "+stu.getGPA()+"\n"+
                    "Student Priority: "+stu.getPriority()+"\n"+
                    "Student Status: "+stu.getStatus()+"\n"+
                    "Student Reason: "+stu.getReason()+"\n"+
                    "Student Assigned Option: "+stu.getAssignedOption()+"\n"+
                    "Student Choices: "+stu.getStudentChoices());
            System.out.println("*-------------------------------------*");
        }
    }
    //Prints all student's who did not get placed into Option course
    public static void NullStudents(HashSet<Student> nullList){
        for(Student stu:nullList){
            System.out.println("Student Name: "+stu.getName()+"\n"+"Reason: "+stu.getReason());
            System.out.println("*-------------------------------------*");
        }
    }
    //Prints specified student information
    public static void SearchStudent(ArrayList<Student> stulist, Set<String> stuID, ArrayList<Options> optlist, HashSet<Student> nullList, Set<String> optName, Set<String> nullStuID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter student's ID");
        String answer = scan.nextLine();
        if(stuID.contains(answer)){
            for(Student stu:stulist){
                if(answer.equals(stu.getID())){
                    System.out.println("Student ID: "+stu.getID()+"\n"+
                            "Student Name: "+stu.getName()+"\n"+
                            "Student GPA: "+stu.getGPA()+"\n"+
                            "Student Priority: "+stu.getPriority()+"\n"+
                            "Student Status: "+stu.getStatus()+"\n"+
                            "Student Reason: "+stu.getReason()+"\n"+
                            "Student Assigned Option: "+stu.getAssignedOption()+"\n"+
                            "Student Choices: "+stu.getStudentChoices());
                    System.out.println("A) Add student to Option course"+"\n"+"B) Drop student from Option course"+"\n"+"C) Back");
                    answer = scan.nextLine();
                    if("a".equals(answer)){
                        AddStudent(stu, optlist, nullList, optName, nullStuID);
                        break;
                    }else if("b".equals(answer)){
                        DropStudent(stu, optlist, nullList, nullStuID);
                        break;
                    }else if("c".equals(answer)){
                        break;
                    }
                    else{System.out.println("Invalid Choice");
                    }
                }
            }
        }else{
            System.out.println("Student does not exist");
        }
    }
    //Add student to Option course
    public static void AddStudent(Student stu, ArrayList<Options> optlist, HashSet<Student> nullList, Set<String> optName, Set<String> nullStuID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name you'd like to add the student to");
        String answer = scan.nextLine().trim();
        if(optName.contains(answer)){
            if("NOTHING".equals(stu.getAssignedOption())){
                for(Options opt:optlist){
                    if(answer.equals(opt.getCourseName())){
                        stu.setAssignedOption(opt.getCourseName());
                        opt.addStudentToList(stu);
                        if(nullStuID.contains(stu.getID())){
                            nullList.remove(stu);
                        }
                        break;
                    }
                }
            }else{System.out.println("Student is a part of "+stu.getAssignedOption()+" class. Please remove student first before trying again.");}
        }else{System.out.println("That is not a valid Option course");}
    }
    //Drops student from Option course
    public static void DropStudent(Student stu, ArrayList<Options> optlist, HashSet<Student> nullList, Set<String> nullStuID){
        for(Options opt:optlist){
            if(stu.getAssignedOption().equals(opt.getCourseName())){
                opt.removeStudent(stu.getName());
                stu.setAssignedOption("NOTHING");
                nullList.add(stu);
                nullStuID.add(stu.getName());
                break;
            }
        }
    }

    //Option Menu Methods
    public static void OptionMenu(){
        System.out.println("Option Menu");
        System.out.println("A) View list of Options");
        System.out.println("B) Search for an Option course");
        System.out.println("C) Go back");
    }
    //Prints all Options information
    public static void ViewOptions(ArrayList<Options> optlist){
        for(Options opt:optlist){
            System.out.println("***************************");
            System.out.println("Option Name: "+opt.getCourseName()+"\n"+
                    "Option Capacity: "+opt.getCapacity()+"\n"+
                    "Available Seats: "+opt.getEmptySeats()+"\n"+
                    "Class List: "+opt.getClassList());
        }
    }
    //Prints specified Option information
    public static void SearchOption(ArrayList<Options> optlist, ArrayList<Student> stulist, HashSet<Student> nullList, Set<String> stuID, Set<String> nullStuID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name");
        String answer = scan.nextLine();
        for(Options opt:optlist){
            if(answer.equals(opt.getCourseName())){
                System.out.println("Option Name: "+opt.getCourseName()+"\n"+
                        "Option Capacity: "+opt.getCapacity()+"\n"+
                        "Available Seats: "+opt.getEmptySeats()+"\n"+
                        "Class List: "+opt.getClassList());
                System.out.println("A) Add student to Option course"+"\n"+"B) Drop student from Option course"+"\n"+"C) Back");
                answer = scan.nextLine();
                if("a".equals(answer)){
                    AddStudentToOption(opt, stulist, nullList, stuID, nullStuID);
                    break;
                }else if("b".equals(answer)){
                    DropStudentFromOption(opt, stulist, nullList, nullStuID, stuID);
                    break;
                }else if("c".equals(answer)){
                    break;
                }
                else{System.out.println("Invalid Choice");
                }

            }
        }
    }
    //Adds a student to Option course
    public static void AddStudentToOption(Options opt, ArrayList<Student> stulist, HashSet<Student> nullList, Set<String> stuID, Set<String> nullStuID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of student");
        String answer = scan.nextLine();
        if(stuID.contains(answer)){
            if(opt.checkStudentInClass(answer) != "pos"){
                for(Student stu:stulist){
                    if(stu.getID().equals(answer)){
                        if("NOTHING".equals(stu.getAssignedOption())){
                            opt.addStudentToList(stu);
                            stu.setAssignedOption(opt.getCourseName());
                            if(nullStuID.contains(stu.getID())){
                                nullList.remove(stu);
                            }
                            break;
                        }else{
                            System.out.println("Student is a part of "+stu.getAssignedOption()+" class. Please remove student first before trying again.");
                        }
                    }
                }
            }else{
                System.out.println("Student is already a part of the class.");
            }
        }else{
            System.out.println("Student is not eligible for Options");
        }
    }
    //Drop student from Option course
    public static void DropStudentFromOption(Options opt, ArrayList<Student> stulist, HashSet<Student> nullList, Set<String> nullStuID, Set<String> stuID){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of student");
        String answer = scan.nextLine();
        if(stuID.contains(answer)){
            if("pos".equals(opt.checkStudentInClass(answer))){
                for(Student stu:stulist){
                    if(stu.getID().equals(answer)){
                        opt.removeStudent(stu.getName());
                        stu.setAssignedOption("NOTHING");
                        nullList.add(stu);
                        nullStuID.add(stu.getID());
                    }
                }
            }else{
                System.out.println("Student is not a part of Option course");
            }
        }else{
            System.out.println("Student does not exist");
        }
    }
}