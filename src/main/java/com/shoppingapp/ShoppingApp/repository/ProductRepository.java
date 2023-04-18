package com.shoppingapp.ShoppingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.ShoppingApp.dto.response.ProductResponseDto;
import com.shoppingapp.ShoppingApp.model.ProductEntity;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {

	List<ProductEntity> findByname(String name);

	List<ProductEntity> findBybrand(String brand);

	ProductEntity findBycode(Integer code);
	
	
}
