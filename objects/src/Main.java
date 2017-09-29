import java.util.ArrayList;

/**
 * Created by mohd on 2017-09-29.
 */
public class Main {
    public static void main(String[] args){
        System.out.println("This is the program!!");
        System.out.println("Creating student objects:");
        ArrayList<String> my_choices = new ArrayList<String>();
        my_choices.add("Option 1");
        my_choices.add("Option 2");
        my_choices.add("Option 3");
        my_choices.add("Option 4");

        Student stu1 = new Student("A00991074", "Mohammed", "Bajaman", 3, 3.5, my_choices);
        Student stu2 = new Student("A00991075", "Rodney", "Tran", 2, 4.0, my_choices);
        Student stu3 = new Student("A00991076", "Dickson", "Chan", 1, 4.0, my_choices);

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(stu1);
        studentList.add(stu2);
        studentList.add(stu3);

        System.out.println("Displaying the student information:\n");

        for (int i=0; i<studentList.size(); i++) {
            System.out.println("ID: "+studentList.get(i).getID()+"\nName:"+studentList.get(i).getName()+"\nGPA"+studentList.get(i).getGPA()
            +"\nPriority:"+studentList.get(i).getPriority()+"\nStudent Choices:"+studentList.get(i).getStudentChoices()+"\n\n");

        }
    }
}
