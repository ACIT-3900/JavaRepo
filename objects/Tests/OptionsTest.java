//import static org.junit.Assert.*;
//import java.util.ArrayList;
//
//public class OptionsTest {
//
//    @org.junit.Test
//    public void optionName() throws Exception {
//        Options opt = new Options("law", 67);
//
//        assertEquals("law", opt.getOptionName());
//        assertEquals(67, opt.getCapacity());
//
//    }
//
//
//
//    @org.junit.Test
//    public void testsetOptions() throws Exception{
//        Options opt = new Options("law", 67);
//
//        assertEquals("law", opt.getOptionName());
//
//        opt.setOptionName("web and mobile");
//
//        assertEquals("web and mobile", opt.getOptionName());
//    }
//
//    @org.junit.Test
//    public void testsetCapacity() throws Exception{
//        Options opt = new Options("law", 67);
//        assertEquals(67, opt.getCapacity());
//
//        opt.setOptionName("SQL");
//        assertEquals("SQL", opt.getOptionName());
//    }
//
//
//
//
//    @org.junit.Test
//    public void setClassList() {
//        Options opt = new Options( "law", 88);
//        ArrayList<Student> students = new ArrayList<Student>();
//        ArrayList<String> choices = new ArrayList<>();
//        Student stu = new Student("A00123456", "Rodney", "Thandi", 1, "", choices);
//        students.add(stu);
//        opt.setClassList(students);
//
//        assertEquals(students, opt.getClassList());
//
//        }
//
//
//    @org.junit.Test
//    public void getCapacity() {
//        Options opt = new Options( "law", 60);
//        assertEquals(60, opt.getCapacity());
//        }
//
//    @org.junit.Test
//    public void getClassList() {
//        ArrayList<Student> students = new ArrayList<Student>();
//        ArrayList<String> choices = new ArrayList<>();
//        Student stu = new Student("A00123456", "Rodney", "Thandi", 1, "", choices);
//        students.add(stu);
//        Options opt = new Options ("comp", 55);
//        opt.setClassList(students);
//        assertEquals(true, students.equals(opt.getClassList()));
//
//
//
//    }
//
//    @org.junit.Test
//    public void getEmptySeats() {
//        ArrayList<Student> students = new ArrayList<Student>();
//        ArrayList<String> choices = new ArrayList<>();
//        Student stu = new Student("A00123456", "Rodney", "Thandi", 1, "", choices);
//        Student stu1 = new Student("A00123656", "Jack", "Thandi", 1, "", choices);
//        Student stu2 = new Student("A00123434", "Bill", "Thandi", 1, "", choices);
//        Student stu3 = new Student("A00112334", "Dickson", "Thandi", 1, "", choices);
//        Options opt = new Options ("Linux", 60);
//        opt.addToClassList(stu);
//        opt.addToClassList(stu1);
//        opt.addToClassList(stu2);
//        opt.addToClassList(stu3);
//        assertEquals(56, opt.getEmptySeats());
//
//
//        }
//
//    @org.junit.Test
//    public void addStudentToList() {
//        ArrayList<Student> students = new ArrayList<Student>();
//        ArrayList<String> choices = new ArrayList<>();
//        Student stu = new Student("A00123456", "Rodney", "Thandi", 1, "", choices);
//        Options opt = new Options ("science", 60);
//        opt.addToClassList(stu);
//        assertEquals("A00123456", opt.getClassList().get(0).getID());
//
//        }
//
//    }
//
