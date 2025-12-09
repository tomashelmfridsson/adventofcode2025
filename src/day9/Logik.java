package day9;

import java.util.ArrayList;

public class Logik {
    public static long area(Tile tileA, Tile tileB) {
        int w = Math.abs(tileA.x - tileB.x + 1);
        int h = Math.abs(tileA.y - tileB.y + 1);
        return (long) w *h;
    }

    public static long maxArea(ArrayList<Tile> tiles){
        long max = 0;
        for (Tile tileA : tiles) {
            for (Tile tileB : tiles) {
                long area = Logik.area(tileA, tileB);
                if (area > max) max = area;
            }
        }
        return max;
    }
}
