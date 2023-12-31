package com.fssa.blood.model;

public class User {

	private String name;
	private String email;
	private String password;
	private String address;
	private String phone;
	public boolean isDeleted;
	private int UserId;

	
	
	
	public int getUserId() {
		return UserId;
	}

	public void setUserId(int userId) {
		UserId = userId;
	}

	public User() {
	}

	public User(String name, String email, String password, String address, String phone, boolean isDeleted) {
		super();

		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
		this.isDeleted = isDeleted;
	}

	public User(String name, String email, String password, String address, String phone) {
		super();

		this.name = name;
		this.email = email;
		this.password = password;
		this.address = address;
		this.phone = phone;
	}

	public User(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public User(String email, boolean isDeleted) {
		super();
		this.email = email;
		this.isDeleted = isDeleted;
	}

	public User(int userid2, String name2, String email2, String password2, String address2, String phone2,
			int deleted) {
		// TODO Auto-generated constructor stub
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", email=" + email + ", password=" + password + ", address="
				+ address + ", phone=" + phone + ", isDeleted=" + isDeleted + ", UserId=" + UserId + "]";

	}
}