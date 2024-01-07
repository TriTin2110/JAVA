/**
 * ThongTinSV
 */
public class ThongTinSV {
    String hoten;
    int tuoi;

    public void xuat() {
        System.out.println("Ho ten: " + hoten);
        System.out.println("Tuoi: " + tuoi);
    }

    public void nhap(String ht, int t) {
        this.hoten = ht;
        this.tuoi = t;
    }
}