package Contact;

/**
 * FamilyContact class
 */
public class FamilyContact extends Contact
{
	//unique fields
	private String relationship;
	private String birthday;

	/**
	 * Empty FamilyContact constructor
	 */
	public FamilyContact()
	{

	}

	/**
	 * Parameterized FamilyContact constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param relationship
	 * @param birthdayMonth
	 * @param birthdayDay
	 * @param birthdayYear
	 */
	public FamilyContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String relationship, String birthday)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		setRelationship(relationship);
		setBirthday(birthday);
	}

	/**
	 * @return relationship
	 */
	public String getRelationship()
	{
		return relationship;
	}

	/**
	 * @param relationship
	 * @return whether the given relationship is valid
	 */
	public boolean setRelationship(String relationship)
	{
		if (relationshipValid(relationship))
		{
			this.relationship = relationship;
			return true;
		}
		return false;
	}

	/**
	 * @param birthday
	 * @return whether the given birthday date is valid
	 */
	public boolean setBirthday(String birthday)
	{
		if (birthdayValid(birthday))
		{
			this.birthday = birthday;
			return true;
		}
		return false;
	}

	/**
	 * @return birthday
	 */
	public String getBirthday()
	{
		return birthday;
	}

	//list of valid relationships. static because it's not changed between different instances
	private static String[] relationships = new String[] { "Father", "Mother", "Brother", "Sister",
			"Son", "Daughter", "Uncle", "Aunt", "Nephew", "Niece", "Father-in-Law", "Mother-in-Law",
			"Brother-in-Law", "Sister-in-Law", "Grandfather", "Grandmother" };

	/**
	 * @param relationship
	 * @return whether the given relationship is valid
	 */
	private boolean relationshipValid(String relationship)
	{
		for (String s : relationships)
		{
			if (relationship.matches(s))
				return true;
		}
		return false;
	}

	/**
	 * @param birthday
	 * @return whether the given birthday is valid
	 */
	private boolean birthdayValid(String birthday)
	{
		try
		{
			//valid input format
			if (!(birthday.matches("[0-9]{2}(/|-| )[0-9]{2}(/|-| )[0-9]{4}")))
				return false;

			//seperate string into integers
			int monthInt = Integer.parseInt(birthday.substring(0, 2));
			int dayInt = Integer.parseInt(birthday.substring(3, 5));
			int yearInt = Integer.parseInt(birthday.substring(6, 10));

			//if invalid month or day or negative stop trying
			if (monthInt <= 0 || monthInt > 12)
				return false;
			if (dayInt <= 0 || dayInt > 31)
				return false;
			if (yearInt < 0)
				return false;

			//for months with less than 31 days
			//februray, considers leap year as well
			if (monthInt == 2)
			{
				if (yearInt % 4 == 0)
				{ //is a leap year
					if (dayInt > 29)
						return false;
				}
				else
				{
					if (dayInt > 28)
						return false;
				}
			}
			//April, June, September, November
			if (monthInt == 4 || monthInt == 6 || monthInt == 9 || monthInt == 11)
			{
				if (dayInt > 30)
					return false;
			}
		} catch (Exception ex)
		{
			//should only occur when parse fails, which means they did not enter numbers
			return false;
		}

		return true;
	}

	/**
	 * @return a string describing the contact
	 */
	public String toString()
	{
		return super.toString() + ", " + String.format("%s, %s", relationship, birthday);
	}
}
