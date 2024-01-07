

import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

class ThoiGian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long day = 0;
		long hour = 0;
		long mi = TimeUnit.MINUTES.toHours(154 * 60 * 24);
		while (mi > 59) {
			mi -= 60;
			hour += 1;
		}
		while (hour > 23) {
			hour -= 24;
			day += 1;
		}
		System.out.println("Số ngày: " + day + ", số giờ: " + hour + ", số phút: " + mi);

		long thoiGian = System.currentTimeMillis();
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String date = df.format(thoiGian);
		System.out.println(date);
	}

}
