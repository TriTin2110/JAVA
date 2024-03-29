package ProductInformationManager.src.RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

// Định nghĩa interface remote
public interface CustomerService extends Remote {
	// Phương thức tìm kiếm thông tin khách hàng theo mã
	String findCustomer(int customerID) throws RemoteException;

	// Phương thức cập nhật thông tin khách hàng
	boolean updateCustomer(int customerID, String newName) throws RemoteException;

	// Phương thức xóa khách hàng
	boolean deleteCustomer(int customerID) throws RemoteException;

	// Phương thức thêm mới khách hàng
	boolean addCustomer(int customerID, String customerName, int productID) throws RemoteException;
}
