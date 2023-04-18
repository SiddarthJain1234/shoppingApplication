package com.shoppingapp.ShoppingApp.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingapp.ShoppingApp.Service.ProductService;
import com.shoppingapp.ShoppingApp.dto.request.ServiceableDto;
import com.shoppingapp.ShoppingApp.dto.response.ProductPriceResponse;
import com.shoppingapp.ShoppingApp.dto.response.ProductResponseDto;
import com.shoppingapp.ShoppingApp.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@Autowired
	ProductRepository productRepo;
	
	//search
	@GetMapping("/searchn")
	public List<ProductResponseDto> searchByName(@RequestParam("name") String name) {
		return productService.searchByName(name);
	} 
	
	@GetMapping("/searchb")
	public List<ProductResponseDto> searchByBrand(@RequestParam("brand") String brand) {
		return productService.searchByBrand(brand);
	}
	
	@GetMapping("/searchc")
	public List<ProductResponseDto> searchByCode(@RequestParam("code") Integer code) {
		return productService.searchBycode(code);
	}
	
	
	//description of product
	@GetMapping("/productDescription")
	public String getProductDes(@RequestParam("code") Integer code) {
		return productRepo.findBycode(code).getDescription();
	}
	
	
	//serviceable or deliverable
	@RequestMapping("/checkServiceable")
	public String checkServiceable(@RequestBody ServiceableDto serviceableDto) {
		System.out.println(serviceableDto);
		return productService.checkServiceable(serviceableDto);
	}
	
	//get price of one or more products
	@GetMapping("/getPrice")
	public List<ProductPriceResponse> getPrice(@RequestBody List<Integer> productcodes) {
		return productService.getPrice(productcodes);
	} 	
	
	
	
	
	
	
}
