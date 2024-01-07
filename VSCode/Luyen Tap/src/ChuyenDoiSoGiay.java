import java.util.Scanner;

public class ChuyenDoiSoGiay {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int giay;
                try {
                        do {
                                System.out.println("Hãy nhập số giây: ");
                                giay = sc.nextInt();
                        } while (giay < 1);
                } catch (Exception e) {
                        System.out.println("Số giây không hợp lệ!");
                        return;
                }
                output(giay);
                sc.close();
        }

        /**
         * output(int giay)
         */
        public static void output(int giay) {
                String gio = Integer.toString(giay / 3600);
                gio = (gio.compareTo("10") > 0) ? gio : "0" + gio;
                String phut = Integer.toString((giay % 3600) / 60);
                phut = (phut.compareTo("10") > 0) ? phut : "0" + phut;
                String s = Integer.toString((giay % 3600) % 60);
                s = (s.compareTo("10") > 0) ? s : "0" + s;
                System.out.println(gio + ":" + phut + ":" + s);
        }
}
