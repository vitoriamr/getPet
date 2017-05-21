package com.es.getpet.core.util;

import java.io.File;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			File config = new File("res/hibernate.cfg.xml");
			sessionFactory = new Configuration().configure(config).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Falha na inicialização da sessão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

}