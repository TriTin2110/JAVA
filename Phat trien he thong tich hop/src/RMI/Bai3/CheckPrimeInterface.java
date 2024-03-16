package RMI.Bai3;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface CheckPrimeInterface extends Remote {
	public boolean checkingPrime(int n) throws RemoteException;
}
