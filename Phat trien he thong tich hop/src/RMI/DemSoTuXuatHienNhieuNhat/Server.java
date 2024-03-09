package RMI.DemSoTuXuatHienNhieuNhat;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			TuXuatHienInterface tuXuatHienInterface = new TuXuatHien();
			LocateRegistry.createRegistry(1026);
			Naming.bind("rmi://localhost:1026/TuXuatHienNhieuNhat", tuXuatHienInterface);
			System.out.println("Đã kết nối với server thành công");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
