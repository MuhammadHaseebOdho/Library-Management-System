package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.hibernate.Session;

import dao.AdminDao;
import dbconnection.DbConnection;
import model.Admin;

public class AdminDaoImpl implements AdminDao {
	Session session = DbConnection.getSession();

	@Override
	public Admin getLoginDetails(String name, String password) {
		try {
			session.beginTransaction();
			Admin admin = session.get(Admin.class, name);
			session.getTransaction().commit();
			System.out.println("session: "+session);
			//session.close();
			return admin;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addUser(Admin admin) {
		boolean success = true;
		try {
			session.beginTransaction();
			session.save(admin);
			session.getTransaction().commit();
		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

}
