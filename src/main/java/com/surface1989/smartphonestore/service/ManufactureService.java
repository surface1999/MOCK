package com.surface1989.smartphonestore.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.surface1989.smartphonestore.dao.ManufactureDao;
import com.surface1989.smartphonestore.model.Manufacture;

@Service
public class ManufactureService {
	@Autowired
	private ManufactureDao manufactureDao;

	public List<Manufacture> getAll() {
		return manufactureDao.getAll();
	}
	public Manufacture getManufactureById(Long id) {
		return manufactureDao.getManufactureById(id);
	}
}
