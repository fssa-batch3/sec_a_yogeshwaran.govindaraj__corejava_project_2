package bloodmodel;

public class User {
	public String name;
	public String email;
	public String password;
	public String address;
	public String phone;
	public String id;
	
	public User(String name,String email,String password,String address,String phone,String id) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.id = id;
	}
	
	
	public User(String email, String password) {
	this.email = email;
	this.password = password;
	}
	
	public User(String email) {
	this.email = email;
	}
	
	//setter
	public void setname(String name) {
		this.name = name;
	}
	public void setemail(String email) {
		this.email = email;
	}
	public void setpassword(String password) {
		this.password = password;
	}
	public void setaddress(String address) {
		this.address = address;
	}
	public void setphone(String phone) {
		this.phone = phone;
	}
	public void setid(String id) {
		this.id = id;
	}
	
	//getter
	
	public String getname() {
		return name;
	}
	
	public String getemail() {
		return email;
	}
	
	public String getpassword() {
		return password;
	}
	
	public String getaddress() {
		return address;
	}
	public String getphone(){
		return phone;
	}
	
	public String getid() {
		return id;
	}
}
