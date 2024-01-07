import java.util.Scanner;

/**
 * chuyenChuHoaThanhChuThuong
 */
public class chuyenChuHoaThanhChuThuong {

        public static void main(String[] args) {
                /* Chuyển chữ cái đầu tiên thành chữ thường */
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 chuoi bat ky: ");
                String chuoi = sc.nextLine();
                String kyTuDauTien = chuoi.substring(0, 1);
                String chuoiConLai = chuoi.substring(1);
                kyTuDauTien = kyTuDauTien.toLowerCase();

                /* ======================================== */
                /* Chuyển chữ cái đầu tiên và chữ cái sau khoảng trắng thành chữ thường */
                char[] kyTu = chuoi.toCharArray();
                boolean khoangTrang = true;
                for (int i = 0; i < chuoi.length(); i++) {
                        if (Character.isLetter(kyTu[i])) {
                                if (khoangTrang) {
                                        kyTu[i] = Character.toLowerCase(kyTu[i]);
                                        khoangTrang = false;
                                }
                        } else
                                khoangTrang = true;
                }
                chuoi = String.valueOf(kyTu);
                System.out.println(kyTuDauTien + chuoiConLai);
                System.out.println(chuoi);
        }

}