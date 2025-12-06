package day5;

import java.util.ArrayList;

public class LogikPart2 {

    public static Range newRange(Range rangeIn, Range rangeResult) {
        Range result;
        // Överlappar eller följer varandra direkt före eller direkt efter
        //  ------         --------                 -----------    // rangeResult
        //     -------             ------     ------               // rangeIn
        if ( overlap(rangeIn,rangeResult)
                || rangeResult.getStop() + 1 == rangeIn.getStart()
                || rangeIn.getStop()+1  == rangeResult.getStart() ) {
            long start = Math.min(rangeIn.getStart(), rangeResult.getStart());
            long stop = Math.max(rangeIn.getStop(),rangeResult.getStop());
            result = new Range(start,stop);
            System.out.println("fixade "+start+"-"+stop);
        }
        else {
            result=null;
        }

        return result;
    }

    public static ArrayList<Range> multiRanges(ArrayList<Range> ranges, Range rangeIn){
            ArrayList<Range> newRanges = new ArrayList<>();
            boolean hit= false;
            for (Range range:ranges){
                Range newRange = newRange(rangeIn,range);
                if (newRange!=null){
                    newRanges.add(newRange);
                    hit =true;
                }
                else newRanges.add(range);
            }
            if (!hit) {
                System.out.println("newArray "+rangeIn.getStart()+"-"+rangeIn.getStop());
                newRanges.add(rangeIn);
            }
       return newRanges;
    }

    public static boolean overlap ( Range r1, Range r2){
        return r1.getStart() <= r2.getStop()
                && r2.getStart() <= r1.getStop();
    }

    public static long sum(ArrayList<Range> ranges){
        long sum = 0;
        for (Range range:ranges){
            sum += range.getStop()-range.getStart()+1;
        }
        return sum;
    }





}
