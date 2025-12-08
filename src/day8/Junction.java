package day8;

public class Junction {
    int x, y, z, circuit=0,number;

    public Junction(int x, int y, int z, int number) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.number = number;
    }

    public int getCircuit() {
        return circuit;
    }

    public void setCircuit(int circuit) {
        this.circuit = circuit;
    }

    public int[] getPosition() {
        return new int[]{x, y, z};
    }

}

