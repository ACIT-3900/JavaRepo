import static org.junit.Assert.*;

public class OptionsTest {

    @org.junit.Test
    public void optionName() throws Exception {
        Options opt = new Options("law", 67);

        assertEquals("law", opt.getOptionName());
        assertEquals(67, opt.getCapacity());

    }

    @org.junit.Test
    public void courseName() throws Exception {
        Options opt = new Options("law", 67);

        assertEquals("law", opt.getOptionName());
        assertEquals(67, opt.getCapacity());


    }


    @org.junit.Test
    public void testsetOptions() throws Exception{
        Options opt = new Options("law", 67);

        assertEquals("law", opt.getOptionName());

        opt.setOptionName("web and mobile");

        assertEquals("web and mobile", opt.getOptionName());
    }

    @org.junit.Test
    public void testsetCapacity() throws Exception{
        Options opt = new Options("law", 67);
        assertEquals(67, opt.getCapacity());

        opt.setOptionName("400");
        assertEquals(400, opt.getOptionName());
    }

    public void testReadStudentByGPA() {
        // Initialize a student list with GPA

        // Initialize a second list w/out the GPAs

        // Call ReadStudentsGPA passing in the secondlist

        // Assert the first and second list
    }



    @org.junit.Test
    public void setClassList() {
        Options opt = new Options( "law", 88);
        assertEquals(88, opt.getCapacity());

        }

    @org.junit.Test
    public void getCourseName() {
        Options opt = new Options( "law", 36);
        assertEquals(36, opt.getCapacity());

        }

    @org.junit.Test
    public void getCapacity() {
        Options opt = new Options( "law", 60);
        assertEquals(60, opt.getCapacity());
        }

    @org.junit.Test
    public void getClassList() {
        }

    @org.junit.Test
    public void getEmptySeats() {
        }

    @org.junit.Test
    public void addStudentToList() {
        }

    }




