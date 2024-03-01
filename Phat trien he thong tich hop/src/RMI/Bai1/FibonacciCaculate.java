package RMI.Bai1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class FibonacciCaculate extends UnicastRemoteObject implements Fibonacci {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FibonacciCaculate() throws RemoteException {
	}

	@Override
	public int getFibonacci(int n) {
		// TODO Auto-generated method stub
		if (n == 1 || n == 2)
			return 1;
		else
			return getFibonacci(n - 1) + getFibonacci(n - 2);
	}

}
