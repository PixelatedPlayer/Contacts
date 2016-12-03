package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JEditorPane;
import java.awt.TextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactManager {

	private JFrame frmContactManagement;
	private JPanel panelTextFields;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZipCode;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZipCode;
	private JLabel lblPhoneNumber;
	private JLabel label;
	private JPanel panelWelcome;
	private JPanel panelFriends;
	private JPanel panelFamily;
	private JLabel lblRelationship;
	private JTextField textField;
	private JTextField textCompany;
	private JTextField textWorkPhone;
	private JTextField textEmail;
	private JMenu mnFile;
	private JMenuItem mntmSave;
	private JMenuItem mntmSaveAs;
	private JMenuItem mntmExit;
	private JButton btnBack;
	private JPanel panelBusiness;
	private JLabel lblWelcomeToFfb;
	private JLabel lblContactManagement;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactManager window = new ContactManager();
					window.frmContactManagement.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ContactManager() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmContactManagement = new JFrame();
		frmContactManagement.setIconImage(Toolkit.getDefaultToolkit().getImage(ContactManager.class.getResource("/javax/swing/plaf/metal/icons/ocean/hardDrive.gif")));
		frmContactManagement.setTitle("Contact Management");
		frmContactManagement.getContentPane().setBackground(Color.WHITE);
		frmContactManagement.setBounds(100, 100, 490, 273);
		frmContactManagement.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmContactManagement.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 474, 21);
		frmContactManagement.getContentPane().add(menuBar);
		
		mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		mntmSave = new JMenuItem("Save");
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save as...");
		mnFile.add(mntmSaveAs);
		
		mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		panelWelcome = new JPanel();
		panelWelcome.setBackground(Color.WHITE);
		panelWelcome.setBounds(0, 0, 474, 389);
		frmContactManagement.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFriends.setVisible(true);
			}
		});
		btnFriends.setBounds(30, 176, 129, 33);
		panelWelcome.add(btnFriends);
		
		JButton btnFamily = new JButton("Family");
		btnFamily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFamily.setVisible(true);
			}
		});
		btnFamily.setBounds(169, 176, 129, 33);
		panelWelcome.add(btnFamily);
		
		JButton btnBusiness = new JButton("Business");
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactManagement.setBounds(100, 100, 490, 430);	
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelBusiness.setVisible(true);
			}
		});
		btnBusiness.setBounds(308, 176, 129, 33);
		panelWelcome.add(btnBusiness);
		
		lblWelcomeToFfb = new JLabel("Welcome To FFB");
		lblWelcomeToFfb.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 26));
		lblWelcomeToFfb.setBounds(131, 59, 206, 57);
		panelWelcome.add(lblWelcomeToFfb);
		
		lblContactManagement = new JLabel(" Contact Management");
		lblContactManagement.setFont(new Font("Consolas", Font.BOLD | Font.ITALIC, 27));
		lblContactManagement.setBounds(90, 105, 302, 33);
		panelWelcome.add(lblContactManagement);
		
		panelTextFields = new JPanel();
		panelTextFields.setBackground(Color.WHITE);
		panelTextFields.setBounds(0, 20, 474, 222);
		frmContactManagement.getContentPane().add(panelTextFields);
		panelTextFields.setLayout(null);
		
		textFirstName = new JTextField();
		textFirstName.setBounds(186, 24, 114, 20);
		panelTextFields.add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBounds(314, 24, 114, 20);
		panelTextFields.add(textLastName);
		textLastName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBounds(186, 71, 242, 20);
		panelTextFields.add(textAddress);
		textAddress.setColumns(10);
		
		textCity = new JTextField();
		textCity.setBounds(186, 119, 114, 20);
		panelTextFields.add(textCity);
		textCity.setColumns(10);
		
		textState = new JTextField();
		textState.setBounds(314, 119, 46, 20);
		panelTextFields.add(textState);
		textState.setColumns(10);
		
		textZipCode = new JTextField();
		textZipCode.setColumns(10);
		textZipCode.setBounds(370, 119, 58, 20);
		panelTextFields.add(textZipCode);
		
		textField_3 = new JTextField();
		textField_3.setBounds(186, 167, 114, 20);
		panelTextFields.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(314, 167, 114, 20);
		panelTextFields.add(textField_4);
		
		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(186, 11, 73, 14);
		panelTextFields.add(lblFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(315, 11, 73, 14);
		panelTextFields.add(lblLastName);
		
		lblAddress = new JLabel("Address");
		lblAddress.setBounds(186, 55, 73, 14);
		panelTextFields.add(lblAddress);
		
		lblCity = new JLabel("City");
		lblCity.setBounds(186, 102, 73, 14);
		panelTextFields.add(lblCity);
		
		lblState = new JLabel("State");
		lblState.setBounds(314, 102, 58, 14);
		panelTextFields.add(lblState);
		
		lblZipCode = new JLabel("Zip Code");
		lblZipCode.setBounds(370, 102, 73, 14);
		panelTextFields.add(lblZipCode);
		
		lblPhoneNumber = new JLabel("Phone Number");
		lblPhoneNumber.setBounds(186, 150, 89, 14);
		panelTextFields.add(lblPhoneNumber);
		
		label = new JLabel("City");
		label.setBounds(315, 150, 73, 14);
		panelTextFields.add(label);
		
		JButton btnNew = new JButton("New");
		btnNew.setBounds(46, 39, 89, 23);
		panelTextFields.add(btnNew);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(46, 73, 89, 23);
		panelTextFields.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(46, 107, 89, 23);
		panelTextFields.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(46, 141, 89, 23);
		panelTextFields.add(btnDelete);
		
		btnBack = new JButton("<- Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				startGUI();
			}
		});
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(0, 0, 78, 23);
		panelTextFields.add(btnBack);
		
		panelFriends = new JPanel();
		panelFriends.setBackground(Color.WHITE);
		panelFriends.setBounds(0, 244, 474, 145);
		frmContactManagement.getContentPane().add(panelFriends);
		panelFriends.setLayout(null);
		
		JTextPane textPaneHobbies = new JTextPane();
		textPaneHobbies.setBackground(Color.LIGHT_GRAY);
		textPaneHobbies.setBounds(193, 28, 237, 85);
		panelFriends.add(textPaneHobbies);
		
		JLabel lblHobbiesInterests = new JLabel("Hobbies & Interests");
		lblHobbiesInterests.setBounds(195, 11, 95, 14);
		panelFriends.add(lblHobbiesInterests);
		
		panelFamily = new JPanel();
		panelFamily.setBounds(0, 244, 474, 145);
		frmContactManagement.getContentPane().add(panelFamily);
		panelFamily.setLayout(null);
		panelFamily.setBackground(Color.WHITE);
		
		lblRelationship = new JLabel("Relationship");
		lblRelationship.setBounds(219, 25, 65, 14);
		panelFamily.add(lblRelationship);
		
		JComboBox comboBoxRelationship = new JComboBox();
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] {"Father", "Mother", "Brother", "Sister", "Son", "Daughter", "Uncle", "Aunt", "Nephew", "Niece", "Father-in-Law", "Mother-in-Law", "Brother-in-Law", "Sister-in-Law", "Grandfather", "Grandmother"}));
		comboBoxRelationship.setBounds(219, 42, 96, 20);
		panelFamily.add(comboBoxRelationship);
		
		JLabel lblBirthdaymmddyyyy = new JLabel("Birthday (mm/dd/yyyy)");
		lblBirthdaymmddyyyy.setBounds(338, 25, 126, 14);
		panelFamily.add(lblBirthdaymmddyyyy);
		
		textField = new JTextField();
		textField.setBounds(338, 42, 126, 20);
		panelFamily.add(textField);
		textField.setColumns(10);
		
		panelBusiness = new JPanel();
		panelBusiness.setLayout(null);
		panelBusiness.setBackground(Color.WHITE);
		panelBusiness.setBounds(0, 244, 474, 145);
		frmContactManagement.getContentPane().add(panelBusiness);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setBounds(200, 26, 126, 14);
		panelBusiness.add(lblCompany);
		
		textCompany = new JTextField();
		textCompany.setColumns(10);
		textCompany.setBounds(200, 43, 126, 20);
		panelBusiness.add(textCompany);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setBounds(338, 26, 126, 14);
		panelBusiness.add(lblWorkPhone);
		
		textWorkPhone = new JTextField();
		textWorkPhone.setColumns(10);
		textWorkPhone.setBounds(338, 43, 126, 20);
		panelBusiness.add(textWorkPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(200, 74, 264, 14);
		panelBusiness.add(lblEmail);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(200, 91, 264, 20);
		panelBusiness.add(textEmail);
		
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
	}
}
