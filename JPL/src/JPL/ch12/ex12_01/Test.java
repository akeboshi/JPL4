package JPL.ch12.ex12_01;

class Test{
	public static void main(String[] args) throws ObjectNotFoundException {
		Test test = new Test();
		test.street();
	}

	public void street() throws ObjectNotFoundException{
		throw new ObjectNotFoundException("test");
	}
}