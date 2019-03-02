package tn.esprit.javaee.evaluation1Serveur.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
//import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;
import tn.esprit.javaee.evaluation1Serveur.persistence.EmployeeType;
import tn.esprit.javaee.evaluation1Serveur.services.EmployeeService;

@ManagedBean
@SessionScoped

public class EmployeeBean {
	private Long matricule;
	private String firstName;
	private String lastName;
	private String password;
	private EmployeeType employeeType;
	private List<String> devicesUniqueIdentifiers;
	private List<Device> devices;
	@EJB
	EmployeeService employeeService;
	private List<Employee> employees;
	private List<String> employeeNames;
	private List<Long> employeesMatricules;
	////////// @ManagedProperty(value = "#{loginBean}")
////////	  private LoginBean loginBean;
//	public List<Device> getDevices() {
//		return employeeService.getAllEmployeeDevices(matricule);
//		//return employeeService.getAllEmployeeDevices(getMatricule());
//		//return employeeService.getAllEmployeeDevices(loginBean.getEmployee().getMatricule());
//	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
	}

//	public List<Long> getEmployeesMatricules() {
//		List<Long> employeesMatricules = employeeService.getAllEmployeMatriculesJPQL();
//		return employeesMatricules;
//	}

	public void setEmployeesMatricules(List<Long> employeesMatricules) {
		this.employeesMatricules = employeesMatricules;
	}

//	public List<String> getEmployeeNames() {
//		List<String> employeeNames = employeeService.getAllEmployeNamesJPQL();
//		return employeeNames;
//	}

	public void setEmployeeNames(List<String> employeeNames) {
		this.employeeNames = employeeNames;
	}

//	public List<Employee> getEmployees() {
//		employees = employeeService.getAllEmployees();
//		return employees;
//	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public Long getMatricule() {
		return matricule;
	}
	public void setMatricule(Long matricule) {
		this.matricule = matricule;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public EmployeeType getEmployeeType() {
		return employeeType;
	}
	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public String addEmployee(){
		String navigateTo="null";
	//public void addEmploye(){
//		employeService.ajouterEmploye(new Employe(nom, prenom, email,role, isActif));
		// Employe(String nom, String prenom, String email, boolean isActif)
		
		employeeService.ajouterEmployee(new Employee(firstName, lastName, password, employeeType));

		//navigateTo = "/login?faces-redirect=true";
	// navigateTo = "/pages/welcome?faces-redirect=true";
		return navigateTo;
	}
	
//	public List<String> getDevicesUniqueIdentifiers() {
//		devicesUniqueIdentifiers = employeeService.getAllEmployeeDeviceUniqueIdentifiersJPQL(matricule);
////		devicesUniqueIdentifiers = employeeService.getAllEmployeeDeviceUniqueIdentifiersJPQL(loginBean.getEmployee().getMatricule());
//		return devicesUniqueIdentifiers;
//	}

	public void setDevicesUniqueIdentifiers(List<String> devicesUniqueIdentifiers) {
		this.devicesUniqueIdentifiers = devicesUniqueIdentifiers;
	}
		
	}
