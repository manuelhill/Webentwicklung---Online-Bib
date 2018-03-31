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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.Book;
import beans.Chapter;

/**
 * Servlet
 */
@WebServlet("/adminBookServlet")
public class adminBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");  
		
		HttpSession session = request.getSession(true);	
		
		Chapter chapter = new Chapter(0);
		Book book = new Book(0);
		
		String i = session.getAttribute("bookid").toString();
		
		final PrintWriter out = response.getWriter();   
		//out.println(i);
		
		try {
			final Connection con = ds.getConnection(); 
				
			PreparedStatement pstmt_book = con.prepareStatement("SELECT id, title, author FROM database.books WHERE id=" + i);
			ResultSet bookQuery = pstmt_book.executeQuery();
			
			PreparedStatement pstmt = con.prepareStatement("SELECT id, title, text FROM database.chapters WHERE bookid=" + i);
			ResultSet chapterQuery = pstmt.executeQuery();

			while (bookQuery.next()){
				book.setTitle(bookQuery.getString("title"));
				book.setAuthor(bookQuery.getString("author"));				
			}
			
			request.setAttribute("book_id", i);
			request.setAttribute("book_title", book.getTitle());
			request.setAttribute("book_author", book.getAuthor());
							
			ArrayList<String> chapterID = new ArrayList<String>();
			ArrayList<String> chapterTitle = new ArrayList<String>();
			
			 
			while (chapterQuery.next()){

				chapter.setID(chapterQuery.getInt("id"));
				chapter.setTitle(chapterQuery.getString("title"));
				chapter.setText(chapterQuery.getString("text"));
				
				chapterID.add(chapter.getId().toString());
				chapterTitle.add(chapter.getTitle());
				}
			
				request.setAttribute("id", chapterID);
			 	request.setAttribute("title", chapterTitle);
			 	
			 	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/adminBook.jsp");
	    		dispatcher.forward(request, response);
	    		
			}	
			catch (Exception ex) 
			{    
				out.println(ex.getMessage()+"\n");    ex.printStackTrace(out);   
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}