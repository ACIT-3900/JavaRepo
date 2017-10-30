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
            HashSet<Student> nullList = new HashSet<>();
            ReadOptionList(optlist, "OptionSelectionControl.csv");
            ReadStudentChoices(stulist, "StudentChoices.csv");
            ReadStudentGPA(stulist, "StudentGPA.csv");
            Placement place = new Placement(stulist, optlist, nullList);
            place.displayGPA();

            Scanner scan = new Scanner(System.in);
            System.out.println("What would you like to do?");
            System.out.println("A) View students in Client Server course");
            System.out.println("B) View students in Web & Mobile course");
            System.out.println("C) View students in Data Communications course");
            System.out.println("D) View students in Digital Processing course");
            System.out.println("E) View students in Information Systems course");
            System.out.println("F) View students who would like to wait for January term");
            System.out.println("G) View students who did not get placed in a course");
            String answer = scan.nextLine();

            while(!answer.equals("q")){
                if("a".equals(answer)){
                    Options opt = optlist.get(0);
                    String courseName = opt.getCourseName();
                    int capacity = opt.getCapacity();
                    String classList = opt.getClassList();
                    System.out.println();
                    System.out.println("Course: " + courseName);
                    System.out.println("Capacity: " + capacity);
                    System.out.println("Class List: " + classList);
                    System.out.println();
                    System.out.println("What would you like to do?");
                    System.out.println("A) Remove Student");
                    System.out.println("B) Add Student");
                    System.out.println("C) Back");
                    answer = scan.nextLine();
                    while(!answer.equals("q")){
                        if("a".equals(answer)){
                            System.out.println();
                            System.out.println("Please select the student");
                            System.out.println(opt.getClassList());
                            answer = scan.nextLine();
                            opt.removeStudent(answer);
                            System.out.println();
                            System.out.println(opt.getClassList());
                            break;
                        }else if("b".equals(answer)){
                            System.out.println("Please enter student name");
                            answer = scan.nextLine();
                            for(Student s:stulist){
                                if(answer.equals(s.getName())){
                                    if("".equals(opt.checkStudentInClass(answer))){
                                        opt.addStudentToList(s);
                                        System.out.println(optlist.get(0).getClassList());
                                        break;
                                    }else if("pos".equals(optlist.get(0).checkStudentInClass(answer))){
                                        System.out.println("Student already in class");
                                        break;
                                    }
                                }
                            }
                            break;
                        }else{
                            break;
                        }
                    }
                }else if("b".equals(answer)){
                    System.out.println(optlist.get(1).getClassList());
                }else if("c".equals(answer)){
                    System.out.println(optlist.get(2).getClassList());
                }else if("d".equals(answer)){
                    System.out.println(optlist.get(3).getClassList());
                }else if("e".equals(answer)){
                    System.out.println(optlist.get(4).getClassList());
                }else if("f".equals(answer)){
                    System.out.println(optlist.get(5).getClassList());
                }else if("g".equals(answer)){
                    for(Student s:nullList){
                        System.out.println(s.getName());
                    }
                }
                System.out.println();
                System.out.println("What would you like to do?");
                System.out.println("A) View students in Client Server course");
                System.out.println("B) View students in Web & Mobile course");
                System.out.println("C) View students in Data Communications course");
                System.out.println("D) View students in Digital Processing course");
                System.out.println("E) View students in Information Systems course");
                System.out.println("F) View students who would like to wait for January term");
                System.out.println("G) View students who did not get placed in a course");
                answer = scan.nextLine();
            }

            scan.close();
        }
        catch(Exception ee){
            ee.printStackTrace();
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
    public static void ReadStudentGPA(ArrayList<Student> stulist, String filename) throws IOException {

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
                        break;
                    }
                }
            }
        }
    }

    //Admin Menu Methods
    public static void AdminMenu(){
        System.out.println("Administrator Menu");
        System.out.println("A) View Student Information");
        System.out.println("B) View Options Information");
        System.out.println("Q) Quit");
    }

    //Student Menu Methods
    public static void StudentMenu(){
        System.out.println("Student Menu");
        System.out.println("A) View all students");
        System.out.println("B) View student's who were not placed");
        System.out.println("C) Search for a student");
        System.out.println("D) Go back");
        System.out.println("Q) Quit");
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
        }
    }
    //Prints all student's who did not get placed into Option course
    public static void NullStudents(HashSet<Student> nullList){
        for(Student stu:nullList){
            System.out.println("Student Name: "+stu.getName()+"\n"+"Reason: "+stu.getReason());
        }
    }
    //Prints specified student information
    public static void SearchStudent(ArrayList<Student> stulist){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter student's name");
        String answer = scan.nextLine();
        for(Student stu:stulist){
            if(answer.equals(stu.getName())){
                System.out.println("Student ID: "+stu.getID()+"\n"+
                        "Student Name: "+stu.getName()+"\n"+
                        "Student GPA: "+stu.getGPA()+"\n"+
                        "Student Priority: "+stu.getPriority()+"\n"+
                        "Student Status: "+stu.getStatus()+"\n"+
                        "Student Reason: "+stu.getReason()+"\n"+
                        "Student Assigned Option: "+stu.getAssignedOption()+"\n"+
                        "Student Choices: "+stu.getStudentChoices());
                break;
            }
        }
    }
    //Add student to Option course
    public static void AddStudent(Student stu, ArrayList<Options> optlist, HashSet<Student> nullList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name you'd like to add the student to");
        String answer = scan.nextLine();
        for(Options opt:optlist){
            if(answer.equals(opt.getCourseName())){
                stu.setAssignedOption(opt.getCourseName());
                opt.addStudentToList(stu);
                break;
            }
        }
        for(Student nullStu:nullList){
            if(stu.getName().equals(nullStu.getName())){
                nullList.remove(stu);
                break;
            }
        }
    }
    //Drops student from Option course
    public static void DropStudent(Student stu, ArrayList<Options> optlist, HashSet<Student> nullList){
        for(Options opt:optlist){
            if(stu.getAssignedOption().equals(opt.getCourseName())){
                opt.removeStudent(stu.getName());
                stu.setAssignedOption("NOTHING");
                nullList.add(stu);
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
        System.out.println("Q) Quit");
    }
    //Prints all Options information
    public static void ViewOptions(ArrayList<Options> optlist){
        for(Options opt:optlist){
            System.out.println("Option Name: "+opt.getCourseName()+"\n"+
                    "Option Capacity: "+opt.getCapacity()+"\n"+
                    "Available Seats: "+opt.getEmptySeats()+"\n"+
                    "Class List: "+opt.getClassList());
        }
    }
    //Prints specified Option information
    public static void SearchOption(ArrayList<Options> optlist){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter Option name");
        String answer = scan.nextLine();
        for(Options opt:optlist){
            if(answer.equals(opt.getCourseName())){
                System.out.println("Option Name: "+opt.getCourseName()+"\n"+
                        "Option Capacity: "+opt.getCapacity()+"\n"+
                        "Available Seats: "+opt.getEmptySeats()+"\n"+
                        "Class List: "+opt.getClassList());
                break;
            }
        }
    }
    //Adds a student to Option course
    public static void AddStudentToOption(Options opt, ArrayList<Student> stulist, HashSet<Student> nullList){
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter name of student");
        String answer = scan.nextLine();
        for(Student stu:stulist){
            if(answer.equals(stu.getName())){
                if(stu.getAssignedOption().equals("NOTHING")){
                    opt.addStudentToList(stu);
                    for(Student nullStu:nullList){
                        if(nullStu.getName().equals(stu.getName())){
                            nullList.remove(stu);
                        }
                    }
                    break;
                }else{
                    System.out.println("Student is currently assigned to "+stu.getAssignedOption());
                    System.out.println("Please confirm if you would like to remove student from this course and add them to new one");
                    System.out.println("A) Yes");
                    System.out.println("B) No");
                }
            }
        }
    }
}