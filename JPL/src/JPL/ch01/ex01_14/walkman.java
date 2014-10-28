package JPL.ch01.ex01_14;

public class Walkman {
	Plug plug;
	MusicTape musictape;
	Status state = Status.STOP;

	public void setPlug(Plug plug){
		this.plug = plug;
	}

	public Plug getPlug(){
		return plug;
	}

	public void setMusicTape(Musictape musictape) {
		this.musictape = musictape;
	}
	
	public Musictape getMusicTape() {
		return musictape;
	}

	public void setStatus(Status state){
		this.state = state;
	}

	public Status getStatus(){
		return state;
	}

	public enum State{
		STOP,START,PAUSE
	}

	public static class Plug {
	}

	public static class MusicTape{
	}
}

public class dualWalkman extends Walkman {
	Plug secondPlug;

	public void setSecondPlug(Plug secondPlug){
		this.secondPlug = secondPlug;
	}
}

