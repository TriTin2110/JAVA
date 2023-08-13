import java.util.Scanner;

public class MainATM {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                ATM atm = new ATM(0);
                while (true) {
                        System.out.println();
                        System.out.println("Hãy nhập lựa chọn của bạn:");
                        System.out.println("1. Kiểm tra số dư");
                        System.out.println("2. Gửi tiền");
                        System.out.println("3. Rút tiền");
                        System.out.println("Lựa chọn của bạn là: ");
                        int luaChon = sc.nextInt();
                        if (luaChon > 3 || luaChon < 1) {
                                break;
                        }
                        inThongTin(luaChon, atm);
                }
        }

        /**
         * inThongTin(int luaChon)
         */
        public static void inThongTin(int luaChon, ATM atm) {
                Scanner sc1 = new Scanner(System.in);
                long tien = 0;
                System.out.println("\n----------------------");
                switch (luaChon) {
                        case 1: {
                                System.out.println(atm.getSoDu() + "/VNĐ");
                                break;
                        }
                        case 2: {
                                System.out.println("Hãy nhập số tiền bạn muốn gửi hoặc nhập 0 để hủy: ");
                                tien = sc1.nextLong();
                                if (tien == 0) {
                                        break;
                                } else {
                                        System.out.println(atm.tinhSoDuSauKhiGui(tien) + "/VNĐ");
                                        atm.setSoDu(atm.getSoDu() + tien);
                                        break;
                                }

                        }
                        case 3: {
                                System.out.println("Hãy nhập số tiền bạn muốn rút hoặc nhập 0 để hủy: ");
                                tien = sc1.nextLong();
                                if (tien == 0) {
                                        break;
                                } else {
                                        System.out.println(atm.tinhSoDuSauKhiRut(tien) + "/VNĐ");
                                        atm.setSoDu(atm.getSoDu() - tien);
                                        break;
                                }

                        }
                }
        }
}
