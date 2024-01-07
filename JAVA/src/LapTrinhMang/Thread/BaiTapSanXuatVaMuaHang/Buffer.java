package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHang;

import java.util.ArrayList;

public class Buffer {
	private int capity;
	private ArrayList<Integer> list;

	public Buffer(int capity) {
		this.capity = capity;
		list = new ArrayList<>();
	}

	public int getCapity() {
		return capity;
	}

	public void setCapity(int capity) {
		this.capity = capity;
	}

	public ArrayList<Integer> getList() {
		return list;
	}

	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	public void addProduct(int productID, int producerID) {
		System.out.println("Nhà sản xuất " + producerID + " đã sản xuất " + productID);
		this.list.add(productID);
	}

	public void buyProduct(int customerID) {
		System.out.println("Khách hàng " + customerID + " đã mua " + this.list.get(0));
		this.list.remove(0);
	}
}
