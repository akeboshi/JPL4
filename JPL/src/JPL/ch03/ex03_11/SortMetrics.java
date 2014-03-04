package JPL.ch03.ex03_11;

final class SortMetrics implements Cloneable{
	public long probeCnt,
				compareCnt,
				swapCnt;
	
	public void init(){
		probeCnt = compareCnt =swapCnt = 0;
	}
	@Override
	public String toString(){
		return probeCnt + " probes "+
				compareCnt + " compares "+
				swapCnt + " swap ";		
	}
	
	public SortMetrics clone(){
		try {
			return (SortMetrics)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.toString());
		}
	}
}