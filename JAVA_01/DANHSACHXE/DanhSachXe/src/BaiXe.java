import java.io.Serializable;

/**
 * BaiXe
 */
public class BaiXe implements Serializable {
    String tenNguoiGui;
    String bienSoXe;
    String ngayDongTien;
    long soTienDong;

    public BaiXe() {
        this.tenNguoiGui = "";
        this.bienSoXe = "";
        this.ngayDongTien = "";
        this.soTienDong = 0;
    }

    public BaiXe(String ht, String bs, String ng, long td) {
        this.tenNguoiGui = ht;
        this.bienSoXe = bs;
        this.ngayDongTien = ng;
        this.soTienDong = td;
    }

    public String setHoTen(String ht) {
        return this.tenNguoiGui;
    }

    public String getHoTen() {
        return this.tenNguoiGui;
    }

    public String getBienSo() {
        return this.bienSoXe;
    }

    public String getNgayGui() {

        return this.ngayDongTien;
    }

    public long getTienDong() {
        return this.soTienDong;
    }

    public String getTen() {
        String chuoi[] = this.tenNguoiGui.split("\\s");
        return chuoi[chuoi.length - 1];
    }
}