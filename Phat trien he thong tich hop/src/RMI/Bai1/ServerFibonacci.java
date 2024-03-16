package RMI.Bai1;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class ServerFibonacci {
	public static void main(String[] args) {
		try {
			Fibonacci fibonacci = new FibonacciCaculate();
			LocateRegistry.createRegistry(1206);
			Naming.bind("rmi://localhost:1206/ExampleFibonacci", fibonacci);
			System.out.println("Đã kết nối thành công!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}
