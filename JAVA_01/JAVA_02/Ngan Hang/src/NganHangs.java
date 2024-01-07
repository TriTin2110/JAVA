import java.io.Serializable;

/**
 * NganHang
 */
public class NganHangs implements Serializable {
    String makh;
    String hoten;
    long taikhoan;
    String phanloai;

    public NganHangs() {
        this.makh = "";
        this.hoten = "";
        this.taikhoan = 0;
        this.phanloai = "";
    }

    public NganHangs(String ht, String ma, long tk) {
        this.makh = ma;
        this.hoten = ht;
        this.taikhoan = tk;
        if (this.taikhoan >= 1000000000)
            this.phanloai = "VIP";
        else if (this.taikhoan >= 100000000)
            this.phanloai = "Tiem Nang";
        else
            this.phanloai = "Pho Thong";
    }
    public void setMaSo(String ms)
    {
    	this.makh = ms;
    }
    public String getHoten() {
        return this.hoten;
    }

    public String getMaSo() {
        return this.makh;
    }

    public String getPhanLoai() {
        return this.phanloai;
    }

    public long getTaiKhoan() {
        return this.taikhoan;
    }
}