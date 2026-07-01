import java.util.*;
public class LinkedHashMapp {
    public static void main(String[] args) {
        //LinkedHashMap
        LinkedHashMap<String , Integer> lhm = new LinkedHashMap<>();
        lhm.put("India", 100);
        lhm.put("China", 150);
        lhm.put("US", 50);
        lhm.put("Indonesia", 10);
        System.out.println(lhm);

        //TreeMap
        TreeMap<String , Integer> tm = new TreeMap<>();
        tm.put("India", 100);
        tm.put("China", 150);
        tm.put("US", 50);
        tm.put("Indonesia", 10);
        System.out.println(tm);
    }
}
