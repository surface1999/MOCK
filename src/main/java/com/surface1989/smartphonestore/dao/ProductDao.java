package com.surface1989.smartphonestore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surface1989.smartphonestore.model.Configure;
import com.surface1989.smartphonestore.model.Manufacture;
import com.surface1989.smartphonestore.model.Product;

@Repository
@Transactional
public class ProductDao {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> getAll() {
		Session session = sessionFactory.getCurrentSession();
		List<Product> rs = session.createQuery("from Product").list();
		session.flush();
		return rs;
	}
	
	public Product getProductById(Long productId) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, productId);
		session.flush();
		return product;
	}
	public void addProduct(Product product) {
		Session session = sessionFactory.getCurrentSession();
		List<Product> list = new ArrayList<Product>();
		list.add(product);
		product.getProductManufacture().setList(list);
		product.getConfigureOfProduct().setProduct(product);
		session.saveOrUpdate(product);
		session.saveOrUpdate(product.getProductManufacture());
		session.saveOrUpdate(product.getConfigureOfProduct());
		System.out.println(product.getProductName());
		session.flush();		
	}
	
	public void deleteProduct(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Product product = session.get(Product.class, id);
		Configure config = product.getConfigureOfProduct();
		session.delete(product);
		session.delete(config);
		session.flush();
	}
}
