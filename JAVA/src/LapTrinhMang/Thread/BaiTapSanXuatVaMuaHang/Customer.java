package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHang;

import java.util.Random;

public class Customer extends Thread {
	private int idCustomer;
	private Buffer buffer;

	public Customer(int idCustomer, Buffer buffer) {
		this.idCustomer = idCustomer;
		this.buffer = buffer;
	}

	public int getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(int idCustomer) {
		this.idCustomer = idCustomer;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {
			if (this.buffer.getList().size() > 0) {
				try {
					this.buffer.buyProduct(idCustomer);
					this.sleep(new Random().nextInt(2000) + 1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}
}
