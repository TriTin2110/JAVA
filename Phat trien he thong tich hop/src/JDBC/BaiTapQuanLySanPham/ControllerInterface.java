package JDBC.BaiTapQuanLySanPham;

interface ControllerInterface<T> {
	public int addProduct(T t);

	public String printList();
}
