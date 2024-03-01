package RMI.KiemTraSoNguyenTo;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			LocateRegistry.createRegistry(1026);
			CheckPrime checkPrime = new OperateCheckPrime();
			Naming.bind("rmi://localhost:1026/checkPrime", checkPrime);
			System.out.println("Kết nối thành công");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
