package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.User;

import java.io.IOException;


import dao.UserDao;

import daoimpl.UserDaoImpl;

/**
 * Servlet implementation class AddUserServlet
 */
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String email=request.getParameter("email");
		String description=request.getParameter("description");
		
		User user=new User();
		user.setName(name);
		user.setEmail(email);
		user.setDescription(description);
		UserDao userDao=new UserDaoImpl();
		boolean check=userDao.addUser(user);
		HttpSession session=request.getSession();
		
		if(check) {
			session.setAttribute("SuccessMsg", "User Addedd");
			response.sendRedirect("Users.jsp");
		}else {
			session.setAttribute("SuccessMsg", "User Failed to Add");
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
