package com.capgemini.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.model.Cart;
import com.capgemini.model.Product;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	@Query(value = "select cp.product from Cart cp where cp.id=?1")
	public List<Product> getProductInCart(int id);
}
