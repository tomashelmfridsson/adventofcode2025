package day9;

public class Line {

    int xStart,xStop,yStart,yStop;

    public Line(int xStart, int xStop, int yStart, int yStop) {
        this.xStart = xStart;
        this.xStop = xStop;
        this.yStart = yStart;
        this.yStop = yStop;
    }

    @Override
    public String toString() {
        return "Line{" +
                "xStart=" + xStart +
                ", xStop=" + xStop +
                ", yStart=" + yStart +
                ", yStop=" + yStop +
                '}';
    }
}
