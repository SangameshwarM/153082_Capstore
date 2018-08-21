package com.capgemini.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.service.DiscountService;

@RestController
public class DiscountActionController {
	@Autowired
	private DiscountService discountService;

	@RequestMapping(value ="/discountCalculation")
	public void discountCalculation(int id) {
		discountService.calculateDiscount(id);
	}

}
