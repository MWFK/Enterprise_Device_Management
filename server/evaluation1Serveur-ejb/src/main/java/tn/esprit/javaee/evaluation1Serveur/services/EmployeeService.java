package tn.esprit.javaee.evaluation1Serveur.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;

/**
 * Session Bean implementation class EmployeeService
 */
@Stateless
@LocalBean
public class EmployeeService implements EmployeeServiceRemote {

	@PersistenceContext(unitName= "evaluation1Serveur-ejb")
	EntityManager em;

    
	public void ajouterEmployee(Employee employee) {
		em.persist(employee);
	}
	
	public List<Employee> getAllEmploye(){
		return em.createQuery("from Employee").getResultList();
	}
	
	public void suppEmpAllDev(Long matricule){
		em.remove(em.find(Employee.class, matricule));
	}

	
	public List<Device> getDevicesByEmploye(Long matricule) {
		Employee employee = em.find(Employee.class, matricule);
		return employee.getDevices();
	}
	
	public Employee getEmployeeByMatriculeAndPassword(Long matricule, String password) {
		TypedQuery<Employee> query= em.createQuery("Select e from Employee e " + "where e.matricule=:matricule and "+"e.password=:password", Employee.class);
		query.setParameter("matricule", matricule);
		query.setParameter("password", password);
		Employee employee = null;
		try{
			employee = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}
		return employee;
	}
}
