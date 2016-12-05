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
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JSeparator;
import java.awt.Label;

public class ContactManager {

	private JFrame frmContactManagement;
	private JPanel panelTextFields;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textAddress;
	private JTextField textCity;
	private JTextField textState;
	private JTextField textZipCode;
	private JTextField textMobileNumber;
	private JTextField textHomeNumber;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblState;
	private JLabel lblZipCode;
	private JLabel lblMobileNumber;
	private JLabel lblHomeNumber;
	private JPanel panelWelcome;
	private JPanel panelFriends;
	private JPanel panelFamily;
	private JLabel lblRelationship;
	private JTextField textField;
	private JTextField textCompany;
	private JTextField textWorkPhone;
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
	private JMenuItem mntmJavadoc;
	private JComboBox comboBox;
	private JLabel lblContact;
	private JMenuItem mntmOpen;

	
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
		mntmOpen.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmOpen);
		
		mntmSave = new JMenuItem("Save");
		mntmSave.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmSave);
		
		mntmSaveAs = new JMenuItem("Save as...");
		mntmSaveAs.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmSaveAs);
		
		separator = new JSeparator();
		mnFile.add(separator);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmExit.setIcon(new ImageIcon(ContactManager.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		mntmExit.setFont(new Font("Century", Font.PLAIN, 12));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help     ");
		mnHelp.setFont(new Font("Century", Font.PLAIN, 12));
		menuBar.add(mnHelp);
		
		mntmJavadoc = new JMenuItem("JavaDoc");
		mntmJavadoc.setFont(new Font("Century", Font.PLAIN, 12));
		mnHelp.add(mntmJavadoc);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				About.main(null);
			}
		});
		mntmAbout.setFont(new Font("Century", Font.PLAIN, 12));
		mnHelp.add(mntmAbout);
		
		panelWelcome = new JPanel();
		panelWelcome.setBackground(SystemColor.activeCaption);
		panelWelcome.setBounds(0, 0, 474, 389);
		frmContactManagement.getContentPane().add(panelWelcome);
		panelWelcome.setLayout(null);
		
		JButton btnFriends = new JButton("Friends");
		btnFriends.setBackground(UIManager.getColor("Button.background"));
		btnFriends.setFont(new Font("Century", Font.PLAIN, 13));
		btnFriends.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				frmContactManagement.setLocationRelativeTo(null);
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFriends.setVisible(true);
			}
		});
		
		lblWelcomeToFfb = new JLabel("Welcome To F.F.B.");
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
		btnFamily.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				frmContactManagement.setBounds(100, 100, 490, 430);
				frmContactManagement.setLocationRelativeTo(null);
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelFamily.setVisible(true);
			}
		});
		btnFamily.setBounds(169, 176, 129, 33);
		panelWelcome.add(btnFamily);
		
		JButton btnBusiness = new JButton("Business");
		btnBusiness.setFont(new Font("Century", Font.PLAIN, 13));
		btnBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				frmContactManagement.setBounds(100, 100, 490, 430);	
				frmContactManagement.setLocationRelativeTo(null);
				
				panelWelcome.setVisible(false);
				panelTextFields.setVisible(true);
				panelBusiness.setVisible(true);
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
		textFirstName.setBackground(Color.LIGHT_GRAY);
		textFirstName.setFont(new Font("Century", Font.PLAIN, 13));
		textFirstName.setBounds(186, 24, 114, 20);
		panelTextFields.add(textFirstName);
		textFirstName.setColumns(10);
		
		textLastName = new JTextField();
		textLastName.setBackground(Color.LIGHT_GRAY);
		textLastName.setFont(new Font("Century", Font.PLAIN, 13));
		textLastName.setBounds(314, 24, 114, 20);
		panelTextFields.add(textLastName);
		textLastName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setBackground(Color.LIGHT_GRAY);
		textAddress.setFont(new Font("Century", Font.PLAIN, 13));
		textAddress.setBounds(186, 71, 242, 20);
		panelTextFields.add(textAddress);
		textAddress.setColumns(10);
		
		textCity = new JTextField();
		textCity.setBackground(Color.LIGHT_GRAY);
		textCity.setFont(new Font("Century", Font.PLAIN, 13));
		textCity.setBounds(186, 119, 114, 20);
		panelTextFields.add(textCity);
		textCity.setColumns(10);
		
		textState = new JTextField();
		textState.setBackground(Color.LIGHT_GRAY);
		textState.setFont(new Font("Century", Font.PLAIN, 13));
		textState.setBounds(314, 119, 46, 20);
		panelTextFields.add(textState);
		textState.setColumns(10);
		
		textZipCode = new JTextField();
		textZipCode.setBackground(Color.LIGHT_GRAY);
		textZipCode.setFont(new Font("Century", Font.PLAIN, 13));
		textZipCode.setColumns(10);
		textZipCode.setBounds(370, 119, 58, 20);
		panelTextFields.add(textZipCode);
		
		textMobileNumber = new JTextField();
		textMobileNumber.setBackground(Color.LIGHT_GRAY);
		textMobileNumber.setFont(new Font("Century", Font.PLAIN, 13));
		textMobileNumber.setBounds(186, 167, 114, 20);
		panelTextFields.add(textMobileNumber);
		textMobileNumber.setColumns(10);
		
		textHomeNumber = new JTextField();
		textHomeNumber.setBackground(Color.LIGHT_GRAY);
		textHomeNumber.setFont(new Font("Century", Font.PLAIN, 13));
		textHomeNumber.setColumns(10);
		textHomeNumber.setBounds(314, 167, 114, 20);
		panelTextFields.add(textHomeNumber);
		
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
		
		lblHomeNumber = new JLabel("Home Number");
		lblHomeNumber.setFont(new Font("Century", Font.PLAIN, 13));
		lblHomeNumber.setBounds(315, 150, 113, 14);
		panelTextFields.add(lblHomeNumber);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Century", Font.PLAIN, 13));
		btnClear.setBounds(10, 102, 89, 23);
		panelTextFields.add(btnClear);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Century", Font.PLAIN, 13));
		btnAdd.setBounds(10, 131, 89, 23);
		panelTextFields.add(btnAdd);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Century", Font.PLAIN, 13));
		btnUpdate.setBounds(9, 160, 89, 23);
		panelTextFields.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Century", Font.PLAIN, 13));
		btnDelete.setBounds(9, 189, 89, 23);
		panelTextFields.add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(ContactManager.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		btnBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnBack.setFont(new Font("Century", Font.PLAIN, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				startGUI();
			}
		});
		btnBack.setBackground(UIManager.getColor("Button.shadow"));
		btnBack.setBounds(0, 0, 94, 23);
		panelTextFields.add(btnBack);
		
		comboBox = new JComboBox();
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
		
		JTextPane textPaneHobbies = new JTextPane();
		textPaneHobbies.setFont(new Font("Century", Font.PLAIN, 13));
		textPaneHobbies.setBackground(Color.LIGHT_GRAY);
		textPaneHobbies.setBounds(190, 41, 245, 104);
		panelFriends.add(textPaneHobbies);
		
		JLabel lblHobbiesInterests = new JLabel("Friend's Hobbies & Interests");
		lblHobbiesInterests.setFont(new Font("Century", Font.PLAIN, 13));
		lblHobbiesInterests.setBounds(190, 22, 245, 23);
		panelFriends.add(lblHobbiesInterests);
		
		lblfriendspic = new JLabel("");
		lblfriendspic.setIcon(new ImageIcon(ContactManager.class.getResource("/Pictures/FriendsPicSmall.png")));
		lblfriendspic.setBounds(0, 0, 145, 157);
		panelFriends.add(lblfriendspic);
		
		panelFamily = new JPanel();
		panelFamily.setBounds(0, 234, 474, 155);
		frmContactManagement.getContentPane().add(panelFamily);
		panelFamily.setLayout(null);
		panelFamily.setBackground(SystemColor.activeCaption);
		
		Label lblFamily = new Label("Family");
		lblFamily.setAlignment(Label.CENTER);
		lblFamily.setBounds(0, 0, 474, 26);
		panelFamily.add(lblFamily);
		
		lblRelationship = new JLabel("Relationship");
		lblRelationship.setFont(new Font("Century", Font.PLAIN, 13));
		lblRelationship.setBounds(219, 25, 109, 14);
		panelFamily.add(lblRelationship);
		
		JComboBox comboBoxRelationship = new JComboBox();
		comboBoxRelationship.setFont(new Font("Century", Font.PLAIN, 13));
		comboBoxRelationship.setModel(new DefaultComboBoxModel(new String[] {"Father", "Mother", "Brother", "Sister", "Son", "Daughter", "Uncle", "Aunt", "Nephew", "Niece", "Father-in-Law", "Mother-in-Law", "Brother-in-Law", "Sister-in-Law", "Grandfather", "Grandmother"}));
		comboBoxRelationship.setBounds(219, 42, 109, 20);
		panelFamily.add(comboBoxRelationship);
		
		JLabel lblBirthdaymmddyyyy = new JLabel("Birthday (mm/dd/yyyy)");
		lblBirthdaymmddyyyy.setFont(new Font("Century", Font.PLAIN, 11));
		lblBirthdaymmddyyyy.setBounds(338, 25, 126, 14);
		panelFamily.add(lblBirthdaymmddyyyy);
		
		textField = new JTextField();
		textField.setBackground(Color.LIGHT_GRAY);
		textField.setFont(new Font("Century", Font.PLAIN, 13));
		textField.setBounds(338, 42, 126, 20);
		panelFamily.add(textField);
		textField.setColumns(10);
		
		lblfamilypic = new JLabel("");
		lblfamilypic.setBounds(-19, 0, 250, 198);
		panelFamily.add(lblfamilypic);
		lblfamilypic.setIcon(new ImageIcon(ContactManager.class.getResource("/Pictures/familySmall.png")));
		
		panelBusiness = new JPanel();
		panelBusiness.setLayout(null);
		panelBusiness.setBackground(SystemColor.activeCaption);
		panelBusiness.setBounds(0, 234, 474, 155);
		frmContactManagement.getContentPane().add(panelBusiness);
		
		JLabel lblCompany = new JLabel("Company");
		lblCompany.setFont(new Font("Century", Font.PLAIN, 13));
		lblCompany.setBounds(200, 26, 126, 14);
		panelBusiness.add(lblCompany);
		
		textCompany = new JTextField();
		textCompany.setBackground(Color.LIGHT_GRAY);
		textCompany.setFont(new Font("Century", Font.PLAIN, 13));
		textCompany.setColumns(10);
		textCompany.setBounds(200, 43, 126, 20);
		panelBusiness.add(textCompany);
		
		JLabel lblWorkPhone = new JLabel("Work Phone");
		lblWorkPhone.setFont(new Font("Century", Font.PLAIN, 13));
		lblWorkPhone.setBounds(338, 26, 126, 14);
		panelBusiness.add(lblWorkPhone);
		
		textWorkPhone = new JTextField();
		textWorkPhone.setBackground(Color.LIGHT_GRAY);
		textWorkPhone.setFont(new Font("Century", Font.PLAIN, 13));
		textWorkPhone.setColumns(10);
		textWorkPhone.setBounds(338, 43, 126, 20);
		panelBusiness.add(textWorkPhone);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Century", Font.PLAIN, 13));
		lblEmail.setBounds(200, 74, 264, 14);
		panelBusiness.add(lblEmail);
		
		textEmail = new JTextField();
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
}
