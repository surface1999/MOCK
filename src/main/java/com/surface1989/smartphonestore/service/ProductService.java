package com.surface1989.smartphonestore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surface1989.smartphonestore.dao.ProductDao;
import com.surface1989.smartphonestore.model.Product;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getAll(){
		return productDao.getAll();
	}
	public Product getProductById(Long productId) {
		return productDao.getProductById(productId);
	}
	public void addProduct(Product product) {
		productDao.addProduct(product);
	}
	public void deleteProduct(Long id) {
		productDao.deleteProduct(id);
	}
}
