package com.pack.AirportManagmentSystem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="pilot")
public class Pilot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long pilotId;
	private String pilotName;
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Plane_id")
	private Plane plane; 
	public Pilot(String pilotName, Plane plane) {
		super();
		this.pilotName = pilotName;
		this.plane = plane;
	}
	public Plane getPlane() {
		return plane;
	}
	public void setPlane(Plane plane) {
		this.plane = plane;
	}
	public long getPilotId() {
		return pilotId;
	}
	public void setPilotId(long pilotId) {
		this.pilotId = pilotId;
	}
	public String getPilotName() {
		return pilotName;
	}
	public void setPilotName(String pilotName) {
		this.pilotName = pilotName;
	}
	public Pilot( String pilotName) {
		super();
	
		this.pilotName = pilotName;
	}
	
	public Pilot(long pilotId, String pilotName) {
		super();
		this.pilotId = pilotId;
		this.pilotName = pilotName;
	}
	public Pilot() {
		super();
	}
	
}
