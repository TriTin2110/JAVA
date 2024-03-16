package QuanLyTaiLieu;

public class TapChi extends TaiLieu {
        private int soPhatHanh, thangPhatHanh;

        public TapChi(int maTaiLieu, int soPhatHanh, String nhaXuatBan, int soPhatHanh2, int thangPhatHanh) {
                super(maTaiLieu, soPhatHanh, nhaXuatBan);
                soPhatHanh = soPhatHanh2;
                this.thangPhatHanh = thangPhatHanh;
        }

        public int getSoPhatHanh() {
                return soPhatHanh;
        }

        public void setSoPhatHanh(int soPhatHanh) {
                this.soPhatHanh = soPhatHanh;
        }

        public int getThangPhatHanh() {
                return thangPhatHanh;
        }

        public void setThangPhatHanh(int thangPhatHanh) {
                this.thangPhatHanh = thangPhatHanh;
        }

        @Override
        public String toString() {
                return "TapChi [soPhatHanh=" + soPhatHanh + ", thangPhatHanh=" + thangPhatHanh + ", maTaiLieu="
                                + super.getMaTaiLieu()
                                + ", soBanPhatHanh=" + super.getSoPhatHanh() + ", nhaXuatBan=" + super.getNhaXuatBan()
                                + "]";
        }

}
