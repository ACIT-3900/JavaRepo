import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

/**
 * Main.java
 *
 * Main class that performs major functions of program
 *
 * @author Rodney Tran and Mohammed Bajaman
 * @version 1.1, Sept 2017
 */

public class Main {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws FileNotFoundException {

        try {
            //ArrayList of Student Objects
            ArrayList<Student> studentList = new ArrayList<>();
            //ArrayList of Options Objects
            ArrayList<Options> optionList = new ArrayList<>();
            //Set List of Option names
            Set<String> optionNameList = new HashSet<String>();
            //Set List of Student IDs
            Set<String> studentIDList = new HashSet<String>();

            //Reads files in
            ReadOptionList(optionList, "Options.csv", optionNameList);
            ReadStudentChoices(studentList, "StudentChoices2.csv");
            ReadStudentGPA(studentList, "StudentGPA.csv", studentIDList);

            //Performs all functions required to sort students into their Option course
            StudentPlacement place = new StudentPlacement(studentList, optionList);
            place.studentPlacementSort();
            Statistics stats = new Statistics(studentList);

            //Performs Statistics class functions

            System.out.println("SPREADSHEET STATISTICS");
            stats.averageGPA(studentList);
            stats.highestGPA(studentList);
            stats.lowestGPA(studentList);
            stats.totalStudents(studentList);
            stats.groupPriority(studentList);
            System.out.println();

            //Outputs student overflow and ineligible students
            CheckOverFlow(studentList, optionList);
            CheckInEligibleStudents(studentList);

            //Scans in new user input
            Scanner scan = new Scanner(System.in);
            AdminMenu();
            //Sets String userInput as variable of next user input
            String userInput = scan.nextLine();

            //Begin Admin menu
            while(!userInput.equals("q") || !userInput.equals("quit")){
                if("a".equals(userInput)){
                    //If 'a' is entered, go to Student menu
                    StudentMenu();
                    userInput = scan.nextLine();
                    while(!userInput.equals("c")){
                        if("a".equals(userInput)){
                            //If 'a' is entered, views all Students and their information
                            ViewStudents(studentList);
                        }else if("b".equals(userInput)){
                            //If 'b' is entered, allows the user to search for a specific student
                            SearchStudent(studentList, studentIDList, optionList, optionNameList);
                        }else{
                            System.out.println("Invalid Choice");
                        }
                        StudentMenu();
                        userInput = scan.nextLine();
                    }
                }else if("b".equals(userInput)){
                    //If 'b' is entered, go to Option menu
                    OptionMenu();
                    userInput = scan.nextLine();
                    while(!userInput.equals("c")){
                        if("a".equals(userInput)){
                            //If 'a' is entered, views all Options and their information
                            ViewOptions(optionList);
                        }else if("b".equals(userInput)){
                            //If 'b' is entered, allows the user to search for a specific student
                            SearchOption(optionList, studentList, studentIDList);
                        }else{
                            System.out.println("Invalid Choice");
                        }
                        OptionMenu();
                        userInput = scan.nextLine();
                    }
                }else{
                    //If anything else is entered, exit system. Breaks out of loop
                    System.out.println("Goodbye");
                    break;
                }
                //Loops through Admin menu
                AdminMenu();
                userInput = scan.nextLine();
            }
            //Closes scanning of user input
            scan.close();
        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }

    //Reads Option CSV file and creates Option objects
    public static void ReadOptionList(ArrayList<Options> optionList, String filename, Set<String> optionNameList)throws IOException{

        BufferedReader br;
        String line;
        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] optionInfo = line.split(COMMA_DELIMITER);

            //Changes Option choice "Wait for January" to "Wait a term"
            if(optionInfo[0].split(" ")[0].equals("Wait")){
                optionInfo[0] = "Wait a term";
            }

            //Save details and creates new Option object
            if(optionInfo.length>0){
                Options option = new Options(optionInfo[0], Integer.parseInt(optionInfo[1]));
                optionList.add(option);
                optionNameList.add(optionInfo[0]);
            }
        }
    }

    //Reads Student Choice CSV file and creates Student objects
    public static void ReadStudentChoices(ArrayList<Student> studentList, String filename) throws IOException {

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

                //Changes Student choice from "Wait for January" to "Wait a term"
                int position = 5;
                while (position < studentInfo.length){
                    if(studentInfo[position].split(" ")[0].equals("Wait")){
                        studentInfo[position] = "Wait a term";
                    }
                    position++;
                }

                //Save option choices made by student
                studentChoices.add(studentInfo[5]);
                studentChoices.add(studentInfo[6]);
                studentChoices.add(studentInfo[7]);
                studentChoices.add(studentInfo[8]);
                studentChoices.add(studentInfo[9]);
                studentChoices.add(studentInfo[10]);

                //Save details and creates new Student object
                Student student = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[3]), 0, studentChoices, "", studentInfo[4], "", 0);
                studentList.add(student);
            }
        }
    }

    //Reads Student GPA CSV file and adds GPA to Student objects
    public static void ReadStudentGPA(ArrayList<Student> studentList, String filename, Set<String> studentIDList) throws IOException {

        String line;
        BufferedReader br;
        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while ((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            if(studentInfo.length>0){
                for (Student student:studentList) {
                    if(student.getID().equals(studentInfo[0])){
                        Double dbl = Double.parseDouble(studentInfo[1]);
                        student.setGPA(dbl);
                        studentIDList.add(student.getID());
                        break;
                    }
                }
            }
        }
    }

    //Checks to see if number of students is greater than capacity
    public static void CheckOverFlow(ArrayList<Student> studentList, ArrayList<Options> optionList){
        int totalCapacity = 0;
        int totalStudents = studentList.size();

        for(Options option:optionList){
            totalCapacity += option.getCapacity();
        }

        if(totalStudents > totalCapacity){
            System.out.println("Too Many Students! Need " + (totalStudents - totalCapacity) + " Space!!!");
        }else{
            System.out.println("There are just enough space for all students");
        }
    }

    //Prints out all students who are ineligible
    public static void CheckInEligibleStudents(ArrayList<Student> stulist){
        System.out.println("Ineligible Students:");
        for(Student stu:stulist){
            if(stu.getPointChecker() == 1){
                System.out.println("Student ID: " + stu.getID());
                System.out.println("Student Name: " + stu.getName());
                System.out.println("Reason: " + stu.getReason());
                System.out.println();
            }
        }
    }

    //Admin Menu Method
    public static void AdminMenu(){
        System.out.println("Administrator Menu");
        System.out.println("A) Student Menu");
        System.out.println("B) Option Menu");
        System.out.println("Q) Quit");
    }

    /* Functions for Student Menu */

    //Student Menu Method
    public static void StudentMenu(){
        System.out.println("Student Menu");
        System.out.println("A) View all students");
        System.out.println("B) Search for a student");
        System.out.println("C) Go back");
    }

    //Prints all student information
    public static void ViewStudents(ArrayList<Student> studentList){
        for(Student student:studentList){
            System.out.println("Student ID: "+student.getID()+"\n"+
                    "Student Name: "+student.getName()+"\n"+
                    "Student GPA: "+student.getGPA()+"\n"+
                    "Student Priority: "+student.getPriority()+"\n"+
                    "Student Status: "+student.getStatus()+"\n"+
                    "Student Reason: "+student.getReason()+"\n"+
                    "Student Assigned Option: "+student.getAssignedOption()+"\n"+
                    "Student Choices: "+student.getStudentChoices());
            System.out.println("*-------------------------------------*");
        }
    }

    //Searches and prints specified student information
    public static void SearchStudent(ArrayList<Student> studentList, Set<String> studentIDList, ArrayList<Options> optionList, Set<String> optionNameList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter student's ID");
        String userInput = scan.nextLine();
        if(studentIDList.contains(userInput)){
            for(Student student:studentList){
                if(userInput.equals(student.getID())){
                    System.out.println("Student ID: "+student.getID()+"\n"+
                            "Student Name: "+student.getName()+"\n"+
                            "Student GPA: "+student.getGPA()+"\n"+
                            "Student Priority: "+student.getPriority()+"\n"+
                            "Student Status: "+student.getStatus()+"\n"+
                            "Student Reason: "+student.getReason()+"\n"+
                            "Student Assigned Option: "+student.getAssignedOption()+"\n"+
                            "Student Choices: "+student.getStudentChoices());
                    System.out.println("A) Add student to Option course"+"\n"+"B) Drop student from Option course"+"\n"+"C) Back");
                    userInput = scan.nextLine();
                    if("a".equals(userInput)){
                        AddStudent(student, optionList, optionNameList);
                        break;
                    }else if("b".equals(userInput)){
                        DropStudent(student, optionList);
                        break;
                    }else if("c".equals(userInput)){
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
    public static void AddStudent(Student student, ArrayList<Options> optionList, Set<String> optionNameList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name you'd like to add the student to");
        String userInput = scan.nextLine().trim();
        if(optionNameList.contains(userInput)){
            if("NOTHING".equals(student.getAssignedOption())){
                for(Options option : optionList){
                    if(userInput.equals(option.getOptionName())){
                        student.setAssignedOption(option.getOptionName());
                        option.addStudentToList(student);
                        break;
                    }
                }
            }else{System.out.println("Student is a part of " + student.getAssignedOption() + " class. Please remove student first before trying again.");}
        }else{System.out.println("That is not a valid Option course");}
    }

    //Drops student from Option course
    public static void DropStudent(Student student, ArrayList<Options> optionList){
        for(Options option:optionList){
            if(student.getAssignedOption().equals(option.getOptionName())){
                option.removeStudent(student.getName());
                student.setAssignedOption("NOTHING");
                break;
            }
        }
    }


    /* Functions for Option Menu */

    //Option Menu Methods
    public static void OptionMenu(){
        System.out.println("Option Menu");
        System.out.println("A) View list of Options");
        System.out.println("B) Search for an Option course");
        System.out.println("C) Go back");
    }

    //Prints all Option's information
    public static void ViewOptions(ArrayList<Options> optionList){
        for(Options option : optionList){
            System.out.println("***************************");
            System.out.println("Option Name: " + option.getOptionName()+"\n"+
                    "Option Capacity: " + option.getCapacity()+"\n"+
                    "Available Seats: " + option.getEmptySeats()+"\n"+
                    "Class List: " + option.getClassList());
        }
    }

    //Prints specified Option information
    public static void SearchOption(ArrayList<Options> optionList, ArrayList<Student> studentList, Set<String> studentIDList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name");
        String userInput = scan.nextLine();
        for(Options option : optionList){
            if(userInput.equals(option.getOptionName())){
                System.out.println("Option Name: "+option.getOptionName()+"\n"+
                        "Option Capacity: "+option.getCapacity()+"\n"+
                        "Available Seats: "+option.getEmptySeats()+"\n"+
                        "Class List: "+option.getClassList());
                System.out.println("A) Add student to Option course"+"\n"+"B) Drop student from Option course"+"\n"+"C) Back");
                userInput = scan.nextLine();
                if("a".equals(userInput)){
                    AddStudentToOption(option, studentList, studentIDList);
                    break;
                }else if("b".equals(userInput)){
                    DropStudentFromOption(option, studentList, studentIDList);
                    break;
                }else if("c".equals(userInput)){
                    break;
                }
                else{System.out.println("Invalid Choice");
                }

            }
        }
    }

    //Adds a student to Option course
    public static void AddStudentToOption(Options option, ArrayList<Student> studentList, Set<String> studentIDList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of student");
        String userInput = scan.nextLine();
        if(studentIDList.contains(userInput)){
            if(option.checkStudentInClass(userInput) != "pos"){
                for(Student student:studentList){
                    if(student.getID().equals(userInput)){
                        if("NOTHING".equals(student.getAssignedOption())){
                            option.addStudentToList(student);
                            student.setAssignedOption(option.getOptionName());
                            break;
                        }else{
                            System.out.println("Student is a part of " + student.getAssignedOption() + " class. Please remove student first before trying again.");
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
    public static void DropStudentFromOption(Options option, ArrayList<Student> studentList, Set<String> studentIDList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter ID of student");
        String userInput = scan.nextLine();
        if(studentIDList.contains(userInput)){
            if("pos".equals(option.checkStudentInClass(userInput))){
                for(Student student:studentList){
                    if(student.getID().equals(userInput)){
                        option.removeStudent(student.getName());
                        student.setAssignedOption("NOTHING");
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