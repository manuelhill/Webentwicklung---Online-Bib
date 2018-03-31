/**
 * @author: Lukas Schütte
 */
package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet
 */
@WebServlet("/changeBookServlet")
public class changeBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");  
		
		String i = request.getParameter("bookid");
		
		final PrintWriter out = response.getWriter();   
		
		try {
			final Connection con = ds.getConnection(); 
				
			PreparedStatement pstmt_book = con.prepareStatement("UPDATE database.books SET title=\""+request.getParameter("title")+"\", author=\"" + request.getParameter("author") + "\" "
					+ "WHERE id=" + i);
			
			pstmt_book.executeUpdate();
		 	
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