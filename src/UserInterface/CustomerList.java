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

public class CustomerList extends JFrame {

	//*****宣告界面*****//
	Container cp = this.getContentPane();
	
	//*****宣告按鈕物件*****//
	JButton edit = new JButton("Edit");
	JButton reset = new JButton("Reset");
	JButton delete = new JButton("Delete");
	JButton cancle = new JButton("Cancle");
	
	//*****宣告標籤物件*****//
	JLabel id = new JLabel("Id:");
	JLabel name = new JLabel("Name:");
	JLabel name2 = new JLabel("Name(2):");
	JLabel phone = new JLabel("Phone Number:");
	JLabel address = new JLabel("Address:");
	JLabel email = new JLabel("Email:");
	
	//*****宣告輸入物件*****//
	JTextField id_in = new JTextField();
	JTextField name_in = new JTextField();
	JTextField name2_in = new JTextField();
	JTextField phone_in = new JTextField();
	JTextField address_in = new JTextField();
	JTextField email_in = new JTextField();
	
	//*****宣告面板物件*****//
	JPanel backgrund = new JPanel();
	
	//*****宣告圖片物件*****//
	ImageIcon Image_Icon = new ImageIcon("src/Image/bg.jpg");
	
	String old_id,old_name,old_kana,old_phone,old_address,old_email;
	
	CustomerList(String ID, String Name, String Kana, String Phone, String Address, String Email)
	{
		//*****設定表單*****//
		this.setSize(340, 410);//340, 360
		this.setLayout(null);
		this.setTitle("Create New Customer");
		
		//*****設定表單屬性*****//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//*****設定物件位置*****//
			backgrund.setBounds(10, 10, 300, 350);//10, 10, 300, 300
			id.setBounds(20, 20, 150, 30);
			id_in.setBounds(140, 20, 150, 30);
			id_in.setText(ID);
			old_id = ID;
			name.setBounds(20, 60, 150, 30);
			name_in.setBounds(140, 60, 150, 30);
			name_in.setText(Name);
			old_name = Name;
			name2.setBounds(20, 100, 150, 30);
			name2_in.setBounds(140, 100, 150, 30);
			name2_in.setText(Kana);
			old_kana = Kana;
			phone.setBounds(20, 140, 150, 30);
			phone_in.setBounds(140, 140, 150, 30);
			phone_in.setText(Phone);
			old_phone = Phone;
			address.setBounds(20, 180, 150, 30);
			address_in.setBounds(140, 180, 150, 30);
			address_in.setText(Address);
			old_address = Address;
			email.setBounds(20, 220, 150, 30);
			email_in.setBounds(140, 220, 150, 30);
			email_in.setText(Email);
			old_email = Email;
			edit.setBounds(20, 260, 70, 30);
			reset.setBounds(120, 260, 70, 30);
			delete.setBounds(220, 260, 70, 30);
			cancle.setBounds(20, 300, 270, 30);
		
		//*****設定Panel*****//
			backgrund.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			backgrund.setLayout(null);
			backgrund.add(new JLabel(Image_Icon));
		
		//*****將物件加入面板*****//
			backgrund.add(id);
			backgrund.add(name);
			backgrund.add(name2);
			backgrund.add(phone);
			backgrund.add(address);
			backgrund.add(email);
			backgrund.add(id_in);
			backgrund.add(name_in);
			backgrund.add(name2_in);
			backgrund.add(phone_in);
			backgrund.add(address_in);
			backgrund.add(email_in);
			backgrund.add(edit);
			backgrund.add(reset);
			backgrund.add(delete);
			backgrund.add(cancle);
		
		//*****將面板加入介面*****//
		cp.add(backgrund);
		
		//*****按鈕執行設定*****//
		edit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent arg0)
			{
				String[] str = name_in.getText().toString().split(" ");
				Contact.UpdateCustomer(id_in.getText().toString(), str[0], str[1], name2_in.getText().toString(), phone_in.getText().toString(), address_in.getText().toString(), email_in.getText().toString());
			}
		});
		
		reset.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				id_in.setText(old_id);
				name_in.setText(old_name);
				name2_in.setText(old_kana);
				phone_in.setText(old_phone);
				address_in.setText(old_address);
				email_in.setText(old_email);
				//MainView.CustomerEnd(1);
			}
		});
		
		delete.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Contact.DeleteCustomer(ID);
			}
		});
		
		cancle.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				MainView.CustomerEnd(1);
			}});
	}
}
