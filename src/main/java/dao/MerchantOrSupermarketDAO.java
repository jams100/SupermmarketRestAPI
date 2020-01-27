package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entities.Address;
import entities.MerchantOrSupermarket;

public class MerchantOrSupermarketDAO {
	Configuration config;
	SessionFactory sFactory;
	public MerchantOrSupermarketDAO() {
		this.config = new Configuration();
		config.configure("hibernate.cfg.xml");
		this.sFactory=HibernateUtil.getSessionFactory();
	}

	public void saveMerchant(MerchantOrSupermarket merchant) {
		try {
			Session sObj = sFactory.openSession();
			Transaction transactionObj = sObj.beginTransaction();
			sObj.save(merchant);
			transactionObj.commit();
			sObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public List<MerchantOrSupermarket> getAllMerchantOrSupermarket(){
		Session session=sFactory.openSession();
		Query query = session.createQuery("from MerchantOrSupermarket");
		List<MerchantOrSupermarket> supermarkets = query.list();
		session.close();
		return supermarkets;		
	}

	//NOT FINISHED
		public int updateSupermarket(MerchantOrSupermarket supermarket) {
			if (supermarket.getMerchid() <= 0)
				return 0;
			Session session=sFactory.openSession();
			Transaction tx = session.beginTransaction();
			String hql = "Update MerchantOrSupermarket set deptname = :name where id = :id";
			Query query = session.createQuery(hql);
			//query.setParameter("id", supermarket.getAddressId());
			//query.setParameter("name", supermarket.getAddressId());
			int rowCount = query.executeUpdate();

			System.out.println("Rows affected: " + rowCount);
			tx.commit();
			session.close();
			return rowCount;
		}

		//NOT FINISHED
		public int deleteMerchant(int id) {
			Session session= sFactory.openSession();
			Transaction transaction=session.beginTransaction();
			//FIX THIS
			String hql="delete from MerchantOrSupermarket where id= :id";
			Query query=session.createQuery(hql);
			query.setParameter("id", id);
			int rowCount=query.executeUpdate();
			System.out.println("Rows affected: " +rowCount);
			transaction.commit();
			session.close();
			return rowCount;
			
		}
}