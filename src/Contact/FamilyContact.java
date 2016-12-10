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
		type = ContactType.FAMILY;
	}

	/**
	 * Parameterized FamilyContact constructor
	 * 
	 * @param firstName
	 *            first name of the contact
	 * @param lastName
	 *            last name of the contact
	 * @param address
	 *            address of the contact
	 * @param city
	 *            city of the contact
	 * @param state
	 *            state of the contact
	 * @param zip
	 *            zip code of the contact
	 * @param phone
	 *            phone number of the contact
	 * @param relationship
	 *            relationship the user has with the contact
	 * @param birthday
	 *            birthday of the contact
	 */
	public FamilyContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String relationship, String birthday)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		setRelationship(relationship);
		setBirthday(birthday);
		type = ContactType.FAMILY;
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
	 *            relationship the user has with the contact
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
	 *            birthday of the contact
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
	 *            relationship to validate
	 * @return whether the given relationship is valid
	 */
	public static boolean relationshipValid(String relationship)
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
	 *            birthday to validate
	 * @return whether the given birthday is valid
	 */
	public static boolean birthdayValid(String birthday)
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
