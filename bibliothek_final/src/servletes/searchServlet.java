/**
 * @author: Manuel Hill
 */
package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		  PrintWriter out = response.getWriter();	    
		    
		    ArrayList<String> books = new ArrayList<String>();
		    ArrayList<Integer> bookID = new ArrayList<Integer>();
			try{
				 final Connection con = ds.getConnection();
				 //Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
			     //out.println("DB Connection successfull");
				 
				 String searchString = request.getParameter("searchString");
				 //out.println("<br />id: " + searchString + "<br />");
				 String selectedSearchType = request.getParameter("searchType");
				//out.println("searchType: " + selectedSearchType + "<br />");
				 
				 if(selectedSearchType.equals("Buchtitel")){
					 PreparedStatement pstmt = con.prepareStatement("SELECT id, title FROM database.books WHERE title LIKE '%"+searchString+"%'");
					 
					 ResultSet rs = pstmt.executeQuery();
					 
					 if(rs.first() == false){
						 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchResult.jsp?result=0");
				    	 dispatcher.forward(request, response);
					 } else{
						 
						 int id = rs.getInt("id"); //Das ist die Buch ID die gefunden wurde in der DB
			        	 String title = rs.getString("title"); //Das ist der Buchtitel der gefunden wurde in der DB
			        	 books.add(title);
			        	 bookID.add(id);
			        	 //out.println("id: " + id + " titel: " + title + "<br />");
			        	 
						 while(rs.next()){
				        	 id = rs.getInt("id"); //Das ist die Buch ID die gefunden wurde in der DB
				        	 title = rs.getString("title"); //Das ist der Buchtitel der gefunden wurde in der DB
				        	 books.add(title);
				        	 //out.println("id: " + id + " titel: " + title + "<br />");
						 }
						 
						 request.setAttribute("id", bookID);
						 request.setAttribute("title", books);
						 	
						 RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/searchResult.jsp");
				    	 dispatcher.forward(request, response);
					  }
				 }

				 if(selectedSearchType.equals("Kapiteltitel")){
					 PreparedStatement pstmt = con.prepareStatement("SELECT bookid, title FROM database.chapters WHERE title LIKE '%"+searchString+"%'");
					 
					 //Wenn die book_id in der Tabelle "chapter" drinsteht sollte dieser SQL Befehl auch die book_id ausgeben
					 //PreparedStatement pstmt = con.prepareStatement("SELECT book_id, title FROM db_bibliothek.chapters WHERE title LIKE '%"+searchString+"%'");
					 
					 ResultSet rs = pstmt.executeQuery();
					 
					 if(rs.first() == false){
						 out.println("<br / >Die Suche ergab leider keine Treffer<br />");
					 } else{
						 
						 int id = rs.getInt("bookid"); //Das ist die Kapitel ID die gefunden wurde in der DB
			        	 String title = rs.getString("title"); //Das ist der Kapiteltitel der gefunden wurde in der DB
			        	 books.add(title);
			        	 bookID.add(id);
			        	 //out.println("id: " + id + " titel: " + title + "<br />");
			        	 
			        	 while(rs.next()){
			        		 id = rs.getInt("bookid"); //Das ist die Kapitel ID die gefunden wurde in der DB
			        		 //bzw dieser SQL Befehl wenn nur die book_id in der Ausgabe interessiert, nicht die chapter id
			        		 //int id = rs.getInt("book_id"); //Das ist die Buch ID die gefunden wurde in der DB
			        		 title = rs.getString("title"); //Das ist der Kapiteltitel der gefunden wurde in der DB
			        		 books.add(title);
			        		 bookID.add(id);
			        		 //out.println("id: " + id + " titel: " + title + "<br />");
			        		 //out.println("id: " + book_id + " titel: " + title + "<br />");
			        	 }
			        	 request.setAttribute("id", bookID);
						 request.setAttribute("title", books);
						 	
						 RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
				    	 dispatcher.forward(request, response);
					 }
				 }	

				 if(selectedSearchType.equals("Kapiteltext")){
					 PreparedStatement pstmt = con.prepareStatement("SELECT bookid, title FROM database.chapters WHERE text LIKE '%"+searchString+"%'");
					 
					 ResultSet rs = pstmt.executeQuery();
					 
					 if(rs.next() == false){
						 out.println("<br / >Die Suche ergab leider keine Treffer<br />");
					 } else{
						 
						 int id = rs.getInt("bookid"); //Das ist die Kapitel ID die gefunden wurde in der DB
			        	 String title = rs.getString("title"); //Das ist der Kapiteltitel der gefunden wurde in der DB
			        	 books.add(title);
			        	 //out.println("id: " + id + " titel: " + title + "<br />");

			        	 while(rs.next()){
			        		 id = rs.getInt("bookid"); //Das ist die Kapitel ID die gefunden wurde in der DB
			        		 //bzw dieser SQL Befehl wenn nur die book_id in der Ausgabe interessiert, nicht die chapter id
			        		 //int id = rs.getInt("book_id"); //Das ist die Buch ID die gefunden wurde in der DB
			        		 title = rs.getString("title"); //Das ist der Kapiteltitel der gefunden wurde in der DB
			        		 books.add(title);
			        		 bookID.add(id);
			        		 //out.println("id: " + id + " titel: " + title + "<br />");
			        		 //out.println("id: " + book_id + " titel: " + title + "<br />");
			        	 }
			        	 request.setAttribute("id", bookID);
						 request.setAttribute("title", books);
						 	
						 RequestDispatcher dispatcher = request.getRequestDispatcher("search.jsp");
				    	 dispatcher.forward(request, response);
					 }
				 }
				 
	}	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}
}
