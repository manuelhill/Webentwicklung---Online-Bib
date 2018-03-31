/**
 * @author: Lukas Schütte
 */
package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Book;


/**
 * Servlet
 */
@WebServlet("/coverUploadServlet")
public class coverUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public coverUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
				
		Book book = new Book(0);
		
		final PrintWriter out = response.getWriter();   
		response.setContentType("text/html;charset=UTF-8");  
		
		try {
			final Connection con = ds.getConnection(); 
					
			PreparedStatement pstmt = con.prepareStatement("SELECT id, title FROM database.books");
			ResultSet bookQuery = pstmt.executeQuery();
						
			ArrayList<String> bookID = new ArrayList<String>();
			ArrayList<String> bookTitle = new ArrayList<String>();
			 
			while (bookQuery.next()){

				book.setID(bookQuery.getInt("id"));
				book.setTitle(bookQuery.getString("title"));
								
				bookID.add(book.getId()+"");
				bookTitle.add(book.getTitle());

				}
			
				request.setAttribute("id", bookID);
			 	request.setAttribute("title", bookTitle);
			 	
			 	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/coverUpload.jsp");
	    		dispatcher.forward(request, response);
			}	
			catch (Exception ex) 
			{
				out.println(ex.getMessage()+"\n");
				ex.printStackTrace(out);
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}