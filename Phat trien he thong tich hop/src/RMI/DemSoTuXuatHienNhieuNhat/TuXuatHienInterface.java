package RMI.DemSoTuXuatHienNhieuNhat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

interface TuXuatHienInterface extends Remote {
	public List<Character> demSoTu(String str) throws RemoteException;
}
