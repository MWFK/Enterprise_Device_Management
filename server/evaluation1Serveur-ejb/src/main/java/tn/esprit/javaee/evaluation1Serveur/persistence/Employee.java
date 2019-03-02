package tn.esprit.javaee.evaluation1Serveur.persistence;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Employee
 *
 */
@Entity

public class Employee implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long matricule;
	private String firstName;
	private String lastName;
	private String password;
	private EmployeeType employeeType;
	@OneToMany (mappedBy = "employee", fetch=FetchType.EAGER, cascade=CascadeType.REMOVE)
	private List<Device> devices;
	private static final long serialVersionUID = 1L;

	
	public Employee() {
		super();
	}
	
	/*public Employee(Long matricule, String firstName,String lastName, String password) {
		this.matricule=matricule;
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
	}
	*/
	public Employee(String firstName,String lastName, String password, EmployeeType employeeType) {
		this.firstName=firstName;
		this.lastName=lastName;
		this.password=password;
		this.employeeType=employeeType;
	}
	
	public EmployeeType getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeType employeeType) {
		this.employeeType = employeeType;
	}

	public List<Device> getDevices() {
		return devices;
	}

	public void setDevices(List<Device> devices) {
		this.devices = devices;
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

	@Override
	public String toString() {
		return this.firstName + " " + this.lastName;
	}
   
}
