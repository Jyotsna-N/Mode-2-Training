package com.pack.AirportManagmentSystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pack.AirportManagmentSystem.dao.AdminRepository;
import com.pack.AirportManagmentSystem.dao.HangerRepository;
import com.pack.AirportManagmentSystem.dao.ManagerRepository;
import com.pack.AirportManagmentSystem.dao.PilotRepository;
import com.pack.AirportManagmentSystem.dao.PlaneRepository;
import com.pack.AirportManagmentSystem.model.Admin;
import com.pack.AirportManagmentSystem.model.Hanger;
import com.pack.AirportManagmentSystem.model.Manager;
import com.pack.AirportManagmentSystem.model.Pilot;
import com.pack.AirportManagmentSystem.model.Plane;
import com.pack.AirportManagmentSystem.service.ManagerService;


@RestController
@RequestMapping("/api")
public class ManagerController {
	
	@Autowired
	ManagerService managerService;	
	@Autowired
	ManagerRepository managerRepository;
	@Autowired
	AdminRepository adminRepository;
	@Autowired
	PlaneRepository planeRepository;
	@Autowired
	PilotRepository pilotRepository;
	@Autowired
	HangerRepository hangerRepository;	
	
	@PostMapping(value = "/airportManagment/managerRegistration")
	@CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Manager> postManager(@RequestBody Manager manager) {
	    try {
	      Manager _manager =managerService.saveManager(manager);
	      return new ResponseEntity<>(_manager, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
		
	  } 
	
	@PostMapping(value = "/airportManagment/adminRegistration")
	@CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Admin> postAdmin(@RequestBody Admin admin) {
	    try {
	      Admin adminObject = adminRepository.save(new Admin(admin.getFirstName(),admin.getLastName(), admin.getAge(),admin.getContactNumber(),admin.getPassword(),admin.getGender()));
	     return new ResponseEntity<>(adminObject, HttpStatus.CREATED);
	    } catch (Exception e) {
	      return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
	    }
	  } 
	
	@PostMapping("/airportManagment/managerLogin")
	@CrossOrigin(origins="http://localhost:4200")
	public Manager login(@RequestBody Manager manager) throws Exception{
		String firstName=manager.getFirstName();
		String password=manager.getPassword();
		Manager managerObject=null;
		System.out.println("into login"+ manager.getFirstName());
		if(firstName != null && password != null) {
			managerObject = managerService.fetchUserByFirstNameAndPassword(firstName, password);
		}
		if(managerObject==null)
		{
			throw new Exception("Bad Credentials");
		}
		return managerObject;
		
	}
	
	@PostMapping("/airportManagment/adminLogin")
	@CrossOrigin(origins="http://localhost:4200")
	public Admin adminLogin(@RequestBody Admin admin) throws Exception{
		String firstName=admin.getFirstName();
		String password=admin.getPassword();
		Admin adminObject=null;
		if(firstName != null && password != null) {
			adminObject = adminRepository.findByFirstNameAndPassword(firstName, password);
		}
		if(adminObject==null)
		{
			throw new Exception("Bad Credentials");
		}
		return adminObject;
		
	}
	
	
	  @PostMapping(value = "/airportManagment/addPlane")
      @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Plane>
	  addPlane(@RequestBody Plane plane) {
		  try { 
			  Plane _plane = planeRepository.save(new Plane(plane.getPlaneId(),plane.getFromPlace(),plane.getToPlace()));
			  return new ResponseEntity<>(_plane, HttpStatus.CREATED);
			  } 
		  catch (Exception e) { 
			  return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			  } 
		  }
	 
	  @PostMapping(value = "/airportManagment/addPilot")
      @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Pilot> addPilot(@RequestBody Pilot pilot) {
		  try { 
			  Pilot _pilot = pilotRepository.save(new Pilot(pilot.getPilotName()));
			  return new ResponseEntity<>(_pilot, HttpStatus.CREATED);
			  } 
		  catch (Exception e) { 
			  return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			  } 
		  }

	  @PostMapping(value = "/airportManagment/addhanger")
      @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Hanger> addHanger(@RequestBody Hanger hanger) {
		  try { 
			  Hanger _hanger = hangerRepository.save(new Hanger(hanger.getHangerName(),hanger.getHangerCode()));
			  return new ResponseEntity<>(_hanger, HttpStatus.CREATED);
			  } 
		  catch (Exception e) { 
			  return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
			  } 
		  }


	  @GetMapping("/airportManagment")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<List<Plane>> viewPlanes()
	  {
		  List<Plane> planes = new ArrayList<Plane>();
		    try {
		      planeRepository.findAll().forEach(planes::add);
		     
		      if (planes.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(planes, HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  
	   
	  @GetMapping("/airportManagment/managers")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<List<Manager>> viewManagers()
	  {
		  List<Manager> managers = new ArrayList<Manager>();
		    try {
		      managerRepository.findAll().forEach(managers::add);
		     
		      if (managers.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(managers , HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @GetMapping("/airportManagment/pilots")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<List<Pilot>> viewPilots()
	  {
		  List<Pilot> pilots = new ArrayList<Pilot>();
		    try {
		      pilotRepository.findAll().forEach(pilots::add);
		     
		      if (pilots.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(pilots , HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @GetMapping("/airportManagment/hangers")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<List<Hanger>> viewHangers()
	  {
		  List<Hanger> hangers = new ArrayList<Hanger>();
		    try {
		      hangerRepository.findAll().forEach(hangers::add);
		     
		      if (hangers.isEmpty()) {
		        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		      }
		      return new ResponseEntity<>(hangers , HttpStatus.OK);
		    } catch (Exception e) {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
	  }
	  
	  @GetMapping("/airportManagment/{id}")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Plane> getPlaneById(@PathVariable("id") long id) {
	    Optional<Plane> Data = planeRepository.findById(id);

	    if (Data.isPresent()) {
	      return new ResponseEntity<>(Data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @GetMapping("/airportManagment/{id}/get")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Pilot> getPilotById(@PathVariable("id") long id) {
	    Optional<Pilot> Data = pilotRepository.findById(id);

	    if (Data.isPresent()) {
	      return new ResponseEntity<>(Data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @GetMapping("/airportManagment/{id}/getHanger")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<Hanger> getHangerById(@PathVariable("id") long id) {
	    Optional<Hanger> Data = hangerRepository.findById(id);

	    if (Data.isPresent()) {
	      return new ResponseEntity<>(Data.get(), HttpStatus.OK);
	    } else {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	  }
	  
	  @PutMapping(value="/airportManagment/update")
	  @CrossOrigin(origins="http://localhost:4200")
	  public Plane updatePlane(@RequestBody Plane plane) {
	      System.out.println("Into update");
	       Plane _plane = planeRepository.save(new Plane(plane.getPlaneId(),plane.getFromPlace(),plane.getToPlace()));
	    return _plane;
	  }
	  
	  @PutMapping(value="/airportManagment/Pilotupdate")
	  @CrossOrigin(origins="http://localhost:4200")
	  public Pilot updatePilot(@RequestBody Pilot pilot) {
	      System.out.println("Into update");
	       Pilot _pilot = pilotRepository.save(new Pilot(pilot.getPilotId(),pilot.getPilotName()));
	    return _pilot;
	  }
	  
	  @PutMapping(value="/airportManagment/planehangerupdate")
	  @CrossOrigin(origins="http://localhost:4200")
	  public Hanger updatePlaneHanger(@RequestBody Hanger hanger,@RequestBody Plane plane) {
	      System.out.println("Into update");
	       Hanger _plane = hangerRepository.save(new Hanger(hanger.getHangarId(),plane));
	    return _plane;
	  }
	  
	  @PutMapping(value="/airportManagment/hangerupdate")
	  @CrossOrigin(origins="http://localhost:4200")
	  public Hanger updateHanger(@RequestBody Hanger hanger) {
	      System.out.println("Into update");
	       Hanger _hanger = hangerRepository.save(new Hanger(hanger.getHangarId(),hanger.getHangerName(),hanger.getHangerCode()));
	    return _hanger;
	  }
	  
	  @DeleteMapping("/airportManagment/{id}")
	  @CrossOrigin(origins="http://localhost:4200")
	  public ResponseEntity<HttpStatus> deleteManager(@PathVariable("id") long id) {
	    try {
	      managerRepository.deleteById(id);
	      return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    } catch (Exception e) {
	      return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
	    }
	  }  
}
