package JPL4.prac63;

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