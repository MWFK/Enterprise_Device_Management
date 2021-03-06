package tn.esprit.javaee.evaluation1Serveur.persistence;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Device
 *
 */
@Entity

public class Device implements Serializable {   
	@Id
	private String uniqueIdentifier;
	private DeviceType deviceType;
	private String modelName;
	private Brand brand;
	@ManyToOne
	private Employee employee;
	private static final long serialVersionUID = 1L;

	public Device() {
		super();
	}
	
	
	public Device(String uniqueIdentifier, DeviceType deviceType, Brand brand) {
		this.deviceType=deviceType;
		this.brand=brand;
		this.uniqueIdentifier=uniqueIdentifier;
	}
	
	public Device(String uniqueIdentifier, DeviceType deviceType, String modelName, Brand brand) {
		this.uniqueIdentifier=uniqueIdentifier;
		this.deviceType=deviceType;
		this.modelName=modelName;
		this.brand=brand;
	}


	public String getUniqueIdentifier() {
		return this.uniqueIdentifier;
	}

	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}   
	public DeviceType getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}   
	public String getModelName() {
		return this.modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}   
	public Brand getBrand() {
		return this.brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	@Override
	public String toString() {
		return this.getModelName();
	}
}
