package entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="Address.findAll", query= "from Address"),
	@NamedQuery(name="Address.findByUsername", query="from Address")
})

@Entity
public class Address 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int addressId;
	private String City;
	private String Street;

	//Empty Constructor
		public Address() {
			super();
			// TODO Auto-generated constructor stub
		}

		//Constructor With Details
		public Address(String City, String Street) {
			super();
			this.City = City;
			this.Street = Street;
		}

	//GETTERS & SETTERS
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getStreet() {
		return Street;
	}
	public void setStreet(String street) {
		Street = street;
	}
	
	@Override
	public String toString() {
		return "[addressId=" + addressId + ", City=" + City + ", Street=" + Street + "]";
	}
}