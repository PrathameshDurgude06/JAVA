package custom_exception;

@SuppressWarnings("serial")
public class PollutionOutOfRangeException extends Exception{
	public PollutionOutOfRangeException(String mesg)
	{
		super(mesg);
	}

}
