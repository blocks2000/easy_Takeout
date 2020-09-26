package bean;

public class Order {
	private String id;
	private String ordertime;
	private String price;
	private String state;
	private String user_id;
	private String shopname;
	private String driver;
	
	//用户订单实体类
	public Order( String ordertime, String price, String state, String user_id) {
		super();
		this.ordertime = ordertime;
		this.price = price;
		this.state = state;
		this.user_id = user_id;
	}
	
	
	public Order(String id, String ordertime, String price, String state, String user_id,String shopname,String driver) {
		super();
		this.id = id;
		this.ordertime = ordertime;
		this.price = price;
		this.state = state;
		this.user_id = user_id;
		this.shopname=shopname;
		this.driver=driver;
	}
	
	public Order() {
		
	}


	public String getShopname() {
		return shopname;
	}


	public void setShopname(String shopname) {
		this.shopname = shopname;
	}


	public String getDriver() {
		return driver;
	}


	public void setDriver(String driver) {
		this.driver = driver;
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(String ordertime) {
		this.ordertime = ordertime;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	
	
}
