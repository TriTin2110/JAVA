package RMI.QuanLySanPham.src;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

public class QlySpClient {
	public static void main(String[] args) {
		try {
			// truy rmi với Naming.lookup("rmi://localhost:yourPort/theRandomName")
			QlySP qlySP = (QlySP) Naming.lookup("rmi://localhost:1026/test");
			Scanner scanner = new Scanner(System.in);

			// Thêm sản phẩm
			System.out.print("Nhập tên sản phẩm mới: ");
			String productName = scanner.nextLine();
			System.out.print("Nhập giá sản phẩm mới: ");
			double productPrice = scanner.nextDouble();
			Product newProduct = new Product(0, productName, productPrice);
			qlySP.addP(newProduct);

			// Hiển thị danh sách sản phẩm
			List<Product> productList = qlySP.getAllProducts();
			System.out.println("Danh sách sản phẩm:");
			for (Product product : productList) {
				System.out.println(product.getId() + ": " + product.getName() + " - " + product.getPrice());
			}

			// Xóa sản phẩm
			System.out.print("Nhập ID của sản phẩm cần xóa: ");
			int productIdToDelete = scanner.nextInt();
			qlySP.delP(productIdToDelete);

			// Tìm kiếm sản phẩm
			System.out.print("Nhập ID của sản phẩm cần tìm: ");
			int productIdToFind = scanner.nextInt();
			Product foundProduct = qlySP.findPbyID(productIdToFind);
			if (foundProduct != null) {
				System.out.println("Sản phẩm được tìm thấy: ID: " + foundProduct.getId() + ", Tên: "
						+ foundProduct.getName() + ", Giá: " + foundProduct.getPrice());
			} else {
				System.out.println("Không tìm thấy sản phẩm.");
			}

			scanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
