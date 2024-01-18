package com.demo.service;

import java.util.List;

import com.demo.model.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addnewProperty(Product p);

	Product getById(int pid);

	void updateById(Product product);

	void deleteProduct(int pid);

}
