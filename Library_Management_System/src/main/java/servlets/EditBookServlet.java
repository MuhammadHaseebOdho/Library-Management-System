package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Book;
import daoimpl.BookDaoImpl;
import dao.BookDao;

import java.io.IOException;

/**
 * Servlet implementation class EditBookServlet
 */
public class EditBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(request.getParameter("id"));
		String title=request.getParameter("bookTitle");
		String author=request.getParameter("bookAuthor");
		String genre=request.getParameter("bookGenre");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Book book=new Book();
		book.setId(id);
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		book.setQuantity(quantity);
		BookDao bookDao=new BookDaoImpl();
		boolean check=bookDao.updateBook(book);
		HttpSession session=request.getSession();
		
		if(check) {
			session.setAttribute("SuccessMsg", "Book Updated");
			response.sendRedirect("Books.jsp");
		}else {
			session.setAttribute("SuccessMsg", "Book Failed to Update");
			response.sendRedirect("Books.jsp");
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
