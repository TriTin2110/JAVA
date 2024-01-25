package Lab4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import Lab4.DAO.CompanyDao;
import Lab4.DAO.ProductDao;
import Lab4.model.modelCompany;
import Lab4.model.modelProduct;

class Server {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ServerSocket serverSocket = new ServerSocket(1026);
			while (true) {
				Socket socket = serverSocket.accept();
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(socket.getOutputStream());
				String messageFormClient = br.readLine();
				pw.println(choose(messageFormClient));
				pw.flush();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public static String choose(String message) {
		String[] splitString = message.split(";");
		switch (splitString[0]) {
		case "Thêm sản phẩm":
			return new ProductDao().insert(
					new modelProduct(splitString[1], splitString[2], splitString[4], Long.parseLong(splitString[3])));

		case "Tìm kiếm sản phẩm":
			return new ProductDao().selectByID(new modelProduct(splitString[1]));
		case "Xóa sản phẩm":
			return new ProductDao().delete(new modelProduct(splitString[1]));
		case "Cập nhật sản phẩm":
			return new ProductDao().update(
					new modelProduct(splitString[1], splitString[2], splitString[4],
							Long.parseLong(splitString[3])));
		
		case "Thêm công ty":
			return new CompanyDao().insert(
					new modelCompany(splitString[1], splitString[2]));

		case "Tìm kiếm công ty":
			return new CompanyDao().selectByID(new modelCompany(splitString[1]));
		case "Xóa công ty":
			return new CompanyDao().delete(new modelCompany(splitString[1]));
		case "Cập nhật công ty":
			return new CompanyDao().update(
					new modelCompany(splitString[1], splitString[2]));
		}
		return message;
	}

}
