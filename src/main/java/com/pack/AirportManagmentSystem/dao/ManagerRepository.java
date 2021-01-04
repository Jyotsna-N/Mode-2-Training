package com.pack.AirportManagmentSystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.pack.AirportManagmentSystem.model.Manager;

public interface ManagerRepository extends CrudRepository<Manager, Long> {

	public Manager findByFirstNameAndPassword(String firstName,String password);
}
