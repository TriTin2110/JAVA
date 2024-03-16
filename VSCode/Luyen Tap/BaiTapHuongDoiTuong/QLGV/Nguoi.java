package QLGV;

class Nguoi {
        private int maGiaoVien, tuoi;
        private String hoTen, queQuan;
        Luong luong;

        public Nguoi(int maGiaoVien) {
                this.maGiaoVien = maGiaoVien;
        }

        public Nguoi(int maGiaoVien, int tuoi, String hoTen, String queQuan, double luongCung, double luongThuong,
                        double phat) {
                this.maGiaoVien = maGiaoVien;
                this.tuoi = tuoi;
                this.hoTen = hoTen;
                this.queQuan = queQuan;
                luong = new Luong(luongCung, luongThuong, phat);
        }

        public int getMaGiaoVien() {
                return maGiaoVien;
        }

        public void setMaGiaoVien(int maGiaoVien) {
                this.maGiaoVien = maGiaoVien;
        }

        public int getTuoi() {
                return tuoi;
        }

        public void setTuoi(int tuoi) {
                this.tuoi = tuoi;
        }

        public String getHoTen() {
                return hoTen;
        }

        public void setHoTen(String hoTen) {
                this.hoTen = hoTen;
        }

        public String getQueQuan() {
                return queQuan;
        }

        public void setQueQuan(String queQuan) {
                this.queQuan = queQuan;
        }

        public Luong getLuong() {
                return luong;
        }

        public void setLuong(Luong luong) {
                this.luong = luong;
        }

        @Override
        public boolean equals(Object obj) {
                if (this == obj)
                        return true;
                if (obj == null)
                        return false;
                if (getClass() != obj.getClass())
                        return false;
                Nguoi other = (Nguoi) obj;
                if (maGiaoVien != other.maGiaoVien)
                        return false;
                return true;
        }

        @Override
        public String toString() {
                return "Nguoi [maGiaoVien=" + maGiaoVien + ", tuoi=" + tuoi + ", hoTen=" + hoTen + ", queQuan="
                                + queQuan + "\n\t|_luong=" + luong.toString() + "]";
        }

}
