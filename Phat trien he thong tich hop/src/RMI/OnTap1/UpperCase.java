package RMI.OnTap1;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface UpperCase extends Remote {
	public String UpperFirstCase(String str) throws RemoteException;
}
