package ProductInformationManager.src.RMI;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class RMIClient {
	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			// Tìm RMI Registry trên localhost và cổng 1099
			Registry registry = LocateRegistry.getRegistry("localhost", 1099);

			// Lấy đối tượng CustomerManager từ Registry
			CustomerService customerManager = (CustomerService) registry.lookup("CustomerManager");

			// Sử dụng các phương thức từ đối tượng CustomerManager để quản lý khách hàng
			Scanner scanner = new Scanner(System.in);
			int choice = 0;
			while (choice != 5) {
				System.out.println("----- MENU -----");
				System.out.println("1. Tìm kiếm khách hàng");
				System.out.println("2. Thêm mới khách hàng");
				System.out.println("3. Cập nhật thông tin khách hàng");
				System.out.println("4. Xóa khách hàng");
				System.out.println("5. Thoát");
				System.out.print("Chọn chức năng: ");
				choice = scanner.nextInt();

				switch (choice) {
				case 1:
					// Tìm kiếm khách hàng
					System.out.print("Nhập mã khách hàng: ");
					int customerID = scanner.nextInt();
					String customerInfo = customerManager.findCustomer(customerID);
					System.out.println("Thông tin khách hàng: " + customerInfo);
					break;
				case 2:
					// Thêm mới khách hàng
					System.out.print("Nhập mã khách hàng mới: ");
					int newCustomerID = scanner.nextInt();
					System.out.print("Nhập tên khách hàng mới: ");
					scanner.nextLine(); // Đọc dấu new line sau khi đọc số int
					String newCustomerName = scanner.nextLine();
					System.out.print("Nhập mã sản phẩm: ");
					int productID = scanner.nextInt();
					boolean added = customerManager.addCustomer(newCustomerID, newCustomerName, productID);
					if (added) {
						System.out.println("Thêm mới khách hàng thành công.");
					} else {
						System.out.println("Thêm mới khách hàng thất bại.");
					}
					break;
				case 3:
					// Cập nhật thông tin khách hàng
					System.out.print("Nhập mã khách hàng cần cập nhật: ");
					int updateCustomerID = scanner.nextInt();
					System.out.print("Nhập tên mới cho khách hàng: ");
					scanner.nextLine(); // Đọc dấu new line sau khi đọc số int
					String updatedCustomerName = scanner.nextLine();
					boolean updated = customerManager.updateCustomer(updateCustomerID, updatedCustomerName);
					if (updated) {
						System.out.println("Cập nhật thông tin khách hàng thành công.");
					} else {
						System.out.println("Cập nhật thông tin khách hàng thất bại.");
					}
					break;
				case 4:
					// Xóa khách hàng
					System.out.print("Nhập mã khách hàng cần xóa: ");
					int deleteCustomerID = scanner.nextInt();
					boolean deleted = customerManager.deleteCustomer(deleteCustomerID);
					if (deleted) {
						System.out.println("Xóa khách hàng thành công.");
					} else {
						System.out.println("Xóa khách hàng thất bại.");
					}
					break;
				case 5:
					// Thoát khỏi chương trình
					System.out.println("Đã thoát khỏi chương trình.");
					break;
				default:
					System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
					break;
				}
			}
		} catch (Exception e) {
			System.err.println("Lỗi client: " + e.toString());
			e.printStackTrace();
		}
	}
}