package NTT;

public class Student {
    String hoten;
    String masosinhvien;
    double diem;
    String ketqua;

    public Student() {
        this.hoten = "";
        this.masosinhvien = "";
        this.diem = 0;
        if (diem > 5)
            this.ketqua = "Dat";
        else
            this.ketqua = "Rot";
    }

    public Student(String ht, String mssv, double d) {
        this.hoten = ht;
        this.masosinhvien = mssv;
        this.diem = d;
        if (this.diem > 5)
            this.ketqua = "Dat";
        else
            this.ketqua = "Rot";
    }

    public void setHOTEN(String ht) {
        this.hoten = ht;
    }

    public void setID(String mssv) {
        this.masosinhvien = mssv;
    }

    public void setDIEM(double d) {
        this.diem = d;
        if (this.diem > 5)
            this.ketqua = "Dat";
        else
            this.ketqua = "Rot";
    }

    public String getHOTEN() {
        return hoten;
    }

    public String getMSSV() {
        return masosinhvien;
    }

    public double getDIEM() {
        return diem;
    }

    public String getKQ() {
        return ketqua;
    }

    public String toString() {
        return "Student_ID: " + this.masosinhvien + " Student_Name: " + this.hoten + " Resutl: " + this.diem
                + " Rank :" + this.ketqua;
    }
}
