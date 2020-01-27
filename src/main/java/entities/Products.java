package entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="Products.findAll", query= "from Products"),
	@NamedQuery(name="Products.findByUsername", query="from Products")
})

@Entity
public class Products 
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int prodId;
	private String prodName;
	private String prodType;

	//Look up cascade type:
	@ManyToMany(mappedBy="products", cascade = CascadeType.REMOVE)
	private List<MerchantOrSupermarket> merchOrSuper = new ArrayList<MerchantOrSupermarket>();

	
	//Empty Constructor
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	//Constructor With Details
	public Products(String prodName, String prodType, List<MerchantOrSupermarket> merchOrSuper) {
		super();
		this.prodName = prodName;
		this.prodType = prodType;
		this.merchOrSuper = merchOrSuper;
	}
	
	//GETTERS & SETTERS 
	public int getProdId() {
		return prodId;
	}
	public void setProdId(int prodId) {
		this.prodId = prodId;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getProdType() {
		return prodType;
	}
	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	//Getters & Setters for merchOrSuper
	public List<MerchantOrSupermarket> getMerchOrSuper() {
		return merchOrSuper;
	}
	public void setMerchOrSuper(List<MerchantOrSupermarket> merchOrSuper) {
		this.merchOrSuper = merchOrSuper;
	}

	@Override
	public String toString() {
		return "Products [prodId=" + prodId + ", prodName=" + prodName + ", prodType=" + prodType + ", merchOrSuper="
				+ merchOrSuper + "]" + "\n";
	}
}
