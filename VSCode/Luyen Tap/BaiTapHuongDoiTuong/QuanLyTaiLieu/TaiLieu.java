package QuanLyTaiLieu;

public class TaiLieu {
        private int maTaiLieu, soBanPhatHanh;
        private String nhaXuatBan;

        public TaiLieu(int maTaiLieu) {
                this.maTaiLieu = maTaiLieu;
        }

        public TaiLieu(int maTaiLieu, int soPhatHanh, String nhaXuatBan) {
                this.maTaiLieu = maTaiLieu;
                this.soBanPhatHanh = soPhatHanh;
                this.nhaXuatBan = nhaXuatBan;
        }

        public int getMaTaiLieu() {
                return maTaiLieu;
        }

        public void setMaTaiLieu(int maTaiLieu) {
                this.maTaiLieu = maTaiLieu;
        }

        public int getSoPhatHanh() {
                return soBanPhatHanh;
        }

        public void setSoPhatHanh(int soPhatHanh) {
                this.soBanPhatHanh = soPhatHanh;
        }

        public String getNhaXuatBan() {
                return nhaXuatBan;
        }

        public void setNhaXuatBan(String nhaXuatBan) {
                this.nhaXuatBan = nhaXuatBan;
        }

        @Override
        public String toString() {
                return "TaiLieu [maTaiLieu=" + maTaiLieu + ", soBanPhatHanh=" + soBanPhatHanh + ", nhaXuatBan="
                                + nhaXuatBan
                                + "]";
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                TaiLieu other = (TaiLieu) obj;
                if (maTaiLieu != other.maTaiLieu)
                        return false;
                return true;
        }

}
