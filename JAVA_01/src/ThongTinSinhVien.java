/**
 * ThongTinSinhVien
 */
public class ThongTinSinhVien {

    String hoten;
    int masinhvien;
    double diem1, diem2, diem3, diemtrungbinh;
    String xeploai;

    public void nhap(String ht, int mssv, double d1, double d2, double d3, double dtb, String xl) {
        this.hoten = ht;
        this.masinhvien = mssv;
        this.diem1 = d1;
        this.diem2 = d2;
        this.diem3 = d3;
        this.diemtrungbinh = dtb;
        this.xeploai = xl;
    }

    public void xuat() {
        System.out.println("Ho ten: " + hoten);
        System.out.println("Ma sinh vien: " + masinhvien);
        System.out.println("Diem 1: " + diem1);
        System.out.println("Diem 2: " + diem2);
        System.out.println("Diem 3: " + diem3);
    }

    public void tinhdiemtrungbinh() {
        this.diemtrungbinh = (this.diem1 + this.diem2 + this.diem3) / 3;
    }

    public void xeploai() {
        if (this.diemtrungbinh >= 9)
            this.xeploai = "Xuat Sac";
        else if (this.diemtrungbinh >= 8)
            this.xeploai = "Gioi";
        else if (this.diemtrungbinh >= 7)
            this.xeploai = "Kha";
        else if (this.diemtrungbinh >= 6)
            this.xeploai = "Trung binh kha";
        else if (this.diemtrungbinh >= 5)
            this.xeploai = "Trung binh";
        else
            this.xeploai = "Yeu";
    }

}
