//James Redmond c15339336
package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import entities.Address;
import entities.Customer;

public class CustomerDAO {
	Configuration config;
	SessionFactory sFactory;
	public CustomerDAO() {
		this.config = new Configuration();
		config.configure("hibernate.cfg.xml");
		this.sFactory=HibernateUtil.getSessionFactory();
	}

	public void saveCustomer(Customer cust) {
		try {
			Session sObj = sFactory.openSession();
			Transaction transactionObj = sObj.beginTransaction();
			sObj.save(cust);
			transactionObj.commit();
			sObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}