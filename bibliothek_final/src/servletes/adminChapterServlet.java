/**
 * @author: Lukas Schütte
 */
package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import beans.Chapter;


/**
 * Servlet
 */
@WebServlet("/adminChapterServlet")
public class adminChapterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminChapterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");  
				
		Chapter chapter = new Chapter(0);
		
		String i = request.getParameter("chapterid");
		
		final PrintWriter out = response.getWriter();   
		
		try {
			final Connection con = ds.getConnection(); 
					
			PreparedStatement pstmt = con.prepareStatement("SELECT id, title, text FROM database.chapters WHERE id=" + i);
			ResultSet chapterQuery = pstmt.executeQuery();

			while (chapterQuery.next()){

				chapter.setID(chapterQuery.getInt("id"));
				chapter.setTitle(chapterQuery.getString("title"));
				chapter.setText(chapterQuery.getString("text"));
				}
			
				request.setAttribute("id", chapter.getId().toString());
				request.setAttribute("title", chapter.getTitle());
			 	request.setAttribute("text", chapter.getText());
			 	
			 	RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/adminChapter.jsp");
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