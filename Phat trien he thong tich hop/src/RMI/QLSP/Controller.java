package RMI.QLSP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;
import java.text.NumberFormat;
import java.util.Locale;

import javax.swing.JOptionPane;

public class Controller implements ActionListener {
	private Client client;

	public Controller(Client client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Tạo sản phẩm":
			addProduct();
			break;

		case "Tìm sản phẩm":
			findProduct();
			break;

		case "Xóa sản phẩm":
			deleteProduct();
			break;

		case "Cập nhật sản phẩm":
			updateProduct();
			break;
		}
	}

	private void updateProduct() {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog(this.client, "Hãy nhập mã của sản phẩm: ");
		try {
			ManagerProduct managerProduct = (ManagerProduct) Naming.lookup("rmi://localhost:1026/test");
			if (managerProduct.searchingProduct(id) != null) {
				String productName = JOptionPane.showInputDialog(this.client, "Hãy nhập tên của sản phẩm: ");
				long productPrice = Long
						.parseLong(JOptionPane.showInputDialog(this.client, "Hãy nhập giá của sản phẩm"));
				JOptionPane.showMessageDialog(this.client, "Đã cập nhật "
						+ managerProduct.updateProduct(id, new ModelProduct(id, productName, productPrice)) + " dòng!");
			} else
				JOptionPane.showMessageDialog(this.client, "Không tìm thấy sản phẩm có mã là: " + id);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void deleteProduct() {
		// TODO Auto-generated method stub
		String id = JOptionPane.showInputDialog(this.client, "Hãy nhập mã của sản phẩm: ");
		try {
			ManagerProduct managerProduct = (ManagerProduct) Naming.lookup("rmi://localhost:1026/test");
			JOptionPane.showMessageDialog(this.client, "Đã cập nhật " + managerProduct.deleteProduct(id) + " dòng!");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void findProduct() {
		Locale locale = new Locale("vi", "vn");
		NumberFormat nf = NumberFormat.getCurrencyInstance(locale);
		String id = JOptionPane.showInputDialog(this.client, "Hãy nhập mã của sản phẩm: ");
		try {
			ManagerProduct managerProduct = (ManagerProduct) Naming.lookup("rmi://localhost:1026/test");
			ModelProduct modelProduct = managerProduct.searchingProduct(id);
			if (modelProduct != null) {
				JOptionPane.showMessageDialog(this.client, "Mã của sản phẩm là: " + modelProduct.getId());
				JOptionPane.showMessageDialog(this.client, "Tên của sản phẩm là: " + modelProduct.getProductName());
				JOptionPane.showMessageDialog(this.client,
						"Giá của sản phẩm là: " + nf.format(modelProduct.getPrice()));
			} else
				JOptionPane.showMessageDialog(this.client, "Không tìm thấy sản phẩm có mã là: " + id);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private void addProduct() {
		// TODO Auto-generated method stub
		String productID = JOptionPane.showInputDialog(this.client, "Hãy nhập mã của sản phẩm");
		String productName = JOptionPane.showInputDialog(this.client, "Hãy nhập tên của sản phẩm");
		long productPrice = Long.parseLong(JOptionPane.showInputDialog(this.client, "Hãy nhập giá của sản phẩm"));
		try {
			ManagerProduct managerProduct = (ManagerProduct) Naming.lookup("rmi://localhost:1026/test");
			JOptionPane.showMessageDialog(this.client, "Đã cập nhật "
					+ managerProduct.addProduct(new ModelProduct(productID, productName, productPrice)) + " dòng!");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}