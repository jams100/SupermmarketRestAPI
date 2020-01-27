package product;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import dao.AddressDAO;
import dao.CustomerDAO;
import dao.MerchantOrSupermarketDAO;
import dao.ProductsDAO;
import entities.Address;
import entities.Customer;
import entities.MerchantOrSupermarket;
import entities.Products;


@Path("/sampleproduct")
public class Action {
	private static List<Address> address;
	private static List<MerchantOrSupermarket> merchOrSuper;
	private static List<Products> product;
	private static List<Customer> customer;

	private static Address add, add1;
	private static MerchantOrSupermarket merch, merch1;
	private static Customer cust, cust1;
	private static Products prod, prod1;


	static {
		// CREATING ADDRESS AND PERSISTING/SAVING
		add = new Address("Dublin", "Bride Street");
		AddressDAO adddao = new AddressDAO();
		adddao.saveAddress(add);
		System.out.println("1st Address table added" + add);

		// CREATING ADDRESS1 AND PERSISTING/SAVING
		add1 = new Address("Wicklow", "Brides Glen");
		AddressDAO adddao1 = new AddressDAO();
		adddao1.saveAddress(add1);
		System.out.println("2nd Address table added" + add1);

		// CREATING ARRAYLIST OF PRODUCTS
		ArrayList<Address> addrs = new ArrayList<Address>();
		addrs.add(add);
		addrs.add(add1);
		address = addrs; 


		// CREATING CUSTOMERS AND PERSISTING/SAVING
		cust = new Customer("James Redmond", "james100", add);
		CustomerDAO custdao = new CustomerDAO();
		custdao.saveCustomer(cust);
		System.out.println("1st Customer Added" + cust);

		// CREATING CUSTOMERS AND PERSISTING/SAVING
		cust1 = new Customer("John Kelly", "johnnie", add1);
		CustomerDAO custdao1 = new CustomerDAO();
		custdao1.saveCustomer(cust1);
		System.out.println("2nd Customer Added" + cust1);

		// CREATING ARRAYLIST OF CUSTOMERS
		ArrayList<Customer> allCustomers = new ArrayList<Customer>();
		allCustomers.add(cust);
		allCustomers.add(cust1);
		customer = allCustomers; 


		// CREATING PRODUCTS AND PERSISTING/SAVING
		prod = new Products("Tayto", "snacks", merchOrSuper);
		ProductsDAO proddao = new ProductsDAO();
		proddao.saveProduct(prod);
		System.out.println("1st Product Added" + prod);

		// CREATING PRODUCTS AND PERSISTING/SAVING
		prod1 = new Products("Cadbury 100g", "sweets", merchOrSuper);
		ProductsDAO proddao1 = new ProductsDAO();
		proddao1.saveProduct(prod1);
		System.out.println("2nd Product Added" + prod1);

		// CREATING ARRAYLIST OF PRODUCTS
		ArrayList<Products> allProducts = new ArrayList<Products>();
		allProducts.add(prod);
		allProducts.add(prod1);
		product = allProducts; 


		// CREATING MERCHANT AND PERSISTING/SAVING
		merch = new MerchantOrSupermarket("Tesco", add1, customer, product);
		MerchantOrSupermarketDAO merchdao = new MerchantOrSupermarketDAO();
		merch.getProducts().add(prod);//Adding product to merchant
		merchdao.saveMerchant(merch);
		System.out.println("1st Merchant Added" + merch);

		// CREATING MERCHANT1 AND PERSISTING/SAVING
		merch1 = new MerchantOrSupermarket("Supervalu", add, customer, product);
		MerchantOrSupermarketDAO merchdao1 = new MerchantOrSupermarketDAO();
		merch1.getProducts().add(prod1);//Adding product1 to merchant1
		merchdao1.saveMerchant(merch1);
		System.out.println("2nd Merchant Added" + merch1);

		// CREATING ARRAYLIST OF MERCHANTS
		ArrayList<MerchantOrSupermarket> merchs = new ArrayList<MerchantOrSupermarket>();
		merchs.add(merch);
		merchs.add(merch1);
		merchOrSuper = merchs; 
		
	}

	//DISPLAY ALL ADDRESSES
	@GET
	@Path("/all/address")
	@Produces("text/plain")
	public String address() {
		return address.toString();
	}

	//DISPLAY ALL MERCHANTS 
	@GET
	@Path("/all/supermarkets")
	@Produces("text/plain")
	public String merchs() {
		return merchOrSuper.toString();
	}

	//DISPLAY ALL CUSTOMERS
	@GET
	@Path("/all/customers")
	@Produces("text/plain")
	public String customers() {
		return customer.toString();
	}

	//DISPLAY ALL PRODUCTS
	@GET
	@Path("/all/products")
	@Produces("text/plain")
	public String products() {
		return product.toString();
	}
	
	
	//GET ALL PRODUCTS FROM A PARTICULAR MERCHANT:STRING
	@GET
	@Path("/user/{name}/{id}/getallproductsfrommerchant")
	@Produces("text/plain")
	public String getAllTracksUser(@PathParam("name") String name, @PathParam("id") int merchid) 
	{
		for(MerchantOrSupermarket m : merchOrSuper)
		{		
		if (name.equals(m.getName()) && merchid == (m.getMerchid())) {
			String greetings = "Hello merchant name: " + name + " Merchant id: " + merchid + "\n";

			ArrayList<Products> prods = new ArrayList<>();
			for (Products p : m.getProducts()) {
				prods.add(p);
			}
			return greetings + prods.toString();
		}
		}
		System.out.println("Incorrect user");
		return "Incorrect user";

	}
	
}
