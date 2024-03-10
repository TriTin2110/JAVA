package ProductInformationManager.src.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
	public static void main(String[] args) {
		try {
			// Tạo và đăng ký đối tượng remote vào Registry
			CustomerService stub = (CustomerService) new CustomerServiceImpl();
			// Khởi động RMI registry trên cổng mặc định 1099
			LocateRegistry.createRegistry(1099);
			Registry registry = LocateRegistry.getRegistry();
			registry.bind("CustomerManager", stub);
			System.out.println("Máy chủ CustomerManager sẵn sàng");
		} catch (Exception e) {
			System.err.println("Lỗi máy chủ CustomerManager: " + e.toString());
			e.printStackTrace();
		}
	}
}
