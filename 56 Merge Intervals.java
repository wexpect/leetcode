Merge Intervals Total Accepted: 2211 Total Submissions: 11484 My Submissions
Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].




/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if(intervals == null)
            return null;
            
        if( intervals.size() <= 1)
            return intervals;
            
        ArrayList<Interval> interList = sortByStart(intervals);

        int i = 0;
        while( i <= interList.size()-2 ){
            Interval int1 = interList.get(i);
            Interval int2 = interList.get(i+1);
            
            if(int1.end < int2.start)
                i++;
            else{
                int1.end = Math.max(int1.end, int2.end);
                interList.remove(i+1);
            }
        }
        
        return interList;
    }
    
    public ArrayList<Interval> sortByStart( ArrayList<Interval> intervals){
        Interval[] arr = new Interval[intervals.size()];
        
        int i = 0;
        for(Interval inter : intervals){
            arr[i++] = inter;
        }
        
        Arrays.sort(arr, new MyComparator() );
        
        ArrayList<Interval> newList = new ArrayList<Interval>();
        for(Interval inter : arr)
            newList.add(inter);
            
        return newList;
    }
    
    public class MyComparator implements Comparator<Interval>{
        public int compare(Interval int1, Interval int2){
            if( int1.start < int2.start)
                return -1;
            else if(int1.start == int2.start)
                return 0;
            else
                return 1;
        }
    }
    
}

/*

Submission Result: Wrong Answer

Input:	[[1,4],[0,4]]
Output:	[[1,4]]
Expected:	[[0,4]]

*/