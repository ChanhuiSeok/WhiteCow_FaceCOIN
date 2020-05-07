package white_cow_gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager
{
	public Connection connection;
	public Statement statement;
	
	public DBManager()
	{
		try
		{
			Class.forName("org.sqlite.JDBC");
		}
		catch (ClassNotFoundException e)
		{
			System.out.println("org.sqlite.JDBC를 찾지 못했습니다.");
		}
		
		try
		{
			connection = DriverManager.getConnection("jdbc:sqlite:test.db");
			statement = connection.createStatement();
			
			//statement.execute("drop table if exists user_info;");
			
			statement.execute("create table if not exists user_info (_id INTEGER PRIMARY KEY AUTOINCREMENT, user_name TEXT, user_birthday TEXT, user_id TEXT UNIQUE, user_pw TEXT);");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}	
	}
	
	//select * from user_info;
	public void selectAll_user_info()
	{
		try
		{
			ResultSet resultSet = statement.executeQuery("select user_name, user_birthday, user_id, user_pw from user_info order by user_name");
			System.out.println("\nResults of 'select * from user_info;' : ");
			System.out.printf("%-10s %-9s %-15s %s\n", "성명", "생년월일", "ID", "비밀번호");
			System.out.println("----------------------------------------------");
			while (resultSet.next())
			{
				System.out.printf("%-10s %-10s %-16s %s\n", resultSet.getString("user_name"), resultSet.getString("user_birthday"), resultSet.getString("user_id"), resultSet.getString("user_pw"));
			}
			
			System.out.println("");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean select_with_condition_user_info(String user_name, String user_birthday, String user_id, String user_pw)
	{
		boolean searched = false;
		
		try
		{
			System.out.println(user_id.length());
			ResultSet resultSet = statement.executeQuery("select user_name, user_birthday, user_id, user_pw from user_info where user_name='" + user_name + "' and user_birthday='" + user_birthday + "' and user_id='" + user_id + "' and user_pw='" + user_pw + "' order by user_name");
			System.out.println("\nResult of 'select * from user_info where user_name='" + user_name + "' and user_birthday='" + user_birthday + "' and user_id='" + user_id + "' and user_pw='" + user_pw + "';' : ");
			System.out.printf("%-10s %-9s %-15s %s\n", "성명", "생년월일", "ID", "비밀번호");
			System.out.println("----------------------------------------------");
			
			while (resultSet.next())
			{
				System.out.printf("%-10s %-10s %-16s %s\n", resultSet.getString("user_name"), resultSet.getString("user_birthday"), resultSet.getString("user_id"), resultSet.getString("user_pw"));
				searched = true;
			}
			
			System.out.println("");
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return searched;
	}
	
	public void insert_user_info(String user_name, String user_birthday, String user_id, String user_pw)
	{
		try
		{
			statement.execute("insert into user_info (user_name, user_birthday, user_id, user_pw) values ('"+ user_name +"', '" + user_birthday + "', '" + user_id + "', '" + user_pw + "');");
		}
		catch (SQLException e)
		{
			System.err.println("insert 쿼리를 수행하는 도중 오류가 발생했습니다.");
		}
	}
	
	public void update_pw_user_info(String set_value, String prev_user_name, String prev_user_birthday, String prev_user_id, String prev_user_pw)
	{
		try
		{
			statement.execute("update user_info set user_pw='" + set_value + "' where user_name='" + prev_user_name + "' and user_birthday='" + prev_user_birthday + "' and user_id='" + prev_user_id + "' and user_pw='" + prev_user_pw + "';");
		}
		catch (SQLException e)
		{
			System.err.println("update 쿼리를 수행하는 도중 오류가 발생했습니다.");
		}
	}
	
	//delete from user_info;
	public void delete_all_user_info()
	{
		try
		{
			statement.execute("delete from user_info;");
			statement.execute("delete from sqlite_sequence where name='user_info';");
		}
		catch (SQLException e)
		{
			System.err.println("delete 쿼리를 수행하는 도중 오류가 발생했습니다.");
		}
	}
	
	public void delete_user_info(String user_name, String user_birthday, String user_id, String user_pw)
	{
		try
		{
			statement.execute("delete from user_info where user_name='" + user_name + "' and user_birthday='" + user_birthday + "' and user_id='" + user_id + "' and user_pw='" + user_pw + "';");
			statement.execute("delete from sqlite_sequence where name='user_info';");
		}
		catch (SQLException e)
		{
			System.err.println("delete 쿼리를 수행하는 도중 오류가 발생했습니다.");
		}
	}
	
	public String loadData(String filename)
	{
		String line = "";
		
		try
		{
			File file = new File(filename);
			FileReader filereader = new FileReader(file);
			BufferedReader bufReader = new BufferedReader(filereader);
			
			line = bufReader.readLine();
			
			bufReader.close();
			
			return line;
		}
		catch (FileNotFoundException fnfe)
		{
			return null;
		}
		catch (IOException ioe)
		{
			ioe.printStackTrace();
			return null;
		}
	}
	
	public String[] split_str(String str)
	{
		String[] ret_val = str.split("_");
		
		return ret_val;
	}
}

	
	