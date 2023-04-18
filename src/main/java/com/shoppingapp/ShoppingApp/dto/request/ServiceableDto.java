package com.shoppingapp.ShoppingApp.dto.request;

public class ServiceableDto {

	private Integer productCode;
	private Integer userPinCode;
	
	
	public Integer getProductCode() {
		return productCode;
	}
	
	public void setProductCode(Integer productCode) {
		this.productCode = productCode;
	}
	
	
	
	public Integer getUserPinCode() {
		return userPinCode;
	}

	public void setUserPinCode(Integer userPinCode) {
		this.userPinCode = userPinCode;
	}

	public ServiceableDto() {
		
	}

	@Override
	public String toString() {
		return "ServiceableDto [productCode=" + productCode + ", userPinCode=" + userPinCode + "]";
	}

	
	
	
	
	
}
