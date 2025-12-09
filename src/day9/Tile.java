package day9;

public class Tile {
    int x,y;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int[] getTile() {
        return new int[]{x,y};
    }


    @Override
    public String toString() {
        return "Tile{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

}
