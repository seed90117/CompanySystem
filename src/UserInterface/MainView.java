package UserInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.Contact;

public class MainView extends JFrame
{
	//***********主容器**************//
		Container myWindows = this.getContentPane();

	//***********文字字型**************//
		Font myFont = new Font(Font.DIALOG, Font.BOLD, 20);
	
	//***********面板物件**************//
		public JPanel Panel_Title = new JPanel();
		public static JPanel[] Panel_ID = new JPanel[2];
		public static JPanel[] Panel_FirstName = new JPanel[2];
		public static JPanel[] Panel_LastName = new JPanel[2];
		public static JPanel[] Panel_Kana = new JPanel[2];
		public static JPanel[] Panel_Phone = new JPanel[2];
		public static JPanel[] Panel_Address = new JPanel[2];
		public static JPanel[] Panel_Email = new JPanel[2];
		public static JPanel[] Panel_Job = new JPanel[2];
		public static JPanel[] Panel_BankNumber = new JPanel[2];
		public static JPanel[] Panel_Datestart = new JPanel[2];
		public static JPanel[] Panel_Dateend = new JPanel[2];
		public static JPanel[] Panel_Paydate = new JPanel[2];		
		
	//***********標籤物件**************//
		public static JLabel Label_NowLocation = new JLabel("顧客List");
		public JLabel Label_Title = new JLabel("Search all fields：");
		public JLabel Label_ID = new JLabel("ID");
		public JLabel Label_FirstName = new JLabel("First Name");
		public JLabel Label_LastName = new JLabel("Last Name");
		public JLabel Label_Kana = new JLabel("Kana");
		public JLabel Label_Phone = new JLabel("Phone");
		public JLabel Label_Address = new JLabel("Address");
		public JLabel Label_Email = new JLabel("E-mail");
		public JLabel Label_Job = new JLabel("Job");
		public JLabel Label_BankNumber = new JLabel("BankNumber");
		public JLabel Label_Datestart = new JLabel("契約日期");
		public JLabel Label_Dateend = new JLabel("契約結束日期");
		public JLabel Label_Paydate = new JLabel("付款日期");
		
	//***********輸入物件**************//
		public static JTextField Text_Title = new JTextField();
		public static JTextField Text_ID = new JTextField();
		public static JTextField Text_FirstName = new JTextField();
		public static JTextField Text_LastName = new JTextField();
		public static JTextField Text_Kana = new JTextField();
		public static JTextField Text_Phone = new JTextField();
		public static JTextField Text_Address = new JTextField();
		public static JTextField Text_Email = new JTextField();
		public static JTextField Text_Job = new JTextField();
		public static JTextField Text_BankNumber = new JTextField();
		public static JTextField Text_Datestart = new JTextField();
		public static JTextField Text_Dateend = new JTextField();
		public static JTextField Text_Paydate = new JTextField();
		
	//***********輸出物件**************//
		public static String[] IDData;
		
		public static List<JList<String>> listbox = new ArrayList<JList<String>>();
		
	//***********按鈕物件**************//
		public static JButton Button_Customer = new JButton("顧客List");
		public static JButton Button_Contract = new JButton("契約List");
		public static JButton Button_Payment = new JButton("付款List");
		public static JButton Button_AddCustomer = new JButton("追加新顧客");
		public static JButton Button_Switch = new JButton("Yes/No");
	
	//***********背景物件**************//
		ImageIcon Image_Icon = new ImageIcon("src/Image/bg.jpg");
		List<JLabel> myIcon = new ArrayList<JLabel>();
		
		ImageIcon Image_Icon_Big = new ImageIcon("src/Image/bg_Big.jpg");
		
	//***********其他面板**************//	
		public static CreateNewCustomer NewCustomer;
		public static CustomerList CustomerData;
		
		static boolean yesno;
	//***********物件設定**************//
		public MainView()
		{
			//***********面板物件**************//
				Panel_ID[0] = new JPanel();
				Panel_ID[0].setBounds(0, 0, 150, 70);
				Panel_ID[0].setLayout(null);
				Panel_ID[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_FirstName[0] = new JPanel();
				Panel_FirstName[0].setBounds(0, 0, 150, 70);
				Panel_FirstName[0].setLayout(null);
				Panel_FirstName[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_LastName[0] = new JPanel();
				Panel_LastName[0].setBounds(0, 0, 150, 70);
				Panel_LastName[0].setLayout(null);
				Panel_LastName[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Kana[0] = new JPanel();
				Panel_Kana[0].setBounds(0, 0, 150, 70);
				Panel_Kana[0].setLayout(null);
				Panel_Kana[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Phone[0] = new JPanel();
				Panel_Phone[0].setBounds(0, 0, 150, 70);
				Panel_Phone[0].setLayout(null);
				Panel_Phone[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Address[0] = new JPanel();
				Panel_Address[0].setBounds(0, 0, 150, 70);
				Panel_Address[0].setLayout(null);
				Panel_Address[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Email[0] = new JPanel();
				Panel_Email[0].setBounds(0, 0, 150, 70);
				Panel_Email[0].setLayout(null);
				Panel_Email[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Job[0] = new JPanel();
				Panel_Job[0].setBounds(0, 0, 150, 70);
				Panel_Job[0].setLayout(null);
				Panel_Job[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_BankNumber[0] = new JPanel();
				Panel_BankNumber[0].setBounds(0, 0, 150, 70);
				Panel_BankNumber[0].setLayout(null);
				Panel_BankNumber[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Datestart[0] = new JPanel();
				Panel_Datestart[0].setBounds(0, 0, 150, 70);
				Panel_Datestart[0].setLayout(null);
				Panel_Datestart[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Dateend[0] = new JPanel();
				Panel_Dateend[0].setBounds(0, 0, 150, 70);
				Panel_Dateend[0].setLayout(null);
				Panel_Dateend[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				
				Panel_Paydate[0] = new JPanel();
				Panel_Paydate[0].setBounds(0, 0, 150, 70);
				Panel_Paydate[0].setLayout(null);
				Panel_Paydate[0].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			
			//***********標籤物件設定**************//
				Label_NowLocation.setBounds(845, 75, 300, 30);
				Label_NowLocation.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
				myWindows.add(Label_NowLocation);
				
				Label_Title.setBounds(1500, 7, 171, 20);
				Label_Title.setFont(myFont);
				Panel_Title.add(Label_Title);
				
				Label_ID.setBounds(65, 10, 19, 20);
				Label_ID.setFont(myFont);
				Panel_ID[0].add(Label_ID);

				Label_FirstName.setBounds(24, 10, 102, 20);
				Label_FirstName.setFont(myFont);
				Panel_FirstName[0].add(Label_FirstName);
				
				Label_LastName.setBounds(25, 10, 100, 20);
				Label_LastName.setFont(myFont);
				Panel_LastName[0].add(Label_LastName);
				
				Label_Kana.setBounds(51, 10, 48, 20);
				Label_Kana.setFont(myFont);
				Panel_Kana[0].add(Label_Kana);
				
				Label_Phone.setBounds(45, 10, 60, 20);
				Label_Phone.setFont(myFont);
				Panel_Phone[0].add(Label_Phone);
				
				Label_Address.setBounds(36, 10, 78, 20);
				Label_Address.setFont(myFont);
				Panel_Address[0].add(Label_Address);
				
				Label_Email.setBounds(46, 10, 58, 20);
				Label_Email.setFont(myFont);
				Panel_Email[0].add(Label_Email);
				
				Label_Job.setBounds(57, 10, 35, 20);
				Label_Job.setFont(myFont);
				Panel_Job[0].add(Label_Job);
				
				Label_BankNumber.setBounds(14, 10, 122, 20);
				Label_BankNumber.setFont(myFont);
				Panel_BankNumber[0].add(Label_BankNumber);
				
				Label_Datestart.setBounds(33, 10, 84, 20);
				Label_Datestart.setFont(myFont);
				Panel_Datestart[0].add(Label_Datestart);
				
				Label_Dateend.setBounds(12, 10, 126, 20);
				Label_Dateend.setFont(myFont);
				Panel_Dateend[0].add(Label_Dateend);
				
				Label_Paydate.setBounds(33, 10, 84, 20);
				Label_Paydate.setFont(myFont);
				Panel_Paydate[0].add(Label_Paydate);
			
			//***********輸入物件設定**************//
				Text_Title.setBounds(1671, 3, 125, 24);
				Text_Title.setFont(myFont);
				Text_Title.setHorizontalAlignment(JTextField.RIGHT);
				Text_Title.addKeyListener(Keylistener);
				Text_Title.setName("Title");
				Panel_Title.add(Text_Title);
				
				Text_ID.setBounds(10, 35, 130, 24);
				Text_ID.setFont(myFont);
				Text_ID.setHorizontalAlignment(JTextField.RIGHT);
				Text_ID.addKeyListener(Keylistener);
				Text_ID.setName("ID");
				Panel_ID[0].add(Text_ID);
				
				Text_FirstName.setBounds(10, 35, 130, 24);
				Text_FirstName.setFont(myFont);
				Text_FirstName.setHorizontalAlignment(JTextField.RIGHT);
				Text_FirstName.addKeyListener(Keylistener);
				Text_FirstName.setName("FirstName");
				Panel_FirstName[0].add(Text_FirstName);
				
				Text_LastName.setBounds(10, 35, 130, 24);
				Text_LastName.setFont(myFont);
				Text_LastName.setHorizontalAlignment(JTextField.RIGHT);
				Text_LastName.addKeyListener(Keylistener);
				Text_LastName.setName("LastName");
				Panel_LastName[0].add(Text_LastName);
				
				Text_Kana.setBounds(10, 35, 130, 24);
				Text_Kana.setFont(myFont);
				Text_Kana.setHorizontalAlignment(JTextField.RIGHT);
				Text_Kana.addKeyListener(Keylistener);
				Text_Kana.setName("Kana");
				Panel_Kana[0].add(Text_Kana);
				
				Text_Phone.setBounds(10, 35, 130, 24);
				Text_Phone.setFont(myFont);
				Text_Phone.setHorizontalAlignment(JTextField.RIGHT);
				Text_Phone.addKeyListener(Keylistener);
				Text_Phone.setName("Phone");
				Panel_Phone[0].add(Text_Phone);
				
				Text_Address.setBounds(10, 35, 130, 24);
				Text_Address.setFont(myFont);
				Text_Address.setHorizontalAlignment(JTextField.RIGHT);
				Text_Address.addKeyListener(Keylistener);
				Text_Address.setName("Address");
				Panel_Address[0].add(Text_Address);
				
				Text_Email.setBounds(10, 35, 130, 24);
				Text_Email.setFont(myFont);
				Text_Email.setHorizontalAlignment(JTextField.RIGHT);
				Text_Email.addKeyListener(Keylistener);
				Text_Email.setName("Email");
				Panel_Email[0].add(Text_Email);
				
				Text_Job.setBounds(10, 35, 130, 24);
				Text_Job.setFont(myFont);
				Text_Job.setHorizontalAlignment(JTextField.RIGHT);
				Text_Job.addKeyListener(Keylistener);
				Text_Job.setName("Job");
				Panel_Job[0].add(Text_Job);
				
				Text_BankNumber.setBounds(10, 35, 130, 24);
				Text_BankNumber.setFont(myFont);
				Text_BankNumber.setHorizontalAlignment(JTextField.RIGHT);
				Text_BankNumber.addKeyListener(Keylistener);
				Text_BankNumber.setName("BankNumber");
				Panel_BankNumber[0].add(Text_BankNumber);
				
				Text_Datestart.setBounds(10, 35, 130, 24);
				Text_Datestart.setFont(myFont);
				Text_Datestart.setHorizontalAlignment(JTextField.RIGHT);
				Text_Datestart.addKeyListener(Keylistener);
				Text_Datestart.setName("DateStart");
				Panel_Datestart[0].add(Text_Datestart);
				
				Text_Dateend.setBounds(10, 35, 130, 24);
				Text_Dateend.setFont(myFont);
				Text_Dateend.setHorizontalAlignment(JTextField.RIGHT);
				Text_Dateend.addKeyListener(Keylistener);
				Text_Dateend.setName("DateEnd");
				Panel_Dateend[0].add(Text_Dateend);
				
				Text_Paydate.setBounds(10, 35, 130, 24);
				Text_Paydate.setFont(myFont);
				Text_Paydate.setHorizontalAlignment(JTextField.RIGHT);
				Text_Paydate.addKeyListener(Keylistener);
				Text_Paydate.setName("PayDate");
				Panel_Paydate[0].add(Text_Paydate);
				
			//***********輸出物件設定**************//
				Panel_Title.setBounds(5, 120, 1800, 30);
				Panel_Title.setLayout(null);
				Panel_Title.setBackground(new java.awt.Color(255, 255, 255));
				Panel_Title.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				myWindows.add(Panel_Title);
				
				Panel_ID[1] = new JPanel();
				Panel_ID[1].setBounds(5, 150, 150, 250);
				Panel_ID[1].setLayout(null);
				Panel_ID[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_ID[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_ID[1].add(Panel_ID[0]);
				Panel_ID[1].add(listbox.get(0));
				myWindows.add(Panel_ID[1]);
				
				Panel_FirstName[1] = new JPanel();
				Panel_FirstName[1].setBounds(155, 150, 150, 250);
				Panel_FirstName[1].setLayout(null);
				Panel_FirstName[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_FirstName[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_FirstName[1].add(Panel_FirstName[0]);
				Panel_FirstName[1].add(listbox.get(1));
				myWindows.add(Panel_FirstName[1]);
				
				Panel_LastName[1] = new JPanel();
				Panel_LastName[1].setBounds(305, 150, 150, 250);
				Panel_LastName[1].setLayout(null);
				Panel_LastName[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_LastName[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_LastName[1].add(Panel_LastName[0]);
				Panel_LastName[1].add(listbox.get(2));
				myWindows.add(Panel_LastName[1]);
				
				Panel_Kana[1] = new JPanel();
				Panel_Kana[1].setBounds(455, 150, 150, 250);
				Panel_Kana[1].setLayout(null);
				Panel_Kana[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Kana[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Kana[1].add(Panel_Kana[0]);
				Panel_Kana[1].add(listbox.get(3));
				myWindows.add(Panel_Kana[1]);
				
				Panel_Phone[1] = new JPanel();
				Panel_Phone[1].setBounds(605, 150, 150, 250);
				Panel_Phone[1].setLayout(null);
				Panel_Phone[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Phone[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Phone[1].add(Panel_Phone[0]);
				Panel_Phone[1].add(listbox.get(4));
				myWindows.add(Panel_Phone[1]);
				
				Panel_Address[1] = new JPanel();
				Panel_Address[1].setBounds(755, 150, 150, 250);
				Panel_Address[1].setLayout(null);
				Panel_Address[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Address[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Address[1].add(Panel_Address[0]);
				Panel_Address[1].add(listbox.get(5));
				myWindows.add(Panel_Address[1]);
				
				Panel_Email[1] = new JPanel();
				Panel_Email[1].setBounds(905, 150, 150, 250);
				Panel_Email[1].setLayout(null);
				Panel_Email[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Email[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Email[1].add(Panel_Email[0]);
				Panel_Email[1].add(listbox.get(6));
				myWindows.add(Panel_Email[1]);
				
				Panel_Job[1] = new JPanel();
				Panel_Job[1].setBounds(1055, 150, 150, 250);
				Panel_Job[1].setLayout(null);
				Panel_Job[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Job[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Job[1].add(Panel_Job[0]);
				Panel_Job[1].add(listbox.get(7));
				myWindows.add(Panel_Job[1]);
				
				Panel_BankNumber[1] = new JPanel();
				Panel_BankNumber[1].setBounds(1205, 150, 150, 250);
				Panel_BankNumber[1].setLayout(null);
				Panel_BankNumber[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_BankNumber[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_BankNumber[1].add(Panel_BankNumber[0]);
				Panel_BankNumber[1].add(listbox.get(8));
				myWindows.add(Panel_BankNumber[1]);
				
				Panel_Datestart[1] = new JPanel();
				Panel_Datestart[1].setBounds(1355, 150, 150, 250);
				Panel_Datestart[1].setLayout(null);
				Panel_Datestart[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Datestart[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Datestart[1].add(Panel_Datestart[0]);
				Panel_Datestart[1].add(listbox.get(9));
				myWindows.add(Panel_Datestart[1]);
				
				Panel_Dateend[1] = new JPanel();
				Panel_Dateend[1].setBounds(1505, 150, 150, 250);
				Panel_Dateend[1].setLayout(null);
				Panel_Dateend[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Dateend[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Dateend[1].add(Panel_Dateend[0]);
				Panel_Dateend[1].add(listbox.get(10));
				myWindows.add(Panel_Dateend[1]);
				
				Panel_Paydate[1] = new JPanel();
				Panel_Paydate[1].setBounds(1655, 150, 150, 250);
				Panel_Paydate[1].setLayout(null);
				Panel_Paydate[1].setBackground(new java.awt.Color(255, 255, 255));
				Panel_Paydate[1].setBorder(BorderFactory.createLineBorder(Color.gray, 1));
				Panel_Paydate[1].add(Panel_Paydate[0]);
				Panel_Paydate[1].add(listbox.get(11));
				myWindows.add(Panel_Paydate[1]);
				
			//***********按鈕物件設定**************//
				Button_Customer.setBounds(0, 0, 0, 0);
				Button_Customer.setFont(myFont);
				Button_Customer.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Label_NowLocation.setText("顧客List");
						Button_Customer.setBounds(0, 0, 0, 0);
						Button_Contract.setBounds(10, 20, 150, 30);
						Button_Payment.setBounds(170, 20, 150, 30);
						Button_AddCustomer.setBounds(10, 60, 150, 30);
						Button_Switch.setBounds(0, 0, 0, 0);
						changelist("Customer", "Title", "");//變更List
					}
				});
				myWindows.add(Button_Customer);
				
				Button_Contract.setBounds(10, 20, 150, 30);
				Button_Contract.setFont(myFont);
				Button_Contract.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Label_NowLocation.setText("契約List(要契約)");
						Button_Customer.setBounds(10, 20, 150, 30);
						Button_Contract.setBounds(0, 0, 0, 0);
						Button_Payment.setBounds(170, 20, 150, 30);
						Button_AddCustomer.setBounds(0, 0, 0, 0);
						Button_Switch.setBounds(10, 60, 150, 30);
						yesno = true;
					}
				});
				myWindows.add(Button_Contract);
				
				Button_Payment.setBounds(170, 20, 150, 30);
				Button_Payment.setFont(myFont);
				Button_Payment.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						Label_NowLocation.setText("付款List(有付款)");
						Button_Customer.setBounds(10, 20, 150, 30);
						Button_Contract.setBounds(170, 20, 150, 30);
						Button_Payment.setBounds(0, 0, 0, 0);
						Button_AddCustomer.setBounds(0, 0, 0, 0);
						Button_Switch.setBounds(10, 60, 150, 30);
						changelist("RecordedCustomer", "Title", "");//變更List
						yesno = true;
					}
				});
				myWindows.add(Button_Payment);
				
				Button_AddCustomer.setBounds(10, 60, 150, 30);
				Button_AddCustomer.setFont(myFont);
				Button_AddCustomer.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						NewCustomer = new CreateNewCustomer();
					}
				});
				myWindows.add(Button_AddCustomer);
				
				Button_Switch.setBounds(10, 60, 150, 30);
				Button_Switch.setFont(myFont);
				
				//*****Yes/No按鈕事件*****//
				Button_Switch.addActionListener(new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						if(Label_NowLocation.getText().equals("付款List(有付款)") || Label_NowLocation.getText().equals("付款List(沒付款)"))
						{
							if(yesno)//true = 已付款
							{
								yesno = false;
								changelist("UnRecordedCustomer", "Title", "");
								Label_NowLocation.setText("付款List(沒付款)");
							}
							else//false = 未付款
							{
								yesno = true;
								changelist("RecordedCustomer", "Title", "");
								Label_NowLocation.setText("付款List(有付款)");
							}
						}
						if(Label_NowLocation.getText().equals("契約List(要契約)") || Label_NowLocation.getText().equals("契約List(不要契約)"))
						{
							if(yesno)//true = 已付款
							{
								yesno = false;
								Label_NowLocation.setText("契約List(不要契約)");
							}
							else//false = 未付款
							{
								yesno = true;
								Label_NowLocation.setText("契約List(要契約)");
							}
						}
					}
				});
				myWindows.add(Button_Switch);
				
			//***********Lgog物件設定**************//
				for(int i = 0; i < 13; i++)
				{
					if(i < 12)
					{
						myIcon.add(new JLabel(Image_Icon));
						myIcon.get(i).setBounds(1, 1, 148, 68);
					}
					else
					{
						myIcon.add(new JLabel(Image_Icon_Big));
						myIcon.get(i).setBounds(1, 1, 1798, 28);
					}
				}
				
				Panel_ID[0].add(myIcon.get(0));
				Panel_FirstName[0].add(myIcon.get(1));
				Panel_LastName[0].add(myIcon.get(2));
				Panel_Kana[0].add(myIcon.get(3));
				Panel_Phone[0].add(myIcon.get(4));
				Panel_Address[0].add(myIcon.get(5));
				Panel_Email[0].add(myIcon.get(6));
				Panel_Job[0].add(myIcon.get(7));
				Panel_BankNumber[0].add(myIcon.get(8));
				Panel_Datestart[0].add(myIcon.get(9));
				Panel_Dateend[0].add(myIcon.get(10));
				Panel_Paydate[0].add(myIcon.get(11));	
				Panel_Title.add(myIcon.get(12));
				
			//***********環境設定**************//
				this.setSize(1825, 800);
				this.setLayout(null);
				this.setTitle("Company System");
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.setVisible(true);
		}
		
		public static void CustomerEnd(int Switch)
		{
			switch(Switch)
			{
				case 0:
					NewCustomer.dispose();
					break;
				case 1:
					CustomerData.dispose();
					break;
			}
		}
		
		//*****List事件*****//
		public static MouseListener listener = new MouseListener()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{}

			@Override
			public void mousePressed(MouseEvent e)
			{}

			@Override
			public void mouseReleased(MouseEvent e)
			{
				JList<?> object = (JList<?>)e.getSource();
				
				if(Label_NowLocation.getText().equals("顧客List"))
				{
					String[][] str = Contact.Select("Customer", "ID", IDData[object.getSelectedIndex()]);
					CustomerData = new CustomerList(str[0][0], str[1][0] +" "+ str[2][0], str[3][0], str[4][0], str[5][0], str[6][0]);
				}
			}

			@Override
			public void mouseEntered(MouseEvent e)
			{}

			@Override
			public void mouseExited(MouseEvent e)
			{}
		};
		
		public static KeyListener Keylistener = new KeyListener()
		{
			@Override
			public void keyTyped(KeyEvent e)
			{}

			@Override
			public void keyPressed(KeyEvent e)
			{}

			@Override
			public void keyReleased(KeyEvent e)
			{
				JTextField object = (JTextField)e.getSource();
				//String[][] str = null;
				//IDData = null;
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					switch(Label_NowLocation.getText())
					{
						case "顧客List":
							changelist("Customer", object.getName(), object.getText());
							break;
						case "契約List":
							break;
						case "付款List":
							changelist("RecordedCustomer", object.getName(), object.getText());
							break;
					}
				}
			}
		};

	//***********主程式**************//
		public static void main(String[] args)
		{
			String[][] str = Contact.Select("Customer", "Title", "");
			for(int i = 0; i < 12; i++)
			{
				listbox.add(new JList<String>(str[i]));
				listbox.get(i).setBounds(1, 70, 148, 178);
				listbox.get(i).addMouseListener(listener);
				
				if(i == 0)
				{
					IDData = str[i];
				}
			}
			
			new MainView();
			
		}
		
		
		public static void changelist(String Table,String Field,String Value)
		{
			String [][] str = Contact.Select(Table, Field, Value);
			IDData = null;
			for(int i = 0; i < 12; i++)
			{
				listbox.get(i).setListData(str[i]);
				if(i == 0)
				{
					IDData = str[i];
				}
			}
		}
}
