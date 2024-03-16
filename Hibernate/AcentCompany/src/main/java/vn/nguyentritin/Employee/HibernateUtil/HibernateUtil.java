package vn.nguyentritin.Employee.HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		// TODO Auto-generated method stub
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}

	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}
}
