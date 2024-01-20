package daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import dao.UserDao;
import dbconnection.DbConnection;
import model.Book;
import model.User;

public class UserDaoImpl implements UserDao {

	Session session = DbConnection.getSession();
	private static final String Insert_User_Query = "insert into user(name,email,description) values(?,?,?)";
	private static final String Total_Users = "SELECT COUNT(*) AS Total FROM user;";
	private static final String Get_All_Users = "SELECT * FROM USER";
	private static final String Update_User = "update user set name=?,email=?,description=? where id=?";
	private static final String Get_User_By_Id = "SELECT * FROM USER where id=?";
	private static final String Delete_User = "delete from user where id=?;";
	private static final String Get_User_Name_By_Id = "select name from user where id=?;";

	@Override
	public boolean addUser(User user) {
		boolean success = true;
		try {
			/*
			 * PreparedStatement ps=connection.prepareStatement(Insert_User_Query);
			 * ps.setString(1,user.getName()); ps.setString(2,user.getEmail());
			 * ps.setString(3,user.getDescription()); ps.execute();
			 */
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();

		} catch (Exception e) {
			success = false;
			e.printStackTrace();
		}
		return success;
	}

	@Override
	public List<User> getAllUsers() {
		List<User> getUsers = new ArrayList<>();
		try {
			/*
			 * PreparedStatement ps=connection.prepareStatement(Get_All_Users); ResultSet
			 * rst=ps.executeQuery(); while(rst.next()) { User user=new User();
			 * user.setId(rst.getInt("id")); user.setName(rst.getString("Name"));
			 * user.setEmail(rst.getString("email"));
			 * user.setDescription(rst.getString("description")); getUsers.add(user); }
			 */
			session.beginTransaction();
			getUsers = session.createQuery("from user").list();
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return getUsers;
	}

	@Override
	public User getUserById(Integer id) {
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Get_User_By_Id);
			 * ps.setInt(1, id); ResultSet rst = ps.executeQuery();
			 * 
			 * while(rst.next()){ User user=new User(); user.setId(rst.getInt("id"));
			 * user.setName(rst.getString("name")); user.setEmail(rst.getString("email"));
			 * user.setDescription(rst.getString("description"));
			 * 
			 * return user; }
			 */
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateUser(User user) {
		boolean success = true;
		try {
			/*
			 * PreparedStatement ps=connection.prepareStatement(Update_User);
			 * ps.setString(1,user.getName()); ps.setString(2,user.getEmail());
			 * ps.setString(3,user.getDescription()); ps.setInt(4,user.getId());
			 * ps.execute();
			 */
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();

		} catch (Exception ex) {
			success = false;
			ex.printStackTrace();
		}
		return success;
	}

	@Override
	public boolean deleteUser(Integer id) {
		boolean success = true;
		try {
			/*
			 * PreparedStatement ps=connection.prepareStatement(Delete_User); ps.setInt(1,
			 * id); ps.execute();
			 */
			session.beginTransaction();
			session.delete(id);
			session.getTransaction().commit();

		} catch (Exception ex) {
			success = false;
			ex.printStackTrace();
		}
		return success;
	}

	@Override
	public User totalUsers() {
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Total_Users); ResultSet
			 * rst = ps.executeQuery();
			 * 
			 * while(rst.next()){ User user=new User();
			 * user.setTotalUsers(rst.getInt("Total")); return user; }
			 */
			Query query = session.createQuery("SELECT COUNT(*) FROM user");
			int rowCount = (int) query.uniqueResult();
			session.getTransaction().commit();
			User user = new User();
			user.setTotalUsers(rowCount);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getNameById(Integer id) {
		try {
			/*
			 * PreparedStatement ps = connection.prepareStatement(Get_User_By_Id);
			 * ps.setInt(1, id); ResultSet rst = ps.executeQuery();
			 * 
			 * while(rst.next()){ User user=new User(); user.setName(rst.getString("Name"));
			 * return user; }
			 */
			session.beginTransaction();
			User user = session.get(User.class, id);
			session.getTransaction().commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
