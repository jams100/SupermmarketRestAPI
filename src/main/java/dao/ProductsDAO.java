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

import entities.Customer;
//import entities.Customer;
import entities.Products;

public class ProductsDAO {

	Configuration config;
	SessionFactory sFactory;
	public ProductsDAO() {
		this.config = new Configuration();
		config.configure("hibernate.cfg.xml");
		this.sFactory=HibernateUtil.getSessionFactory();
	}

	public void saveProduct(Products prod) {
		try {
			Session sObj = sFactory.openSession();
			Transaction transactionObj = sObj.beginTransaction();
			sObj.save(prod);
			transactionObj.commit();
			sObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
}
