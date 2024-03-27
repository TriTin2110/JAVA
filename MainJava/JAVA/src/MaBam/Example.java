package MaBam;

import java.security.MessageDigest;
import java.util.HexFormat;

class Example {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String incomeString = "nguyentritin";
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.update(incomeString.getBytes());
			HexFormat hexFormat = HexFormat.of();
			System.out.println(hexFormat.formatHex(messageDigest.digest()));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
