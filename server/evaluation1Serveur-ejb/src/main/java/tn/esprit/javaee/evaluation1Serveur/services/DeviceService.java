package tn.esprit.javaee.evaluation1Serveur.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;

/**
 * Session Bean implementation class DeviceService
 */
@Stateless
@LocalBean
public class DeviceService implements DeviceServiceRemote {

   @PersistenceContext(unitName= "evaluation1Serveur-ejb")
   EntityManager em;

	public void ajouterDevice(Device device) {
		em.persist(device);
	}

	
	public void affecterDeviceAEmployee(String deviceUniqueIdentifier, Long employeeMatricule) {
		Device deviceManagedEntity = em.find(Device.class, deviceUniqueIdentifier);
		Employee employeeManagedEntity = em.find(Employee.class, employeeMatricule);
		deviceManagedEntity.setEmployee(employeeManagedEntity);
	}
	
	public List<Device> getAllDevices(){
		return em.createQuery("from Device").getResultList();
	}
	
}
