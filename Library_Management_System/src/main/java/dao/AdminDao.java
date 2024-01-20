package dao;

import model.Admin;

public interface AdminDao {
	public Admin getLoginDetails(String name,String password);
	public boolean addUser(Admin admin);
}
