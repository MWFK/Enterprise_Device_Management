package evaluation1Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.javaee.evaluation1Serveur.persistence.Employee;
import tn.esprit.javaee.evaluation1Serveur.persistence.EmployeeType;
import tn.esprit.javaee.evaluation1Serveur.services.EmployeeServiceRemote;

public class QuestionA {
	public static void main(String[] args) throws NamingException {
		String jndiName="evaluation1Serveur-ear/evaluation1Serveur-ejb/EmployeeService!tn.esprit.javaee.evaluation1Serveur.services.EmployeeServiceRemote";
		Context context=new InitialContext();
		EmployeeServiceRemote proxy= (EmployeeServiceRemote) context.lookup(jndiName);

		Employee employee = new Employee();
		employee.setEmployeeType(EmployeeType.ADMIN);
		employee.setFirstName("Walid");
		employee.setLastName("YAICH");
		employee.setPassword("password");
		proxy.ajouterEmployee(employee);
	}
}
