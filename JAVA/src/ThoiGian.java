import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

class ThoiGian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long giay = 3600;
		long t = TimeUnit.SECONDS.toHours(giay);
		System.out.println(giay + "s = " + t + "h");

		// Lấy ngày hiện tại
		Date d = new Date(System.currentTimeMillis());
		// Định dạng kiểu ngày khi in
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String date = df.format(d);
		System.out.println(date);

		Calendar cl = Calendar.getInstance();
		System.out.println(cl.get(Calendar.DATE) + "/" + (cl.get(Calendar.MONTH) + 1) + "/" + cl.get(Calendar.YEAR));
	}

}
