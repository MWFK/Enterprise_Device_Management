package tn.esprit.javaee.evaluation1Serveur.presentation.mbeans;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;
import tn.esprit.javaee.evaluation1Serveur.persistence.EmployeeType;
import tn.esprit.javaee.evaluation1Serveur.services.DeviceService;
import tn.esprit.javaee.evaluation1Serveur.services.EmployeeService;

@ManagedBean
@SessionScoped
public class LoginBean {
private Long login;
private String password;
private Employee employee;
private boolean loggedIn;
private Long selectedEmployeId;
private String selectedDeviceId;


@EJB
EmployeeService employeeService;

@EJB
DeviceService deviceService;

public String doLogin(){
	String navigateTo="null";
	employee = employeeService.getEmployeeByMatriculeAndPassword(login, password);
    if (employee !=null){
    	loggedIn=true;
	if (employee.getEmployeeType()==EmployeeType.ADMIN){
		navigateTo="/espaceadmin?faces-redirect=true";
	}
	if (employee.getEmployeeType()==EmployeeType.EMP){
		navigateTo="/espacemployee?faces-redirect=true";
	}
    }
	else {
		FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
	}
return navigateTo;
}


public void affecterDeviceAEmploye(){
	deviceService.affecterDeviceAEmployee(selectedDeviceId, selectedEmployeId);
}


public String doLogout(){
	FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	return "/login?faces-redirect=true";
}

public List<Device> getDevicesByEmploye() {
	return employeeService.getDevicesByEmploye(employee.getMatricule()); //getAllEmployeeDevices(employee.getMatricule());
	//return employeeService.getAllEmployeeDevices(getMatricule());
	//return employeeService.getAllEmployeeDevices(loginBean.getEmployee().getMatricule());
}


public List<Employee> getAllEmployees() {
	return employeeService.getAllEmploye();
}


public List<Device> getAllDevices(){
	return deviceService.getAllDevices();
}


public Long getSelectedEmployeId() {
	return selectedEmployeId;
}



public void setSelectedEmployeId(Long selectedEmployeId) {
	this.selectedEmployeId = selectedEmployeId;
}



public String getSelectedDeviceId() {
	return selectedDeviceId;
}



public void setSelectedDeviceId(String selectedDeviceId) {
	this.selectedDeviceId = selectedDeviceId;
}



public EmployeeService getEmployeeService() {
	return employeeService;
}



public void setEmployeeService(EmployeeService employeeService) {
	this.employeeService = employeeService;
}



public DeviceService getDeviceService() {
	return deviceService;
}



public void setDeviceService(DeviceService deviceService) {
	this.deviceService = deviceService;
}


public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


public boolean isLoggedIn() {
	return loggedIn;
}

public void setLoggedIn(boolean loggedIn) {
	this.loggedIn = loggedIn;
}

public Long getLogin() {
	return login;
}

public void setLogin(Long login) {
	this.login = login;
}

public Employee getEmployee() {
	return employee;
}
public void setEmployee(Employee employee) {
	this.employee = employee;
}

}
