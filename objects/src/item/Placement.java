package item;
import java.util.*;

/**
 * Created by rodne on 2017-10-19.
 */
public class Placement {

    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;
    private HashSet<Student> nullList;
    ArrayList<String> idList = new ArrayList<>();
    ArrayList<Student> onePriorityList = new ArrayList<>();
    ArrayList<Student> twoPriorityList = new ArrayList<>();
    ArrayList<Student> threePriorityList = new ArrayList<>();
    ArrayList<Student> fourPriorityList = new ArrayList<>();
    HashMap<String, Student> hMap = new HashMap<>();
    HashMap<String, Double> tMap = new HashMap<>();

    public Placement(ArrayList<Student> stulist, ArrayList<Options> optlist, HashSet<Student> nullList){
        this.stulist = stulist;
        this.optlist = optlist;
        this.nullList = nullList;
    }

    private HashMap<String, Student> createStudentList1(ArrayList<Student> stulist){
        for(Student s:stulist){
            hMap.put(s.getID(), s);
        }
        return hMap;
    }

    private HashMap<String, Double> createStudentList2(ArrayList<Student> stulist){
        for(Student s:stulist){
            tMap.put(s.getID(), s.getGPA());
        }
        return tMap;
    }

    private ArrayList<String> sortStudentsOnGPA(HashMap<String, Double> tMap){

        List<Double> mapValue = new ArrayList<>(tMap.values());
        List<String> mapKey = new ArrayList<>(tMap.keySet());
        Collections.sort(mapValue);
        Collections.sort(mapKey);

        LinkedHashMap<String, Double> sortedMap = new LinkedHashMap<>();

        Iterator<Double> iter = mapValue.iterator();
        while (iter.hasNext()) {
            Double dbl = iter.next();
            Iterator<String> itera = mapKey.iterator();

            while (itera.hasNext()) {
                String str = itera.next();
                Double doub = tMap.get(str);
                Double doubl = dbl;

                if (doub.equals(doubl)) {
                    itera.remove();
                    sortedMap.put(str, dbl);
                    break;
                }
            }
        }

        Set set = sortedMap.entrySet();
        Iterator itr = set.iterator();

        while (itr.hasNext()) {
            Map.Entry me = (Map.Entry) itr.next();
            idList.add(0, (String) me.getKey());
        }
        return idList;
    }

    private void sortStudentsOnPriority(ArrayList<String> idList, HashMap<String, Student> hMap){
        for (String s:idList) {
            Student stu = hMap.get(s);
            int i = stu.getPriority();
            switch(i){
                case 1:
                    onePriorityList.add(stu);
                    break;

                case 2:
                    twoPriorityList.add(stu);
                    break;

                case 3:
                    threePriorityList.add(stu);
                    break;

                case 4:
                    fourPriorityList.add(stu);
                    break;
            }
        }
    }

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

    private void placePriorityLists(ArrayList<Student> priorityList, ArrayList<Options> optlist) {
        for(Student stu:priorityList){
            int checking = 0;
            for( int i = 0;i<stu.getStudentChoices().size();i++){
                if(checking == 0){
                    for(Options opt:optlist){
                        if (opt.getCourseName().equals(stu.getStudentChoices().get(i)) && stu.getStatus().equals("") && opt.getEmptySeats()!= 0) {
                            opt.addStudentToList(stu);
                            stu.setAssignedOption(opt.getCourseName());
                            checking++;
                            break;
                        }
                    }
                }
            }if(checking == 0 && stu.getAssignedOption() != null){
                stu.setAssignedOption("NOTHING");
            }
        }
    }

    public void displayGPA(){
        createStudentList1(stulist);
        createStudentList2(stulist);
        sortStudentsOnGPA(tMap);
        sortStudentsOnPriority(idList, hMap);
        placePriorityLists(onePriorityList, optlist);
        placePriorityLists(twoPriorityList, optlist);
        placePriorityLists(threePriorityList, optlist);
        placePriorityLists(fourPriorityList, optlist);
        createNullList(onePriorityList, twoPriorityList, threePriorityList, fourPriorityList);
    }


}
