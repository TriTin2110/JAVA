package Interface;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface MainInterface extends Remote {
	public int add(Object object, String currentTable) throws RemoteException;

	public int remove(Object object, String currentTable) throws RemoteException;

	public int update(Object object, String currentTable) throws RemoteException;

	public Object searching(Object object, String currentTable) throws RemoteException;

	public ArrayList<Object> printList(String currentTable) throws RemoteException;
}