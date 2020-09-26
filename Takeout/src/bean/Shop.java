package bean;

public class Shop {
	private String id;
	private String merchants;
	private String shopname;
	private String menu_id;
	private String desc;
	private String imgurl;
	public Shop(String id, String merchants, String shopname, String menu_id, String desc,String imgurl) {
		super();
		this.id = id;
		this.merchants = merchants;
		this.shopname = shopname;
		this.menu_id = menu_id;
		this.desc = desc;
		this.imgurl=imgurl;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMerchants() {
		return merchants;
	}
	public void setMerchants(String merchants) {
		this.merchants = merchants;
	}
	public String getShopname() {
		return shopname;
	}
	public void setShopname(String shopname) {
		this.shopname = shopname;
	}
	public String getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(String menu_id) {
		this.menu_id = menu_id;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
}
