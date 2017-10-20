package item;
import java.util.*;

/**
 * Created by rodne on 2017-10-19.
 */
public class Placement {


    private ArrayList<Student> stulist;
    private ArrayList<Options> optlist;
    HashMap<String, ArrayList<String>> onePriorityList = new HashMap<>();
    HashMap<String, ArrayList<String>> twoPriorityList = new HashMap<>();
    HashMap<String, ArrayList<String>> threePriorityList = new HashMap<>();
    HashMap<String, ArrayList<String>> fourPriorityList = new HashMap<>();
    HashMap<String, Student> hMap = new HashMap<>();

    public Placement(ArrayList<Student> stulist, ArrayList<Options> optlist){
        this.stulist = stulist;
        this.optlist = optlist;
    }

    private HashMap<String, Student> addStudentToList(ArrayList<Student> stuList){
        for(Student s:stulist){
            hMap.put(s.getID(), s);
        }
        return hMap;
    }

    private ArrayList<String> sortStudentsOnGPA(ArrayList<Student> stulist, HashMap<String, Student> hMap){
        HashMap<String, Double> tMap = new HashMap<>();

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

        ArrayList<String> idList = new ArrayList<>();

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
                    onePriorityList.put(stu.getID(), stu.getStudentChoices());
                    break;

                case 2:
                    twoPriorityList.put(stu.getID(), stu.getStudentChoices());
                    break;

                case 3:
                    threePriorityList.put(stu.getID(), stu.getStudentChoices());
                    break;

                case 4:
                    fourPriorityList.put(stu.getID(), stu.getStudentChoices());
                    break;
            }
        }
    }

    private void placePriorityLists(HashMap<String, ArrayList<String>> priorityList, ArrayList<Options> optlist, HashMap<String, Student> hMap) {
        Set set = priorityList.entrySet();
        Iterator itr = set.iterator();

        while(itr.hasNext()){
            int checking = 0;
            Map.Entry me = (Map.Entry) itr.next();
            String studentId = (String) me.getKey();
            Student stu = hMap.get(studentId);
            List<String> myList = stu.getStudentChoices();
            for( int i = 0;i<myList.size();i++){
                String choice = myList.get(i);
                if(checking == 0){
                    for(Options opt:optlist){
                        if (opt.getCourseName().equals(choice) && opt.getEmptySeats()!= 0 && stu.getStatus().equals("")) {
                            opt.addStudentToList(stu);
                            checking++;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void displayGPA(){
        sortStudentsOnPriority(sortStudentsOnGPA(stulist, hMap), hMap);
        placePriorityLists(onePriorityList, optlist, hMap);
        placePriorityLists(twoPriorityList, optlist, hMap);
        placePriorityLists(threePriorityList, optlist, hMap);
        placePriorityLists(fourPriorityList, optlist, hMap);
    }
}
