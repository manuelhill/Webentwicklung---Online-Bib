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

import beans.User;

/**
 * Servlet
 */
@WebServlet("/userVerwaltungServlet")
public class userVerwaltungServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userVerwaltungServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		User user = new User();
		
		final PrintWriter out = response.getWriter();   
		response.setContentType("text/html;charset=UTF-8");  
			
		try {
			final Connection con = ds.getConnection(); 
					
			PreparedStatement pstmt = con.prepareStatement("SELECT * FROM database.user");
			ResultSet userQuery = pstmt.executeQuery();
			
			ArrayList<String> userID = new ArrayList<String>();
			ArrayList<String> username = new ArrayList<String>();
			ArrayList<String> vorname = new ArrayList<String>();
			ArrayList<String> nachname = new ArrayList<String>();
			ArrayList<String> password = new ArrayList<String>();
			
			while (userQuery.next()){
					user.setId(userQuery.getInt("id"));
					user.setUsername(userQuery.getString("username"));
					user.setVorname(userQuery.getString("vorname"));
					user.setNachname(userQuery.getString("nachname"));
					user.setPassword(userQuery.getString("passwort"));
			
					userID.add(user.getId().toString());
					username.add(user.getUsername());
					vorname.add(user.getVorname());
					nachname.add(user.getNachname());
					password.add(user.getPassword());
			}
			
			request.setAttribute("userid", userID);
			request.setAttribute("username", username);
			request.setAttribute("vorname", vorname);
			request.setAttribute("nachname", nachname);
			request.setAttribute("password", password);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/userAusgabe.jsp");
			dispatcher.forward(request, response);
			
		
			/*response.setContentType("text/plain");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().append("Loki");*/
			
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