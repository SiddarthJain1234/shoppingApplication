package com.shoppingapp.ShoppingApp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.ShoppingApp.dto.request.ServiceableDto;
import com.shoppingapp.ShoppingApp.dto.response.ProductPriceResponse;
import com.shoppingapp.ShoppingApp.dto.response.ProductResponseDto;
import com.shoppingapp.ShoppingApp.model.ProductEntity;
import com.shoppingapp.ShoppingApp.repository.ProductRepository;
import com.shoppingapp.ShoppingApp.repository.TokenRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	TokenRepository tokenRepository;
	
	
	public List<ProductResponseDto> searchBycode(Integer code) {
		if(Objects.isNull(productRepository.findBycode(code))) {
			  //returning null dto so that it can be handled at frontend
				return new ArrayList<ProductResponseDto>();
		}
		List<ProductResponseDto> list=new ArrayList<ProductResponseDto>();
		list.add(convert(productRepository.findBycode(code)));
		return list;
	}
	
	public List<ProductResponseDto> searchByName(String name){
		if(productRepository.findByname(name).isEmpty()) {
			return new ArrayList<ProductResponseDto>();
		}
		List<ProductEntity> ls=productRepository.findByname(name);
		List<ProductResponseDto> list=new ArrayList<ProductResponseDto>();
		for(int i=0; i<ls.size(); i++) {
			list.add(convert(ls.get(i)));
		}
		return list;
		
	}
	
	public List<ProductResponseDto> searchByBrand(String brand){
		if(productRepository.findBybrand(brand).isEmpty()) {
			return new ArrayList<ProductResponseDto>();
		}
		List<ProductEntity> ls=productRepository.findBybrand(brand);
		List<ProductResponseDto> list=new ArrayList<ProductResponseDto>();
		
		for(int i=0; i<ls.size(); i++) {
			list.add(convert(ls.get(i)));
		}
		return list;
	}
	
	
	
	
	
	private ProductResponseDto convert(ProductEntity proEntity) {
		ProductResponseDto productResponseDto =new ProductResponseDto();
		productResponseDto.setName(proEntity.getName());
		productResponseDto.setBrand(proEntity.getBrand());
		productResponseDto.setUrl(proEntity.getUrl());
		productResponseDto.setCode(proEntity.getCode());
			
	    //if user is logged in
		if(!tokenRepository.findAll().isEmpty()) {
		productResponseDto.setDescription(proEntity.getDescription());
		productResponseDto.setLocation(proEntity.getLocation());
		productResponseDto.setPrice(proEntity.getPrice());
				
		}
		
		return productResponseDto;
		
	}

	public String checkServiceable(ServiceableDto serviceableDto) {
	Integer currentLocation=productRepository.findBycode(serviceableDto.getProductCode()).getLocation();
	Integer userPincode=serviceableDto.getUserPinCode();
	
	
	
	if(Math.abs(currentLocation-userPincode)<=20) {
		return "Product Deliverable, it will take 2-5 days";
	}
	else if(Math.abs(currentLocation-userPincode)<50 && Math.abs(currentLocation-userPincode)>20) {
		return "Product Deliverable, it will take 5-10 days";
	}
	else {
		return "Sorry, Product is not available at your place";
	}
	
	
	
	}

	public List<ProductPriceResponse> getPrice(List<Integer> productcodes) {
		
		List<ProductPriceResponse> list=new ArrayList<ProductPriceResponse>();
		
		for(int i=0; i<productcodes.size(); i++) {
			Integer price=productRepository.findBycode(productcodes.get(i)).getPrice();		 
			list.add(new ProductPriceResponse(productcodes.get(i), price));
		}
		
		return list;
	}
	
	
}
