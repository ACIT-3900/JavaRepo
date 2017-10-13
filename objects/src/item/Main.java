package item;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import static javafx.scene.input.KeyCode.K;


public class Main {
    private static final String COMMA_DELIMITER = ",";
    public static void main(String[] args) throws FileNotFoundException {

        try
        {
            ArrayList<Student> stulist = new ArrayList<>();
            ArrayList<Options> optlist = new ArrayList<>();
            ReadOptionList(optlist, "OptionList.csv");
            ReadStudentList(stulist, "StudentList.csv");

//            for(Options o:optlist){
//                System.out.println("Course Name: "+o.getCourseName()+"\t"+
//                        "Course Capacity: "+o.getCapacity()+"\t"+
//                        "Class List: "+o.getClassList()+"\t"+
//                        "Empty Seats: "+o.getEmptySeats());
//            }
//
//            for(Student s:stulist){
//                System.out.println("Student ID: "+s.getID()+"\t"+
//                        "Student Name: "+s.getName()+"\t"+
//                        "Student Priority: "+s.getPriority()+"\t"+
//                        "Student GPA: "+s.getGPA()+"\t"+
//                        "Student Choices: "+s.getStudentChoices()+"\t"+
//                        "Student Status: "+s.getAssignedOption()+"\t"+
//                        "Student Status: "+s.getStatus());
//            }

            HashMap<String, Double> tMap = new HashMap <>();
            HashMap<String, Student> hMap = new HashMap <>();

            //Puts all student's GPA into a TreeMap, which sorts them in ascending order (lowest to highest)
            for(Student s:stulist){
                tMap.put(s.getID(), s.getGPA());
                hMap.put(s.getID(), s);
            }



            List<Double> mapValue = new ArrayList<>(tMap.values());
            List<String> mapKey = new ArrayList<>(tMap.keySet());
            Collections.sort(mapValue);
            Collections.sort(mapKey);

            LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();

            Iterator<Double> iter = mapValue.iterator();
            while(iter.hasNext()){
                Double dbl = iter.next();
                Iterator<String> itera = mapKey.iterator();

                while(itera.hasNext()){
                    String str = itera.next();
                    Double doub = tMap.get(str);
                    Double doubl = dbl;

                    if(doub.equals(doubl)){
                        itera.remove();
                        sortedMap.put(str, dbl);
                        break;
                    }
                }
                //System.out.println(sortedMap);
            }

            Set set = sortedMap.entrySet();
            Iterator itr = set.iterator();

            ArrayList<String> idList = new ArrayList<>();

            while (itr.hasNext()){
                Map.Entry me = (Map.Entry)itr.next();
                idList.add(0, (String) me.getKey());
            }

            HashMap<String, String> onePriorityList = new HashMap<>();
            HashMap<String, String> twoPriorityList = new HashMap<>();
            HashMap<String, String> threePriorityList = new HashMap<>();
            HashMap<String, String> fourPriorityList = new HashMap<>();



            //Sorts students into priority lists

            for(String s:idList) {

                Student stu = hMap.get(s);
                int i = stu.getPriority();

                if (i == 1) {
                    if (onePriorityList.containsKey(stu.getID())) {
                        System.out.println(stu.getID() + " already in Priority 1 list");
                    }else{
                        onePriorityList.put(stu.getID(), stu.getStudentChoices());
                        System.out.println("Match at Priority 1");
                    }
                } else if (i == 2) {
                    if (twoPriorityList.containsKey(stu.getID())) {
                        System.out.println(stu.getID() + " already in Priority 2 list");
                    }else{
                        twoPriorityList.put(stu.getID(), stu.getStudentChoices());
                        System.out.println("Match at Priority 2");
                    }
                } else if (i == 3) {
                    if (threePriorityList.containsKey(stu.getID())) {
                        System.out.println(stu.getID() + " already in Priority 3 list");
                    }else{
                        threePriorityList.put(stu.getID(), stu.getStudentChoices());
                        System.out.println("Match at Priority 3");
                    }
                } else if (i == 4) {
                    if (fourPriorityList.containsKey(stu.getID())) {
                        System.out.println(stu.getID() + " already in Priority 4 list");
                    }else{
                        fourPriorityList.put(stu.getID(), stu.getStudentChoices());
                        System.out.println("Match at Priority 4");
                    }
                }
            }

            Set oneSet = onePriorityList.entrySet();
            Set twoSet = onePriorityList.entrySet();
            Set threeSet = onePriorityList.entrySet();
            Set fourSet = onePriorityList.entrySet();
            Iterator itr1 = oneSet.iterator();
            Iterator itr2 = twoSet.iterator();
            Iterator itr3 = threeSet.iterator();
            Iterator itr4 = fourSet.iterator();


            //Sorts students into Options list

            while (itr1.hasNext()) {
                Map.Entry me = (Map.Entry) itr1.next();

                String studentId = (String) me.getKey();
                Student stu = hMap.get(studentId);
                String choice = (stu.getStudentFirstChoice());
                int index = 0;

                for (Options opt : optlist) {
                    if (opt.getCourseName() == choice) {
                        if (opt.getEmptySeats() != 0) {
                            ArrayList<String> classList = new ArrayList<>();
                            classList.add(stu.getID() + "\t" + stu.getName() + "\t" + stu.getPriority() + "\t" + stu.getGPA());
                            opt.setClassList(classList);
                            index = optlist.indexOf(opt);
                            optlist.get(index).setClassList(classList);
                        } else{
                            String choice2 = (stu.getStudentSecondChoice());
                            for (Options opt2 : optlist) {
                                if (opt.getCourseName() == choice2) {
                                    if (opt2.getEmptySeats() != 0) {
                                        ArrayList<Student> classList = new ArrayList<>();
                                        classList.add(stu);
                                        index = optlist.indexOf(opt2);
                                    }else{
                                        String choice3 = (stu.getStudentThirdChoice());
                                        for(Options opt3:optlist){
                                            if(opt3.getEmptySeats() != 0){
                                                ArrayList<Student> classList = new ArrayList<>();
                                                classList.add(stu);
                                                index = optlist.indexOf(opt3);
                                            }else{
                                                String choice4 = (stu.getStudentFourthChoice());
                                                for(Options opt4:optlist) {
                                                    if (opt4.getEmptySeats() != 0) {
                                                        ArrayList<Student> classList = new ArrayList<>();
                                                        classList.add(stu);
                                                        index = optlist.indexOf(opt4);
                                                    }else{
                                                        System.out.println("Student could not be placed");
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        break;
                    }
                }
            }

            for(Options o:optlist){
                System.out.println("Course Name: "+o.getCourseName()+"\t"+
                        "Course Capacity: "+o.getCapacity()+"\t"+
                        "Class List: "+o.getClassList()+"\t"+
                        "Empty Seats: "+o.getEmptySeats());
            }




            //Printing which students are in which Priority list
            while (itr1.hasNext()) {
                Map.Entry me = (Map.Entry)itr1.next();
                System.out.println("Priority 1: "+me.getKey() + " " + me.getValue());
            }
            while (itr2.hasNext()) {
                Map.Entry me = (Map.Entry)itr2.next();

                System.out.println("Priority 2: "+me.getKey() + " " + me.getValue());
            }
            while (itr3.hasNext()) {
                Map.Entry me = (Map.Entry)itr3.next();
                System.out.println("Priority 3: "+me.getKey() + " " + me.getValue());
            }
            while (itr4.hasNext()) {
                Map.Entry me = (Map.Entry)itr4.next();
                System.out.println("Priority 4: "+me.getKey() + " " + me.getValue());
            }




        }
        catch(Exception ee){
            ee.printStackTrace();
        }
    }

    public static void ReadStudentList(ArrayList <Student> stulist, String filename)throws IOException{
        BufferedReader br;
        String line;


        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] studentInfo = line.split(COMMA_DELIMITER);
            ArrayList<String> studentChoices = new ArrayList<>();
            if(studentInfo.length>0){
                int studentInformation = 6;
                while(studentInformation < studentInfo.length){
                    String choice = studentInfo[studentInformation];
                    studentChoices.add(choice);
                    studentInformation++;
                }
                Student stu = new Student(studentInfo[0], studentInfo[1], studentInfo[2], Integer.parseInt(studentInfo[4]), Double.parseDouble(studentInfo[5]), studentChoices, null, studentInfo[3]);
                stulist.add(stu);
            }
        }
    }

    public static void ReadOptionList(ArrayList <Options> optlist, String filename)throws IOException{
        BufferedReader br;
        String line;

        br = new BufferedReader(new FileReader(filename));
        br.readLine();

        while((line = br.readLine()) != null){
            String[] optionInfo = line.split(COMMA_DELIMITER);
            ArrayList<String> optionList = new ArrayList<>();
            if(optionInfo.length>0){
                Options opt = new Options(optionInfo[0], Integer.parseInt(optionInfo[1]), null);
                optlist.add(opt);
            }
        }
    }
}