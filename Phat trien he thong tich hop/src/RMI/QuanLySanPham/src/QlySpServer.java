package RMI.QuanLySanPham.src;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class QlySpServer {
	public static void main(String[] args) {
		try {
			QlySP qlySP = new QlySpImpl();
			// Để mở một kết nối RMI

			// B1: tạo 1 cổng với LocateRegistry
			LocateRegistry.createRegistry(1026);

			// B2: đăng ký rmi với Naming.bind("rmi://localhost:yourPort/theRandomName",
			// interface)
			Naming.bind("rmi://localhost:1026/test", qlySP);

			System.out.println("Server đang chạy");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

//		try {
//			QlySP qlySP = new QlySpImpl();
//			LocateRegistry.createRegistry(2023);
//			Naming.rebind("QlySP", qlySP);
//			System.out.println("Server đang chạy");
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
}
