package Contact;

//throw this in GUI if not valid, catch and do a JOptionPane
public class InvalidDeletionAttemptException extends Exception
{
	public InvalidDeletionAttemptException()
	{
		super();
	}

	public InvalidDeletionAttemptException(String arg)
	{
		super(arg);
	}
}
