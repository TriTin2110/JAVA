package RMI.KiemTraSoNguyenTo;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CheckPrime extends Remote {
	public boolean checkingPrime(int n) throws RemoteException;
}
