package RMI.KiemTraSoNguyenTo;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class OperateCheckPrime extends UnicastRemoteObject implements CheckPrime {

	protected OperateCheckPrime() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean checkingPrime(int n) throws RemoteException {
		// TODO Auto-generated method stub
		for (int i = 2; i < n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

}
