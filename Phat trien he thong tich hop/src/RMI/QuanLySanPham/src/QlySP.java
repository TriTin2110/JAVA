package RMI.QuanLySanPham.src;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface QlySP extends Remote {
	void addP(Product product) throws RemoteException;

	void updP(Product product) throws RemoteException;

	void delP(int productId) throws RemoteException;

	Product findPbyID(int productId) throws RemoteException;

	List<Product> getAllProducts() throws RemoteException;
}
