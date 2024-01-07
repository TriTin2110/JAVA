/**
 * thongtinsinhvien2
 */
public class thongtinsinhvien2 {
    String hoten;
    String hovaten = "";
    String hovaten2 = "";
    String mssv;
    float diem1, diem2, diem3, diemtb;
    String xeploai;

    public void nhap(String ht, String ms, float d1, float d2, float d3, float dtb) {
        this.hoten = ht;
        this.mssv = ms;
        this.diem1 = d1;
        this.diem2 = d2;
        this.diem3 = d3;
        this.diemtb = dtb;
    }

    public void xuat() {
        System.out.println("Ho ten: " + hoten);
        System.out.println("Ma so sinh vien: " + mssv);
    }

    public void tinhdiemtrungbinh(float diem1, float diem2, float diem3, float diemtb) {
        this.diemtb = (this.diem1 + this.diem2 + this.diem3) / 3;
    }

    public void xeploai(double diemtb) {
        if (diemtb >= 9)
            this.xeploai = "Xuat sac";
        else if (diemtb >= 8)
            this.xeploai = "Gioi";
        else if (diemtb >= 7)
            this.xeploai = "Kha";
        else if (diemtb >= 6)
            this.xeploai = "Trung binh kha";
        else if (diemtb >= 5)
            this.xeploai = "Trung binh";
        else
            this.xeploai = "Yeu";
    }
}