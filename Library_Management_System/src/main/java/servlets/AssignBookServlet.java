package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import model.Book;
import daoimpl.BookDaoImpl;
import dao.BookDao;
import daoimpl.AssignBookDaoImpl;
import dao.AssignBookDao;
import model.AssignBook;
import model.User;
/**
 * Servlet implementation class AssignBookServlet
 */
public class AssignBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int userId=Integer.parseInt(request.getParameter("id"));
		String bookName=request.getParameter("bookName");
		BookDao bookDao=new BookDaoImpl();
		Book book=bookDao.getIdByName(bookName);
		User user=new User();
		user.setId(userId);
		AssignBookDao assignBookDao=new AssignBookDaoImpl();
		AssignBook assignBook=new AssignBook();
		assignBook.setBook(book);
		assignBook.setUser(user);
		boolean check=assignBookDao.assignBook(assignBook);
		HttpSession session=request.getSession();
			
			if(check) {
				session.setAttribute("SuccessMsg", "Book Assigned");
				response.sendRedirect("Users.jsp");
			}else {
				session.setAttribute("SuccessMsg", "Book Failed to Assign");
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
