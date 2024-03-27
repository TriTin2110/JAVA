package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHang;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Buffer buffer = new Buffer(100);
		Producer producer = new Producer(1, buffer);
		Customer customer = new Customer(11, buffer);
		// Bắt đầu thêm hàng
		producer.start();

		// Bắt đầu mua hàng
		customer.start();
	}

}
