package LapTrinhMang.QuanLySanPham.Interface;

import java.util.ArrayList;

public interface MainInterface {
	public int add(Object object);

	public int remove(Object object);

	public int update(Object object);

	public Object searching(Object object);

	public ArrayList<Object> printList(String currentTable);
}
