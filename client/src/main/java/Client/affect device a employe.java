package evaluation1Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.javaee.evaluation1Serveur.services.DeviceServiceRemote;

public class QuestionC {

	public static void main(String[] args) throws NamingException {
		String jndiName="evaluation1Serveur-ear/evaluation1Serveur-ejb/DeviceService!tn.esprit.javaee.evaluation1Serveur.services.DeviceServiceRemote";
		Context context=new InitialContext();
		DeviceServiceRemote proxy= (DeviceServiceRemote) context.lookup(jndiName);

		
		proxy.affecterDeviceAEmployee("00000000-54b3-e7c7-0000-000046bffd90", 1L);
		
	}

}
