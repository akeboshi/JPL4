package JPL.ch06.ex06_03;

interface Verbose{
	enum Message{
		SILENT,
		TERSE,
		NORMAL,
		VERBOSE
	}
	void setVerbosity(Message level);
	Message getVerbosity();
}