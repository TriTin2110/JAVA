import java.util.Base64;

class MaHoaChuoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "Nguyễn Trí Tín";
		String encode = Base64.getEncoder().encodeToString(name.getBytes());
		System.out.println(encode);
		byte[] decode = Base64.getDecoder().decode(encode.getBytes());
		String newString = new String(decode);
		System.out.println(newString);
	}

}
