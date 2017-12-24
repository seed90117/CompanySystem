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

	//*****�ŧi�ɭ�*****//
	Container cp = this.getContentPane();
	
	//*****�ŧi���s����*****//
	JButton edit = new JButton("Edit");
	JButton reset = new JButton("Reset");
	JButton delete = new JButton("Delete");
	JButton cancle = new JButton("Cancle");
	
	//*****�ŧi���Ҫ���*****//
	JLabel id = new JLabel("Id:");
	JLabel name = new JLabel("Name:");
	JLabel name2 = new JLabel("Name(2):");
	JLabel phone = new JLabel("Phone Number:");
	JLabel address = new JLabel("Address:");
	JLabel email = new JLabel("Email:");
	
	//*****�ŧi��J����*****//
	JTextField id_in = new JTextField();
	JTextField name_in = new JTextField();
	JTextField name2_in = new JTextField();
	JTextField phone_in = new JTextField();
	JTextField address_in = new JTextField();
	JTextField email_in = new JTextField();
	
	//*****�ŧi���O����*****//
	JPanel backgrund = new JPanel();
	
	//*****�ŧi�Ϥ�����*****//
	ImageIcon Image_Icon = new ImageIcon("src/Image/bg.jpg");
	
	String old_id,old_name,old_kana,old_phone,old_address,old_email;
	
	CustomerList(String ID, String Name, String Kana, String Phone, String Address, String Email)
	{
		//*****�]�w���*****//
		this.setSize(340, 410);//340, 360
		this.setLayout(null);
		this.setTitle("Create New Customer");
		
		//*****�]�w����ݩ�*****//
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		//*****�]�w�����m*****//
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
		
		//*****�]�wPanel*****//
			backgrund.setBorder(BorderFactory.createLineBorder(Color.gray, 1));
			backgrund.setLayout(null);
			backgrund.add(new JLabel(Image_Icon));
		
		//*****�N����[�J���O*****//
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
		
		//*****�N���O�[�J����*****//
		cp.add(backgrund);
		
		//*****���s����]�w*****//
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
