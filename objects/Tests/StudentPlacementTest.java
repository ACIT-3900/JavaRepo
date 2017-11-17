import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentPlacementTest {

    @org.junit.Test
    public void sortStudentsOnGPA() throws Exception {

        ArrayList<Student> stulist = new ArrayList<>();
        ArrayList<Options> optlist = new ArrayList<>();

        Options opt1 = new Options("Option1", 20);
        Options opt2 = new Options("Option2", 20);
        Options opt3 = new Options("Option3", 20);
        Options opt4 = new Options("Option4", 20);
        Options opt5 = new Options("Option5", 20);

        optlist.add(opt1);
        optlist.add(opt2);
        optlist.add(opt3);
        optlist.add(opt4);
        optlist.add(opt5);

        ArrayList<String> studentChoices =  new ArrayList<>();
        studentChoices.add("Option1");
        studentChoices.add("Option2");
        studentChoices.add("Option3");
        studentChoices.add("Option4");

        for (int i=0; i<100; i++){
            Student stu = new Student("A00123456", "Mohammed", "Bajaman", 1, "", studentChoices);
            stulist.add(stu);
        }

        StudentPlacement studentPlacement = new StudentPlacement(stulist,optlist, null);

        assertEquals(20,opt1.getEmptySeats());
        assertEquals(20,opt2.getEmptySeats());
        assertEquals(20,opt3.getEmptySeats());
        assertEquals(20,opt4.getEmptySeats());
        assertEquals(20,opt5.getEmptySeats());
    }
}