package com.capgemini.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.model.Discount;
@Repository
public interface DiscountRepo  extends JpaRepository<Discount,Integer>{
	
	

}
