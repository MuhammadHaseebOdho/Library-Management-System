package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import dao.AssignBookDao;
import dbconnection.DbConnection;
import model.AssignBook;
import model.Book;
import model.User;

public class AssignBookDaoImpl implements AssignBookDao{
	
	Session session=DbConnection.getSession();
	
	/*
	 * private static final String
	 * Assign_Book="insert into assigned_books(user_id,book_id) values(?,?);";
	 * private static final String
	 * Get_Assigned_Books="SELECT a.`id`,b.book_title FROM assigned_books a\r\n" +
	 * "INNER JOIN books b ON  b.`id`=a.`book_id`\r\n" + "WHERE a.`user_id`=?;";
	 * 
	 * 
	 * private static final String
	 * Un_Assign_Book="delete from assigned_books where id=?;";
	 */
	@Override
	public boolean assignBook(AssignBook assignBook) {
		boolean success=true;
		try {
			session.beginTransaction();
			session.save(assignBook);
			session.getTransaction().commit();
		}catch(Exception ex) {
			success=false;
			ex.printStackTrace();
		}
		return success;
	}
	@Override
	public AssignBook getAssignedBooks(int userId) {
		
		try {
			session.beginTransaction();
			AssignBook assignBook=session.get(AssignBook.class, userId);
			session.getTransaction().commit();
			return assignBook;
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
		
	}
	@Override
	public boolean unAssignBook(int id) {
		// TODO Auto-generated method stub
		boolean success=true;
		try {
			session.beginTransaction();
			session.delete(id);
			session.getTransaction().commit();
			
		}catch(Exception ex) {
			success=false;
			ex.printStackTrace();
		}
		return success;
	}

}
