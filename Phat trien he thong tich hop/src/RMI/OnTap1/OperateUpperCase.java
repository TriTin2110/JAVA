package RMI.OnTap1;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

class OperateUpperCase extends UnicastRemoteObject implements UpperCase {

	protected OperateUpperCase() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String UpperFirstCase(String str) {
		// TODO Auto-generated method stub
		String newString = Character.toUpperCase(str.charAt(0)) + "";
		out: for (int i = 1; i < str.length(); i++) {
			if (str.charAt(i) == ' ' && str.charAt(i + 1) != ' ') {
				newString += str.charAt(i);
				i++;
				newString += Character.toUpperCase(str.charAt(i));
				continue out;
			}

			newString += str.charAt(i);
		}
		return newString;
	}

}
