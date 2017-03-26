package com.arp.testers;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.arp.entities.Message;
import com.arp.utils.HibernateUtil;

public class HelloWorld {
	private Logger logger = Logger.getLogger(HelloWorld.class);

	public static void main(String[] args) {
		HelloWorld hello = new HelloWorld();
		Long messageID = hello.executeFirstUnitOfWork();
		hello.executeSecondUnitOfWork();
		hello.executeThirdUnitOfWork(messageID);
		HibernateUtil.shutdown();
	}

	private Long executeFirstUnitOfWork() {
		logger.info("executeFirstUnitOfWork - start");
		Session session = HibernateUtil.getSessionFactory().openSession();
		logger.info("session - retrieved");
		Transaction tx = session.beginTransaction();
		Message message = new Message("Hello World");
		Long messageID = (Long) session.save(message);
		logger.info("message save with id - " + messageID+" and message - "+message.getText());
		tx.commit();
		session.close();
		return messageID;
	}
	
	private void executeSecondUnitOfWork() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		@SuppressWarnings("unchecked")
		List<Message> messages = session.createQuery("from Message m order by m.text asc").list();
		if(null!=messages){
		 logger.info("number of messages retrieved - "+messages.size());
		 for(Iterator<Message> iterator = messages.iterator(); iterator.hasNext();){
			 Message loadedMessage = iterator.next();
			 logger.info("loadedMessage is "+loadedMessage.getText());
		 }
		}
		tx.commit();
		session.close();
	}
	
	private void executeThirdUnitOfWork(Long messageID){
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Message message = (Message) session.get(Message.class,messageID);
		message.setText("Hello Mars");
		message.setNextMessage(new Message("Hello Mercury"));
		
		tx.commit();
		session.close();
	}

}
