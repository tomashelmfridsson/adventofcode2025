package day5;

public class Range {
    private long start;
    private long stop;

    public void setStart(long start) {
        this.start = start;
    }

    public void setStop(long stop) {
        this.stop = stop;
    }

    public Range(long start, long stop){
        this.start = start;
        this.stop = stop;
    }

    public long getStart() {
        return start;
    }

    public long getStop() {
        return stop;
    }
}
