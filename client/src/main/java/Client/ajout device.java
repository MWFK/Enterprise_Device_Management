package evaluation1Client;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.esprit.javaee.evaluation1Serveur.persistence.Brand;
import tn.esprit.javaee.evaluation1Serveur.persistence.Device;
import tn.esprit.javaee.evaluation1Serveur.persistence.DeviceType;
import tn.esprit.javaee.evaluation1Serveur.services.DeviceServiceRemote;

public class QuestionB {
	public static void main(String[] args) throws NamingException {
		String jndiName="evaluation1Serveur-ear/evaluation1Serveur-ejb/DeviceService!tn.esprit.javaee.evaluation1Serveur.services.DeviceServiceRemote";
		Context context=new InitialContext();
		DeviceServiceRemote proxy= (DeviceServiceRemote) context.lookup(jndiName);

		Device device1 = new Device("00000000-54b3-e7c7-0000-000046bffd90", DeviceType.MOBILE, "Samsung Galaxy J1 Mini", Brand.SAMSUNG);
		proxy.ajouterDevice(device1);
		Device device2 = new Device("00154687-54b3-e7c7-0000-000046bf3206", DeviceType.TABLET, "iPad Mini 4", Brand.APPLE);
		proxy.ajouterDevice(device2);
		Device device3 = new Device("99999888-0000-e7c7-1111-000046bfkkkk", DeviceType.LAPTOP, "MacBook Pro", Brand.APPLE);
		proxy.ajouterDevice(device3);
	}
}
