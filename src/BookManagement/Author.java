package BookManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class Author extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String Name;
	private String Country;
	private int Age;
	private int AuthorID;
	private ArrayList<Author> AllAuthors = new ArrayList<Author>();
	private ArrayList<Book> Works = new ArrayList<Book>();
	private Map<String,Object> session;
	
	
	
	public Map<String, Object> getMap() {
		return session;
	}

	public void setMap(Map<String, Object> map) {
		this.session = map;
	}

	public Author()
	{}
	
	public Author (int authorID, String name, int age, String country)
	{
		Name = name;
		Country = country;
		Age = age;
		AuthorID = authorID;
	}
	
	public  ArrayList<Author> getAllAuthors() {
		return AllAuthors;
	}

	public  void setAllAuthors(ArrayList<Author> allAuthors) {
		AllAuthors = allAuthors;
	}

	public  ArrayList<Book> getWorks() {
		return Works;
	}

	public  void setWorks(ArrayList<Book> works) {
		Works = works;
	}

	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public int getAge() {
		return Age;
	}
	public void setAge(int age) {
		Age = age;
	}
	public int getAuthorID() {
		return AuthorID;
	}
	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}
	public String addAuthor() throws SQLException{
		String table = "Author";
		String sql1 = "select * from " + table;
		ResultSet rr = JDBCUtils.getRs(sql1);
	    while (rr.next())
		{
			int authorID = rr.getInt(1);
			if (authorID == AuthorID)
				return "fail";
		}
		String sql = "insert into Author values (" + AuthorID +",'"+ Name +"',"+ Age +",'"+ Country + "');";
		JDBCUtils.getStmt().executeUpdate(sql);
		
		ActionContext context = ActionContext.getContext();
		session = context.getSession();
		
		if((boolean) session.get("noAuthor"))
		{
			session.put("noAuthor", false);
			Book noBook = (Book) session.get("shit");
			String sql2 = "insert into Book values ('" 
		            + noBook.getTittle() +"',"+ AuthorID +",'"+ noBook.getPublisher() +"','"+ noBook.getPublishDate() + "'," + noBook.getPrice() + ",'" + noBook.getISBN()+"');";
		        JDBCUtils.getStmt().executeUpdate(sql2);
		}
		return SUCCESS;
	}
	public String findAuthor() throws SQLException
	{
		String sql1 = "select * from Author where AuthorID = " + AuthorID;
		ResultSet rr = JDBCUtils.getRs(sql1);
		if(rr.next())
		{
	      	Name = rr.getString(2);
	     	Age = rr.getInt(3);
	    	Country = rr.getString(4);
		}
		return SUCCESS;
	}
	public String updateAuthor() throws SQLException{
	    String sql = "update Author set Name = '"+Name+"',Age = "+Age+",Country = '"+Country+"' where AuthorID = " + AuthorID +";";
		JDBCUtils.getStmt().executeUpdate(sql);
		return SUCCESS;
	}
	
	public String showAllAuthors() throws SQLException{
		String table = "Author";
	    String sql = "select * from " + table;
	    ResultSet rr = JDBCUtils.getRs(sql);
        while (rr.next())
	    {
        	int AuthorID = rr.getInt(1);
	      	String Name = rr.getString(2);
	     	int Age = rr.getInt(3);
	    	String Country = rr.getString(4);
	    	Author tmpAuthor = new Author(AuthorID,Name,Age,Country);
	    	AllAuthors.add(tmpAuthor);
     	}
        return SUCCESS;
	}
	
	public String searchForWorks() throws SQLException
	{
		int Count = 0;
		String sql3 = "select count(*) from Author where Name = '" + Name + "';";
		ResultSet rr = JDBCUtils.getRs(sql3);
		if(rr.next())
	        Count = rr.getInt(1);
	    if(Count == 1)
	    {
	    	Works.clear();
	    	String table1 = "Author";
	        String sql1 = "select * from " + table1 + " where Name = '" + Name + "';";
	         rr = JDBCUtils.getRs(sql1);
	        if(rr.next())
	    	    AuthorID = rr.getInt(1);
	        
	        
	    	String table2 = "Book";
	        String sql2 = "select * from " + table2 + " where AuthorID = " + AuthorID;
	        rr = JDBCUtils.getRs(sql2);
            while (rr.next())
	        {
             	String Tittle = rr.getString(1);
		        int AuthorID = rr.getInt(2);
	          	String Publisher = rr.getString(3);
	      	    String PublishDate = rr.getString(4);
	         	int Price = rr.getInt(5);
	        	String ISBN = rr.getString(6);
	        	Book tmpBook = new Book(ISBN,Tittle,AuthorID,Publisher,PublishDate,Price);
	        	Works.add(tmpBook);
         	}
            return SUCCESS;
	    }
	    else return "fail";
	}
}
