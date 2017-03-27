package com.arp.testers;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.apache.log4j.Logger;

import com.arp.entities.Address;
import com.arp.entities.Bike;
import com.arp.entities.Car;
import com.arp.entities.Land;
import com.arp.entities.Property;
import com.arp.entities.User;
import com.arp.entities.Vehicle;
import com.arp.utils.JPAUtil;

public class InheritenceMappingTester {

	private Logger logger = Logger.getLogger(InheritenceMappingTester.class);
	
	/**
	 * This class and its child Car and Bike represents the inheritance mapping 
	 * scenario 1 : Table per concrete class with implicit polymorphism
	 * @author Ashwin
	 *
	 */
	public static void main(String[] args) {
		InheritenceMappingTester tester = new InheritenceMappingTester();
		//tester.tablePerConcreteClass();
		//tester.tablePerHeirarchy();
	}
	
	private void tablePerConcreteClass() {
		logger.info("tablePerConcreteClass - start");
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Creating user object..");
		User user = getUser("person 1",33);
		/*vehicle -  table per concrete class */
		Car car = new Car();
		/**
		 * very important thing to note is : you cannot use auto increment feature in hibernate
		 *  while using this type of inheritance strategy - one table per concrete class without polymorphism.
		 *  Hence you have to set id explicitly.. as there cannot be the same ID in multiple concrete classes..!!
		 *  Hence it prevents  polymorphism in real
		 */
		car.setId(3);
		car.setColor("Blue");
		car.setSeater(11);
		user.setVehicle(car);
		
		logger.info("Saving user object..");
		em.persist(user);
		tx.commit();
		em.close();
	}
	
	private void tablePerHeirarchy() {
		/**
		 * Property attribute is set by the strategy of one table per entire hierarchy..
		 * 
		 */
		logger.info("tablePerHeirarchy - start");
		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		logger.info("Creating user object..");
		User user = getUser("Ashwin",27);
		
		/*vehicle -  table per concrete class */
		Bike bike = new Bike();
		bike.setColor("black");
		bike.setId(1);
		bike.setSpeedometer("Digital");
		user.setVehicle(bike);
		
		/*property - table per hierarchy */
		Land land = new Land();
		land.setCurrentValue(500000);
		land.setLocation("Walkeshwar");
		land.setName("Construction Land");
		user.setProperty(land);
		
		logger.info("Saving user object..");
		em.persist(user);
		tx.commit();
		em.close();
	}
	
	private User getUser(String username,int age) {
		User user = new User();
		user.setUserName(username);
		user.setAge(age);
		user.setHomeAddress(new Address("Ramkrishna bldg", "Manvelpada road", "Mumbai"));
		user.setOfficeAddress(new Address("Microsoft", "Majestic", "Bangalore"));
		return user;
	}

}
