package com.surface1989.smartphonestore.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.surface1989.smartphonestore.model.Configure;

@Repository
@Transactional
public class ConfigureDao {
	@Autowired
	private SessionFactory sessionFactory;

	public void addConfigure(Configure configure) {
		Session session = sessionFactory.getCurrentSession();
		session.save(configure);
		session.flush();
	}
}
