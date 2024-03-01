package RMI.Bai3;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class ServerCheckingPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CheckPrimeInterface checkPrimeInterface = new CheckPrime();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/checkingPrime", checkPrimeInterface);

		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
