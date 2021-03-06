package Contact;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contact class.
 */
public abstract class Contact implements Serializable
{
	public static enum ContactType
	{
		FRIEND, FAMILY, BUSINESS
	}

	//fields
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;
	protected ContactType type;

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
	 *            first name of the contact
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
	 *            last name of the contact
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
	 *            address of the contact
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
	 *            city of the contact
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
	 *            state of the contact
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
	 *            zip code of the contact
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
	 *            phone number of the contact
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

	public ContactType getType()
	{
		return type;
	}

	/**
	 * @param firstName
	 *            first name to validate
	 * @return whether the given first name is valid
	 */
	public static boolean firstNameValid(String firstName)
	{
		return firstName.matches("[A-Z][a-zA-Z'-]*");
	}

	/**
	 * @param lastName
	 *            last name to validate
	 * @return whether the given last name is valid
	 */
	public static boolean lastNameValid(String lastName)
	{
		return lastName.matches("[A-Z][a-zA-Z'-]*");
	}

	/**
	 * @param address
	 *            address to validate
	 * @return whether the given address is valid
	 */
	public static boolean addressValid(String address)
	{
		return address.matches("[0-9A-Za-z #,.]+");
	}

	/**
	 * @param city
	 *            city to validate
	 * @return whether the given city is valid
	 */
	public static boolean cityValid(String city)
	{
		return city.matches("([A-Z][a-z]*[-' ]?)+");
	}

	/**
	 * @param state
	 *            state to validate
	 * @return whether the given state is valid
	 */
	public static boolean stateValid(String state)
	{
		return state.matches("[A-Za-z]{2}");
	}

	/**
	 * @param zip
	 *            zip code to validate
	 * @return whether the given zip code is valid
	 */
	public static boolean zipValid(String zip)
	{
		return zip.matches("[0-9]{5}(-[0-9]{4})?");
	}

	/**
	 * @param phone
	 *            phone number to validate
	 * @return whether the given phone number is valid
	 */
	public static boolean phoneValid(String phone)
	{
		return phone.matches("\\(([0-9]{3})\\)([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})-([0-9]{3})-([0-9]{4})")
				|| phone.matches("([0-9]{3})\\.([0-9]{3})\\.([0-9]{4})")
				|| phone.matches("\\(?[0-9]{3}\\)? [0-9]{3} [0-9]{4}")
				|| phone.matches("[0-9]{10}");
	}

	/**
	 * @return a string describing the contact
	 */
	public String toString()
	{
		return String.format("%s %s, %s, %s, %s, %s, (%s)", firstName, lastName, address, city, state, zip, phone);
	}
	//serializaiton stuffs

	/**
	 * write ArrayList<Contact> to file
	 * 
	 * @param contacts
	 *            list of contacts to serialize
	 * @param fileName
	 *            file location to serialize to
	 */
	public static void serialize(ArrayList<Contact> contacts, String fileName)
	{
		try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName)))
		{
			out.writeObject(contacts);
		} catch (IOException ex)
		{
			System.out.println("Error during serialization");
			System.out.println(ex.getMessage());
		}
	}

	/**
	 * read a file as ArrayList<Contact>
	 * 
	 * @param fileName
	 *            file location to deserialize
	 * @return ArrayList<Contact> contacts
	 */
	public static ArrayList<Contact> deserialize(String fileName)
	{
		ArrayList<Contact> contacts = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
		{
			contacts = (ArrayList<Contact>) in.readObject();
		} catch (IOException | ClassNotFoundException ex)
		{
			System.out.println("Error during deserialization of " + fileName);
			System.out.println(ex.getMessage());
		}

		return contacts;
	}
}