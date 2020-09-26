package bean;

public class Single_order {
	private String id;
	private String order_id;
	private String quantity;
	private String single_price;
	private String menu_id;
	
	
	//单项菜品实体类
	public Single_order(String id, String order_id, String quantity, String single_price, String menu_id) {
		super();
		this.id = id;
		this.order_id = order_id;
		this.quantity = quantity;
		this.single_price = single_price;
		this.menu_id = menu_id;
	}
	
	
	
	
	public Single_order(String order_id, String quantity, String single_price, String menu_id) {
		super();
		this.order_id = order_id;
		this.quantity = quantity;
		this.single_price = single_price;
		this.menu_id = menu_id;
	}




	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public String getSingle_price() {
		return single_price;
	}
	public void setSingle_price(String single_price) {
		this.single_price = single_price;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	
	
}
