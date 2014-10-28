package JPL.ch01.ex01_16;

import java.io.*;

class BadDataSetException extends Exception {
	public String setName;
	public IOException internalIOException;

	public BadDataSetException(String setName,IOException e){
		this.setName = setName;
		this.internalIOException = e;
	}
}

class MyUtilities{

	public static void main(String[] args) throws BadDataSetException{
		MyUtilities test = new MyUtilities();
		double[] dData = new double[100];
		dData = test.getDataSet("test");
		for( int i= 0 ; dData[i] != 0 ; i++){
			System.out.println(dData[i]);
		}
	}

	public double[] getDataSet(String setName)
		throws BadDataSetException
	{
		String file = setName + ".dset";
		FileInputStream in = null;
		try {
			in = new FileInputStream(file);
			if( in == null)System.out.println("in is error");
			return readDataSet(in);
		} catch (IOException e) {
			throw new BadDataSetException(setName, e);
		} finally {
			try {
				if ( in != null)
					in.close();
			} catch (IOException e) {
				; // 無視：データの読み込みは成功しているか、あるいは、BadDataSetExceptionをスローしようとしている
			}
		}
		
	}
	
	private double[] readDataSet(FileInputStream in) throws IOException{
		DataInputStream din = new DataInputStream(in);
		double[] numSet = new double[din.available()];

		try{
			for(int i = 0; i < numSet.length; i++){
				numSet[i] = din.readDouble();
			}
		} catch (IOException e) {
			throw e;
		}finally {
			;
		}
		return numSet;
	}
}
