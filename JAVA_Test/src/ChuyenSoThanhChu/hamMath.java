package ChuyenSoThanhChu;

public class hamMath {
	public static void main(String[] args) {
		double a = 1.5, b = 2;
		
		//Hàm trị tuyệt đối
		System.out.println("|a|= "+Math.abs(a));
		
		//Hàm làm tròn lên
		System.out.println("Ceil a = "+Math.ceil(a));
		
		//Hàm làm tròn xuống
		System.out.println("Florr a = "+Math.floor(a));
				
		//Hàm làm min
		System.out.println("min(a,b) = "+Math.min(a, b));
		
		//Hàm làm max
		System.out.println("max(a,b) = "+Math.max(a, b));
		
		//Hàm căn bậc 2
		System.out.println("Căn bậc 2 của a = " +Math.sqrt(a));
		
		//Hàm lũy thừa
		System.out.println("Lũy thừa bậc 2 của a = " +Math.pow(a, 2));
	}
	
}
