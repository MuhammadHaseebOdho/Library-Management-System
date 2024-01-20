package dbconnection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class DbConnection {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getSession() {
		try {
			if(session==null) {
				configuration=new Configuration().configure("hibernate.cfg.xml");
				sessionFactory=configuration.buildSessionFactory();
				session=sessionFactory.openSession();
				System.out.println("session here:"+session);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		
		return session;
	}

	
}
