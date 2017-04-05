package sandpit;

/**
 * Created by kahramani on 1/7/2017.
 */

// amazon nearest locker location
public class Locker {
    public static void main(String[] args) {
        int[] x = {2, 4, 3};
        int[] y = {2, 2, 7};
        get2DLockerLocation(5, 7, x, y);

        //printMatrix(5, 7, x, y);
    }

    private static int[][] get2DLockerLocation(int cityLength, int cityWidth, int[] lockerXCoordinates, int[] lockerYCoordinates) {
        int[][] customDistances = new int[cityWidth][cityLength];
        for(int width = 0; width < customDistances.length; width++) {
            for(int length = 0; length < customDistances[0].length; length++) {
                int customDistance = Integer.MAX_VALUE;
                for(int i=0; i < lockerXCoordinates.length; i++){
                    int xCoordinate = lockerXCoordinates[i];
                    int yCoordinate = lockerYCoordinates[i];
                    int temp = Math.abs(xCoordinate-length-1)+Math.abs(yCoordinate-width-1);
                    if(customDistance > temp){
                        customDistance = temp;
                    }

                }

                customDistances[width][length] = customDistance;
            }
        }

        return customDistances;
    }

    private static void printMatrix(int cityLength, int cityWidth,
                                    int[] xCordinates, int[] yCordinates) {

        for(int i=0;i<cityWidth;i++){
            for(int j=0;j<cityLength;j++){
                int lockDistance=findNearestLocker(i,j,xCordinates,yCordinates);
                System.out.print(lockDistance +" ");
            }
            System.out.println();
        }


    }

    private static int findNearestLocker(int i, int j, int[] xCordinates,
                                         int[] yCordinates) {
        int totalLocker= xCordinates.length;
        int distance=Integer.MAX_VALUE;
        for(int l=0;l<totalLocker;l++){
            int x=xCordinates[l];
            int y =yCordinates[l];
            int tempDistance=Math.abs(x-j-1)+Math.abs(y-i-1);
            if(distance>tempDistance){
                distance=tempDistance;
            }
        }
        return distance;
    }
}
