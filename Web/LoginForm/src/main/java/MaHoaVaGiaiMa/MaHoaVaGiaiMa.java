package MaHoaVaGiaiMa;

class MaHoaVaGiaiMa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String secretKey = "TVD";
		String originalString = "teamvietdev.com";

		TestAES testAES = new TestAES();
		String encryptedString = testAES.encrypt(originalString, secretKey);
		System.out.println("Encrypt: " + encryptedString);
		String decryptedString = testAES.decrypt(encryptedString, secretKey);
		System.out.println("Decrypt: " + decryptedString);
	}

}
