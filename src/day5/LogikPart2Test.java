package day5;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class LogikPart2Test {

    @Test
    public void overlap(){
        assertTrue(LogikPart2.overlap(new Range(1,3),new Range(2,5)));
    }

    @Test
    public void overlapBorderBefore(){
        assertTrue(LogikPart2.overlap(new Range(3,7),new Range(7,9)));
    }

    @Test
    public void overlapBorderAfter(){
        assertTrue(LogikPart2.overlap(new Range(1,3),new Range(3,5)));
    }

    @Test
    public void overlapInsidaR1(){
        assertTrue(LogikPart2.overlap(new Range(1,8),new Range(3,5)));
    }

    @Test
    public void overlapInsideR2(){
        assertTrue(LogikPart2.overlap(new Range(3,4),new Range(3,5)));
    }

    @Test
    public void testBefore(){
        Range rangeDefault = new Range(5,7);
        Range rangeIn = new Range(3,5);
        Range result = LogikPart2.newRange(rangeIn, rangeDefault);
        assertEquals("3-7",result.getStart()+"-"+result.getStop());
    }

    @Test
    public void testDirektBefore(){
        Range rangeDefault = new Range(5,7);
        Range rangeIn = new Range(3,4);
        Range result = LogikPart2.newRange(rangeIn, rangeDefault);
        assertEquals("3-7",result.getStart()+"-"+result.getStop());
    }

    @Test
    public void testAfter(){
        Range rangeDefault = new Range(5,7);
        Range rangeIn = new Range(6,9);
        Range result = LogikPart2.newRange(rangeIn, rangeDefault);
        assertEquals("5-9",result.getStart()+"-"+result.getStop());
    }

    @Test
    public void testDirektAfter(){
        Range rangeDefault = new Range(5,7);
        Range rangeIn = new Range(8,9);
        Range result = LogikPart2.newRange(rangeIn, rangeDefault);
        assertEquals("5-9",result.getStart()+"-"+result.getStop());
    }

    @Test
    public void testNoChange(){
        Range rangeDefault = new Range(5,6);
        Range rangeIn = new Range(8,9);
        Range result = LogikPart2.newRange(rangeIn, rangeDefault);
        assertNull(result);
        //assertEquals("5-6",result.getStart()+"-"+result.getStop());
    }

    @Test
    public void testNewArray(){
        Range rangeDefault = new Range(5,6);
        ArrayList<Range> rangeResult = new ArrayList<>();
        rangeResult.add(rangeDefault);
        Range rangeIn = new Range(8,9);
        ArrayList<Range> result = LogikPart2.multiRanges(rangeResult,rangeIn);
        assertEquals("5-6",result.getFirst().getStart()+"-"+result.getFirst().getStop());
        assertEquals("8-9",result.getLast().getStart()+"-"+result.getLast().getStop());
    }

    @Test
    public void testNewArrayAndKeepOne(){
        Range rangeDefault1 = new Range(5,6);
        Range rangeDefault2 = new Range(9,16);
        ArrayList<Range> rangeResult = new ArrayList<>();
        rangeResult.add(rangeDefault1);
        rangeResult.add(rangeDefault2);
        Range rangeIn = new Range(8,9);
        ArrayList<Range> result = LogikPart2.multiRanges(rangeResult,rangeIn);
        assertEquals("5-6",result.getFirst().getStart()+"-"+result.getFirst().getStop());
        assertEquals("8-16",result.getLast().getStart()+"-"+result.getLast().getStop());
        assertEquals(11,LogikPart2.sum(result));
    }

    @Test
    public void testThreeRanges(){
        Range rangeDefault1 = new Range(5,6);
        Range rangeDefault2 = new Range(9,16);
        Range rangeDefault3 = new Range(20,26);
        ArrayList<Range> rangeResult = new ArrayList<>();
        rangeResult.add(rangeDefault1);
        rangeResult.add(rangeDefault2);
        rangeResult.add(rangeDefault3);
        Range rangeIn = new Range(8,9);
        ArrayList<Range> result = LogikPart2.multiRanges(rangeResult,rangeIn);
        assertEquals("5-6",result.getFirst().getStart()+"-"+result.getFirst().getStop());
        assertEquals("20-26",result.getLast().getStart()+"-"+result.getLast().getStop());
        assertEquals(18,LogikPart2.sum(result));
    }

}
