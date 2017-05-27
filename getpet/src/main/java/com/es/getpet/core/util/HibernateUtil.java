package com.es.getpet.core.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			sessionFactory = new Configuration().configure(HibernateUtil.class.getResource("/res/hibernate.cfg.xml")).buildSessionFactory();
		} catch (Throwable ex) {
			System.err.println("Falha na inicialização da sessão." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void fechaSessao() {
		sessionFactory.close();
	}

}