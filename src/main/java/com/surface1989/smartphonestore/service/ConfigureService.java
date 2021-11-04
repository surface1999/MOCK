package com.surface1989.smartphonestore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surface1989.smartphonestore.dao.ConfigureDao;
import com.surface1989.smartphonestore.model.Configure;

@Service
public class ConfigureService {
	@Autowired
	private ConfigureDao configureDao;
	
	public void addConfigure(Configure configure) {
		configureDao.addConfigure(configure);
	}

}
