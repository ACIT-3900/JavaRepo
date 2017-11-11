import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class StudentPlacement{
    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;
    private ArrayList<Student> priorityListOne = new ArrayList<>();
    private ArrayList<Student> priorityListTwo = new ArrayList<>();
    private ArrayList<Student> priorityListThree = new ArrayList<>();
    private ArrayList<Student> priorityListFour = new ArrayList<>();

    StudentPlacement(ArrayList<Student> stulist, ArrayList<Options> optlist){
        this.stulist = stulist;
        this.optlist = optlist;
    }

    private void sortStudentsOnGPA(ArrayList<Student> stulist){
        if (stulist != null) {
            Collections.sort(stulist, Comparator.comparing(Student::getGPA).reversed());
        }
    }

    private void sortStudentsOnPriority(ArrayList<Student> stulist){
        for (Student s:stulist) {
            switch(s.getPriority()){
                case 1:
                    priorityListOne.add(s);
                    break;

                case 2:
                    priorityListTwo.add(s);
                    break;

                case 3:
                    priorityListThree.add(s);
                    break;

                case 4:
                    priorityListFour.add(s);
                    break;
            }
        }
    }

    private void placePriorityLists(ArrayList<Student> priorityList, ArrayList<Options> optlist){
        for(Student s : priorityList){
            int chk_placed = 0;
            for(int i=0; i<s.getStudentChoices().size();i++) {
                if (chk_placed == 0) {
                    for (Options o : optlist) {
                        if (o.getOptionName().equals(s.getStudentChoices().get(i)) && o.getEmptySeats() != 0) {
                            o.addToClassList(s);
                            chk_placed++;
                            break;
                        }
                    }
                }
            }
        }
    }

    void displayGPA(){
        sortStudentsOnGPA(stulist);
        sortStudentsOnPriority(stulist);
        placePriorityLists(priorityListOne, optlist);
        placePriorityLists(priorityListTwo, optlist);
        placePriorityLists(priorityListThree, optlist);
        placePriorityLists(priorityListFour, optlist);
    }
}
