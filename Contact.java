import java.util.ArrayList;

// panel system - one jframe for 4 different screens - welcome page - business - family - friends
// if neccessary make another class that saves each of the lists (3) and serialize that to save into a single file
// right now in order to check if valid you have to set it (b/c they are private) do we want to set it every time they press enter in a text box? if not make the validations public
public abstract class Contact //implements Serializable
{
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	// Theoretically, contacts are created when you click new, and have no information yet
	// so you should never be giving anything to the constructor, only using set when you update.
	// therefore we might want to remove paramaterized constructors. and have only an empty one.
	// do this for sub classes as well.
	public Contact(String firstName, String lastName, String address, String city, String state, String zip,
			String phone)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public Contact()
	{

	}

	public String getFirstName()
	{
		return firstName;
	}

	public boolean setFirstName(String firstName)
	{
		if (firstNameValid(firstName))
		{
			this.firstName = firstName;
			return true;
		}
		return false;
	}

	public String getLastName()
	{
		return lastName;
	}

	public boolean setLastName(String lastName)
	{
		if (lastNameValid(lastName))
		{
			this.lastName = lastName;
			return true;
		}
		return false;
	}

	public String getAddress()
	{
		return address;
	}

	public boolean setAddress(String address)
	{
		if (addressValid(address))
		{
			this.address = address;
			return true;
		}
		return false;
	}

	public String getCity()
	{
		return city;
	}

	public boolean setCity(String city)
	{
		if (cityValid(city))
		{
			this.city = city;
			return true;
		}
		return false;
	}

	public String getState()
	{
		return state;
	}

	public boolean setState(String state)
	{
		if (stateValid(state))
		{
			this.state = state;
			return true;
		}
		return false;
	}

	public String getZip()
	{
		return zip;
	}

	public boolean setZip(String zip)
	{
		if (zipValid(zip))
		{
			this.zip = zip;
			return true;
		}
		return false;
	}

	public String getPhone()
	{
		return phone;
	}

	public boolean setPhone(String phone)
	{
		if (phoneValid(phone))
		{
			this.phone = phone;
			return true;
		}
		return false;
	}

	private boolean firstNameValid(String firstName)
	{
		return firstName.matches("[A-Z][a-zA-Z'-]*");
	}

	private boolean lastNameValid(String lastName)
	{
		return lastName.matches("[A-Z][a-zA-Z'-]*");
	}

	private boolean addressValid(String address)
	{
		return address.matches("[0-9A-Za-z #,.]");
	}

	private boolean cityValid(String city)
	{
		return city.matches("([A-Z][a-z]*[-' ]?)+");
	}

	private boolean stateValid(String state)
	{
		return state.matches("([A-Z][a-z]*[-' ]?)+");
		//return state.matches("^[0-9]");
	}

	private boolean zipValid(String zip)
	{
		return zip.matches("[0-9]{5}");
	}

	private boolean phoneValid(String phone)
	{
		return phone.matches("\\(([0-9]{3})\\)([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})\\.([0-9]{3})\\.([0-9]{4})")
				|| phone.matches("\\(?[0-9]{3}\\)? [0-9]{3} [0-9]{4}");
	}

	//TODO serialization probs in each individual subclass - one list for each contact type since 3 seperate panels for each type
	public static void serializeContacts(ArrayList<Contact> cList, String fileName)
	{

	}

	public static void main(String[] args)
	{

	}
}