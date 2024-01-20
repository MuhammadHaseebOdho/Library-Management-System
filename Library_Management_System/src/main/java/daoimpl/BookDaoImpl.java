package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Query;

import dao.BookDao;
import dbconnection.DbConnection;
import model.Book;

public class BookDaoImpl implements BookDao {

	Session session = DbConnection.getSession();

	@Override
	public boolean addBook(Book book) {
		boolean success = true;
		try {
			session.beginTransaction();
			session.persist(book);
			session.getTransaction().commit();

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean updateBook(Book book) {
		boolean success = true;
		try {
			session.beginTransaction();
			session.merge(book);
			session.getTransaction().commit();
		} catch (Exception ex) {
			success = false;
			ex.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteBook(Integer id) {
		boolean success = true;
		try {
			session.beginTransaction();
			session.remove(id);
			session.getTransaction().commit();
		} catch (Exception ex) {
			success = false;
			ex.printStackTrace();
		}
		return success;
	}

	@Override
	public List<Book> getAllBook() {
		List<Book> getAllBooksList = new ArrayList<>();
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Get_All_Books_Query);
			 * ResultSet rst = ps.executeQuery(); while (rst.next()) { Book book = new
			 * Book(); book.setId(rst.getInt("id"));
			 * book.setTitle(rst.getString("book_title"));
			 * book.setAuthor(rst.getString("book_author"));
			 * book.setGenre(rst.getString("book_genre"));
			 * book.setQuantity(rst.getInt("quantity")); getAllBooksList.add(book); }
			 */
			session.beginTransaction();
			getAllBooksList=session.createQuery("from books").list();
			session.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAllBooksList;
	}

	@Override
	public Book totalBooks() {
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Total_Books); ResultSet
			 * rst = ps.executeQuery();
			 * 
			 * while (rst.next()) { Book book = new Book();
			 * book.setTotalBooks(rst.getInt("Total")); return book; }
			 */
			
			Query query = session.createQuery("SELECT COUNT(*) FROM books");
            int rowCount = (int) query.uniqueResult();
            session.getTransaction().commit();
            Book book=new Book();
            book.setTotalBooks(rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookById(Integer id) {
		try {
			session.beginTransaction();
			Book book = session.get(Book.class, id);
			session.getTransaction().commit();
			return book;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Book> getBookDetails() {
		List<Book> getAllBooksDetails = new ArrayList<>();
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Get_Book_Details);
			 * ResultSet rst = ps.executeQuery();
			 * 
			 * while (rst.next()) { Book book = new Book(); book.setId(rst.getInt("id"));
			 * book.setTitle(rst.getString("book_title")); getAllBooksDetails.add(book); }
			 */
			session.beginTransaction();
			getAllBooksDetails=session.createQuery("from books").list();
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return getAllBooksDetails;
	}

	@Override
	public String getNameById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Book getIdByName(String name) {
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Get_Book_Id_By_Name);
			 * ps.setString(1, name); ResultSet rst = ps.executeQuery();
			 * 
			 * while (rst.next()) { Book book = new Book(); book.setId(rst.getInt("id"));
			 * return book; }
			 */
			session.beginTransaction();
			Book book=session.get(Book.class, name);
			session.getTransaction().commit();
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
