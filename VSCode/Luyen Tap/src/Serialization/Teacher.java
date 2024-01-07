package Serialization;

import java.io.Serializable;

public class Teacher implements Serializable {
        private String tenGiaoVien;
        private int maGiaoVien;
        //Dùng để xác định lớp implements Serializable là 1 
        private static final long serialVersionUID = 1;
        public Teacher() {
        }

        public Teacher(String tenGiaoVien, int maGiaoVien) {
                this.tenGiaoVien = tenGiaoVien;
                this.maGiaoVien = maGiaoVien;
        }

        public String getTenGiaoVien() {
                return tenGiaoVien;
        }

        public void setTenGiaoVien(String tenGiaoVien) {
                this.tenGiaoVien = tenGiaoVien;
        }

        public int getMaGiaoVien() {
                return maGiaoVien;
        }

        public void setMaGiaoVien(int maGiaoVien) {
                this.maGiaoVien = maGiaoVien;
        }

}
