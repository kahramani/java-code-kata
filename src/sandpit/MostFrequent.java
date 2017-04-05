package sandpit;

import java.util.Collections;
import java.util.Comparator;
import java.util.*;

/**
 * Created by kahramani on 1/4/2017.
 */
public class MostFrequent {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,7,7,7,7,10,10,10,10,6,6,6,6,8,8,8,8,11,11,11,11};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : a) {
            Integer count = map.get(i);
            map.put(i, count != null ? count+1 : 0);
        }

        Integer popular = Collections.max(map.entrySet(),
                new Comparator<Map.Entry<Integer,Integer>>() {
                    @Override
                    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                        return o1.getValue().compareTo(o2.getValue());
                    }
                }).getKey();

        System.out.println("popular: " + popular);
    }
}
