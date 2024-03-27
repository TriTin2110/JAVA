package TaoFile;

import java.text.SimpleDateFormat;
import java.util.Date;

class ngaySinh {
	private int ngay, thang, nam;

	public ngaySinh(int ngay, int thang, int nam) {
		this.ngay = ngay;
		this.thang = thang;
		this.nam = nam;
	}

	@Override
	public String toString() {
		Date d = new Date(nam - 1900, thang - 1, ngay);
//		Date d = new Date(ngay + thang + nam);
		SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
		String DOF = df.format(d);
		return DOF;
	}
}
