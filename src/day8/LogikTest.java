package day8;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LogikTest {
    @Test
    public void distanceTest(){
        Junction A = new Junction(1,1,1,0);
        Junction B = new Junction(2,2,2,0);
        System.out.println(Logik.calculateClosest(A,B));
    }
}
