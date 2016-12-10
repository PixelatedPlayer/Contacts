package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Label;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.nio.file.Path;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.KeyStroke;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import Contact.BusinessContact;
import Contact.Contact;
import Contact.FamilyContact;
import Contact.FriendContact;
import Contact.InvalidDeletionAttemptException;

public class ContactManager
{

	private JFrame frmContactManagement;
	private JPanel panelTextFields;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZipCode;
	private JTextField textMobileNumber;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZipCode;
	private JLabel lblMobileNumber;
	private JPanel panelWelcome;
	private JPanel panelFriends;
	private JPanel panelFamily;
	private JLabel lblRelationship;
	private JTextField textFieldBirthday;
	private JTextField textCompany;
	private JTextField textEmail;
	private JButton btnBack;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmExit;
	private JPanel panelBusiness;
	private JLabel lblWelcomeToFfb;
	private JLabel lblContactManagement;
	private JLabel lblfamilypic;
	private JLabel lblfriendspic;
	private JLabel lblBusinessPic;
	private JSeparator separator;
	private JComboBox comboBox;
	private JLabel lblContact;
	private JMenuItem mntmOpen;
	private JTextPane textPaneHobbies;
	private JTextPane textPaneInterests;
	private JComboBox comboBoxRelationship;
	private JButton btnDelete;
	private JButton btnAdd;

	private ArrayList<Contact> contacts;
	private Contact selected;
	private Contact.ContactType menu = Contact.ContactType.FRIEND;
	private boolean fileExists = false;
	private String fileName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		EventQueue.invokeLater(new Runnable()
		{
			public void run()
			{
				try
				{
					ContactManager window = new ContactManager();
					window.frmContactManagement.setVisible(true);
				} catch (Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactManager()
	{
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
	{
		try
		{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels())
			{
				if ("W".equals(info.getName()))
				{
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e)
		{

		}

		contacts = new ArrayList<Contact>();

		frmContactManagement = new JFrame();
		frmContactManagement.setIconImage(Toolkit.getDefaultToolkit()
				.getImage(ContactManager.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		frmContactManagement.setTitle("Contact Management");
		frmContactManagement.getContentPane().setBackground(Color.WHITE);
		frmContactManagement.setBounds(100, 100, 526, 342);
		frmContactManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactManagement.getContentPane().setLayout(null);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 474, 21);
		frmContactManagement.getContentPane().add(menuBar);

		mnFile = new JMenu("File     ");
		mnFile.setFont(new Font("Century", Font.PLAIN, 12));
		menuBar.add(mnFile);

		mntmOpen = new JMenuItem("Open...");
		mntmOpen.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				fileExists = true;
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				int result = fileChooser.showOpenDialog(mnFile);

				// if user clicked Cancel button on dialog, return
				if (result == JFileChooser.CANCEL_OPTION)
					return;

				// return Path representing the selected file
				Path filePath = fileChooser.getSelectedFile().toPath();
				fileName = filePath.toString();

				ArrayList<Contact> contactsBuffer = Contact.deserialize(fileName);
				if (contactsBuffer == null)
				{
					JOptionPane.showMessageDialog(mntmOpen, "Error loading file.", "Invalid File!",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				contacts = contactsBuffer;
				updateList(menu);
				setContactPage(comboBox.getSelectedIndex(), menu);
			}
		});
		mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
		mntmOpen.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmOpen);

		mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				save();
			}
		});
		mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmSave.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmSave);

		mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				saveAs();
			}
		});
		mntmSaveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mntmSaveAs.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmSaveAs);

		separator = new JSeparator();
		mnFile.add(separator);

		mntmExit = new JMenuItem("Exit");
		mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mntmExit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		mntmExit.setIcon(
				new ImageIcon(ContactManager.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmExit.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmExit);

		JMenu mnHelp = new JMenu("Help     ");
		mnHelp.setFont(new Font("Century", Font.PLAIN, 12));
		menuBar.add(mnHelp);

		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				About.main(null);
			}
		});
		mntmAbout.setFont(new Font("Century", Font.PLAIN, 12));
		mnHelp.add(mntmAbout);

		panelFamily = new JPanel();
		panelFamily.setBounds(0, 234, 474, 168);
		frmContactManagement.getContentPane().add(panelFamily);
		panelFamily.setLayout(null);
		panelFamily.setBackground(SystemColor.activeCaption);

		Label lblFamily = new Label("Family");
		lblFamily.setAlignment(Label.CENTER);
		lblFamily.setBounds(0, 0, 474, 26);
		panelFamily.add(lblFamily);

		lblRelationship = new JLabel("Relationship");
		lblRelationship.setFont(new Font("Century", Font.PLAIN, 13));
		lblRelationship.setBounds(188, 25, 126, 14);
		panelFamily.add(lblRelationship);

		comboBoxRelationship = new JComboBox();
		comboBoxRelationship.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (FamilyContact.relationshipValid(comboBoxRelationship.getSelectedItem().toString()))
					textFieldBirthday.grabFocus();
				else
					JOptionPane.showMessageDialog(comboBoxRelationship,
							"\"" + comboBoxRelationship.getSelectedItem().toString()
									+ "\" is not a valid relationship!",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		comboBoxRelationship.setFont(new Font("Century", Font.PLAIN, 13));
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] { "Father", "Mother", "Brother", "Sister",
				"Son", "Daughter", "Uncle", "Aunt", "Nephew", "Niece", "Father-in-Law", "Mother-in-Law",
				"Brother-in-Law", "Sister-in-Law", "Grandfather", "Grandmother" }));
		comboBoxRelationship.setBounds(188, 42, 126, 20);
		panelFamily.add(comboBoxRelationship);

		JLabel lblBirthdaymmddyyyy = new JLabel("Birthday (mm/dd/yyyy)");
		lblBirthdaymmddyyyy.setToolTipText("");
		lblBirthdaymmddyyyy.setFont(new Font("Century", Font.PLAIN, 11));
		lblBirthdaymmddyyyy.setBounds(324, 25, 140, 14);
		panelFamily.add(lblBirthdaymmddyyyy);

		textFieldBirthday = new JTextField();
		textFieldBirthday.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (FamilyContact.birthdayValid(textFieldBirthday.getText()))
					btnAdd.grabFocus();
				else
					JOptionPane.showMessageDialog(textFieldBirthday,
							"\"" + textFieldBirthday.getText() + "\" is not a valid date!", "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textFieldBirthday.setToolTipText("(mm/dd/yyyy)");
		textFieldBirthday.setBackground(Color.LIGHT_GRAY);
		textFieldBirthday.setFont(new Font("Century", Font.PLAIN, 13));
		textFieldBirthday.setBounds(324, 42, 105, 20);
		panelFamily.add(textFieldBirthday);
		textFieldBirthday.setColumns(10);

		lblfamilypic = new JLabel("");
		lblfamilypic.setBounds(-19, 0, 250, 198);
		panelFamily.add(lblfamilypic);
		lblfamilypic.setIcon(new ImageIcon(ContactManager.class.getResource("/Pictures/familySmall.png")));

		panelWelcome = new JPanel();
		panelWelcome.setBackground(SystemColor.activeCaption);
		panelWelcome.setBounds(0, 0, 474, 389);
		frmContactManagement.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);

		JButton btnFriends = new JButton("Friends");
		btnFriends.setBackground(UIManager.getColor("Button.background"));
		btnFriends.setFont(new Font("Century", Font.PLAIN, 13));
		btnFriends.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				frmContactManagement.setLocationRelativeTo(null);

				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFriends.setVisible(true);

				menu = Contact.ContactType.FRIEND;
				updateList(-1, Contact.ContactType.FRIEND);
			}
		});

		lblWelcomeToFfb = new JLabel("Welcome To F.F.B.");
		lblWelcomeToFfb.setToolTipText("Friends Family Business");
		lblWelcomeToFfb.setForeground(Color.BLACK);
		lblWelcomeToFfb.setBackground(Color.LIGHT_GRAY);
		lblWelcomeToFfb.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToFfb.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 26));
		lblWelcomeToFfb.setBounds(90, 23, 302, 55);
		panelWelcome.add(lblWelcomeToFfb);

		lblContactManagement = new JLabel("Contact Management");
		lblContactManagement.setBackground(Color.LIGHT_GRAY);
		lblContactManagement.setHorizontalAlignment(SwingConstants.CENTER);
		lblContactManagement.setFont(new Font("Century", Font.BOLD | Font.ITALIC, 27));
		lblContactManagement.setBounds(100, 78, 302, 33);
		panelWelcome.add(lblContactManagement);
		btnFriends.setBounds(30, 176, 129, 33);
		panelWelcome.add(btnFriends);

		JButton btnFamily = new JButton("Family");
		btnFamily.setFont(new Font("Century", Font.PLAIN, 13));
		btnFamily.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				frmContactManagement.setLocationRelativeTo(null);

				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFamily.setVisible(true);

				menu = Contact.ContactType.FAMILY;
				updateList(-1, Contact.ContactType.FAMILY);
			}
		});
		btnFamily.setBounds(169, 176, 129, 33);
		panelWelcome.add(btnFamily);

		JButton btnBusiness = new JButton("Business");
		btnBusiness.setFont(new Font("Century", Font.PLAIN, 13));
		btnBusiness.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				frmContactManagement.setLocationRelativeTo(null);

				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelBusiness.setVisible(true);

				menu = Contact.ContactType.BUSINESS;
				updateList(-1, Contact.ContactType.BUSINESS);
			}
		});
		btnBusiness.setBounds(308, 176, 129, 33);
		panelWelcome.add(btnBusiness);

		panelTextFields = new JPanel();
		panelTextFields.setBackground(SystemColor.activeCaption);
		panelTextFields.setBounds(0, 20, 474, 222);
		frmContactManagement.getContentPane().add(panelTextFields);
		panelTextFields.setLayout(null);

		textFirstName = new JTextField();
		textFirstName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (Contact.firstNameValid(textFirstName.getText()))
					textLastName.grabFocus();
				else
					JOptionPane.showMessageDialog(textFirstName,
							"\"" + textFirstName.getText()
									+ "\" is not a valid first name! Names must begin with a capital letter.",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textFirstName.setToolTipText("First Name");
		textFirstName.setBackground(Color.LIGHT_GRAY);
		textFirstName.setFont(new Font("Century", Font.PLAIN, 13));
		textFirstName.setBounds(186, 24, 114, 20);
		panelTextFields.add(textFirstName);
		textFirstName.setColumns(10);

		textLastName = new JTextField();
		textLastName.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (Contact.lastNameValid(textLastName.getText()))
					textAddress.grabFocus();
				else
					JOptionPane.showMessageDialog(textLastName,
							"\"" + textLastName.getText()
									+ "\" is not a valid last name! Names must begin with a capital letter.",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textLastName.setToolTipText("Last Name");
		textLastName.setBackground(Color.LIGHT_GRAY);
		textLastName.setFont(new Font("Century", Font.PLAIN, 13));
		textLastName.setBounds(314, 24, 114, 20);
		panelTextFields.add(textLastName);
		textLastName.setColumns(10);

		textAddress = new JTextField();
		textAddress.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Contact.addressValid(textAddress.getText()))
					textCity.grabFocus();
				else
					JOptionPane.showMessageDialog(textAddress,
							"\"" + textAddress.getText() + "\" is not a valid address!", "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textAddress.setToolTipText("Address");
		textAddress.setBackground(Color.LIGHT_GRAY);
		textAddress.setFont(new Font("Century", Font.PLAIN, 13));
		textAddress.setBounds(186, 71, 242, 20);
		panelTextFields.add(textAddress);
		textAddress.setColumns(10);

		textCity = new JTextField();
		textCity.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Contact.cityValid(textCity.getText()))
					textState.grabFocus();
				else
					JOptionPane.showMessageDialog(textCity,
							"\"" + textCity.getText()
									+ "\" is not a valid city name! City names must begin with a capital letter",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textCity.setToolTipText("City");
		textCity.setBackground(Color.LIGHT_GRAY);
		textCity.setFont(new Font("Century", Font.PLAIN, 13));
		textCity.setBounds(186, 119, 114, 20);
		panelTextFields.add(textCity);
		textCity.setColumns(10);

		textState = new JTextField();
		textState.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Contact.stateValid(textState.getText()))
					textZipCode.grabFocus();
				else
					JOptionPane.showMessageDialog(textState,
							"\"" + textState.getText() + "\" is not a valid state! Use the state abbreviation.",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textState.setToolTipText("Two Letters of State");
		textState.setBackground(Color.LIGHT_GRAY);
		textState.setFont(new Font("Century", Font.PLAIN, 13));
		textState.setBounds(314, 119, 46, 20);
		panelTextFields.add(textState);
		textState.setColumns(10);

		textZipCode = new JTextField();
		textZipCode.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Contact.zipValid(textZipCode.getText()))
					textMobileNumber.grabFocus();
				else
					JOptionPane.showMessageDialog(textZipCode,
							"\"" + textZipCode.getText() + "\" is not a valid zip code! Zip codes are 5 digits.",
							"Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textZipCode.setToolTipText("5 Digit Zip");
		textZipCode.setBackground(Color.LIGHT_GRAY);
		textZipCode.setFont(new Font("Century", Font.PLAIN, 13));
		textZipCode.setColumns(10);
		textZipCode.setBounds(370, 119, 58, 20);
		panelTextFields.add(textZipCode);

		textMobileNumber = new JTextField();
		textMobileNumber.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (Contact.phoneValid(textMobileNumber.getText()))
				{
					if (menu == Contact.ContactType.FRIEND)
						textPaneHobbies.grabFocus();
					else if (menu == Contact.ContactType.FAMILY)
						comboBoxRelationship.grabFocus();
					else if (menu == Contact.ContactType.BUSINESS)
						textCompany.grabFocus();
				}
				else
					JOptionPane.showMessageDialog(textMobileNumber,
							"\"" + textMobileNumber.getText() + "\" is not a valid phone number!", "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textMobileNumber.setToolTipText("(000)111-2222");
		textMobileNumber.setBackground(Color.LIGHT_GRAY);
		textMobileNumber.setFont(new Font("Century", Font.PLAIN, 13));
		textMobileNumber.setBounds(186, 167, 242, 20);
		panelTextFields.add(textMobileNumber);
		textMobileNumber.setColumns(10);

		lblFirstName = new JLabel("First Name");
		lblFirstName.setFont(new Font("Century", Font.PLAIN, 13));
		lblFirstName.setBounds(186, 11, 73, 14);
		panelTextFields.add(lblFirstName);

		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Century", Font.PLAIN, 13));
		lblLastName.setBounds(315, 11, 73, 14);
		panelTextFields.add(lblLastName);

		lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Century", Font.PLAIN, 13));
		lblAddress.setBounds(186, 55, 73, 14);
		panelTextFields.add(lblAddress);

		lblCity = new JLabel("City");
		lblCity.setFont(new Font("Century", Font.PLAIN, 13));
		lblCity.setBounds(186, 102, 73, 14);
		panelTextFields.add(lblCity);

		lblState = new JLabel("State");
		lblState.setFont(new Font("Century", Font.PLAIN, 13));
		lblState.setBounds(314, 102, 58, 14);
		panelTextFields.add(lblState);

		lblZipCode = new JLabel("Zip Code");
		lblZipCode.setFont(new Font("Century", Font.PLAIN, 13));
		lblZipCode.setBounds(370, 102, 73, 14);
		panelTextFields.add(lblZipCode);

		lblMobileNumber = new JLabel("Mobile Number");
		lblMobileNumber.setFont(new Font("Century", Font.PLAIN, 13));
		lblMobileNumber.setBounds(186, 150, 114, 14);
		panelTextFields.add(lblMobileNumber);

		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				clear();
			}
		});
		btnClear.setToolTipText("Clear All Fields");
		btnClear.setFont(new Font("Century", Font.PLAIN, 13));
		btnClear.setBounds(10, 102, 89, 23);
		panelTextFields.add(btnClear);

		btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Contact toAdd;
				ArrayList<String> invalidFields = new ArrayList<String>();

				if (menu == Contact.ContactType.FRIEND)
				{
					toAdd = new FriendContact();

					if (!toAdd.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!toAdd.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!toAdd.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!toAdd.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!toAdd.setState(textState.getText()))
						invalidFields.add("state");
					if (!toAdd.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!toAdd.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((FriendContact) toAdd).setHobbies(textPaneHobbies.getText()))
						invalidFields.add("hobbies");
					if (!((FriendContact) toAdd).setInterests(textPaneInterests.getText()))
						invalidFields.add("interests");

					if (invalidFields.size() != 7)
						contacts.add(toAdd);

				}
				else if (menu == Contact.ContactType.FAMILY)
				{
					toAdd = new FamilyContact();

					if (!toAdd.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!toAdd.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!toAdd.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!toAdd.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!toAdd.setState(textState.getText()))
						invalidFields.add("state");
					if (!toAdd.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!toAdd.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((FamilyContact) toAdd).setRelationship(comboBoxRelationship.getSelectedItem().toString()))
						invalidFields.add("relationship");
					if (!((FamilyContact) toAdd).setBirthday(textFieldBirthday.getText()))
						invalidFields.add("birthday");

					if (invalidFields.size() != 8)
						contacts.add(toAdd);
				}
				else if (menu == Contact.ContactType.BUSINESS)
				{
					toAdd = new BusinessContact();

					if (!toAdd.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!toAdd.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!toAdd.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!toAdd.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!toAdd.setState(textState.getText()))
						invalidFields.add("state");
					if (!toAdd.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!toAdd.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((BusinessContact) toAdd).setCompany(textCompany.getText()))
						invalidFields.add("company");
					if (!((BusinessContact) toAdd).setEmail(textEmail.getText()))
						invalidFields.add("email");

					if (invalidFields.size() != 8)
						contacts.add(toAdd);
				}

				//no invalid fields
				if (invalidFields.size() == 0)
					JOptionPane.showMessageDialog(btnAdd, "Successfully added contact.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				//some number of invalid fields
				else
				{
					String buffer = "";
					for (int i = 0; i < invalidFields.size(); i++)
					{
						//add each invalid field to buffer string. if it is not the last field, add a comma (,)
						buffer += invalidFields.get(i) + (i < invalidFields.size() - 1 ? ", " : "");
					}

					JOptionPane.showMessageDialog(btnAdd,
							"Error adding contact! Fields (" + buffer
									+ ") are either invalid or empty. Added all other fields.",
							"Error!", JOptionPane.ERROR_MESSAGE);
				}

				updateList(menu);
			}
		});
		btnAdd.setToolTipText("Add Contact");
		btnAdd.setFont(new Font("Century", Font.PLAIN, 13));
		btnAdd.setBounds(10, 131, 89, 23);
		panelTextFields.add(btnAdd);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				//stop trying if it doesn't exist
				if (selected == null)
					return;

				ArrayList<String> invalidFields = new ArrayList<String>();

				if (menu == Contact.ContactType.FRIEND)
				{
					if (!selected.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!selected.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!selected.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!selected.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!selected.setState(textState.getText()))
						invalidFields.add("state");
					if (!selected.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!selected.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((FriendContact) selected).setHobbies(textPaneHobbies.getText()))
						invalidFields.add("hobbies");
					if (!((FriendContact) selected).setInterests(textPaneInterests.getText()))
						invalidFields.add("interests");

				}
				else if (menu == Contact.ContactType.FAMILY)
				{
					if (!selected.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!selected.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!selected.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!selected.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!selected.setState(textState.getText()))
						invalidFields.add("state");
					if (!selected.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!selected.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((FamilyContact) selected).setRelationship(comboBoxRelationship.getSelectedItem().toString()))
						invalidFields.add("relationship");
					if (!((FamilyContact) selected).setBirthday(textFieldBirthday.getText()))
						invalidFields.add("birthday");
				}
				else if (menu == Contact.ContactType.BUSINESS)
				{
					if (!selected.setFirstName(textFirstName.getText()))
						invalidFields.add("first name");
					if (!selected.setLastName(textLastName.getText()))
						invalidFields.add("last name");
					if (!selected.setAddress(textAddress.getText()))
						invalidFields.add("address");
					if (!selected.setCity(textCity.getText()))
						invalidFields.add("city");
					if (!selected.setState(textState.getText()))
						invalidFields.add("state");
					if (!selected.setZip(textZipCode.getText()))
						invalidFields.add("zip code");
					if (!selected.setPhone(textMobileNumber.getText()))
						invalidFields.add("phone number");

					if (!((BusinessContact) selected).setCompany(textCompany.getText()))
						invalidFields.add("company");
					if (!((BusinessContact) selected).setEmail(textEmail.getText()))
						invalidFields.add("email");
				}

				//no invalid fields
				if (invalidFields.size() == 0)
					JOptionPane.showMessageDialog(btnAdd, "Successfully updated contact.", "Success!",
							JOptionPane.INFORMATION_MESSAGE);
				//some number of invalid fields
				else
				{
					String buffer = "";
					for (int i = 0; i < invalidFields.size(); i++)
					{
						//add each invalid field to buffer string. if it is not the last field, add a comma (,)
						buffer += invalidFields.get(i) + (i < invalidFields.size() - 1 ? ", " : "");
					}

					JOptionPane.showMessageDialog(btnAdd,
							"Error updating contact! Fields (" + buffer
									+ ") are either invalid or empty. Updated all other fields.",
							"Error!", JOptionPane.ERROR_MESSAGE);
				}

				updateList(menu);
			}
		});
		btnUpdate.setToolTipText("Update Contact");
		btnUpdate.setFont(new Font("Century", Font.PLAIN, 13));
		btnUpdate.setBounds(9, 160, 89, 23);
		panelTextFields.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int index = comboBox.getSelectedIndex();
				try
				{
					delete(index, menu);
					JOptionPane.showMessageDialog(btnDelete, "Successfully deleted contact.", "Deleted!",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (InvalidDeletionAttemptException ex)
				{
					clear();
					JOptionPane.showMessageDialog(btnDelete,
							"Deletion failed. Please select a contact before attempting to delete it.",
							"InvalidDeletionAttemptException!",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnDelete.setToolTipText("Delete Contact");
		btnDelete.setFont(new Font("Century", Font.PLAIN, 13));
		btnDelete.setBounds(9, 189, 89, 23);
		panelTextFields.add(btnDelete);

		btnBack = new JButton("Back");
		btnBack.setToolTipText("Return to Main Menu");
		btnBack.setIcon(
				new ImageIcon(ContactManager.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Century", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				startGUI();
				clear();
				selected = null;
			}
		});
		btnBack.setBackground(UIManager.getColor("Button.shadow"));
		btnBack.setBounds(0, 0, 94, 23);
		panelTextFields.add(btnBack);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0)
			{
				if (comboBox.getSelectedIndex() == -1)
					return;

				selected = getContactsOfType(menu).get(comboBox.getSelectedIndex());
				setContactPage(comboBox.getSelectedIndex(), menu);
			}
		});
		comboBox.setBounds(8, 46, 142, 20);
		panelTextFields.add(comboBox);

		lblContact = new JLabel("Contact");
		lblContact.setFont(new Font("Century", Font.PLAIN, 13));
		lblContact.setBounds(10, 28, 142, 16);
		panelTextFields.add(lblContact);

		panelFriends = new JPanel();
		panelFriends.setBackground(SystemColor.activeCaption);
		panelFriends.setBounds(0, 234, 474, 168);
		frmContactManagement.getContentPane().add(panelFriends);
		panelFriends.setLayout(null);

		textPaneHobbies = new JTextPane();
		textPaneHobbies.setFont(new Font("Century", Font.PLAIN, 13));
		textPaneHobbies.setBackground(Color.LIGHT_GRAY);
		textPaneHobbies.setBounds(190, 31, 245, 45);
		panelFriends.add(textPaneHobbies);

		JLabel lblHobbies = new JLabel("Friend's Hobbies");
		lblHobbies.setFont(new Font("Century", Font.PLAIN, 13));
		lblHobbies.setBounds(190, 12, 245, 23);
		panelFriends.add(lblHobbies);

		textPaneInterests = new JTextPane();
		textPaneInterests.setFont(new Font("Century", Font.PLAIN, 13));
		textPaneInterests.setBackground(Color.LIGHT_GRAY);
		textPaneInterests.setBounds(190, 96, 245, 45);
		panelFriends.add(textPaneInterests);

		JLabel lblInterests = new JLabel("Friend's Interests");
		lblInterests.setFont(new Font("Century", Font.PLAIN, 13));
		lblInterests.setBounds(190, 77, 245, 23);
		panelFriends.add(lblInterests);

		lblfriendspic = new JLabel("");
		lblfriendspic.setIcon(new ImageIcon(ContactManager.class.getResource("/Pictures/FriendsPicSmall.png")));
		lblfriendspic.setBounds(0, 0, 145, 157);
		panelFriends.add(lblfriendspic);

		panelBusiness = new JPanel();
		panelBusiness.setLayout(null);
		panelBusiness.setBackground(SystemColor.activeCaption);
		panelBusiness.setBounds(0, 234, 474, 168);
		frmContactManagement.getContentPane().add(panelBusiness);

		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Century", Font.PLAIN, 13));
		lblCompany.setBounds(200, 26, 126, 14);
		panelBusiness.add(lblCompany);

		textCompany = new JTextField();
		textCompany.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (BusinessContact.companyValid(textCompany.getText()))
					textEmail.grabFocus();
				else
					JOptionPane.showMessageDialog(textCompany,
							"\"" + textCompany.getText() + "\" is not a valid company name!", "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textCompany.setToolTipText("Example INC.");
		textCompany.setBackground(Color.LIGHT_GRAY);
		textCompany.setFont(new Font("Century", Font.PLAIN, 13));
		textCompany.setColumns(10);
		textCompany.setBounds(200, 43, 264, 20);
		panelBusiness.add(textCompany);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century", Font.PLAIN, 13));
		lblEmail.setBounds(200, 74, 264, 14);
		panelBusiness.add(lblEmail);

		textEmail = new JTextField();
		textEmail.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if (BusinessContact.emailValid(textEmail.getText()))
					btnAdd.grabFocus();
				else
					JOptionPane.showMessageDialog(textEmail,
							"\"" + textEmail.getText() + "\" is not a valid email address!", "Invalid Input!",
							JOptionPane.ERROR_MESSAGE);
			}
		});
		textEmail.setToolTipText("example@company.com");
		textEmail.setBackground(Color.LIGHT_GRAY);
		textEmail.setFont(new Font("Century", Font.PLAIN, 13));
		textEmail.setColumns(10);
		textEmail.setBounds(200, 91, 264, 20);
		panelBusiness.add(textEmail);

		lblBusinessPic = new JLabel("");
		lblBusinessPic.setIcon(new ImageIcon(ContactManager.class.getResource("/Pictures/BusinessSmall.png")));
		lblBusinessPic.setBounds(0, 0, 190, 145);
		panelBusiness.add(lblBusinessPic);

		startGUI();
	}

	public void startGUI()
	{
		panelFriends.setVisible(false);
		panelTextFields.setVisible(false);
		panelFamily.setVisible(false);
		panelBusiness.setVisible(false);
		panelWelcome.setVisible(true);

		frmContactManagement.setBounds(100, 100, 490, 273);
		frmContactManagement.setLocationRelativeTo(null);
	}

	//update the combo box's list of names
	//index is because setting the model resets the selection to 0
	private void updateList(int index, Contact.ContactType type)
	{
		if (contacts.size() == 0)
		{
			comboBox.setModel(new DefaultComboBoxModel());
			comboBox.setSelectedIndex(-1);
		}

		else
		{
			comboBox.setModel(new DefaultComboBoxModel(getNames(type).toArray()));
			comboBox.setSelectedIndex(index);
		}
	}

	//^
	private void updateList(Contact.ContactType type)
	{
		int index = comboBox.getSelectedIndex();
		updateList(index, type);
	}

	private ArrayList<Contact> getContactsOfType(Contact.ContactType type)
	{
		ArrayList<Contact> contactsOfType = new ArrayList<Contact>();

		for (Contact c : contacts)
		{
			if (c.getType() == type)
				contactsOfType.add(c);
		}

		return contactsOfType;
	}

	//set values. should only be changed upon change in comboBox selection or loading, so no need to update the comboBox.
	private void setContactPage(int index, Contact.ContactType type)
	{
		//stop trying if empty
		if (getContactsOfType(type).size() == 0)
			return;
		//if you are not selecting something, select it
		if (index >= getContactsOfType(type).size())
		{
			index = 0;
		}
		if (index == -1)
			return;

		Contact contact = getContactsOfType(type).get(index);

		comboBox.setSelectedIndex(index);

		textFirstName.setText(contact.getFirstName());
		textLastName.setText(contact.getLastName());
		textAddress.setText(contact.getAddress());
		textCity.setText(contact.getCity());
		textState.setText(contact.getState());
		textZipCode.setText(contact.getZip());
		textMobileNumber.setText(contact.getPhone());

		if (type == Contact.ContactType.FRIEND)
		{
			textPaneHobbies.setText(((FriendContact) contact).getHobbies());
			textPaneInterests.setText(((FriendContact) contact).getInterests());
		}
		else if (type == Contact.ContactType.FAMILY)
		{
			comboBoxRelationship.setSelectedItem(((FamilyContact) contact).getRelationship());
			textFieldBirthday.setText(((FamilyContact) contact).getBirthday());
		}
		else if (type == Contact.ContactType.BUSINESS)
		{
			textEmail.setText(((BusinessContact) contact).getEmail());
			textCompany.setText(((BusinessContact) contact).getCompany());
		}
	}

	//if given a contact, get its index and run it through the other.
	private void setContactPage(Contact contact, Contact.ContactType type)
	{
		int index = contacts.indexOf(contact);
		setContactPage(index, type);
	}

	//returns an array of the names of all contacts.
	private ArrayList<String> getNames(Contact.ContactType type)
	{
		ArrayList<String> names = new ArrayList<String>();

		for (Contact contact : contacts)
		{
			if (contact.getType() == type)
			{
				String first = contact.getFirstName();
				String last = contact.getLastName();

				if (first == null)
					first = "";
				if (last == null)
					last = "";

				names.add(first + " " + last);
			}
		}

		return names;
	}

	private void clear()
	{
		//general
		textFirstName.setText("");
		textLastName.setText("");
		textAddress.setText("");
		textCity.setText("");
		textState.setText("");
		textZipCode.setText("");
		textMobileNumber.setText("");

		//friend
		textPaneHobbies.setText("");
		textPaneInterests.setText("");

		//fam
		comboBoxRelationship.setSelectedItem(0);
		textFieldBirthday.setText("");

		//business
		textCompany.setText("");
		textEmail.setText("");
	}

	//save contacts to fileName
	private void save()
	{
		//if the file already exists, save over it
		if (fileExists)
			Contact.serialize(contacts, fileName);
		//if not saveAs
		else
			saveAs();
	}

	//save contacts to new file
	private void saveAs()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int result = fileChooser.showSaveDialog(mnFile);

		// if user clicked Cancel button on dialog, return
		if (result == JFileChooser.CANCEL_OPTION)
			return;

		// return Path representing the selected file
		Path filePath = fileChooser.getSelectedFile().toPath();
		fileName = filePath.toString();
		Contact.serialize(contacts, fileName);
		fileExists = true;
	}

	private void delete(int index, Contact.ContactType type) throws InvalidDeletionAttemptException
	{
		try
		{
			//if no contact exist, just clear
			if (getContactsOfType(type).size() == 0)
			{
				throw new InvalidDeletionAttemptException();
			}
			else
			{
				contacts.remove(getContactsOfType(type).get(index));
			}

			//now that it's removed, if it was the only one
			if (getContactsOfType(type).size() == 0)
			{
				updateList(-1, menu);
			}
			else
			{
				//if multiple contacts and not first selection, go down by one index
				if (index != 0)
					updateList(index - 1, menu);
				//if multiple contacts and first selection, re select the first.
				else
					updateList(0, menu);
			}
			updateList(comboBox.getSelectedIndex(), menu);
		} catch (Exception ex)
		{
			throw new InvalidDeletionAttemptException();
		}
	}
}