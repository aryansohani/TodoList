package lovejava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;


@WebServlet("/servletone")
public class servletone extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

        String task = request.getParameter("task");

        Model m = new Model();
        m.settask(task);

        int rowaffected = m.add();

        if (rowaffected == 0) {
            System.out.println("error");
        } else {
            // store model in session
            HttpSession session = request.getSession();
            session.setAttribute("model", m);

            response.sendRedirect(request.getContextPath() + "/view.jsp");
        }
    }
}