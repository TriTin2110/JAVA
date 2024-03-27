package LapTrinhMang.InetAddressExample;

import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

class UrlCheckUrl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] websites = { "https://www.google.com.vn", "https://www.facebook.com", "https://www.youtube.com" };
		for (String string : websites) {
			checkWebsite(string);
		}
	}

	public static void checkWebsite(String website) {
		try {
			URL url = new URL(website);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
			int result = connection.getResponseCode();
			if (result == 200) {
				System.out.println("Website " + website + " is available");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Website " + website + " is NOT available");
		}

	}

}
