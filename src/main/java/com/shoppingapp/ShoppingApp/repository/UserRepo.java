package com.shoppingapp.ShoppingApp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.shoppingapp.ShoppingApp.model.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Integer> {

	public UserEntity findByemail(String email);

}
