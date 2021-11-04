package com.surface1989.smartphonestore.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surface1989.smartphonestore.model.Manufacture;

@Repository
@Transactional
public class ManufactureDao {
	@Autowired
	private SessionFactory sessionFactory;
	public List<Manufacture> getAll(){
		Session session = sessionFactory.getCurrentSession();
		List<Manufacture> manufactures = session.createQuery("from Manufacture").list();
		session.flush();
		return manufactures;
	}
	
	public Manufacture getManufactureById(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Manufacture manufacture = session.get(Manufacture.class, id);
		session.flush();
		return manufacture;
	}

}
