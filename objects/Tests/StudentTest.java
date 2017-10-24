import static org.junit.Assert.*;

public class StudentTest {
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

}