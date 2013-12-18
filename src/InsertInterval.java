import java.util.ArrayList;


public class InsertInterval {
	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
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

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
