package JPL.ch06.ex06_03;

class Test implements Verbose{
	Message level = Message.SILENT;
	
	public static void main(String[] args) {
			Test test = new Test();
			test.setVerbosity(Message.TERSE);
			switch (test.getVerbosity()) {
			case SILENT:
				System.out.println("silent");
				break;
			case TERSE:
				System.out.println("terse");
				break;
			case NORMAL:
				System.out.println("normal");
				break;
			case VERBOSE:
				System.out.println("verbose");
				break;
	
			default:
				break;
		}
	}
	
	@Override
	public void setVerbosity(Message level) {
		this.level = level; 
	}

	@Override
	public Message getVerbosity() {
		return this.level;
	}
	
}