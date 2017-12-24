package SQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Contact
{
	public static String conurl = "jdbc:sqlserver://140.127.22.4;database=pet";
	public static String userid = "b10056";
	public static String userpwd = "b10056";
	
	public static String[][] Select(String Table, String Field, String value)
	{
		String[][] str1 = null;
		
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			
			try
			{
				String sql;
				
				if(Field.equals("Title"))
				{
					if(value.equals(""))
						sql = "select * from " + Table;
					else
						sql = "select * from " + Table + " where ( ID = '" + value + "') OR ( FirstName = '" + value + "') OR ( LastName = '" + value + "') OR ( Kana = '" + value + "') OR ( Phone = '" + value + "') OR ( Address = '" + value + "') OR ( Email = '" + value + "') OR ( Job = '" + value + "') OR ( BankNumber = '" + value + "') OR ( Datestart = '" + value + "') OR ( Dateend = '" + value + "') OR ( Paydate = '" + value + "')";
				}
				else
				{
					if(value.equals(""))
						sql = "select * from " + Table;
					else
						sql = "select * from " + Table + " where " + Field + " = '" + value + "'";
				}
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				
				int i = 0;
				
				String str = "";
				
				while(rs.next())
				{
					str = str + rs.getString("ID") + "," + rs.getString("FirstName") + "," + rs.getString("LastName")
					 			 + "," + rs.getString("Kana") + "," + rs.getString("Phone") + "," + rs.getString("Address")
					 			 + "," + rs.getString("Email") + "," + rs.getString("Job") + "," + rs.getString("BankNumber")
					 			 + "," + rs.getString("DateStart") + "," + rs.getString("DateEnd") + "," + rs.getString("PayDate") + "_";
					i++;
				}
				
				str1 = new String[12][i];
				
				for(int j = 0; j < i; j++)
				{
					String[] strarray = str.split("_");
					String[] strattay2 = strarray[j].split(",");
					for(int k = 0; k < 12; k++)
					{
						str1[k][j] = strattay2[k];
					}
				}
				
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return str1;
	}
	
	//*****�s�W�U��*****//
	public static boolean InsertCustomer(String ID,String FirstName,String LastName,String Kana,String Phone,String Address,String Job,String DateStart,String DateEnd,String PayDate)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "insert into Customer(ID,FirstName,LastName,Kana,Phone,Address,Job,DateStart,DateEnd,PayDate) values('"+ID+"','"+FirstName+"','"+LastName+"','"+Kana+"','"+Phone+"','"+Address+"','"+Job+"','"+DateStart+"','"+DateEnd+"','"+PayDate+"')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				re = true;//�ק令�\�^��true
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	
	
	//*****�ק��U�ȸ�T*****//
	public static boolean UpdateCustomer(String ID,String FirstName,String LastName,String Kana,String Phone,String Address,String Email)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "update Customer set ID='"+ID+"',FirstName='"+FirstName+"',LastName='"+LastName+"',Kana='"+Kana+"',Phone='"+Phone+"',Address='"+Address+"',Email='"+Email+"' where ID='"+ID+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				re = true;//���\�^��true
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�R���U�ȸ�T*****//
	public static boolean DeleteCustomer(String ID)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "delete from Customer where ID='"+ID+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				re = true;//���\�^��true
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�P�_�O�_�J�b�æ۰ʱN����k��*****//
	public static boolean IsRecorded(String Field,String Value)//���(Field) ��(Value)
	{
		boolean re = false;
		boolean check = false;
		String tmp = "";
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "select * from Recorded where '"+Field+"'='"+Value+"'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					//*****�Y�j�M�J�b��Ʈw�L�ӵ����*****//
					if(rs.wasNull())
					{
						re = true;
						tmp = SearchRecordedCustomer(Field,Value);//�j�M�w�J�b�U�ȸ�Ʈw
						if(!tmp.equals(""))//�j�M���ƶi�J�P�_��
						{
							String[] tmparray = tmp.split(";");
							if(DeleteRecordedCustomer(tmparray[0]))//�R���w�J�b�U�ȸ�Ʈw
							{
								tmp = SearchUnRecordedCustomer(Field,Value);//�j�M���J�b�U�ȸ�Ʈw
								if(tmp.equals(""))//�Y���J�b�U�ȸ�Ʈw�L�o����ƫh�s�W
								{
									if(InsertUnRecordedCustomer(tmparray[0],tmparray[1],tmparray[2],tmparray[3],tmparray[4],tmparray[5],tmparray[6],tmparray[7],tmparray[8],tmparray[9],tmparray[10],tmparray[11]))
									{
										check = true;
									}
								}
							}
						}
					}
					//*****�Y�j�M�J�b��Ʈw���ӵ����*****//
					else
					{
						tmp = SearchUnRecordedCustomer(Field,Value);//�j�M���J�b�U�ȸ�Ʈw
						if(!tmp.equals(""))//�j�M���ƶi�J�P�_��
						{
							String[] tmparray = tmp.split(";");
							if(DeleteUnRecordedCustomer(tmparray[0]))//�R�����J�b�U�ȸ�Ʈw
							{
								tmp = SearchRecordedCustomer(Field,Value);//�j�M�w�J�b�U�ȸ�Ʈw
								if(tmp.equals(""))//�Y�w�J�b�U�ȸ�Ʈw�L�o����ƫh�s�W
								{
									if(InsertRecordedCustomer(tmparray[0],tmparray[1],tmparray[2],tmparray[3],tmparray[4],tmparray[5],tmparray[6],tmparray[7],tmparray[8],tmparray[9],tmparray[10],tmparray[11]))
									{
										check = true;
									}
								}
							}
						}
					}
				}
				
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�j�M�J�b���*****//
	public static String SearchRecordedCustomer(String Field,String Value)//���(Field) ��(Value)
	{
		String re = "";
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "select * from RecordedCustomer where '"+Field+"'='"+Value+"'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					re = rs.getString("ID")+";"+rs.getString("FirstName")+";"+rs.getString("LastName")+";"+rs.getString("Kana")+";"+rs.getString("Phone")+";"+rs.getString("Address")+";"+rs.getString("Email")+";"+rs.getString("Job")+";"+rs.getString("BankNumber")+";"+rs.getString("DateStart")+";"+rs.getString("DateEnd")+";"+rs.getString("PayDate");
				}
				
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�j�M���J�b���*****//
	public static String SearchUnRecordedCustomer(String Field,String Value)//���(Field) ��(Value)
	{
		String re = "";
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "select * from RecordedCustomer where '"+Field+"'='"+Value+"'";
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next())
				{
					re = rs.getString("ID")+";"+rs.getString("FirstName")+";"+rs.getString("LastName")+";"+rs.getString("Kana")+";"+rs.getString("Phone")+";"+rs.getString("Address")+";"+rs.getString("Email")+";"+rs.getString("Job")+";"+rs.getString("BankNumber")+";"+rs.getString("DateStart")+";"+rs.getString("DateEnd")+";"+rs.getString("PayDate");
				}
				
				stmt.close();
				conn.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�s�W�J�b���*****//
	public static boolean InsertRecordedCustomer(String ID,String FirstName,String LastName,String Kana,String Phone,String Address,String Email,String Job,String BankNumber,String DateStart,String DateEnd,String PayDate)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "insert into RecordedCustomer(ID,FirstName,LastName,Kana,Phone,Address,Email,Job,BankNumber,DateStart,DateEnd,PayDate) values('"+ID+"','"+FirstName+"','"+LastName+"','"+Kana+"','"+Phone+"','"+Address+"','"+Email+"','"+Job+"','"+BankNumber+"','"+DateStart+"','"+DateEnd+"','"+PayDate+"')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				re = true;//���\�^��true
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�s�W���J�b���*****//
	public static boolean InsertUnRecordedCustomer(String ID,String FirstName,String LastName,String Kana,String Phone,String Address,String Email,String Job,String BankNumber,String DateStart,String DateEnd,String PayDate)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "insert into UnRecordedCustomer(ID,FirstName,LastName,Kana,Phone,Address,Email,Job,BankNumber,DateStart,DateEnd,PayDate) values('"+ID+"','"+FirstName+"','"+LastName+"','"+Kana+"','"+Phone+"','"+Address+"','"+Email+"','"+Job+"','"+BankNumber+"','"+DateStart+"','"+DateEnd+"','"+PayDate+"')";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				re = true;//���\�^��true
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�R���J�b��T*****//
	public static boolean DeleteRecordedCustomer(String ID)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "delete from RecordedCustomer where ID='"+ID+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				re = true;//���\�^��true
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
	//*****�R�����J�b��T*****//
	public static boolean DeleteUnRecordedCustomer(String ID)
	{
		boolean re = false;
		try
		{
			Connection conn = DriverManager.getConnection(conurl, userid, userpwd);
			try
			{
				String sql = "delete from UnRecordedCustomer where ID='"+ID+"'";
				Statement stmt = conn.createStatement();
				stmt.executeUpdate(sql);
				stmt.close();
				conn.close();
				re = true;//���\�^��true
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return re;
	}
	
}
