package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Book;

import java.io.IOException;

import dao.BookDao;
import daoimpl.BookDaoImpl;

/**
 * Servlet implementation class AddBookServlet
 */
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title=request.getParameter("bookTitle");
		String author=request.getParameter("bookAuthor");
		String genre=request.getParameter("bookGenre");
		int quantity=Integer.parseInt(request.getParameter("quantity"));
		Book book=new Book();
		book.setAuthor(author);
		book.setTitle(title);
		book.setGenre(genre);
		book.setQuantity(quantity);
		BookDao bookDao=new BookDaoImpl();
		boolean check=bookDao.addBook(book);
		HttpSession session=request.getSession();
		
		if(check) {
			session.setAttribute("SuccessMsg", "Book Addedd");
			response.sendRedirect("Books.jsp");
		}else {
			session.setAttribute("SuccessMsg", "Book Failed to Add");
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
