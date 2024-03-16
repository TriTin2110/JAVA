
public class KieuDuLieu {
	public static void main(String[] args) {
		// Menu
		String com = "Cơm";
		final int giaCom = 15;
		boolean conCom = false;
		char maCom = 'C';
		giaCom = 20;
		String bun = "Bún";
		int giaBun = 20;
		char maBun = 'B';
		if(conCom == true)
			System.out.println("Còn "+com+" với giá là "+ giaCom+ " và mã là: "+maCom);
		else
			System.out.println("Còn "+bun+" với giá là "+ giaBun+ " và mã là: "+maBun);
	}
}
