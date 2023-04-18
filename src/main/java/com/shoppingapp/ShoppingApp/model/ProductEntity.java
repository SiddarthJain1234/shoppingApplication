package com.shoppingapp.ShoppingApp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.type.TrueFalseType;

@Entity
@Table(name = "Product")
public class ProductEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="product_id")
	private Integer productId;
	
	private String name;
	
	@Column(unique = true)
	private Integer code;
	
	private String brand;
	
	private Integer price;
	
	private String description;
	
	private String url;
	
	private Integer location;

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ProductEntity() {
	
	}

	public ProductEntity(Integer productId, String name, Integer code, String brand, Integer price, String description,
			String url, Integer location) {
		super();
		this.productId = productId;
		this.name = name;
		this.code = code;
		this.brand = brand;
		this.price = price;
		this.description = description;
		this.url = url;
		this.location = location;
	}

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "ProductEntity [productId=" + productId + ", name=" + name + ", code=" + code + ", brand=" + brand
				+ ", price=" + price + ", description=" + description + ", url=" + url + ", location=" + location + "]";
	}

	
    
	
	
	
	
}