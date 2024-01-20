package dao;

import java.util.List;

import model.Book;

public interface BookDao {
	public boolean addBook(Book book);
	public boolean updateBook(Book book);
	public boolean deleteBook(Integer id);
	public List<Book> getAllBook();
	public Book totalBooks();
	public Book getBookById(Integer id);
	public List<Book> getBookDetails();
	public String getNameById(Integer id);
	public Book getIdByName(String name);
	
}
