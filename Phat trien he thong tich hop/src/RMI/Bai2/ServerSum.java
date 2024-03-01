package RMI.Bai2;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class ServerSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			SumInterface sumInterface = new SumCaculate();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/sum", sumInterface);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
