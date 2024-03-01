package RMI.Lab3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Customer extends Remote {
	public int addCustomer(modelCustomer modelCustomer) throws RemoteException;

	public int deleteCustomer(int id) throws RemoteException;

	public int updateCustomer(int id, modelCustomer modelCustomer) throws RemoteException;

	public modelCustomer searchCustomerByID(int id) throws RemoteException;
}
