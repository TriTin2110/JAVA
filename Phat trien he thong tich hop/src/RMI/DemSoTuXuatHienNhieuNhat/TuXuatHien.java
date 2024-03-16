package RMI.DemSoTuXuatHienNhieuNhat;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

class TuXuatHien extends UnicastRemoteObject implements TuXuatHienInterface {

	protected TuXuatHien() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Character> demSoTu(String str) throws RemoteException {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> maps = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (maps.containsKey(str.charAt(i))) {
				maps.put(str.charAt(i), maps.get(str.charAt(i)) + 1);
			} else {
				maps.put(str.charAt(i), 1);
			}
		}
		Set<Character> key = maps.keySet();
		int max = 0;
		List<Character> list = new ArrayList<Character>();
		for (Character character : key) {
			if (maps.get(character) >= max) {
				max = maps.get(character);
				list.add(character);
			}
		}
		return list;
	}

}
