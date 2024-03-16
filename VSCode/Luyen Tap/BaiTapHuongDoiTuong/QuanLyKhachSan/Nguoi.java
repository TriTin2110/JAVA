package QuanLyKhachSan;

import java.io.Serializable;

public class Nguoi implements Serializable{
        private String hoTen;
        private int tuoi, soCMND;

        public Nguoi(String hoTen, int tuoi, int soCMND) {
                this.hoTen = hoTen;
                this.tuoi = tuoi;
                this.soCMND = soCMND;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public int getTuoi() {
                return tuoi;
        }

        public void setTuoi(int tuoi) {
                this.tuoi = tuoi;
        }

        public int getSoCMND() {
                return soCMND;
        }

        public void setSoCMND(int soCMND) {
                this.soCMND = soCMND;
        }

        @Override
        public String toString() {
                return "Nguoi [hoTen=" + hoTen + ", tuoi=" + tuoi + ", soCMND=" + soCMND + "]";
        }

}
