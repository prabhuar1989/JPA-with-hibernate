package com.arp.testers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import com.arp.entities.Address;
import com.arp.entities.User;
import com.arp.utils.JPAUtil;

public class EntityValueTypeTester {
	private Logger logger = Logger.getLogger(EntityValueTypeTester.class);

	public static void main(String[] args) {
		EntityValueTypeTester tester = new EntityValueTypeTester();
		//tester.executeFirstUnitOfWork();
		tester.executeSecondUnitOfWork();
	}

	private void executeFirstUnitOfWork() {
		logger.info("executeFirstUnitOfWork - start");
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		logger.info("em - retrieved");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = getUser("Ramchandra");
		em.persist(user);
		/*if(null != id){
			logger.info("User with id :"+ id+" saved successfully !!");
		}else{
			logger.info("Something went wrong while persistence !!");
		}*/
		tx.commit();
		em.close();
	}
	
	private void executeSecondUnitOfWork(){
		logger.info("executeSecondUnitOfWork - start");
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		logger.info("em - retrieved");
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		User user = em.find(User.class, 1);
		if(null != user){
			logger.info("User with id :"+ user.getId()+" retrieved !!");
		}else{
			logger.info("Something went wrong while retrieving user !!");
		}
		tx.commit();
		em.close();
	}

	private User getUser(String username) {
		User user = new User();
		user.setUserName(username);
		user.setAge(27);
		user.setHomeAddress(new Address("Ramkrishna bldg", "Manvelpada road", "Mumbai"));
		user.setOfficeAddress(new Address("Capgemini", "Airoli", "Mumbai"));
		return user;
	}
}
