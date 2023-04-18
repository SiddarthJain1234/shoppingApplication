package com.shoppingapp.ShoppingApp.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.ShoppingApp.model.AuthenticationToken;
import com.shoppingapp.ShoppingApp.repository.TokenRepository;

@Service
public class AuthenticationService {

	@Autowired
	TokenRepository tokenRepository;
	
	public void savetoken(AuthenticationToken authenticationToken) {
		tokenRepository.save(authenticationToken);
	}


	

}
