package day9;

public class Logik {
    public static long area(Tile tileA, Tile tileB) {
        int w = Math.abs(tileA.x - tileB.x + 1);
        int h = Math.abs(tileA.y - tileB.y + 1);
        return (long) w *h;
    }
}
