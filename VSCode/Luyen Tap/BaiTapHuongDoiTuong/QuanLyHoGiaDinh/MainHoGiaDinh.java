package QuanLyHoGiaDinh;

import java.util.Scanner;

public class MainHoGiaDinh {
        static Scanner sc = new Scanner(System.in);
        static boolean check = true;

        public static void main(String[] args) {
                // int n = 0;
                // do {
                // try {
                // do {
                // System.out.println("Hãy nhập số hộ gia đình bạn muốn thêm: ");
                // n = sc.nextInt();
                // check = true;
                // } while (n <= 0);
                // } catch (Exception e) {
                // // TODO: handle exception
                // System.out.println("Số lượng hộ gia đình không hợp lệ!");
                // check = false;
                // }
                // sc.nextLine();
                // } while (!check);
                KhuPho khuPho = new KhuPho();
                khuPho.docKetQua();
                // nhapThongTinHoGiaDinh(n, khuPho);
                khuPho.hienThiHoGiaDinh();
                // khuPho.luuKetQua();
                // sc.close();

        }

        public static void nhapThongTinHoGiaDinh(int n, KhuPho khuPho) {
                int soLuongThanhVien = 0;
                int soNha = 0;
                for (int i = 0; i < n; i++) {
                        HoGiaDinh hoGiaDinh;
                        do {
                                System.out.println("Hãy nhập thông tin của hộ gia đình thứ " + (i + 1));
                                // Nhập số lượng thành viên
                                do {
                                        try {
                                                System.out.println("Hãy nhập số lượng thành viên của hộ gia đình: ");
                                                soLuongThanhVien = sc.nextInt();
                                                check = true;
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Số lượng thành viên không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check || soLuongThanhVien == 0);

                                // Nhập số nhà
                                do {
                                        try {
                                                System.out.println("Hãy nhập số nhà của hộ gia đình: ");
                                                soNha = sc.nextInt();
                                                check = true;
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Số nhà không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check || soNha == 0);
                                hoGiaDinh = new HoGiaDinh(soLuongThanhVien, soNha);
                        } while (!khuPho.themHoGiaDinh(hoGiaDinh)); // hộ gia đình sẽ được nhập lại nếu kết quả trả về
                                                                    // false
                        nhapNguoi(hoGiaDinh, khuPho);
                        System.out.println("\n---------------------------------\n");
                }
        }

        // Nhập thông tin của thành viên trong gia đình
        public static void nhapNguoi(HoGiaDinh hoGiaDinh, KhuPho khuPho) {
                String hoTen, ngheNghiep;
                int tuoi = 0, CMND = 0;
                for (int i = 0; i < hoGiaDinh.getSoThanhVien(); i++) {
                        Nguoi nguoi;
                        do {
                                System.out.println("Hãy nhập tên của thành viên thứ " + (i + 1) + ": ");
                                hoTen = sc.nextLine();
                                System.out.println("Hãy nhập nghề nghiệp của thành viên thứ " + (i + 1) + ": ");
                                ngheNghiep = sc.nextLine();

                                // Nhập số tuổi
                                do {
                                        try {
                                                System.out.println(
                                                                "Hãy nhập tuổi của thành viên thứ " + (i + 1) + ": ");
                                                tuoi = sc.nextInt();
                                                check = true;
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Số tuổi không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check || tuoi == 0);

                                // Nhập số CMND
                                do {
                                        try {
                                                System.out.println(
                                                                "Hãy nhập CMND của thành viên thứ " + (i + 1) + ": ");
                                                CMND = sc.nextInt();
                                                check = true;
                                        } catch (Exception e) {
                                                // TODO: handle exception
                                                System.out.println("Số CMND không hợp lệ!");
                                                check = false;
                                        }
                                        sc.nextLine();
                                } while (!check || CMND == 0);
                                nguoi = new Nguoi(hoTen, ngheNghiep, tuoi, CMND);
                        } while (!hoGiaDinh.themNguoi(nguoi, khuPho)); // Nếu trùng CMND
                }
        }
}
