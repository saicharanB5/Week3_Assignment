import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class BookManagementSystem {
	
    private final static String Insert_Book="Insert into book values(?,?,?,?)";
    private final static String Delete_Book="delete from book where BookID=?";
    private final static String Update_Book="Update book set BookName=? where BookID=? ";
    private final static String Search_Book="SELECT * from book where BookID=?";
    private final static String Show_Book="SELECT * from book";
    public static void main(String args[]) throws Exception
    {
    	Class.forName("com.mysql.cj.jdbc.Driver");
    	Connection con=DriverManager.getConnection("jdbc:mysql:///example1","root","Nivas@123");
    	Scanner scan=new Scanner(System.in);
    	PreparedStatement ps=null;
    	int result=0;
    	int book_id=0;
    	String book_name=null;
    	String author_name=null;
    	String edition=null;
    	int option=0;
    	int numberOfBooks=0;
    	int success=0;
    	try
    	{

    		if(con!=null)
    		{
    			System.out.println("Select one of the options below\\n\"\r\n"
    					+ "1. Add New Book\n"
    					+ "2. Delete Book\n"
    					+ "3. Update Book\n"
    					+ "4. Search Book\n"
    					+ "5. Show Book\n"
    					+ "6. Exit ");
    			option=scan.nextInt();
    		}
    		else
    		{
    			System.out.println("Connection not found");
    		}
    		
    		switch(option)
    		{
    		case 1: ps=con.prepareStatement(Insert_Book);
    				System.out.println("Enter the number of books");
    				numberOfBooks=scan.nextInt();
    				for(int i=0;i<numberOfBooks;i++)
    				{
    					System.out.println("\nEnter Book "+(i+1)+" details: ");
  		              System.out.print("BookID ");
  		              book_id = scan.nextInt();
  		              System.out.print("Book name: ");
  		              book_name = scan.next();;
  		              System.out.print("Author Name : ");
  		              author_name = scan.next();
  		              System.out.print("Edition: ");
  		              edition = scan.next();
  		              // set parameters values
  		              ps.setInt(1, book_id);
  		              ps.setString(2, book_name);
  		              ps.setString(3, author_name);
  		              ps.setString(4, edition);
  		              
  		              result = ps.executeUpdate();
    				}
    				if(result==0)
    				{
    					System.out.println("Insertion of books failed");
    				}
    				else
    				{
    					System.out.println("Books inserted Successfully");
    				}
    				break;
    		case 2: System.out.println("Enter the Book ID that you want to delete");
    				int BookID=scan.nextInt();
    				PreparedStatement ps1=con.prepareStatement(Delete_Book);
    				ps1.setInt(1, BookID);
    				success=ps1.executeUpdate();
    				if(success==0)
    				{
    					System.out.println("Deletion of Book failed");
    				}
    				else
    				{
    					System.out.println("Book deleted successfully");
    				}
    				break;
    				
    		case 3: System.out.println("Enter the Book ID that you want to update");
    				int BookID1=scan.nextInt();
    				System.out.println("Enter the new Book name");
    				String newBook=scan.next();
    				PreparedStatement ps2=con.prepareStatement(Update_Book);
    				ps2.setString(1, newBook);
    				ps2.setInt(2, BookID1);
    				ps2.executeUpdate();
    				success=ps2.executeUpdate();
    				if(success==0)
    				{
    					System.out.println("Book Updation failed");
    				}
    				else
    				{
    					System.out.println("Book updated successfully");
    				}
    				break;
    				
    		case 4: System.out.println("Enter the Book ID that you want to search");
    				int BookID2=scan.nextInt();
    				PreparedStatement ps3=con.prepareStatement(Search_Book);
    				ps3.setInt(1, BookID2);
    				ResultSet rs=ps3.executeQuery();
    					while(rs.next())
    					{
    						System.out.println("Book ID : "+rs.getInt(1)+", Book Name : "+rs.getString(2)+", Author Name : "+rs.getString(3)+", Edition : "+rs.getString(4));
    					}
    				break;
    				
    		case 5: System.out.println("Displaying all books..\n");
    				PreparedStatement ps4=con.prepareStatement(Show_Book);
    				ResultSet rs1=ps4.executeQuery();
    				while(rs1.next())
    				{
    					System.out.println("Book ID : "+rs1.getInt(1)+", Book Name : "+rs1.getString(2)+", Author Name : "+rs1.getString(3)+", Edition : "+rs1.getString(4));
    				}
    				break;
    				
    		case 6: System.out.println("Exiting Book Management System...... Thank you!");
    				break;
    				
    		default : System.out.println("Select the correct option");
    				break;
    			
    				
    		}
    	}
    	catch(SQLException se) {
    		se.printStackTrace();
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}finally {
    		try {
				if(ps!=null)
					ps.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}try {
				if(con!=null)
					con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}try {
				if(scan != null)
					scan.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
    	}
    }

}
