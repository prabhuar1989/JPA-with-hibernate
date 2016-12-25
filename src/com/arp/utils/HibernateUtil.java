package com.arp.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class HibernateUtil {
	
	private static SessionFactory sessionFactory;
	
	static {
		try{
			Configuration cfg = new Configuration().configure();
			SchemaExport schemaExport = new SchemaExport(cfg);
			schemaExport.create(false, true);
			sessionFactory = cfg.buildSessionFactory();
		}catch(Throwable ex){
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

	public static void shutdown(){
		getSessionFactory().close();
	}
}
