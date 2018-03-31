/**
 * @author: Lukas Schütte, Manuel Hill
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
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import beans.User;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/registrationServlet")
public class registrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		final PrintWriter out = response.getWriter();   
		response.setContentType("text/html;charset=UTF-8");  
		User user = new User();
		
		user.setUsername(request.getParameter("username"));
		user.setPassword(request.getParameter("password"));
				
		try
		{
			final Connection con = ds.getConnection(); 
					
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM database.user "
					+ "WHERE username=\""+ user.getUsername() +"\" AND password=\""+user.getPassword()+"\"");
			
			ResultSet userQuery = pstmt.executeQuery();
			if(userQuery.next()) 
			{
				out.println("Username existiert bereits");
				out.println("<a href=\"index.jsp\">Index</a>");
			}
			else 
			{
				user.setUsername(request.getParameter("username"));
				user.setVorname(request.getParameter("vorname"));
				user.setNachname(request.getParameter("nachname"));
				user.setPassword(request.getParameter("password"));
				user.setAdmin(0);
			
				PreparedStatement pstmt2 = con.prepareStatement("INSERT INTO database.user (username, vorname, nachname, password) "
						+ "VALUES(\""+ user.getUsername()
						+"\", \"" + user.getVorname()
						+"\", \"" + user.getNachname()
						+"\", \"" + user.getPassword()
						+"\")");
				pstmt2.executeUpdate();
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("jsp/indexNoUser.jsp?register=1");
				dispatcher.forward(request, response);
			}
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