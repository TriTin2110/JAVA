package RMI.Lab3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Customer customer = new ProccessCustomer();
			LocateRegistry.createRegistry(1027);
			Naming.bind("rmi://localhost:1027/lab4", customer);
			System.out.println("Đã kết nối");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
