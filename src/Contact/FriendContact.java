package Contact;

/**
 * FriendContact class
 */
public class FriendContact extends Contact
{
	//unique fields
	private String hobbies;
	private String interests;

	/**
	 * Empty FriendContact constructor
	 */
	public FriendContact()
	{
		type = ContactType.FRIEND;
	}

	/**
	 * Parametrized FriendContact constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param hobbies
	 * @param interests
	 */
	public FriendContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String hobbies, String interests)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		setHobbies(hobbies);
		setInterests(interests);
		type = ContactType.FRIEND;
	}

	/**
	 * @return hobbies
	 */
	public String getHobbies()
	{
		return hobbies;
	}

	/**
	 * @param hobbies
	 * @return whether the given hobbies string is valid
	 */
	public boolean setHobbies(String hobbies)
	{
		if (hobbiesValid(hobbies))
		{
			this.hobbies = hobbies;
			return true;
		}
		return false;
	}

	/**
	 * @return interests
	 */
	public String getInterests()
	{
		return interests;
	}

	/**
	 * @param interests
	 * @return whether the given interests string is valid
	 */
	public boolean setInterests(String interests)
	{
		if (interestsValid(interests))
		{
			this.interests = interests;
			return true;
		}
		return false;
	}

	/**
	 * @param hobbies
	 * @return whether the given hobbies string is valid
	 */
	public static boolean hobbiesValid(String hobbies)
	{
		return true;
	}

	/**
	 * @param interests
	 * @return whether the given interests string is valid
	 */
	public static boolean interestsValid(String interests)
	{
		return true;
	}

	/**
	 * @return a string describing the contact
	 */
	public String toString()
	{
		return super.toString() + ", " + String.format("%s, %s", hobbies, interests);
	}
}
