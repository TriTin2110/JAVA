package QuanLyCanBo;

import java.util.LinkedList;

public class QLCB {
        LinkedList<CanBo> list;

        public QLCB() {
                this.list = new LinkedList<>();
        }

        public void themCanBo(CanBo canBoMoi) {
                list.add(canBoMoi);
        }

        public void xuatDanhSachCanBo() {
                list.forEach(li -> System.out.println(li.toString()));
        }

        public void timKiemTheoTen(String ten) {
                list.forEach(li -> {
                        if (layTen(ten).equals(layTen(li.getHoTen()))) {
                                System.out.println("Đã tìm thấy!");
                                System.out.println(li.toString());
                        }
                });
        }

        public String layTen(String ten) {
                int i = ten.lastIndexOf(" ");
                return ten.substring(i + 1, ten.length());
        }
}
