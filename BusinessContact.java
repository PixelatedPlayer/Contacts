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
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 * @param company
	 * @param email
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
	 * @return whether the given company name is valid
	 */
	private boolean companyValid(String company)
	{
		return true;
	}

	/**
	 * @param email
	 * @return whether the given email is valid
	 */
	private boolean emailValid(String email)
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
