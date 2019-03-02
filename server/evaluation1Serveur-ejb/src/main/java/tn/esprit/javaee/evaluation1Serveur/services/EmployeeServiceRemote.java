package tn.esprit.javaee.evaluation1Serveur.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;

@Remote
public interface EmployeeServiceRemote {
	public void ajouterEmployee(Employee employee);
	public List<Device> getDevicesByEmploye(Long matricule);
	public void suppEmpAllDev(Long matricule);
}
