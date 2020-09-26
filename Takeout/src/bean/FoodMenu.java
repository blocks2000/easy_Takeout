package bean;

public class FoodMenu {
	private String id;
	private String name;
	private String des;
	private String imgurl;
	private String mark;
	private String price;
	private String merchant;
	
	
	public FoodMenu(String id, String name, String des, String imgurl, String mark,String price,String merchant) {
		super();
		this.id = id;
		this.name = name;
		this.des = des;
		this.imgurl = imgurl;
		this.mark = mark;
		this.price=price;
		this.merchant=merchant;
	}
	public FoodMenu(String name, String des, String imgurl,String mark) {
		super();
		this.mark=mark;
		this.name = name;
		this.des = des;
		this.imgurl = imgurl;
	}
	
	
	
	public String getMerchant() {
		return merchant;
	}
	public void setMerchant(String merchant) {
		this.merchant = merchant;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}
	public String getMark() {
		return mark;
	}
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	
}
