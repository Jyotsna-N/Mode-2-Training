package com.pack.AirportManagmentSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pack.AirportManagmentSystem.dao.ManagerRepository;
import com.pack.AirportManagmentSystem.model.Manager;


@Service
public class ManagerServiceImpl implements ManagerService {

	@Autowired
	ManagerRepository managerRepository;
	@Override
	public Manager fetchUserByFirstNameAndPassword(String firstName, String password) {
		
		Manager manager= managerRepository.findByFirstNameAndPassword(firstName, password);
		return manager;
	}

	 public Manager saveManager(Manager manager) {
		
		      
		 Manager _manager = managerRepository.save(new Manager(manager.getFirstName(),manager.getLastName(), manager.getAge(),manager.getContactNumber(),manager.getPassword(),manager.getGender()));	     
	 return _manager;
	 }

	@Override
	public List<Manager> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
