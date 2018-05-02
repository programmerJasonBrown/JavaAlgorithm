package lintCodeProblem.convertStringToInt.num156merge;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Merge {

    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        List<Interval> rs = new ArrayList<Interval>();
        if (intervals == null || intervals.size() < 1)
            return rs;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        Interval pre = null;
        for (Interval interval : intervals) {
            if (pre == null || pre.end < interval.start) {
                rs.add(interval);
                pre = interval;
            } else if (interval.end > pre.end) {
                pre.end = interval.end;
            }
        }
        return rs;
    }
}
