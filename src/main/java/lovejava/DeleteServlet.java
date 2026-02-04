package lovejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  int id = Integer.parseInt(request.getParameter("id"));

	        Model m = new Model();
	        int result = m.delete(id);

	        response.sendRedirect(request.getContextPath() + "/view.jsp");
	    }
	
	}


