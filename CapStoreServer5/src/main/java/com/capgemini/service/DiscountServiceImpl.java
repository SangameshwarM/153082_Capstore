package com.capgemini.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.model.Discount;
import com.capgemini.model.Product;
import com.capgemini.repository.CartRepository;
import com.capgemini.repository.DiscountRepo;

@Service
public class DiscountServiceImpl implements DiscountService {
	@Autowired
	private CartRepository cartRepositry;
	@Autowired
	private DiscountRepo discountRepository;

	public void calculateDiscount(int id) {
		List<Product> products = cartRepositry.getProductInCart(id);
		for (Product product : products) {
			if (product.getDiscount() != null) {
				LocalDate localDate = LocalDate.now();
				Date date = Date.valueOf(localDate);
				if (date.before(product.getDiscount().getEndTime())) {
					Discount discount = product.getDiscount();
					discount.setDiscountedPrice((float) ((product.getCost())
							- (product.getCost() * (0.01 * discount.getDiscountPercentage()))));
					discountRepository.save(discount);
				} else {
					Discount discount = product.getDiscount();
					discount.setDiscountedPrice(product.getCost());
					discountRepository.save(discount);
				}
			}
		}
	}
}
