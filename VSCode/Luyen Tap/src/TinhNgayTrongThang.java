import java.util.Scanner;

public class TinhNgayTrongThang {
        public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);
                int thang, nam;
                try {
                        do {
                                System.out.println("Hãy nhập tháng: ");
                                thang = sc.nextInt();
                        } while (thang < 1 || thang > 12);
                } catch (Exception e) {
                        System.out.println("Giá trị tháng không hợp lệ!");
                        return;
                }

                try {
                        do {
                                System.out.println("Hãy nhập năm: ");
                                nam = sc.nextInt();
                        } while (nam < 1);
                } catch (Exception e) {
                        System.out.println("Giá trị năm không hợp lệ!");
                        return;
                }
                tinhNgay(thang, nam);
                sc.close();
        }

        /**
         * tinhNgay(int thang, int nam)
         */
        public static void tinhNgay(int thang, int nam) {
                switch (thang) {
                        case 1:
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12: {
                                System.out.println("Tháng " + thang + " trong " + nam + " có 31 ngày!");
                                break;
                        }
                        case 4:
                        case 6:
                        case 9:
                        case 11: {
                                System.out.println("Tháng " + thang + " năm " + nam + " có 30 ngày!");
                                break;
                        }
                        default:
                                if (nam % 4 == 0 && nam % 100 != 0 || nam % 400 == 0) {
                                        System.out.println("Tháng " + thang + " năm " + nam + " có 29 ngày!");
                                        break;
                                } else {
                                        System.out.println("Tháng " + thang + " năm " + nam + " có 28 ngày!");
                                }
                }
        }
}
