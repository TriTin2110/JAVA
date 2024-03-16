package LapTrinhMang.InetAddressExample;

import java.net.InetAddress;

class InetAddressExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InetAddress inetAddress = InetAddress.getByName("www.facebook.com");
			System.out.println("Địa chỉ ip của Facebook là: " + inetAddress.getHostAddress());

			inetAddress = InetAddress.getLocalHost();
			System.out.println("Địa chỉ ip của máy tính hiện tại là: " + inetAddress.getHostAddress());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
