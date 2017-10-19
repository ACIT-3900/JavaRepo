import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class StudentPlacement{
    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;

    public StudentPlacement(ArrayList<Student> stulist, ArrayList<Options> optlist){
        this.stulist = stulist;
        this.optlist = optlist;
    }

    private void sortStudentsOnGPA(ArrayList<Student> stulist){
        Collections.sort(stulist, Comparator.comparing(Student::getGPA).reversed());
    }

    private void sortStudentsOnPriority(ArrayList<Student> stulist, ArrayList<Options> optlist){
        for (Student s:stulist) {
            switch(s.getPriority()){
                case 1:
                    for(int i=0; i<s.getStudentChoices().size(); i++) {
                        for (Options o : optlist) {
                            if (s.getStudentChoices().get(i).equals(o.getOptionName())) {
                                o.addToClassList(s);
                                break;
                            }
                        }
                        break;
                    }

                case 2:
                    for(int i=0; i<s.getStudentChoices().size(); i++) {
                        for (Options o : optlist) {
                            if (s.getStudentChoices().get(i).equals(o.getOptionName())) {
                                o.addToClassList(s);
                                break;
                            }
                        }
                        break;
                    }

                case 3:
                    for(int i=0; i<s.getStudentChoices().size(); i++) {
                        for (Options o : optlist) {
                            if (s.getStudentChoices().get(i).equals(o.getOptionName())) {
                                o.addToClassList(s);
                                break;
                            }
                        }
                        break;
                    }
            }
        }
    }

    public void displayGPA(){
        sortStudentsOnGPA(stulist);
        sortStudentsOnPriority(stulist, optlist);
    }
}
