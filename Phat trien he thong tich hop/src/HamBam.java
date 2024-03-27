import java.security.MessageDigest;
import java.util.HexFormat;

public class HamBam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			String incomeString = "Nguyễn Trí Tín";

			// MessageDigest sẽ nhận kiểu mã hóa mà người dùng muốn chọn
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");

			// Sau đó sẽ nhận chuỗi cần được mã hóa với chuỗi ban đầu được chuyển sang mảng
			// byte
			messageDigest.update(incomeString.getBytes());

			// Tiến hành mã hóa chuỗi ban đầu thành mã băm và trả nó về dưới dạng mảng byte
			byte[] outcomeString = messageDigest.digest();

			// Khai báo HexFormat để chuyển mảng byte được trả về thành chuỗi
			// HexFormat.of() sẽ trả về một bộ định dạng thập lục phân không có dấu phân
			// cách và ký tự chữ thường
			HexFormat hexFormat = HexFormat.of();

			// Format mảng byte và in ra kết quả
			System.out.println(hexFormat.formatHex(outcomeString));
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
