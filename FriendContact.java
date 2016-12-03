
public class FriendContact extends Contact
{
	private String hobbies;
	private String interests;

	public FriendContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String hobbies, String interests)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		this.hobbies = hobbies;
		this.interests = interests;
	}

	public String getHobbies()
	{
		return hobbies;
	}

	public boolean setHobbies(String hobbies)
	{
		if (hobbiesValid(hobbies))
		{
			this.hobbies = hobbies;
			return true;
		}
		return false;
	}

	public String getInterests()
	{
		return interests;
	}

	public boolean setInterests(String interests)
	{
		if (interestsValid(interests))
		{
			this.interests = interests;
			return true;
		}
		return false;
	}

	private boolean hobbiesValid(String hobbies)
	{
		return true;
	}

	private boolean interestsValid(String interests)
	{
		return true;
	}
}
