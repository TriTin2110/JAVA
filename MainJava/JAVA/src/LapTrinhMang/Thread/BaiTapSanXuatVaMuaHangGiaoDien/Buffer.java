package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHangGiaoDien;

import java.util.ArrayList;

class Buffer {
	private int capity;
	private ArrayList<Integer> list;

	public Buffer(int capity) {
		this.capity = capity;
		this.list = new ArrayList<>();
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

	void addProduct(int productID, int producerID) {
		this.list.add(producerID);
	}

	void buyProduct() {
		this.list.remove(0);
	}
}
