package tn.esprit.javaee.evaluation1Serveur.services;

import java.util.List;

import javax.ejb.Remote;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;

@Remote
public interface DeviceServiceRemote {
	public void ajouterDevice(Device device);
	public void affecterDeviceAEmployee(String deviceUniqueIdentifier, Long employeeMatricule);
}
