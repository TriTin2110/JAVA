/**
 * sinhvien
 */
public class sinhvien {
    int masinhvien;
    String hoten;
    double diem;
    String xeploai;

    /*
     * public nhap(int ms, String ht, double d, String xl) {
     * this.masinhvien = ms;
     * this.hoten = ht;
     * this.diem = d;
     * this.xeploai = xl;
     * }
     */

    public void xuat() {
        System.out.print("Ma so cua sinh vien la: " + masinhvien);
        System.out.print("Ho ten cua sinh vien la: " + hoten);
        System.out.print("Diem trung binh cua sinh vien la: " + diem);
        System.out.print("Xep loai cua sinh vien la: " + xeploai);
    }
}