package RMI.QLSP;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ManagerProduct managerProduct = new OperateProduct();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/test", managerProduct);
			System.out.println("Server đang chạy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
