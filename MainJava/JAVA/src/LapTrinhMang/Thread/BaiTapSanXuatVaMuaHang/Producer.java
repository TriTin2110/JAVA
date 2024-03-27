package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHang;

import java.util.Random;

public class Producer extends Thread {
	private int idProducer;
	private Buffer buffer;

	public Producer(int idProducer, Buffer buffer) {
		this.idProducer = idProducer;
		this.buffer = buffer;
	}

	public int getIdProducer() {
		return idProducer;
	}

	public void setIdProducer(int idProducer) {
		this.idProducer = idProducer;
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
		int i = 0;
		while (true) {
			// Nếu số lượng ô trống còn thì sẽ cho phép nhập thêm sản phẩm
			if (this.buffer.getCapity() > this.buffer.getList().size()) {
				try {
					this.buffer.addProduct(i++, idProducer);
					this.sleep(new Random().nextInt(1000) + 1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

}
