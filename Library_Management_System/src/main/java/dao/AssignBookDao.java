package dao;

import java.util.List;

import model.AssignBook;

public interface AssignBookDao {
	public boolean assignBook(AssignBook assignBook);
	public AssignBook getAssignedBooks(int userId);
	public boolean unAssignBook(int id);
}
