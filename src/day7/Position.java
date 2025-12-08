package day7;

public class Position {
    private int row;
    private int col;
    private boolean end= false;

    public Position(int r, int c){
        this.row=r;
        this.col=c;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public String pos() {
        return row + "," + col+ " "+end;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
