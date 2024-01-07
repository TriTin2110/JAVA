package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHangGiaoDien;

import java.util.Random;

class Producer extends Thread {
	private int producerId, productID;
	private Buffer buffer;
	private ViewSanXuatVaMuaHang viewSanXuatVaMuaHang;
	private boolean isRuning = true;

	public Producer(int producerId, Buffer buffer, ViewSanXuatVaMuaHang viewSanXuatVaMuaHang) {
		this.producerId = producerId;
		this.buffer = buffer;
		producerId = 0;
		this.viewSanXuatVaMuaHang = viewSanXuatVaMuaHang;
	}

	public int getProducerId() {
		return producerId;
	}

	public void setProducerId(int producerId) {
		this.producerId = producerId;
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
		while (isRuning) {
			if (this.buffer.getCapity() > this.buffer.getList().size()) {
				try {
//					Nếu ô trống trong kho lớn hơn danh sách sản phẩm sẽ tiến hành thêm sản phẩm vào kho
					this.buffer.addProduct(productID, producerId);
					this.viewSanXuatVaMuaHang.lblSoLuong.setText(this.buffer.getList().size() + "");
					productID++;
					// Từ 0,5s đến 1s sẽ tiến hành thêm 1 sản phẩm vào danh sách
					this.sleep(new Random().nextInt(500) + 1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	public void stopRunning() {
		this.isRuning = false;
	}
}
