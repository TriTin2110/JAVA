package RMI.OnTap1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UpperCase upperCase = new OperateUpperCase();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/StringController", upperCase);
			System.out.println("Server đang hoạt động");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
