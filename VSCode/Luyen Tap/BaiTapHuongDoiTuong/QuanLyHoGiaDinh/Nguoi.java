package QuanLyHoGiaDinh;

import java.io.Serializable;

public class Nguoi implements Serializable {
        private String hoTen, ngheNghiep;
        private int tuoi, CMND;
        private static final long serialVersionUID = 1;

        public Nguoi(String hoTen, String ngheNghiep, int tuoi, int cMND) {
                this.hoTen = hoTen;
                this.ngheNghiep = ngheNghiep;
                this.tuoi = tuoi;
                CMND = cMND;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public String getNgheNghiep() {
                return ngheNghiep;
        }

        public void setNgheNghiep(String ngheNghiep) {
                this.ngheNghiep = ngheNghiep;
        }

        public int getTuoi() {
                return tuoi;
        }

        public void setTuoi(int tuoi) {
                this.tuoi = tuoi;
        }

        public int getCMND() {
                return CMND;
        }

        public void setCMND(int cMND) {
                CMND = cMND;
        }

        @Override
        public String toString() {
                return "Nguoi [hoTen=" + hoTen + ", ngheNghiep=" + ngheNghiep + ", tuoi=" + tuoi + ", CMND=" + CMND
                                + "]";
        }

}
