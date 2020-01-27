package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
    @NamedQuery(name="Customer.findAll", query= "from Customer"),
    @NamedQuery(name="Customer.findByUsername", query="from Customer")
})

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int userId;
	private String name;
	private String username;
	
	//ManyToOne Relationship (Multiple users can belong to one address)
	@ManyToOne  //What does this mean -> (cascade = CascadeType.ALL)
	private Address address;
	
	//Empty Constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Constructor With Details
	public Customer(String name, String username, Address address) {
		super();
		this.name = name;
		this.username = username;
		this.address = address;
	}
	
	
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "[userId=" + userId + ", name=" + name + ", username=" + username + ", address=" + address.getStreet()
				+ "]";
	}
}