package tn.esprit.javaee.evaluation1Serveur.presentation.mbeans;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import tn.esprit.javaee.evaluation1Serveur.persistence.Brand;
import tn.esprit.javaee.evaluation1Serveur.persistence.DeviceType;
import tn.esprit.javaee.evaluation1Serveur.persistence.EmployeeType;

@ManagedBean
@ApplicationScoped
public class Data {

	
	public EmployeeType[] getTypes(){
		return EmployeeType.values();
	}
	public DeviceType[] getDeviceTypes(){
		return DeviceType.values();
	}
	public Brand[] getBrand(){
		return Brand.values();
	}
}
