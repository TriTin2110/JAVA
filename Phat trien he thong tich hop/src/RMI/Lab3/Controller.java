package RMI.Lab3;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JOptionPane;

class Controller implements ActionListener {
	Client client;

	public Controller(Client client) {
		this.client = client;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		switch (command) {
		case "Tạo Khách Hàng":
			addCustomer();
			break;
		case "Xóa khách hàng":
			deleteCustomer();
			break;
		case "Tìm khách hàng":
			searchingCustomer();
			break;
		case "Cập nhật khách hàng":
			updatingCustomer();
			break;
		}
	}

	public void addCustomer() {
		String name = JOptionPane.showInputDialog(this.client, "Hãy nhập tên của khách hàng");
		String customerType = JOptionPane.showInputDialog(this.client, "Hãy nhập loại khách hàng");
		int phone = Integer.parseInt(JOptionPane.showInputDialog(this.client, "Hãy nhập số điện thoại của khách hàng"));
		try {
			Customer customer = (Customer) Naming.lookup("rmi://localhost:1027/lab4");
			modelCustomer modelCustomer = new modelCustomer(name, customerType, phone);
			int result = customer.addCustomer(modelCustomer);
			JOptionPane.showMessageDialog(this.client, "Đã tạo cập nhật thành công " + result + " dòng");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void deleteCustomer() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(this.client, "Hãy nhập id khách hàng: "));
		try {
			Customer customer = (Customer) Naming.lookup("rmi://localhost:1027/lab4");
			JOptionPane.showMessageDialog(this.client, "Đã cập nhật " + customer.deleteCustomer(id) + " dòng!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void searchingCustomer() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(this.client, "Hãy nhập id khách hàng: "));
		try {
			Customer customer = (Customer) Naming.lookup("rmi://localhost:1027/lab4");
			modelCustomer modelCustomer = customer.searchCustomerByID(id);
			if (modelCustomer != null) {
				JOptionPane.showMessageDialog(this.client, "Name: " + modelCustomer.getName() + "; Phone: "
						+ modelCustomer.getPhone() + "; Type: " + modelCustomer.getCustomerType());
			} else
				JOptionPane.showMessageDialog(this.client, "Khách hàng không tồn tại trong danh sách");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void updatingCustomer() {
		int id = Integer.parseInt(JOptionPane.showInputDialog(this.client, "Hãy nhập id khách hàng: "));
		String name = JOptionPane.showInputDialog(this.client, "Hãy nhập tên của khách hàng");
		String customerType = JOptionPane.showInputDialog(this.client, "Hãy nhập loại khách hàng");
		int phone = Integer.parseInt(JOptionPane.showInputDialog(this.client, "Hãy nhập số điện thoại của khách hàng"));
		try {
			Customer customer = (Customer) Naming.lookup("rmi://localhost:1027/lab4");
			JOptionPane.showMessageDialog(this.client, "Đã cập nhật thành công "
					+ customer.updateCustomer(id, new modelCustomer(name, customerType, phone)) + " dòng!");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
