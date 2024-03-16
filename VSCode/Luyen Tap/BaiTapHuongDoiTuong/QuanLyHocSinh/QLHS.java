package QuanLyHocSinh;

import java.util.Comparator;
import java.util.LinkedList;

public class QLHS {
        LinkedList<HocSinh> hocSinhs;

        public QLHS() {
                this.hocSinhs = new LinkedList<>();
        }

        public LinkedList<HocSinh> getHocSinhs() {
                return hocSinhs;
        }

        public void setHocSinhs(LinkedList<HocSinh> hocSinhs) {
                this.hocSinhs = hocSinhs;
        }

        public void themHocSinh(HocSinh hocSinhMoi) {
                this.hocSinhs.add(hocSinhMoi);
        }

        public void hienThiDanhSachHocSinh() {
                sapXepHocSinh();
                this.hocSinhs.forEach(hs -> System.out.println(hs.toString()));
        }

        public void hienThiHocSinhTrenHaiMuoi() {
                this.hocSinhs.forEach(hs -> {
                        if (hs.getTuoi() > 20)
                                System.out.println(hs.toString());
                });
        }

        public void hienThiHocSinhTheoDieuKien() {
                this.hocSinhs.forEach(hs -> {
                        if (hs.getTuoi() > 23 && hs.getQueQuan().equals("DN"))
                                System.out.println(hs.toString());
                });
        }

        public void sapXepHocSinh() {
                this.hocSinhs.sort(new Comparator<HocSinh>() {

                        @Override
                        public int compare(HocSinh o1, HocSinh o2) {
                                // TODO Auto-generated method stub
                                // Nếu lớp trc > lớp sau thì sẽ hoán đổi 2 học sinh
                                if (o1.getLop().getTenLop().compareTo(o2.getLop().getTenLop()) == 1)
                                        return 1;
                                else if (o1.getLop().getTenLop().compareTo(o2.getLop().getTenLop()) == -1)
                                        return -1;
                                else
                                        return 0;
                        }

                });
        }
}
