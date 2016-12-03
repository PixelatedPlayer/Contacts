
public class FamilyContact extends Contact
{
	private String relationship;
	//either have 3 strings or ints for month/day/year or Date class
	private String birthdayMonth;
	private String birthdayDay;
	private String birthdayYear;

	public FamilyContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String relationship, String birthdayMonth, String birthdayDay, String birthdayYear)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		this.relationship = relationship;
		this.birthdayMonth = birthdayMonth;
		this.birthdayDay = birthdayDay;
		this.birthdayYear = birthdayYear;
	}

	public String getRelationship()
	{
		return relationship;
	}

	public boolean setRelationship(String relationship)
	{
		if (relationshipValid(relationship))
		{
			this.relationship = relationship;
			return true;
		}
		return false;
	}

	//TODO not sure how to do setters for birthday, since there are 3 seperate ones.
	// you wouldn't be able to validate the date until all 3 are in.
	// either do it as one string and split it or validate only when all 3 are in and on update.

	public String getBirthdayMonth()
	{
		return birthdayMonth;
	}

	//TODO confirm these are it..
	private String[] relationships = new String[] { "Brother", "Sister", "Mother", "Father", "Son", "Daughter", "Wife",
			"Husband", "Spouse", "Cousin", "Grandfather", "Grandmother", "Aunt", "Uncle", "Nephew", "Niece", "Grandson",
			"Granddaughter" };

	private boolean relationshipValid(String relationship)
	{
		for (String s : relationships)
		{
			if (relationship.matches(s))
				return true;
		}
		return false;
	}

	//month/day/year or day/month/year?
	//check which one it is, and make sure it is valid to that format
	//accept 2 or 4 digit for year
	// OR
	// GUI has 3 text boxes, specified as month day year, validate each of those.

	// do we alloy any year? or only reasonable ones?
	private boolean birthdayValid(String month, String day, String year)
	{
		try
		{
			int monthInt = Integer.parseInt(month);
			int dayInt = Integer.parseInt(day);
			int yearInt = Integer.parseInt(year);

			//if invalid month or day stop trying
			if (monthInt <= 0 || monthInt > 12)
				return false;
			if (dayInt <= 0 || dayInt > 31)
				return false;

			//for months with less than 31 days
			switch (monthInt)
			{
			//februray, considers leap year as well
			case 2:
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
				//April
			case 4:
				if (monthInt > 30)
					return false;
				//June
			case 6:
				if (monthInt > 30)
					return false;
				//September
			case 9:
				if (monthInt > 30)
					return false;
				//November
			case 11:
				if (monthInt > 30)
					return false;
			}
		} catch (Exception ex)
		{
			//should only occur when parse fails, which means they did not enter numbers
			return false;
		}

		return true;
	}
}
