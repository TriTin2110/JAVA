package Test;

import code_a.ViDu;

public class Main {
        public static void main(String[] args) {
                ViDu vd1 = new ViDu("Nguyễn Trí Tín");
                System.out.println(vd1.getName());
                code_b.ViDu vd2 = new code_b.ViDu(2003);
                System.out.println(vd2.getNamSinh());
        }
}
