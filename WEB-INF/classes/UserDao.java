package com.saddam.dao;
import java.sql.*;
import java.util.*;
import com.saddam.bean.User;
public class UserDao
{
	public static Connection getConnection()
	{
		Connection con=null;
		try
		{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","SCOTT","TIGER");
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
	public static int save(User u)
	{
		int status=0;
		try{
		Connection con=getConnection();
		PreparedStatement pst=con.prepareStatement("insert into user1(name,password,email,sex,country) values(?,?,?,?,?)");
		
		pst.setString(1,u.getName());
		pst.setString(2,u.getPassword());
		pst.setString(3,u.getEmail());
		pst.setString(4,u.getSex());
		pst.setString(5,u.getCountry());
		status=pst.executeUpdate();
		}
		catch(Exception ex){System.out.println(ex);}
		return status;
	}
	public static List<User> getAllRecords()
	{
		List<User> list=new ArrayList<User>();
		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from user1");
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				User u=new User();
				u.setId(rs.getInt(1));
				u.setName(rs.getString(2));
				u.setPassword(rs.getString(3));
				u.setEmail(rs.getString(4));
				u.setSex(rs.getString(5));
				u.setCountry(rs.getString(6));
				list.add(u);
			}
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	public static int delete(User u)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("delete from user1 where id=?");
			pst.setInt(1,u.getId());
			status=pst.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	}
	public static int edit(User u)
	{
		int status=0;
		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("update user1 set name=?,password=?,email=?,sex=?,country=? where id=?");
			pst.setString(1,u.getName());
			pst.setString(2,u.getPassword());
			pst.setString(3,u.getEmail());
			pst.setString(4,u.getSex());
			pst.setString(5,u.getCountry());
			pst.setInt(6,u.getId());
			status=pst.executeUpdate();
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return status;
	
	}
	public static User getRecordById(int id)
	{
		User u=null;

		try
		{
			Connection con=getConnection();
			PreparedStatement pst=con.prepareStatement("select * from user1 where id=?");
			pst.setInt(1,id);
			ResultSet rs=pst.executeQuery();

			while(rs.next())
			{
				u=new User();
				u.setId(rs.getInt("id"));
				u.setName(rs.getString("name"));
				u.setPassword(rs.getString("password"));
				u.setEmail(rs.getString("email"));
				u.setSex(rs.getString("sex"));
				u.setCountry(rs.getString("country"));

			}
			
		}
		catch (Exception e)
		{
			System.out.println(e);
		}
		return u;
	}
}