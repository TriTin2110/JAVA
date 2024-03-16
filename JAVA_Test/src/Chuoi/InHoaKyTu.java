import java.util.Scanner;

/**
 * InHoaKyTu
 */

public class InHoaKyTu {
        public static void main(String[] args) {
                /* In hoa ký tự sau ĐẦU TIÊN */
                Scanner sc = new Scanner(System.in);
                System.out.print("Hay nhap 1 chuoi bat ky: ");
                String chuoi = sc.nextLine();
                String kyTuDauTien = chuoi.substring(0, 1);
                String chuoiConLai = chuoi.substring(1);
                /*
                 * public String substring(int startIndex): Phương thức này trả về đối tượng
                 * chuỗi mới là chuỗi con của chuỗi đã cho tính từ startIndex đã nhập đến cuối
                 * cùng.
                 * public String substring(int startIndex, int endIndex): Phương thức này trả về
                 * đối tượng chuỗi mới là chuỗi con của chuỗi đã cho tính startIndex đến
                 * endIndex đã nhập.
                 */
                kyTuDauTien = kyTuDauTien.toUpperCase();

                /*
                 * ================================================================***==========
                 * ===================================================
                 */

                /* In hoa ký tự sau ĐẦU TIÊN và ký tự SAU KHOẢNG TRẮNG */
                char[] kyTu = chuoi.toCharArray();
                boolean khoangTrang = true;
                for (int i = 0; i < chuoi.length(); i++) {
                        if (Character.isLetter(kyTu[i])) { /* Nếu ký tự là chữ */
                                if (khoangTrang) { /* Sẽ kiểm tra khoảng trắng */
                                        kyTu[i] = Character.toUpperCase(kyTu[i]); /* Thì sẽ in hoa ký tự đó */
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
