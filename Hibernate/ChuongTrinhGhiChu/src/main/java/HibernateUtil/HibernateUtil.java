package HibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory SESSION_FACTORY = build();

	private static SessionFactory build() {
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
