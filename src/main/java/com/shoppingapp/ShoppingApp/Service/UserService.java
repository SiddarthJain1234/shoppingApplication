package com.shoppingapp.ShoppingApp.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shoppingapp.ShoppingApp.dto.request.SigninDto;
import com.shoppingapp.ShoppingApp.dto.request.SignupDto;
import com.shoppingapp.ShoppingApp.dto.response.ResponseDto;
import com.shoppingapp.ShoppingApp.model.AuthenticationToken;
import com.shoppingapp.ShoppingApp.model.UserEntity;
import com.shoppingapp.ShoppingApp.repository.TokenRepository;
import com.shoppingapp.ShoppingApp.repository.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AuthenticationService authenticationService;
	
	@Autowired
	TokenRepository tokenRepository;
	
	
	public ResponseDto createUser(SignupDto signupDto) {
		
	    if(Objects.nonNull(userRepo.findByemail(signupDto.getEmail()))) {
			//user already exist
	    	
			return new ResponseDto("Error", "Already registered!");
		}
	  
		
	    String encryptedpwd=null;
	    try {
	    	encryptedpwd=hashPassword(signupDto.getPwd());
	    }
	    
	    catch (Exception e) {
			e.printStackTrace();
		}
	    
	    
	    //create new user
		UserEntity user=new UserEntity();
		user.setEmail(signupDto.getEmail());
		user.setFirstName(signupDto.getFirstName());
		user.setLastName(signupDto.getLastName());
		user.setPwd(encryptedpwd);
		
		userRepo.save(user);
		
	
	 
	 return new ResponseDto("Success","Successfully Registered");
		
	}

	private String hashPassword(String pwd) throws NoSuchAlgorithmException {
		MessageDigest md=MessageDigest.getInstance("SHA-256");
		md.update(pwd.getBytes());
	    byte[] digest=md.digest();
	    String hash=DatatypeConverter.printHexBinary(digest).toUpperCase();
	    return hash;
	}
	
	
	public ResponseDto signin(SigninDto signinDto) throws NoSuchAlgorithmException {
		
		// validate
		if (Objects.nonNull(userRepo.findByemail(signinDto.getEmail()))) {

			// check if user is already logged in
			if (Objects.nonNull(tokenRepository.findByemail(signinDto.getEmail()))) {
				// user is already logged in some another tab

				return new ResponseDto("Error", "User is already logged in");

			} else {
				// check password and validate

				if (hashPassword(signinDto.getPwd()).equals(userRepo.findByemail(signinDto.getEmail()).getPwd())) {
					//token generation store email in token table
					AuthenticationToken authenticationToken=new AuthenticationToken(userRepo.findByemail(signinDto.getEmail()));
					 authenticationService.savetoken(authenticationToken);		
					
					return new ResponseDto("Success", "Successfully, logged in");
					
				} else {
					return new ResponseDto("Error", "Wrong Password");
				}

			}

		} else {
			// user email is incorrect
		
			return new ResponseDto("Error", "User Not Found!");
		}
			
	}
	
	public ResponseDto logout(String email) {
	if(Objects.isNull(tokenRepository.findByemail(email))) {
		return new ResponseDto("Erorr","User not logged in");
	}	
	else {	
		tokenRepository.deleteById(tokenRepository.findByemail(email).getId());
		return new ResponseDto("Success","logged out");
	}	
		
	}
	
	
	
}
