package nowcoder.合并区间;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<Interval>();
        if(intervals.isEmpty()) return ans;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        ans.add(intervals.get(0));
        int tail=0;
        for(int i=0;i<intervals.size();i++){
            if(ans.get(tail).end >= intervals.get(i).start) {
                ans.get(tail).end  = Math.max(ans.get(tail).end , intervals.get(i).end);
            } else {
                ans.add(intervals.get(i));
                tail++;
            }
        }
        return ans;
    }

}
