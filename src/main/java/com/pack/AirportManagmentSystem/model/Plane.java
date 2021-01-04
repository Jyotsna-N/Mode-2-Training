package com.pack.AirportManagmentSystem.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="plane")
public class Plane {
@Id
private long planeId;
private String fromPlace;
private String toPlace;
@OneToOne(fetch=FetchType.EAGER)
private Pilot pilot;

@OneToOne(fetch=FetchType.EAGER)
private Hanger hanger;


public Plane(long planeId, Hanger hanger) {
	super();
	this.planeId = planeId;
	this.hanger = hanger;
}

public Hanger getHanger() {
	return hanger;
}
public void setHanger(Hanger hanger) {
	this.hanger = hanger;
}
public Plane(long planeId, String fromPlace, String toPlace, Pilot pilot) {
	super();
	this.planeId = planeId;
	this.fromPlace = fromPlace;
	this.toPlace = toPlace;
	this.pilot = pilot;
}
public Pilot getPilot() {
	return pilot;
}
public void setPilot(Pilot pilot) {
	this.pilot = pilot;
}
public long getPlaneId() {
	return planeId;
}
public void setPlaneId(long planeId) {
	this.planeId = planeId;
}
public String getFromPlace() {
	return fromPlace;
}
public void setFromPlace(String fromPlace) {
	this.fromPlace = fromPlace;
}
public String getToPlace() {
	return toPlace;
}
public void setToPlace(String toPlace) {
	this.toPlace = toPlace;
}
public Plane(long planeId, String fromPlace, String toPlace) {
	super();
	this.planeId = planeId;
	this.fromPlace = fromPlace;
	this.toPlace = toPlace;
}
public Plane() {
	super();
}


}
