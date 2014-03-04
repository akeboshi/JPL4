package JPL.ch03.ex03_12;

class SimpleSortDouble extends SortHarness implements Cloneable{
	static int i = 1;
	@Override
	protected void doSort() {
		for (int i = 0; i < getDataLength(); i++) {
			for (int j = 0; j < getDataLength(); j++) {
				if (compare(i, j) > 0)
					swap(i, j);
			}
		}
/*
		double[] aaa = {0};
		SortDouble tes = (SortDouble)this.clone();
		if(i == 1){i++;tes.sort(aaa);}
*/	}
	
	@Override
	protected SimpleSortDouble clone(){
		try {
			return (SimpleSortDouble)super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			throw new InternalError(e.toString());
		}
	}
	
}