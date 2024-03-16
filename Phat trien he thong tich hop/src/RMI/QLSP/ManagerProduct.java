package RMI.QLSP;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Connection;

public interface ManagerProduct extends Remote {
	public int addProduct(ModelProduct modelProduct) throws RemoteException;

	public int deleteProduct(String id) throws RemoteException;

	public int updateProduct(String id, ModelProduct modelProduct) throws RemoteException;

	public ModelProduct searchingProduct(String id) throws RemoteException;

	public Connection getConnection() throws RemoteException;

	public void closeConnection(Connection connection) throws RemoteException;
}
