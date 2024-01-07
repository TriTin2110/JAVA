package LamLai.DanhSachSinhVien;

import java.io.Serializable;

/**
 * SinhVien
 */
public class SinhVien implements Serializable {
        private String tenSinhVien;
        private int maSinhVien, namSinh;
        private float diemTB;

        public SinhVien(int maSinhVien) {
                this.maSinhVien = maSinhVien;
        }

        public SinhVien(String tenSinhVien, int maSinhVien, int namSinh, float diemTB) {
                this.tenSinhVien = tenSinhVien;
                this.maSinhVien = maSinhVien;
                this.namSinh = namSinh;
                this.diemTB = diemTB;
        }

        public String getTenSinhVien() {
                return tenSinhVien;
        }

        public int getMaSinhVien() {
                return maSinhVien;
        }

        public int getnamSinh() {
                return namSinh;
        }

        public float getDiemTB() {
                return diemTB;
        }

        public void setTenSinhVien(String tenSinhVien) {
                this.tenSinhVien = tenSinhVien;
        }

        public void setMaSinhVien(int maSinhVien) {
                this.maSinhVien = maSinhVien;
        }

        public void setNamnamSinh(int namNhapHoc) {
                this.namSinh = namNhapHoc;
        }

        public void setDiemTB(float diemTB) {
                this.diemTB = diemTB;
        }

        @Override
        public String toString() {
                return "SinhVien [tenSinhVien=" + tenSinhVien + ", maSinhVien=" + maSinhVien + ", namnamSinh="
                                + namSinh + ", diemTB=" + diemTB + "]";
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                SinhVien other = (SinhVien) obj;
                if (maSinhVien != other.maSinhVien)
                        return false;
                return true;
        }

        /**
         * InnerDanhSachSinhVien
         */
        public String layTenSinhVien() {
                String tenSV = "";
                this.tenSinhVien.trim();
                int TSV = this.tenSinhVien.lastIndexOf(" ");
                tenSV = this.tenSinhVien.substring(TSV + 1, this.tenSinhVien.length());
                return tenSV;
        }
}