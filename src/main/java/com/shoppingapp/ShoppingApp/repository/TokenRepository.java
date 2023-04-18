package com.shoppingapp.ShoppingApp.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.shoppingapp.ShoppingApp.model.AuthenticationToken;

@Repository
public interface TokenRepository extends JpaRepository<AuthenticationToken, Integer>{

	AuthenticationToken findByemail(String email);

	
	
}
