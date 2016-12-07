package Contact;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class ContactList implements Serializable
{
	// have as public, or have getters and setters?
	// public is seriously better, but Baird might get mad :(
	public ArrayList<BusinessContact> businessContacts;
	public ArrayList<FriendContact> friendContacts;
	public ArrayList<FamilyContact> familyContacts;

	public ContactList()
	{
		businessContacts = new ArrayList<BusinessContact>();
		friendContacts = new ArrayList<FriendContact>();
		familyContacts = new ArrayList<FamilyContact>();
	}

	public static void serialize(ContactList contacts, String fileName)
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

	public static ContactList deserialize(String fileName)
	{
		ContactList contacts = null;
		try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName)))
		{
			contacts = (ContactList) in.readObject();
		} catch (IOException | ClassNotFoundException ex)
		{
			System.out.println("Error during deserialization of " + fileName);
			System.out.println(ex.getMessage());
		}

		return contacts;
	}
}
