package BookManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.*;

public class JDBCUtils {
	private static String url = "jdbc:mysql://ccfiwazkrssl.rds.sae.sina.com.cn:10605/bookdb";
//	private static String url = "jdbc:mysql://localhost:3306/bookdb";
	private static String username = "root";
	private static String password = "fanyang";
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null;
	public static String getUrl() {
		return url;
	}
	public static void setUrl(String url) {
		JDBCUtils.url = url;
	}
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		JDBCUtils.username = username;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		JDBCUtils.password = password;
	}
	public static String getDriver() {
		return driver;
	}
	public static void setDriver(String driver) {
		JDBCUtils.driver = driver;
	}
	public static Connection getCon() {
		return con;
	}
	public static void setCon(Connection con) {
		JDBCUtils.con = con;
	}
	public static Statement getStmt() throws SQLException {
		if(stmt == null || stmt.isClosed())
		{
			try{
				Class.forName(driver);
				con = DriverManager.getConnection(url, username, password);
				stmt = con.createStatement();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
		return stmt;
	}
	public static void setStmt(Statement stmt) {
		
		JDBCUtils.stmt = stmt;
	}
	public static ResultSet getRs(String sql) throws SQLException {
		try{
			rs = getStmt().executeQuery(sql);
		}catch (Exception e){
			e.printStackTrace();
		}
		if(rs==null||rs.isClosed())
			rs=getRs(sql);
		return rs;
	}
	public static void setRs(ResultSet rs) {
		JDBCUtils.rs = rs;
	}
	public static void main (String [] args) throws SQLException
	{
		Author testAuthor;
		Book testBook;
		String result;
		testAuthor= new Author(4,"马化腾",50,"中国");
		testBook = new Book("84651-3-562-9","不充值你能更强吗？",4,"企鹅出版社","2016-10-1",998);
		result = testBook.addBook();
	/*	if(result == "success")
		{
			String table = "Author";
		    String sql = "select * from " + table;
		    ResultSet rr = getRs(sql);
	        while (rr.next())
		    {
			    int AuthorID = rr.getInt(1);
		      	String Name = rr.getString(2);
		     	int Age = rr.getInt(3);
		    	String Country = rr.getString(4);
		    	System.out.println(AuthorID + "\t" + Name + "\t" + Age + "\t" + Country);
	     	}
		}
		else
		{
			System.out.println("作者ID不存在！");
		}*/
		System.out.println(result);
		if(result == "success")
		{
			String table = "Book";
		    String sql = "select * from " + table;
		    ResultSet rr = getRs(sql);
	        while (rr.next())
		    {
	        	String Tittle = rr.getString(1);
			    int AuthorID = rr.getInt(2);
		      	String Publisher = rr.getString(3);
		      	String PublishDate = rr.getString(4);
		     	int Price = rr.getInt(5);
		    	String ISBN = rr.getString(6);
		    	System.out.println(ISBN + "\t" + Tittle + "\t" + AuthorID + "\t" + Publisher + "\t" + PublishDate + "\t" + Price);
	     	}
		}
		else
		{
			System.out.println("BUG！");
		}
		
	}

}
