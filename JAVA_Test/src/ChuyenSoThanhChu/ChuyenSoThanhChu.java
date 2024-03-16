package ChuyenSoThanhChu;
import java.util.Scanner;

public class ChuyenSoThanhChu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i = 0; i <= 999; i++)
		{
			int n = i;
			int donVi = (n%100)%10;	//donVi là phần dư của n / 10
			int chuc = (n%100)/10;	//chuc là phần nguyên của n /10
			int tram = n/100;		// tram là phần hàng trăm của n
			String soDonVi = "";
			String soChuc = "";
			String soTram ="";
			String ketQua = "";
			if (tram == 0 && chuc ==1 && soDonVi!=null) //Nếu hàng trăm = 0 và hàng chục = 1 thì sẽ trả về giá trị là "Mười" từ 11 -> 19
			{								
				ketQua= traVeChuc(chuc, soChuc, n, donVi) +" " + traVeDonVi(donVi, soDonVi, n, chuc);
			}
			else if (tram == 0 && chuc >1 && chuc <= 9 && soDonVi!=null) //Từ 20 -> 99  
			{
				soChuc = traVeChuc(chuc, soChuc, n, donVi);
				ketQua= soChuc +" "+ traVeDonVi(donVi, soDonVi, n, chuc);
			}
			else if (tram == 0 && n>=1 && n<=9) // Hàm này sẽ xuất giá trị từ 1 -> 9
			{
				ketQua = traVeDonVi(donVi, soDonVi, n, chuc);
			}
			else if (tram>=1 && tram <=9 && chuc>=0 && chuc <=9 && soDonVi!=null) { // Từ 100 -> 999
				ketQua = traVeTram(tram, soTram)+" " + traVeChuc(chuc, soChuc, donVi, donVi)+" "+ traVeDonVi(donVi, soDonVi, n, chuc);
			}
			else {
				ketQua = "Không";
			}
			System.out.println(n+": "+ketQua);
		}
	}
	public static String traVeDonVi(int donVi, String soDonVi, int n, int chuc) {
		//Hàm này sẽ lấy giá trị donVi đc tính từ n%10, thêm giá trị n vì để phân biệt giữa "Năm" và "Lăm"
		if (donVi%10>0 && donVi<10) {
			if (n==1|| chuc == 0 && donVi == 1 || chuc == 1 && donVi == 1) { //khi hàng đơn vị = 0 hoặc = 1 và hàng chục = 0 hoặc = 1 thì hàng đơn vị sẽ trả về giá trị là "Một"
				soDonVi = "Một";  
			}
			else if (donVi%10 == 1 && n!=11) {//khi phần đơn vị = 1 và input khác 11 thì hàng đơn vị sẽ trả về giá trị "Mốt"
				soDonVi = "Mốt";
			}
			else if (donVi%10==2) {
				soDonVi = "Hai";
			}
			else if (donVi%10==3) {
				soDonVi = "Ba";
			}
			else if (donVi%10==4) {
				soDonVi = "Bốn";
			}
			else if (n==5 || chuc == 0 && donVi == 5) { //Nếu giá trị input = 5 hoặc khi hàng chục = 0 và hàng đơn vị = 5 thì hàng đơn vị sẽ trả về giá trị là "Năm"
				soDonVi = "Năm";
			}
			else if (donVi%10==5) //Nếu phần đơn vị là 5 thì sẽ trả về giá trị là "Lăm"
			{
				soDonVi = "Lăm";
			}
			else if (donVi%10==6) {
				soDonVi = "Sáu";
			}
			else if (donVi%10==7) {
				soDonVi = "Bảy";
			}
			else if (donVi%10==8) {
				soDonVi = "Tám";
			}
			else if (donVi%10==9){
				soDonVi = "Chín";
			}
		}
		return soDonVi;
	}
	public static String traVeChuc(int chuc, String soChuc, int n, int donVi) {
		if(chuc == 0&& donVi !=0)	//khi hàng chục = 0 và hàng đơn vị mang bất kì số nào đó khác 0 thì hàng chục sẽ trả về giá trị là "Lẻ"
		{
			soChuc = "Lẻ";	
		}
		if (chuc%10>0) {
			if (chuc%10 == 1) {//khi hàng chục = 1 thì sẽ trả về giá trị là mười
				soChuc = "Mười";
			}
			else if (chuc%10==2) {
				soChuc = "Hai Mươi";
			}
			else if (chuc%10==3) {
				soChuc = "Ba Mươi";
			}
			else if (chuc%10==4) {
				soChuc = "Bốn Mươi";
			}
			else if (chuc%10==5) { 
				soChuc = "Năm Mươi";
			}
			else if (chuc%10==6) {
				soChuc = "Sáu Mươi";
			}
			else if (chuc%10==7) {
				soChuc = "Bảy Mươi";
			}
			else if (chuc%10==8) {
				soChuc = "Tám Mươi";
			}
			else if (chuc%10==9){
				soChuc = "Chín Mươi";
			}
		}
		return soChuc;
	}
	public static String traVeTram(int tram, String soTram) {
		if (tram>0) {
			
			if (tram == 1) {
				soTram = "Một Trăm";
			}
			else if (tram==2) {
				soTram = "Hai Trăm";
			}
			else if (tram==3) {
				soTram = "Ba Trăm";
			}
			else if (tram==4) {
				soTram = "Bốn Trăm";
			}
			else if (tram==5) { 
				soTram = "Năm Trăm";
			}
			else if (tram==6) {
				soTram = "Sáu Trăm";
			}
			else if (tram==7) {
				soTram = "Bảy Trăm";
			}
			else if (tram==8) {
				soTram = "Tám Trăm";
			}
			else if (tram==9){
				soTram = "Chín Trăm";
			}
		}
		return soTram;
	}
}
