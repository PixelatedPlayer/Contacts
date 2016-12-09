package Contact;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ContactTest
{

	private FriendContact friC;
	private BusinessContact busC;
	private FamilyContact famC;

	@Before
	public void setUp() throws Exception
	{
		friC = new FriendContact();
		busC = new BusinessContact();
		famC = new FamilyContact();
	}

	@After
	public void tearDown() throws Exception
	{
		friC = null;
		busC = null;
		famC = null;
	}

	@Test
	public void test()
	{
		//fields
		String firstName = "George";
		String lastName = "Washington";
		String address = "Washington Home Address #2";
		String city = "New York";
		String state = "NY";
		String zip = "55555";
		String phone = "555 555 5555";

		//specific fields
		String relationship = "Father";
		String birthday = "02/22/1732";

		String hobbies = "Being a war hero, Being unanimously elected as the first president.";
		String interests = "Guns, Horses";

		String company = "Washington INC.";
		String email = "george.washington@washingtonisme.com";

		//General contact
		System.out.println(firstName + " valid first name?: " + friC.setFirstName(firstName));
		System.out.println(lastName + " valid last name?: " + friC.setLastName(lastName));
		System.out.println(address + " valid address?: " + friC.setAddress(address));
		System.out.println(city + " valid city?: " + friC.setCity(city));
		System.out.println(state + " valid state?: " + friC.setState(state));
		System.out.println(zip + " valid zip code?: " + friC.setZip(zip));
		System.out.println(phone + " valid phone number?: " + friC.setPhone(phone));

		//Friend contact
		System.out.println(hobbies + " valid hobbies?: " + friC.setHobbies(hobbies));
		System.out.println(interests + " valid interests?: " + friC.setInterests(interests));

		//Business contact
		busC.setFirstName(firstName);
		busC.setLastName(lastName);
		busC.setAddress(address);
		busC.setCity(city);
		busC.setState(state);
		busC.setZip(zip);
		busC.setPhone(phone);

		System.out.println(company + " valid?: " + busC.setCompany(company));
		System.out.println(email + " valid?: " + busC.setEmail(email));

		//Family contact
		famC.setFirstName(firstName);
		famC.setLastName(lastName);
		famC.setAddress(address);
		famC.setCity(city);
		famC.setState(state);
		famC.setZip(zip);
		famC.setPhone(phone);

		System.out.println(relationship + " valid?: " + famC.setRelationship(relationship));
		System.out.println(birthday + " valid?: " + famC.setBirthday(birthday));

		//set confirmation
		System.out.println("\nCreated contacts:");
		System.out.println(friC.toString());
		System.out.println(busC.toString());
		System.out.println(famC.toString());

		//invalid checks
		System.out.println("\nInvalid checks:");

		firstName = "george";
		lastName = "washington";
		address = "-";
		city = "new york";
		state = "NEW YORK";
		zip = "0";
		phone = "-";

		System.out.println(firstName + " valid first name?: " + friC.setFirstName(firstName));
		System.out.println(lastName + " valid last name?: " + friC.setLastName(lastName));
		System.out.println(address + " valid address?: " + friC.setAddress(address));
		System.out.println(city + " valid city?: " + friC.setCity(city));
		System.out.println(state + " valid state?: " + friC.setState(state));
		System.out.println(zip + " valid zip code?: " + friC.setZip(zip));
		System.out.println(phone + " valid phone number?: " + friC.setPhone(phone));

		System.out.println();

		firstName = "Ge0rge";
		lastName = "W4shington";
		address = "no @ddress";
		city = "new y0rk";
		state = "N0";
		zip = "five5";
		phone = "5555 555 555";

		System.out.println(firstName + " valid first name?: " + friC.setFirstName(firstName));
		System.out.println(lastName + " valid last name?: " + friC.setLastName(lastName));
		System.out.println(address + " valid address?: " + friC.setAddress(address));
		System.out.println(city + " valid city?: " + friC.setCity(city));
		System.out.println(state + " valid state?: " + friC.setState(state));
		System.out.println(zip + " valid zip code?: " + friC.setZip(zip));
		System.out.println(phone + " valid phone number?: " + friC.setPhone(phone));

		//constructor test
		System.out.println("\nConstructor test");

		famC = new FamilyContact("Thomas", "Jefferson", "Mozebarry ln.", "Pennsylvania City", "PA", "55555",
				"(555)555-5555", "Father", "04/13/1743");
		System.out.println(famC.toString());

		//serialization test
		System.out.println("\nSerialization Testing:");
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		contacts = new ArrayList<Contact>();

		contacts.add(famC);
		contacts.add(friC);
		contacts.add(busC);

		Contact.serialize(contacts, "contacts.ser");
		contacts = Contact.deserialize("contacts.ser");
		for (Contact c : contacts)
		{
			System.out.println(c.toString());
		}
	}

}
