package sandpit;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by kahramani on 5/3/2017.
 * Zalando Task-3
 */
public class ElevatorStop {
    public static int solution(int[] A, int[] B, int M, int X, int Y) {
        List<List<Integer>> elevatorRings = new LinkedList<>();
        List<Integer> elevatorRing = new LinkedList<>();
        int weightSum = 0;
        for(int i = 0; i < A.length; i++) {
            if((A[i] + weightSum) > Y || elevatorRing.size() + 1 > X) {
                elevatorRings.add(elevatorRing);
                elevatorRing = new LinkedList<>();
                weightSum = 0;
            }
            weightSum += A[i];
            elevatorRing.add(B[i]);
        }
        elevatorRings.add(elevatorRing);

        int totalStop = elevatorRings.size();
        for(List<Integer> ring : elevatorRings) {
            totalStop += new HashSet<>(ring).size();
        }

        return totalStop;
    }
}
