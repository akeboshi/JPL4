package JPL4.prac312;

abstract class  SortHarness{
	private Object[] values;
	private final SortMetrics curMetrics = new SortMetrics();
	
	public final SortMetrics sort(Object[] data){
		values =data;
		curMetrics.init();
		doSort();
		return getMetrics();
	}
	
	 public final SortMetrics getMetrics() {
		return curMetrics.clone();
	}

	protected final int getDataLength(){
		return values.length;
	}
	
	protected final Object probe(int i){
		curMetrics.probeCnt++;
		return values[i];
	}
	
	protected final int compare(int i, int j){
		curMetrics.compareCnt++;
		Object d1 = values[i];
		Object d2 = values[j];
		
		if(d1 == d2)
			return 0;
		else
			return (d1.hashCode() - d2.hashCode()  );
	}
	
	protected final void swap (int i, int j){
		curMetrics.swapCnt++;
		Object tmp = values[i];
		values[i] = values[j];
		values[j] = tmp;
	}
	
	protected abstract void doSort();
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}
}