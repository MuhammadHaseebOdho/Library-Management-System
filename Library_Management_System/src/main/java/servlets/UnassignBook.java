package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.AssignBookDao;
import daoimpl.AssignBookDaoImpl;

/**
 * Servlet implementation class UnassignBook
 */
public class UnassignBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UnassignBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		AssignBookDao assignBookDao=new AssignBookDaoImpl();
		boolean check=assignBookDao.unAssignBook(id);
		HttpSession session=request.getSession();
		if(check) {
			session.setAttribute("SuccessMsg", "Book UnAssigned");
			response.sendRedirect("Users.jsp");
		}else {
			session.setAttribute("SuccessMsg", "Failed to Unassign.");
			response.sendRedirect("Users.jsp");
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
