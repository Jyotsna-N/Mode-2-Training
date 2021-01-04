package com.pack.AirportManagmentSystem.dao;

import org.springframework.data.repository.CrudRepository;

import com.pack.AirportManagmentSystem.model.Admin;

public interface AdminRepository extends CrudRepository<Admin, Long> {

	public Admin findByFirstNameAndPassword(String firstName,String password);

}