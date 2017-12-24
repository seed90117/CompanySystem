package UserInterface;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import SQL.Contact;
import UserInterface.MainView;

public class CreateNewCustomer extends JFrame
{	
	//*****宣告界面*****//
	Container cp = this.getContentPane();
		
	//*****宣告按鈕物件*****//
	JButton apply = new JButton("Apply");
	JButton discard = new JButton("Discard");
	
	//*****宣告標籤物件*****//
	JLabel id = new JLabel("Id:");
	JLabel firstname = new JLabel("First Name:");
	JLabel lastname = new JLabel("Last Name:");
	JLabel kana = new JLabel("Kana:");
	JLabel phone = new JLabel("Phone:");
	JLabel address = new JLabel("Address:");
	JLabel job = new JLabel("Job:");
	JLabel contractdate = new JLabel("Contract Date:");
	JLabel contractenddate = new JLabel("Contract End Date:");
	JLabel paydate = new JLabel("Pay Date:");
	JLabel extra = new JLabel("Extra:");
	
	//*****宣告輸入物件*****//
	JTextField id_in = new JTextField("null");
	JTextField firstname_in = new JTextField("null");
	JTextField lastname_in = new JTextField("null");
	JTextField kana_in = new JTextField("null");
	JTextField phone_in = new JTextField("null");
	JTextField address_in = new JTextField("null");
	JTextField job_in = new JTextField("null");
	JTextField contractdate_in = new JTextField("null");
	JTextField contractenddate_in = new JTextField("null");
	JTextField paydate_in = new JTextField("null");
	JTextField extra_in = new JTextField("null");
	
	//*****宣告面板物件*****//
	JPanel backgrund = new JPanel();
	
	//*****宣告圖片物件*****//
	ImageIcon Image_Icon = new ImageIcon("src/Image/bg.jpg");
	
	CreateNewCustomer()
	{
		//*****設定表單*****//
		this.setSize(340, 560);
		this.setLayout(null);
		this.setTitle("Create New Customer");
		
		//*****設定表單屬性*****//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//*****設定物件位置*****//
		backgrund.setBounds(10, 10, 300, 500);
		id.setBounds(20, 20, 150, 30);
		id_in.setBounds(140, 20, 150, 30);
		firstname.setBounds(20, 60, 150, 30);
		firstname_in.setBounds(140, 60, 150, 30);
		lastname.setBounds(20, 100, 150, 30);
		lastname_in.setBounds(140, 100, 150, 30);
		kana.setBounds(20, 140, 150, 30);
		kana_in.setBounds(140, 140, 150, 30);
		phone.setBounds(20, 180, 150, 30);
		phone_in.setBounds(140, 180, 150, 30);
		address.setBounds(20, 220, 150, 30);
		address_in.setBounds(140, 220, 150, 30);
		job.setBounds(20, 260, 150, 30);
		job_in.setBounds(140, 260, 150, 30);
		contractdate.setBounds(20, 300, 150, 30);
		contractdate_in.setBounds(140, 300, 150, 30);
		contractenddate.setBounds(20, 340, 150, 30);
		contractenddate_in.setBounds(140, 340, 150, 30);
		paydate.setBounds(20, 380, 150, 30);
		paydate_in.setBounds(140, 380, 150, 30);
		extra.setBounds(20, 420, 150, 30);
		extra_in.setBounds(140, 420, 150, 30);
		apply.setBounds(20, 460, 100, 30);
		discard.setBounds(160, 460, 100, 30);
		
		//*****設定Panel*****//
		backgrund.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
		backgrund.setLayout(null);
		backgrund.add(new JLabel(Image_Icon));
		
		//*****將物件加入面板*****//
		backgrund.add(id);
		backgrund.add(firstname);
		backgrund.add(lastname);
		backgrund.add(kana);
		backgrund.add(phone);
		backgrund.add(address);
		backgrund.add(job);
		backgrund.add(contractdate);
		backgrund.add(contractenddate);
		backgrund.add(paydate);
		backgrund.add(extra);
		backgrund.add(id_in);
		backgrund.add(firstname_in);
		backgrund.add(lastname_in);
		backgrund.add(kana_in);
		backgrund.add(phone_in);
		backgrund.add(address_in);
		backgrund.add(job_in);
		backgrund.add(contractdate_in);
		backgrund.add(contractenddate_in);
		backgrund.add(paydate_in);
		backgrund.add(extra_in);
		backgrund.add(apply);
		backgrund.add(discard);
		
		//*****將面板加入介面*****//
		cp.add(backgrund);
		
		//*****按鈕執行設定*****//
		apply.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Contact.InsertCustomer(id_in.getText(), firstname_in.getText(), lastname_in.getText(), kana_in.getText(), phone_in.getText(), address_in.getText(), job_in.getText(), contractdate_in.getText(), contractenddate_in.getText(), paydate_in.getText());
				MainView.CustomerEnd(0);
			}
		});
		
		discard.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				MainView.CustomerEnd(0);
			}
		});
	}
}
