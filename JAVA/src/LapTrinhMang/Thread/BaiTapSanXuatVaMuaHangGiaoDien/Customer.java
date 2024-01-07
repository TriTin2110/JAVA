package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHangGiaoDien;

import java.util.Random;

class Customer extends Thread {
	private int customerID;
	private Buffer buffer;
	private ViewSanXuatVaMuaHang viewSanXuatVaMuaHang;
	// Kiểm tra xem Thread có đang chạy hay không
	private boolean isRunning = true;

	public Customer(int customerID, Buffer buffer, ViewSanXuatVaMuaHang viewSanXuatVaMuaHang) {
		this.customerID = customerID;
		this.buffer = buffer;
		this.viewSanXuatVaMuaHang = viewSanXuatVaMuaHang;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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
		while (isRunning) {
			if (this.buffer.getList().size() > 0) {
				try {
					// Nếu trong danh sách còn hàng thì sẽ xóa sản phẩm đầu tiên trong danh sách
					this.buffer.buyProduct();
					this.viewSanXuatVaMuaHang.lblSoLuong.setText(this.buffer.getList().size() + "");
					// Cứ mỗi 1,5s đến 2,5s sẽ thực hiện mua 1 lần
					this.sleep(new Random().nextInt(1500) + 1000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		}
	}

	// Khi gọi stop running thì biến isRunning sẽ trả về false từ đó dẫn đến vòng
	// lập while sẽ không đc thực hiện
	public void stopRunning() {
		this.isRunning = false;
	}
}
