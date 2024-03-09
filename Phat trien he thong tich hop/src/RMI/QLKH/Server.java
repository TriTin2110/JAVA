package RMI.QLKH;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			CustomerInterface customerInterface = new CustomerOperate();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/Customer", customerInterface);
			System.out.println("Đã kết nối với server");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
