package LapTrinhMang.Thread.BaiTapSanXuatVaMuaHangGiaoDien;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Controller implements ActionListener {
	private ViewSanXuatVaMuaHang viewSanXuatVaMuaHang;
	Buffer buffer;
	Producer producer;
	Customer customer;

	public Controller(ViewSanXuatVaMuaHang viewSanXuatVaMuaHang) {
		this.viewSanXuatVaMuaHang = viewSanXuatVaMuaHang;
		buffer = new Buffer(100);
		producer = new Producer(1, buffer, this.viewSanXuatVaMuaHang);
		customer = new Customer(10, buffer, this.viewSanXuatVaMuaHang);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Bắt đầu sản xuất":
			beginProduce();
			break;

		case "Kết thúc sản xuất":
			endProduce();
			break;
		case "Bắt đầu mua":
			beginBuying();
			break;
		case "Kết thúc mua":
			endBuying();
			break;
		}
	}

	public void beginProduce() {
		producer.start();
	}

	public void endProduce() {
		producer.stopRunning();
		producer.interrupt();
		this.producer = new Producer(0, buffer, viewSanXuatVaMuaHang);
	}

	public void beginBuying() {
		customer.start();
	}

	// Khi chọn ngừng mua thì customer.stopRunning() = false dẫn đến lệnh while sẽ
	// ngừng lại
	// Do chúng ta không thể chạy lại thread khi nó đã bị đóng nên ở đây ta sẽ tạo 1
	// đối tượng thread mới
	public void endBuying() {
		customer.stopRunning();
		customer.interrupt();
		this.customer = new Customer(0, buffer, viewSanXuatVaMuaHang);
	}
}
