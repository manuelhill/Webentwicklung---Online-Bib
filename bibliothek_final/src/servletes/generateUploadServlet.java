/**
 * @author: Lukas Schütte, Manuel Hill
 */
package servletes;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import java.io.InputStream;
import javax.servlet.http.Part;

/**
 * Servlet
 */
@WebServlet("/generateUploadServlet")
@MultipartConfig

public class generateUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public generateUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Resource(lookup="jdbc/MyTHIPool")
	private DataSource ds;
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		final PrintWriter out = response.getWriter();
		
		Part filepart = request.getPart("cover");
		byte[] picturedata=null;
		
		try (ByteArrayOutputStream baos = new ByteArrayOutputStream();
				 InputStream in = filepart.getInputStream()	){
				int i=0;
				while ((i = in.read()) != -1) {
					baos.write(i);
				}
				picturedata = baos.toByteArray();
				baos.flush();
				
				ByteArrayInputStream bais = new ByteArrayInputStream(picturedata);
				BufferedImage image = ImageIO.read(bais);
				File output = new File("tmpImage.png");
				 
				ImageIO.write(image, "png", output);
				 
				request.setAttribute("image", output.getAbsolutePath());
				
				out.println("<html><body><img src='"+ output.getAbsolutePath() +"'></body></html>");
	    		
			} catch (IOException ex) {
				throw new ServletException(ex.getMessage());
			}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}