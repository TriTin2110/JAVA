package RMI.Bai2;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class SumCaculate extends UnicastRemoteObject implements SumInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected SumCaculate() throws RemoteException {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int sum(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a + b;
	}

	@Override
	public int subtract(int a, int b) throws RemoteException {
		// TODO Auto-generated method stub
		return a - b;
	}

}
