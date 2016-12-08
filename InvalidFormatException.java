package Contact;

//throw this in GUI if not valid, catch and do a JOptionPane
public class InvalidFormatException extends Exception
{
	public InvalidFormatException()
	{
		super();
	}

	public InvalidFormatException(String arg)
	{
		super(arg);
	}
}
