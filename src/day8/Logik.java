package day8;

public class Logik {
    public static double calculateClosest(Junction A, Junction B) {
        int deltaX = (A.x - B.x);
        int deltaY = (A.y - B.y);
        int deltaZ = (A.z - B.z);
        double distance = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2) + Math.pow(deltaZ,2));
        return distance;
    }
}
