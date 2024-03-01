package RMI.Bai3;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class CheckPrime extends UnicastRemoteObject implements CheckPrimeInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected CheckPrime() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkingPrime(int n) throws RemoteException {
		// TODO Auto-generated method stub
		if (n < 2 && n > 0)
			return true;
		else {
			for (int i = 2; i < n; i++) {
				if (n % i == 0)
					return false;
			}
		}
		return true;
	}

}
