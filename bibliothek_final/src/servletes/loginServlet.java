/**
 * @author: Manuel Hill
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
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
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
				user.setVorname(userQuery.getString("vorname"));
				user.setNachname(userQuery.getString("nachname"));
				user.setAdmin(userQuery.getInt("admin"));
			
				HttpSession session=request.getSession();
				//session.setAttribute("user", user);
				session.setAttribute("username", user.getUsername());
				session.setAttribute("vorname", user.getVorname());
				session.setAttribute("nachname", user.getNachname());
				session.setAttribute("admin", user.getAdmin());
				response.setStatus(HttpServletResponse.SC_OK);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("bibliothekForUserServlet");
				dispatcher.forward(request, response);
			}
			else 
			{
				/*out.println("Login Fehlgeschlagen");
				out.println("<a href=\"index.jsp\">Index</a>");*/
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