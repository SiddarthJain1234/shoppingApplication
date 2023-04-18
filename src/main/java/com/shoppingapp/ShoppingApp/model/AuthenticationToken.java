package com.shoppingapp.ShoppingApp.model;



import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Token")
public class AuthenticationToken {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	private String token;
	
	@Column(name = "created_date")
	private Date createdDate;
	
	
	@OneToOne(targetEntity = UserEntity.class,fetch = FetchType.EAGER)
	@JoinColumn(nullable = false ,name = "user_id")
	private UserEntity userEntity;

	@Column(name = "email")
	private String email;
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public Date getCreatedDate() {
		return createdDate;
	}


	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}


	public UserEntity getUserEntity() {
		return userEntity;
	}


	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	
	
	
	
	
    public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public AuthenticationToken(UserEntity user) {
	userEntity=user;
	this.email=user.getEmail();
	createdDate=new Date();
	token=UUID.randomUUID().toString();
    }


	public AuthenticationToken() {
		
	}
	
	
	
	
	
}
