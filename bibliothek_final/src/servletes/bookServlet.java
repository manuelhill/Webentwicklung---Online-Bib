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

import beans.Chapter;

/**
 * Servlet
 */
@WebServlet("/bookServlet")
public class bookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session=request.getSession();
			
		Chapter chapter = new Chapter(0);		
		
		String book_id = session.getAttribute("id").toString();
		
		final PrintWriter out = response.getWriter();   
		response.setContentType("text/html;charset=UTF-8");
				
		try {
			final Connection con = ds.getConnection(); 
					
			PreparedStatement pstmt = con.prepareStatement("SELECT id, title, text FROM database.chapters WHERE bookid=" + book_id);
			ResultSet chapterQuery = pstmt.executeQuery();

			
			ArrayList<String> chapterTitle = new ArrayList<String>();
			ArrayList<String> chapterText = new ArrayList<String>();
			ArrayList<String> chapterID = new ArrayList<String>();
			 
			while (chapterQuery.next()){

				chapter.setID(chapterQuery.getInt("id"));
				chapter.setTitle(chapterQuery.getString("title"));
				chapter.setText(chapterQuery.getString("text"));
				
				chapterID.add(chapter.getId().toString());
				chapterTitle.add(chapter.getTitle());
				chapterText.add(chapter.getText());
				}			
				request.setAttribute("id", chapterID);
				request.setAttribute("title", chapterTitle);
			 	request.setAttribute("text", chapterText);
			 	
			 	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/book.jsp");
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