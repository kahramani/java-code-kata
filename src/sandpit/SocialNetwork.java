package sandpit;

import java.util.*;

/**
 * Created by kahramani on 1/7/2017.
 */
// social network traversal
public class SocialNetwork {

    public static void main(String[] args) {
        System.out.println(getRankedCourses("user-5"));
    }

    public static List<String> getRankedCourses(String user) {
        Map<String, Integer> rankMap = new HashMap<>();
        List<String> attendedCourses = getAttendedCoursesForUser(user);
        for(String friend : getDirectFriendsForUser(user)) {
            for(String course : getAttendedCoursesForUser(friend)) {
                if(!attendedCourses.contains(course)) {
                    Integer frequency = rankMap.get(course);
                    rankMap.put(course, frequency != null ? frequency + 1 : 1);
                }
            }
        }

        List<Map.Entry<String, Integer>> temp = new LinkedList<>(rankMap.entrySet());

        Comparator comparator = new Comparator<Map.Entry<String,Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        };

        Collections.sort(temp, comparator);
        Collections.reverse(temp);

        List<String> rankList = new LinkedList<>();

        for(Map.Entry<String, Integer> entry : temp) {
            rankList.add(entry.getKey());
        }

        return rankList;
    }

    public static List<String> getDirectFriendsForUser(String user) {
        List l = new ArrayList();
        l.add("user-1");
        l.add("user-2");
        l.add("user-3");
        return l;
    }

    public static List<String> getAttendedCoursesForUser(String user) {
        List l = new ArrayList();
        if(user.equals("user-1")) {
            l.add("course-1");
            l.add("course-2");
            l.add("course-3");
        }
        if(user.equals("user-2")) {
            l.add("course-3");
            l.add("course-4");
            l.add("course-5");
        }
        if(user.equals("user-3")) {
            l.add("course-3");
            l.add("course-5");
        }

        if(user.equals("user-5")) {
            l.add("course-3");
        }

        return l;
    }
}
