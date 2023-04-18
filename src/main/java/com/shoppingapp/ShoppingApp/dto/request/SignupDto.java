package com.shoppingapp.ShoppingApp.dto.request;

public class SignupDto {

	private String firstName;
	private String lastName;
	private String email;
	private String pwd;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public SignupDto(String firstName, String lastName, String email, String pwd) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pwd = pwd;
	}

	public SignupDto() {

	}

	
	
	

}
