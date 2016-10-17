package BookManagement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import org.eclipse.jdt.internal.compiler.batch.Main;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class Book extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String ISBN;
    private String Tittle;
    private int AuthorID;
    private String Publisher;
    private String PublishDate;
    private int Price;
    private static Book noAuthorBook = new Book();
    private static boolean noAuthor = false;
    private ArrayList<Book> AllBooks = new ArrayList<Book>();
    private Map<String,Object> session;
    
    public Map<String,Object> getSession() {
		return session;
	}


	public void setSession(Map<String,Object> session) {
		this.session = session;
	}


	public Book()
    {}
    
    
    public  boolean isNoAuthor() {
		return noAuthor;
	}


	public void setNoAuthor(boolean noAuthor) {
		Book.noAuthor = noAuthor;
	}


	public Book getNoAuthorBook() {
		return noAuthorBook;
	}


	public void setNoAuthorBook(Book noAuthorBook) {
		Book.noAuthorBook = noAuthorBook;
	}


	@Override
	public String toString() {
		return "Book [ISBN=" + ISBN + ", Tittle=" + Tittle + ", AuthorID=" + AuthorID + ", Publisher=" + Publisher
				+ ", PublishDate=" + PublishDate + ", Price=" + Price + "]";
	}

    
    public ArrayList<Book> getAllBooks() {
		return AllBooks;
	}
	public  void setAllBooks(ArrayList<Book> allBooks) {
		AllBooks = allBooks;
	}
	public Author getWriter() {
		return Writer;
	}
	public void setWriter(Author writer) {
		Writer = writer;
	}

	private Author Writer;
    
    public Book (String iSBN, String tittle, int authorID, String publisher, String publishDate, int price)
	{
		ISBN = iSBN;
		Tittle = tittle;
		AuthorID = authorID;
		Publisher = publisher;
		PublishDate = publishDate;
		Price = price;
	}
    public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getTittle() {
		return Tittle;
	}

	public void setTittle(String tittle) {
		Tittle = tittle;
	}

	public int getAuthorID() {
		return AuthorID;
	}

	public void setAuthorID(int authorID) {
		AuthorID = authorID;
	}

	public String getPublisher() {
		return Publisher;
	}

	public void setPublisher(String publisher) {
		Publisher = publisher;
	}

	public String getPublishDate() {
		return PublishDate;
	}

	public void setPublishDate(String publishDate) {
		PublishDate = publishDate;
	}

	public int getPrice() {
		return Price;
	}

	public void setPrice(int price) {
		Price = price;
	}
	
	public String addBook() throws SQLException{
		int Count = 0;
		String table2 = "Author";
		String sql2 = "select * from " + table2;
		String sql3 = "select count(*) from Book where ISBN = '" + ISBN + "';";
		ResultSet rr = JDBCUtils.getRs(sql3);
		if(rr.next())
	        Count = rr.getInt(1);
	    if(Count == 1)
			return "fail";
	    else
	    {
	    	rr = JDBCUtils.getRs(sql2);
		    while (rr.next())
			{
		    	int authorID = rr.getInt(1);
				if (authorID == AuthorID)
				{
					String sql = "insert into Book values ('" 
			            + Tittle +"',"+ AuthorID +",'"+ Publisher +"','"+ PublishDate + "'," + Price + ",'" + ISBN+"');";
			        JDBCUtils.getStmt().executeUpdate(sql);
			        return SUCCESS;
				}
			}
		    
		    ActionContext context = ActionContext.getContext();
		    session = context.getSession();
		    
	    	session.put("shit",new Book(ISBN, Tittle, AuthorID, Publisher, PublishDate, Price));
	        session.put("noAuthor",true);
	        
	        
	    	return "noAuthor";
	    }
	}
	
	public String deleteBook() throws SQLException
	{
	    String sql = "delete from Book where ISBN = '" + ISBN + "';";
	    JDBCUtils.getStmt().executeUpdate(sql);
		return SUCCESS;
	}
	public String findBook() throws SQLException
	{
		String sql3 = "select * from Book where ISBN = '" + ISBN + "';";
		ResultSet rr = JDBCUtils.getRs(sql3);
		if(rr.next())
		{
			Tittle = rr.getString(1);
		    AuthorID = rr.getInt(2);
	      	Publisher = rr.getString(3);
	      	PublishDate = rr.getString(4);
	     	Price = rr.getInt(5);
		}
		return SUCCESS;
	}
	public String updateBook() throws SQLException{
	    int Count = 0;
	    String sql4 = "select count(*) from Author where AuthorID = '" + AuthorID + "';";
	    ResultSet rr = JDBCUtils.getRs(sql4);
		if(rr.next())
		    Count = rr.getInt(1);
		if(Count == 1)
		{
		    String sql = "update Book set Title = '"+ Tittle +"', Publisher = '"
	            + Publisher +"',PublishDate = '" + PublishDate + "',Price = " + Price + ",AuthorID = " + AuthorID + " where ISBN = '" + ISBN +"';";
		    JDBCUtils.getStmt().executeUpdate(sql);
		    return SUCCESS;
		}
		else
		{
		    noAuthor = true;
		    noAuthorBook = new Book(ISBN, Tittle, AuthorID, Publisher, PublishDate, Price);
		    return "noAuthor";
		}
	}
	
	public String showAllBooks() throws SQLException{
		String table = "Book";
	    String sql = "select * from " + table;
	    ResultSet rr = JDBCUtils.getRs(sql);
        while (rr.next())
	    {
        	String tittle = rr.getString(1);
		    int authorID = rr.getInt(2);
	      	String publisher = rr.getString(3);
	      	String publishDate = rr.getString(4);
	     	int price = rr.getInt(5);
	    	String iSBN = rr.getString(6);
	    	Book tmpBook = new Book(iSBN,tittle,authorID,publisher,publishDate,price);
	    	AllBooks.add(tmpBook);
     	}
        return SUCCESS;
	}
	
	public String searchForWriter() throws SQLException
	{

		String sql1 = "select * from Book where ISBN = '" + ISBN + "';";
		ResultSet rr = JDBCUtils.getRs(sql1);
		if(rr.next())
		{
			Tittle = rr.getString(1);
		    AuthorID = rr.getInt(2);
	      	Publisher = rr.getString(3);
	      	PublishDate = rr.getString(4);
	     	Price = rr.getInt(5);
		}
		String sql2 = "select * from Author where AuthorID = " + AuthorID + ";";
		rr = JDBCUtils.getRs(sql2);
		if(rr.next())
	    {
        	int AuthorID = rr.getInt(1);
	      	String Name = rr.getString(2);
	     	int Age = rr.getInt(3);
	    	String Country = rr.getString(4);
	        Writer = new Author(AuthorID,Name,Age,Country);
     	}
		return SUCCESS;
	}
	
	public static void main(String[] args) throws SQLException {
		Book book = new Book();
		System.out.println(book.showAllBooks());
		System.out.println(book.getAllBooks());
		
		
	}
}
