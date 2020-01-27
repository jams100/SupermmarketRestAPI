//James Redmond c15339336
package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import entities.Address;

public class AddressDAO {
	Configuration config;
	SessionFactory sFactory;
	public AddressDAO() {
		this.config = new Configuration();
		config.configure("hibernate.cfg.xml");
		this.sFactory=HibernateUtil.getSessionFactory();
	}

	public void saveAddress(Address address) {
		try {
			Session sObj = sFactory.openSession();
			Transaction transactionObj = sObj.beginTransaction();
			sObj.save(address);
			transactionObj.commit();
			sObj.close();
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}
	
	public List<Address> getAddresses(){
		Session session=sFactory.openSession();
		Query query = session.createQuery("from Address");
		List<Address> addresses = query.list();
		session.close();
		return addresses;		
	}
	
	//NOT FINISHED
	public int updateAddress(Address address) {
		if (address.getAddressId() <= 0)
			return 0;
		Session session=sFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "Update Address set deptname = :name where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", address.getAddressId());
		query.setParameter("name", address.getAddressId());
		int rowCount = query.executeUpdate();

		System.out.println("Rows affected: " + rowCount);
		tx.commit();
		session.close();
		return rowCount;
	}
	
	public int deleteAddress(int id) {
		Session session= sFactory.openSession();
		Transaction transaction=session.beginTransaction();
		//FIX THIS
		String hql="delete from Address where id= :id";
		Query query=session.createQuery(hql);
		query.setParameter("id", id);
		int rowCount=query.executeUpdate();
		System.out.println("Rows affected: " +rowCount);
		transaction.commit();
		session.close();
		return rowCount;
		
	}
}