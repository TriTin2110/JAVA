package RMI.Bai1;

import java.rmi.Remote;
import java.rmi.RemoteException;

interface Fibonacci extends Remote {
	public int getFibonacci(int n) throws RemoteException;
}
