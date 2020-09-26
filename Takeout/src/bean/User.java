package bean;

public class User {
	private String id;
	private String username;
	private String password;
	private String phone;
	private String address;
	private String sex;
	private String type;
	
	public User() {
		
	}
	public User(String username, String password, String phone, String address, String sex, String type) {
		super();
		//this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
		this.sex = sex;
		this.type = type;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", phone=" + phone
				+ ", address=" + address + ", sex=" + sex + ", type=" + type + "]";
	}
	}

