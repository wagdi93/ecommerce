package com.tornado.ecommerce.controller;

import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tornado.ecommerce.business.service.ProductService;
import com.tornado.ecommerce.model.entity.Product;

@RestController
@RequestMapping("/tornado/client/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	@RequestMapping(value="/:id",method = RequestMethod.GET, produces = "application/json",consumes = "application/json")
	public Product getProduct(@PathParam("id") Long id){
		
		return productService.findOne(id);
	}
}
