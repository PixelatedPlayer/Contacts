package GUI;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.SystemColor;

public class About extends JDialog
{

	private final JPanel contentPanel = new JPanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
	{
		try
		{
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public About()
	{
		setTitle("About");
		setBounds(100, 100, 490, 269);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(SystemColor.activeCaption);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblContactManagementSystem = new JLabel("Contact Management System");
			lblContactManagementSystem.setFont(new Font("Century", Font.PLAIN, 13));
			lblContactManagementSystem.setHorizontalAlignment(SwingConstants.CENTER);
			lblContactManagementSystem.setBounds(10, 130, 454, 14);
			contentPanel.add(lblContactManagementSystem);
		}
		{
			JLabel lblCsisObject = new JLabel("CSIS 1410 Object Oriented Programming");
			lblCsisObject.setFont(new Font("Century", Font.PLAIN, 13));
			lblCsisObject.setHorizontalAlignment(SwingConstants.CENTER);
			lblCsisObject.setBounds(10, 155, 454, 14);
			contentPanel.add(lblCsisObject);
		}
		{
			JLabel lblCreditKevinNguyen = new JLabel("Credit: Kevin Nguyen, Daniel Dekaye");
			lblCreditKevinNguyen.setFont(new Font("Century", Font.PLAIN, 13));
			lblCreditKevinNguyen.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreditKevinNguyen.setBounds(10, 180, 454, 21);
			contentPanel.add(lblCreditKevinNguyen);
		}
		{
			JLabel lblAboutPic = new JLabel("");
			lblAboutPic.setHorizontalAlignment(SwingConstants.CENTER);
			lblAboutPic.setIcon(new ImageIcon(About.class.getResource("/Pictures/SLCClogo.jpg")));
			lblAboutPic.setBounds(10, 11, 454, 108);
			contentPanel.add(lblAboutPic);
		}
		{
			JLabel lblAlfredoRodriguez = new JLabel("Alfredo Rodriguez, Christopher Schlenker");
			lblAlfredoRodriguez.setFont(new Font("Century", Font.PLAIN, 13));
			lblAlfredoRodriguez.setHorizontalAlignment(SwingConstants.CENTER);
			lblAlfredoRodriguez.setBounds(10, 205, 454, 14);
			contentPanel.add(lblAlfredoRodriguez);
		}
	}

}
