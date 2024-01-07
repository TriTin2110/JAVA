package GhiChu;

import java.io.Serializable;

public class Setting implements Serializable {
        String mauChuDe, loaiPhong, coChu;

        public Setting(String mauChuDe, String loaiPhong, String coChu) {
                this.mauChuDe = mauChuDe;
                this.loaiPhong = loaiPhong;
                this.coChu = coChu;
        }

        public String getMauChuDe() {
                return mauChuDe;
        }

        public void setMauChuDe(String mauChuDe) {
                this.mauChuDe = mauChuDe;
        }

        public String getLoaiPhong() {
                return loaiPhong;
        }

        public void setLoaiPhong(String loaiPhong) {
                this.loaiPhong = loaiPhong;
        }

        public String getCoChu() {
                return coChu;
        }

        public void setCoChu(String coChu) {
                this.coChu = coChu;
        }

        @Override
        public String toString() {
                return mauChuDe + ";" + loaiPhong + ";" + coChu;
        }

}
