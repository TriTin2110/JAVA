package RMI.Bai2;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface SumInterface extends Remote {
	public int sum(int a, int b) throws RemoteException;

	public int subtract(int a, int b) throws RemoteException;
}
