package Lab4.ClientServer;

public interface process<T> {
//	a. Tìm sản phẩm
//	b. Cập nhật thông tin
//	c. Xóa sản phẩm
//	d. Thêm sản phẩm

	public String insert(T t);

	public String delete(T t);

	public String update(T t);

	public String selectByID(T t);
}
