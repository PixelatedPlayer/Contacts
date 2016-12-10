package Contact;

/**
 * BusinessContact class
 */
public class BusinessContact extends Contact
{
	//unique fields
	private String company;
	private String email;

	/**
	 * Empty BusinessContact constructor
	 */
	public BusinessContact()
	{
		type = ContactType.BUSINESS;
	}

	/**
	 * Parameterized BusinessContact constructor
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
	 * @param company
	 *            company of the contact
	 * @param email
	 *            email of the contact
	 */
	public BusinessContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String company, String email)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		setCompany(company);
		setEmail(email);
		type = ContactType.BUSINESS;
	}

	/**
	 * @return company
	 */
	public String getCompany()
	{
		return company;
	}

	/**
	 * @param company
	 *            company of the contact
	 * @return whether the given company name is valid
	 */
	public boolean setCompany(String company)
	{
		if (companyValid(company))
		{
			this.company = company;
			return true;
		}
		return false;
	}

	/**
	 * @return email
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * @param email
	 *            email of the contact
	 * @return whether the given email is valid
	 */
	public boolean setEmail(String email)
	{
		if (emailValid(email))
		{
			this.email = email;
			return true;
		}
		return false;
	}

	/**
	 * @param company
	 *            company name to validate
	 * @return whether the given company name is valid
	 */
	public static boolean companyValid(String company)
	{
		return true;
	}

	/**
	 * @param email
	 *            email to validate
	 * @return whether the given email is valid
	 */
	public static boolean emailValid(String email)
	{
		return email.matches("^[A-Za-z0-9._]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");
	}

	/**
	 * @return a string describing the contact
	 */
	public String toString()
	{
		return super.toString() + ", " + String.format("%s, %s", company, email);
	}
}
