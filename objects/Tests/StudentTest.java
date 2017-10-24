import static org.junit.Assert.*;

public class StudentTest {
    @org.junit.Test
    public void getID() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(null, stu.getID());
    }

    @org.junit.Test
    public void getFirstName() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals("Rodney", stu.getFirstName());
    }

    @org.junit.Test
    public void getLastName() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals("Tran", stu.getLastName());
    }

    @org.junit.Test
    public void getName() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals("Rodney Tran", stu.getName());
    }

    @org.junit.Test
    public void getPriority() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(0, stu.getPriority());
    }

    @org.junit.Test
    public void getGPA() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(null, stu.getGPA());
    }

    @org.junit.Test
    public void getStudentChoices() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(null, stu.getStudentChoices());
    }

    @org.junit.Test
    public void getAssignedOption() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(null, stu.getAssignedOption());
    }

    @org.junit.Test
    public void getStatus() throws Exception {
        Student stu = new Student("Rodney", "Tran");
        assertEquals(null, stu.getStatus());
    }
}