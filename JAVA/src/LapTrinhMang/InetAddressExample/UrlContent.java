package LapTrinhMang.InetAddressExample;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

class UrlContent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL("https://www.geeksforgeeks.org/url-class-java-examples/");
			InputStreamReader isr = new InputStreamReader(url.openStream());
			BufferedReader br = new BufferedReader(isr);
			String content = "";
			while ((content = br.readLine()) != null) {
				System.out.println(content);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}
