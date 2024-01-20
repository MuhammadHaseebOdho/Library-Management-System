package dao;

import java.util.List;

import model.User;

public interface UserDao {

	public boolean addUser(User user);
	public List<User> getAllUsers();
	public User getUserById(Integer id);
	public boolean updateUser(User user);
	public boolean deleteUser(Integer id);
	public User totalUsers();
	public User getNameById(Integer id);
	
}
