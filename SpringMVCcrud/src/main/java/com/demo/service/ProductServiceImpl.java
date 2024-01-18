package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ProductDao;
import com.demo.model.Product;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDao pdao;

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return pdao.findAllproducts();
	}

	@Override
	public void addnewProperty(Product p) {
		pdao.save(p);
		
	}

	@Override
	public Product getById(int pid) {
		// TODO Auto-generated method stub
		return pdao.findById(pid);
	}

	@Override
	public void updateById(Product product) {
		pdao.modifyProduct(product);
		
		
	}

	@Override
	public void deleteProduct(int pid) {
		pdao.delete(pid);
	}

}
