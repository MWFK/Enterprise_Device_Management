package tn.esprit.javaee.evaluation1Serveur.presentation.mbeans;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import tn.esprit.javaee.evaluation1Serveur.persistence.Brand;
import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.DeviceType;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;
import tn.esprit.javaee.evaluation1Serveur.services.DeviceService;

@ManagedBean
@SessionScoped
public class DeviceBean {
	private String uniqueIdentifier;
	private DeviceType deviceType;
	private String modelName;
	private Brand brand;
	private Employee employee;
	private Long selectedEmployeeMatricule;
    
	@EJB
	DeviceService deviceService;

	
	public String addDevice(){
		String navigateTo="null";
	    deviceService.ajouterDevice(new Device(uniqueIdentifier, deviceType, modelName, brand));	
		return navigateTo;
	}
	
	public String affDevice(){
		String navigateTo="null";
	    deviceService.affecterDeviceAEmployee(uniqueIdentifier, selectedEmployeeMatricule);
		return navigateTo;
	}
	
	public Long getSelectedEmployeeMatricule() {
		return selectedEmployeeMatricule;
	}
	
	public void setSelectedEmployeeMatricule(Long selectedEmployeeMatricule) {
		this.selectedEmployeeMatricule = selectedEmployeeMatricule;
	}

	public String getUniqueIdentifier() {
		return uniqueIdentifier;
	}
	public void setUniqueIdentifier(String uniqueIdentifier) {
		this.uniqueIdentifier = uniqueIdentifier;
	}
	public DeviceType getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(DeviceType deviceType) {
		this.deviceType = deviceType;
	}
	public String getModelName() {
		return modelName;
	}
	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
	public Brand getBrand() {
		return brand;
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
	
}
