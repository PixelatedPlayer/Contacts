
public class BusinessContact extends Contact
{
	private String company;
	private String email;

	public BusinessContact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone, String company, String email)
	{
		super(firstName, lastName, address, city, state, zip, phone);
		this.company = company;
		this.email = email;
	}

	public String getCompany()
	{
		return company;
	}

	public boolean setCompany(String company)
	{
		if (companyValid(company))
		{
			this.company = company;
			return true;
		}
		return false;
	}

	public String getEmail()
	{
		return email;
	}

	public boolean setEmail(String email)
	{
		if (emailValid(email))
		{
			this.email = email;
			return true;
		}
		return false;
	}

	//TODO are companies names restricted?
	private boolean companyValid(String company)
	{
		return true;
	}

	//TODO test this works right
	private boolean emailValid(String email)
	{
		return email.matches("[^@]*@[^@]*\\.(com|net|org|gov|biz)");
	}
}
