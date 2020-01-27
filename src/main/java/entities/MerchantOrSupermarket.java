//James Redmond c15339336
package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
//import javax.persistence.Table;

@NamedQueries({
	@NamedQuery(name="MerchantOrSupermarket.findAll", query= "from MerchantOrSupermarket"),
	@NamedQuery(name="MerchantOrSupermarket.findByUsername", query="from MerchantOrSupermarket")
})

@Entity
//@Table(name="supermarket")
public class MerchantOrSupermarket //POJO
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int merchid;
	//@Column(name="supermarket_names")if u want to create an extra column
	private String name;
	@OneToOne //Address is foreign key
	private Address address;
	@OneToMany (cascade = CascadeType.REMOVE) //Customer is foreign key
	private List<Customer> customer = new ArrayList<Customer>();

	//
	@ManyToMany
	private List<Products> products = new ArrayList<Products>();

	//Empty Constructor
	public MerchantOrSupermarket() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Constructor With Details
	public MerchantOrSupermarket(String name, Address address, List<Customer> customer, List<Products> products) {
		super();
		this.name = name;
		this.address = address;
		this.customer = customer;
		this.products = products;
	}
	
	//GETTERS & SETTERS
	public int getMerchid() {
		return merchid;
	}
	public void setMerchid(int merchid) {
		this.merchid = merchid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	//Getters & Setters for Address
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}

	//Getters & Setters for Customer
	public List<Customer> getCustomer() {
		return customer;
	}
	public void setCustomer(List<Customer> customer) {
		this.customer = customer;
	}

	//Getters & Setters for Products
	public List<Products> getProducts() {
		return products;
	}
	public void setProducts(List<Products> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "[merchid=" + merchid + ", name=" + name + "]";
	}
}