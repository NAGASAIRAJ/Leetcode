import java.util.ArrayList;


public class MergeIntervals {
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		ArrayList<Interval> results = new ArrayList<Interval>();
		for( int i = 0; i < intervals.size(); i++ ) 
			results = InsertInterval(results, intervals.get(i));
		return results;		
    }
	private ArrayList<Interval> InsertInterval(ArrayList<Interval> intervals, 
												Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		for( int i = 0; i < intervals.size(); i++ ) {
			Interval tmp = intervals.get(i);
			if( newInterval.end < tmp.start ) {
				result.add(newInterval);
				for( int j = i; j < intervals.size(); j++ )
					result.add(intervals.get(j));
				return result;
			}
			else if( tmp.end < newInterval.start ) {
				result.add(tmp);
				continue;
			}
			else {
				newInterval.start = Math.min(tmp.start, newInterval.start);
				newInterval.end = Math.max(tmp.end, newInterval.end);
			}
		}
		result.add(newInterval);
		return result;
	}
}
