package Contact;

import java.util.ArrayList;

/**
 * Contact class.
 */
public abstract class Contact //implements Serializable
{
	//fields
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	/**
	 * Empty Contact constructor
	 */
	public Contact()
	{

	}

	/**
	 * Parameterized Contact constructor
	 * 
	 * @param firstName
	 * @param lastName
	 * @param address
	 * @param city
	 * @param state
	 * @param zip
	 * @param phone
	 */
	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone)
	{
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhone(phone);
	}

	/**
	 * @return first name
	 */
	public String getFirstName()
	{
		return firstName;
	}

	/**
	 * @param firstName
	 * @return whether the given first name is valid
	 */
	public boolean setFirstName(String firstName)
	{
		if (firstNameValid(firstName))
		{
			this.firstName = firstName;
			return true;
		}
		return false;
	}

	/**
	 * @return last name
	 */
	public String getLastName()
	{
		return lastName;
	}

	/**
	 * @param lastName
	 * @return whether the given last name is valid
	 */
	public boolean setLastName(String lastName)
	{
		if (lastNameValid(lastName))
		{
			this.lastName = lastName;
			return true;
		}
		return false;
	}

	/**
	 * @return address
	 */
	public String getAddress()
	{
		return address;
	}

	/**
	 * @param address
	 * @return whether the given address is valid
	 */
	public boolean setAddress(String address)
	{
		if (addressValid(address))
		{
			this.address = address;
			return true;
		}
		return false;
	}

	/**
	 * @return city
	 */
	public String getCity()
	{
		return city;
	}

	/**
	 * @param city
	 * @return whether the given city is valid
	 */
	public boolean setCity(String city)
	{
		if (cityValid(city))
		{
			this.city = city;
			return true;
		}
		return false;
	}

	/**
	 * @return state
	 */
	public String getState()
	{
		return state;
	}

	/**
	 * @param state
	 * @return whether the given state is valid
	 */
	public boolean setState(String state)
	{
		if (stateValid(state))
		{
			this.state = state;
			return true;
		}
		return false;
	}

	/**
	 * @return zip code
	 */
	public String getZip()
	{
		return zip;
	}

	/**
	 * @param zip
	 * @return whether the given zip code is valid
	 */
	public boolean setZip(String zip)
	{
		if (zipValid(zip))
		{
			this.zip = zip;
			return true;
		}
		return false;
	}

	/**
	 * @return phone number
	 */
	public String getPhone()
	{
		return phone;
	}

	/**
	 * @param phone
	 * @return whether the given phone number is valid
	 */
	public boolean setPhone(String phone)
	{
		if (phoneValid(phone))
		{
			this.phone = phone;
			return true;
		}
		return false;
	}

	/**
	 * @param firstName
	 * @return whether the given first name is valid
	 */
	private boolean firstNameValid(String firstName)
	{
		return firstName.matches("[A-Z][a-zA-Z'-]*");
	}

	/**
	 * @param lastName
	 * @return whether the given last name is valid
	 */
	private boolean lastNameValid(String lastName)
	{
		return lastName.matches("[A-Z][a-zA-Z'-]*");
	}

	/**
	 * @param address
	 * @return whether the given address is valid
	 */
	private boolean addressValid(String address)
	{
		return address.matches("[0-9A-Za-z #,.]*");
	}

	/**
	 * @param city
	 * @return whether the given city is valid
	 */
	private boolean cityValid(String city)
	{
		return city.matches("([A-Z][a-z]*[-' ]?)+");
	}

	/**
	 * @param state
	 * @return whether the given state is valid
	 */
	private boolean stateValid(String state)
	{
		return state.matches("[A-Z]{2}");
	}

	/**
	 * @param zip
	 * @return whether the given zip code is valid
	 */
	private boolean zipValid(String zip)
	{
		return zip.matches("[0-9]{5}");
	}

	/**
	 * @param phone
	 * @return whether the given phone number is valid
	 */
	private boolean phoneValid(String phone)
	{
		return phone.matches("\\(([0-9]{3})\\)([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})\\.([0-9]{3})\\.([0-9]{4})")
				|| phone.matches("\\(?[0-9]{3}\\)? [0-9]{3} [0-9]{4}");
	}

	/**
	 * @return a string describing the contact
	 */
	public String toString()
	{
		return String.format("%s %s, %s, %s, %s, %s, (%s)", firstName, lastName, address, city, state, zip, phone);
	}

	//TODO serialization probs in each individual subclass - one list for each contact type since 3 seperate panels for each type
	public static void serializeContacts(ArrayList<Contact> cList, String fileName)
	{

	}

	public static void main(String[] args)
	{

	}
}