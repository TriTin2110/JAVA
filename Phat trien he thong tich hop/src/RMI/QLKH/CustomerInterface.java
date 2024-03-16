package RMI.QLKH;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface CustomerInterface extends Remote {
	public int addCustomer(ModelCustomer modelCustomer) throws RemoteException;

	public int removeCustomer(ModelCustomer modelCustomer) throws RemoteException;

	public int alterCustomer(ModelCustomer modelCustomer) throws RemoteException;

	public ModelCustomer findCustomer(ModelCustomer modelCustomer) throws RemoteException;
}
