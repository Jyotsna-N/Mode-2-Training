package com.pack.AirportManagmentSystem.service;

import java.util.List;

import com.pack.AirportManagmentSystem.model.Manager;


public interface ManagerService {
 public Manager fetchUserByFirstNameAndPassword(String firstName,String password);
 public Manager saveManager(Manager manager);
 public List<Manager> findAll();
}
