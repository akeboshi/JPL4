package JPL.ch12.ex12_01;

public class ObjectNotFoundException extends Exception{
	public final String reason;

	public ObjectNotFoundException(String reason){
		super("Object don't found " + reason );
		this.reason = reason;
	}
}