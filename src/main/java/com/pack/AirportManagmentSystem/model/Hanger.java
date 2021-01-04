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
@Table(name="hangerdetails")
public class Hanger {
@Id
 @GeneratedValue(strategy = GenerationType.AUTO)
private long hangarId;
private String hangerName;
private String hangerCode;
@OneToOne(fetch=FetchType.EAGER)
@JoinColumn(name="Plane_id")
private Plane plane;
public Hanger(String hangerName, String hangerCode, Plane plane) {
	super();
	this.hangerName = hangerName;
	this.hangerCode = hangerCode;
	this.plane = plane;
}

public Hanger(long hangarId, Plane plane) {
	super();
	this.hangarId = hangarId;
	this.plane = plane;
}

public Hanger(long hangarId) {
	super();
	this.hangarId = hangarId;
}

public Plane getPlane() {
	return plane;
}
public void setPlane(Plane plane) {
	this.plane = plane;
}
public long getHangarId() {
	return hangarId;
}
public void setHangarId(long hangarId) {
	this.hangarId = hangarId;
}
public String getHangerName() {
	return hangerName;
}
public void setHangerName(String hangerName) {
	this.hangerName = hangerName;
}
public String getHangerCode() {
	return hangerCode;
}
public void setHangerCode(String hangerCode) {
	this.hangerCode = hangerCode;
}
public Hanger(long hangarId, String hangerName, String hangerCode) {
	super();
	this.hangarId = hangarId;
	this.hangerName = hangerName;
	this.hangerCode = hangerCode;
}
public Hanger(String hangerName, String hangerCode) {
	super();
	this.hangerName = hangerName;
	this.hangerCode = hangerCode;
}
public Hanger() {
	super();
}

}
