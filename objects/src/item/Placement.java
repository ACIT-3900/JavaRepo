package item;
import java.util.*;

/**
 * Created by rodne on 2017-10-19.
 */
public class Placement {

    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;
    private HashSet<Student> nullList;
    ArrayList<Student> onePriorityList = new ArrayList<>();
    ArrayList<Student> twoPriorityList = new ArrayList<>();
    ArrayList<Student> threePriorityList = new ArrayList<>();
    ArrayList<Student> fourPriorityList = new ArrayList<>();

    //What is the average GPA of all students
    public void averageGPA(ArrayList<Student> stulist){
        Double gpa = 0.0;
        int numberOfStudents = 1;
        for(Student stu:stulist){
            gpa += stu.getGPA();
            numberOfStudents++;
        }
        System.out.println(gpa/numberOfStudents);
    }




    //Not default Constructor
    public Placement(ArrayList<Student> stulist, ArrayList<Options> optlist, HashSet<Student> nullList){
        this.stulist = stulist;
        this.optlist = optlist;
        this.nullList = nullList;
    }
    //Function to sort students in ArrayList based on their GPA
    private void sortStudentsOnGPA(ArrayList<Student> stulist){
        Collections.sort(stulist, Comparator.comparing(Student::getGPA).reversed());
    }
    //Function to sort students into ArrayList based on their priority level
    private void sortStudentsOnPriority(ArrayList<Student> stulist){
        for (Student s:stulist) {
            switch(s.getPriority()){
                case 1:
                    onePriorityList.add(s);
                    break;

                case 2:
                    twoPriorityList.add(s);
                    break;

                case 3:
                    threePriorityList.add(s);
                    break;

                case 4:
                    fourPriorityList.add(s);
                    break;
            }
        }
    }
    //If students do not get placed and their assigned option is listed as "NOTHING", place student in a null list
    private void createNullList(ArrayList<Student> onePriorityList, ArrayList<Student> twoPriorityList, ArrayList<Student> threePriorityList, ArrayList<Student> fourPriorityList){
        ArrayList<Student> one = onePriorityList;
        ArrayList<Student> two = twoPriorityList;
        ArrayList<Student> three = threePriorityList;
        ArrayList<Student> four = fourPriorityList;

        for(Student stu:one){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:two){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:three){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
        for(Student stu:four){
            if(stu.getAssignedOption().equals("NOTHING")){
                nullList.add(stu);
            }
        }
    }
    //Sorts students into their Option course
    private void placePriorityLists(ArrayList<Student> priorityList, ArrayList<Options> optlist) {
        for(Student stu:priorityList){
            if(stu.getStudentChoices().size()>0){
                if("".equals(stu.getStatus())){
                    int check = 0;
                    for(int i=0;i<stu.getStudentChoices().size();i++){
                        if(check ==0){
                            for(Options opt:optlist){
                                if (opt.getCourseName().equals(stu.getStudentChoices().get(i)) && opt.getEmptySeats()!= 0) {
                                    opt.addStudentToList(stu);
                                    stu.setAssignedOption(opt.getCourseName());
                                    check++;
                                    break;
                                }
                            }
                        }
                    }
                    if(check == 0 && stu.getAssignedOption() != null){
                        stu.setReason("All choice classes are full");
                        stu.setAssignedOption("NOTHING");
                    }
                }else{
                    stu.setReason("Has a status");
                    stu.setAssignedOption("NOTHING");
                }
            }else{
                stu.setReason("No selection was made");
                stu.setAssignedOption("NOTHING");
            }
        }
    }
    //Function to perform all functions above in the correct order
    public void displayGPA(){
        sortStudentsOnGPA(stulist);
        sortStudentsOnPriority(stulist);
        placePriorityLists(onePriorityList, optlist);
        placePriorityLists(twoPriorityList, optlist);
        placePriorityLists(threePriorityList, optlist);
        placePriorityLists(fourPriorityList, optlist);
        createNullList(onePriorityList, twoPriorityList, threePriorityList, fourPriorityList);
    }
}
