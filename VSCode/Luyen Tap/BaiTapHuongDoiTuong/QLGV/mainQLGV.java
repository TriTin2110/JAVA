package QLGV;

import java.nio.charset.Charset;
import java.util.Random;

class mainQLGV {
        public static void main(String[] args) {
                QLGV qlgv = new QLGV();
                char c = 'A';
                int stt = 0;
                StringBuilder c1 = new StringBuilder();
                boolean check = false;
                for (int i = 0; i < 60; i++) {
                        qlgv.themGiaoVien(new Nguoi((i + 1), 30, "Nguyễn Văn " + c1, "HCM",
                                        new Random().nextDouble(10000000) + 10000000,
                                        new Random().nextDouble(1000000) + 2000000,
                                        new Random().nextDouble(2000000) + 3000000));

                        if (c > 'Z') {
                                c = 'A';
                                c1 = c1.insert(0, c);
                                check = true;
                                stt++;
                        }
                        if (check)
                                c1.replace(stt, c1.capacity(), c + "");
                        else
                                c1.replace(stt, c1.capacity(), c + "");
                        c++;
                }
                qlgv.xoaGiaoVien(new Nguoi(30));
                qlgv.inDanhSach();
        }
}
