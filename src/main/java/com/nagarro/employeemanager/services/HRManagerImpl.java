package com.nagarro.employeemanager.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.employeemanager.dao.HRDAOImpl;
import com.nagarro.employeemanager.model.HR;

@Service
public class HRManagerImpl implements HRManager {

	@Autowired
	HRDAOImpl dao;

	public HR validateHR(HR hr) {
		return dao.validateHR(hr);
	}

}
