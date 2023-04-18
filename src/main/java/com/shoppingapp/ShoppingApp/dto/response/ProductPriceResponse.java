package com.shoppingapp.ShoppingApp.dto.response;

public class ProductPriceResponse {

	private Integer code;
	private Integer price;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	
	
	public ProductPriceResponse(Integer code, Integer price) {
		super();
		this.code = code;
		this.price = price;
	}
	
	
	
	
}
