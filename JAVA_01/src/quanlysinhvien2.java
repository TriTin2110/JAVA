import java.util.Scanner;

/**
 * quanlysinhvien2
 */
public class quanlysinhvien2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        thongtinsinhvien2 dssv[] = new thongtinsinhvien2[100];
        System.out.print("Hay nhap so luong sinh vien co trong danh sach: ");
        int n = scanner.nextInt();
        int kiemtra = 0;
        for (int i = 0; i < n; i++) {
            dssv[i] = new thongtinsinhvien2();
            scanner.nextLine();
            do {
                kiemtra = 0;
                System.out.print("\nHay nhap ten cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].hoten = scanner.nextLine();
                if (dssv[i].hoten.matches(".*[0-9]")) {
                    kiemtra++;
                }
            } while (kiemtra > 0);
            do {
                kiemtra = 0;
                System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + (i + 1) +
                        ": ");
                dssv[i].mssv = scanner.nextLine();
                if (dssv[i].mssv.length() != 8)
                    kiemtra++;
                for (int j = 0; j < i; j++) {
                    if (dssv[i].mssv.contains(dssv[j].mssv))
                        kiemtra++;
                }
            } while (kiemtra > 0);
            do {
                System.out.print("Hay nhap diem thu nhat cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].diem1 = scanner.nextFloat();
            } while (dssv[i].diem1 > 10 || dssv[i].diem1 < 0);
            do {
                System.out.print("Hay nhap diem thu hai cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].diem2 = scanner.nextFloat();
            } while (dssv[i].diem2 > 10 || dssv[i].diem2 < 0);
            do {
                System.out.print("Hay nhap diem thu ba cua sinh vien thu " + (i + 1) + ": ");
                dssv[i].diem3 = scanner.nextFloat();
            } while (dssv[i].diem3 > 10 || dssv[i].diem3 < 0);
        }
        for (int i = 0; i < n; i++) {
            dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
            for (int j = i; j < n; j++) {
                dssv[j].tinhdiemtrungbinh(dssv[j].diem1, dssv[j].diem2, dssv[j].diem3, dssv[j].diemtb);
                if (dssv[i].diemtb > dssv[j].diemtb) {
                    thongtinsinhvien2 temp = dssv[i];
                    dssv[i] = dssv[j];
                    dssv[j] = temp;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            char kytu[] = dssv[i].hoten.toCharArray();
            for (int j = 0; j < dssv[i].hoten.length(); j++) {
                if (kytu[0] >= 'a' && kytu[0] <= 'z') {
                    kytu[0] = Character.toUpperCase(kytu[0]);
                } else if (kytu[j] == ' ' && kytu[j + 1] != ' ' && kytu[j + 1] >= 'a' && kytu[j + 1] <= 'z') {
                    kytu[j + 1] = Character.toUpperCase(kytu[j + 1]);
                }
                dssv[i].hovaten += Character.toString(kytu[j]);
            }
        }
        System.out.println(
                "._________________________________________________________________________________________________________________.");
        System.out.printf("|%5s  |%10s|%30s|%8s  |%8s  |%8s  |%9s  |%13s     |", "STT", "MSSV", "Ho ten", "Diem 1",
                "Diem 2", "Diem 3", "Diem TB", "Xep loai");
        System.out.print(
                "\n|_______|__________|______________________________|__________|__________|__________|___________|__________________|");
        for (int i = 0; i < n; i++) {
            dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
            dssv[i].xeploai(dssv[i].diemtb);
            System.out.printf("\n|%4d   |%9s |%29s |%8.2f  |%8.2f  |%8.2f  |%8.2f   |%16s  |", (i + 1), dssv[i].mssv,
                    dssv[i].hovaten, dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb, dssv[i].xeploai);
        }
        System.out.println(
                "\n'-----------------------------------------------------------------------------------------------------------------'");
        char traloi;
        scanner.nextLine();
        do {
            System.out.println("Ban co muon them 1 sinh vien nao do hay khong (Y/N): ");
            traloi = scanner.next().charAt(0);
            Character.toUpperCase(traloi);
        } while (traloi != 'Y' && traloi != 'N' && traloi != 'y' && traloi != 'n');
        if (traloi == 'Y' || traloi == 'y') {
            for (int i = n; i <= n; i++) {
                dssv[i] = new thongtinsinhvien2();
                scanner.nextLine();
                do {
                    kiemtra = 0;
                    System.out.print("\nHay nhap ten cua sinh vien thu " + (i + 1) + ": ");
                    dssv[i].hoten = scanner.nextLine();
                    if (dssv[i].hoten.matches(".*[0-9]")) {
                        kiemtra++;
                    }
                } while (kiemtra > 0);
                do {
                    kiemtra = 0;
                    System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + (i + 1) +
                            ": ");
                    dssv[i].mssv = scanner.nextLine();
                    if (dssv[i].mssv.length() != 8)
                        kiemtra++;
                    for (int j = 0; j < i; j++) {
                        if (dssv[i].mssv.contains(dssv[j].mssv))
                            kiemtra++;
                    }
                } while (kiemtra > 0);
                do {
                    System.out.print("Hay nhap diem thu nhat cua sinh vien thu " + (i + 1) + ": ");
                    dssv[i].diem1 = scanner.nextFloat();
                } while (dssv[i].diem1 > 10 || dssv[i].diem1 < 0);
                do {
                    System.out.print("Hay nhap diem thu hai cua sinh vien thu " + (i + 1) + ": ");
                    dssv[i].diem2 = scanner.nextFloat();
                } while (dssv[i].diem2 > 10 || dssv[i].diem2 < 0);
                do {
                    System.out.print("Hay nhap diem thu ba cua sinh vien thu " + (i + 1) + ": ");
                    dssv[i].diem3 = scanner.nextFloat();
                } while (dssv[i].diem3 > 10 || dssv[i].diem3 < 0);
            }
            for (int i = n; i <= n; i++) {
                char kytu[] = dssv[i].hoten.toCharArray();
                for (int j = 0; j < dssv[i].hoten.length(); j++) {
                    if (kytu[0] >= 'a' && kytu[0] <= 'z') {
                        kytu[0] = Character.toUpperCase(kytu[0]);
                    } else if (kytu[j] == ' ' && kytu[j + 1] != ' ' && kytu[j + 1] >= 'a' && kytu[j + 1] <= 'z') {
                        kytu[j + 1] = Character.toUpperCase(kytu[j + 1]);
                    }
                    dssv[i].hovaten += Character.toString(kytu[j]);
                }
            }
            for (int i = 0; i <= n; i++) {
                dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
                for (int j = i; j <= n; j++) {
                    dssv[j].tinhdiemtrungbinh(dssv[j].diem1, dssv[j].diem2, dssv[j].diem3, dssv[j].diemtb);
                    if (dssv[i].diemtb > dssv[j].diemtb) {
                        thongtinsinhvien2 temp = dssv[i];
                        dssv[i] = dssv[j];
                        dssv[j] = temp;
                    }
                }
            }
            System.out.println(
                    "._________________________________________________________________________________________________________________.");
            System.out.printf("|%5s  |%10s|%30s|%8s  |%8s  |%8s  |%9s  |%13s     |", "STT", "MSSV", "Ho ten", "Diem 1",
                    "Diem 2", "Diem 3", "Diem TB", "Xep loai");
            System.out.print(
                    "\n|_______|__________|______________________________|__________|__________|__________|___________|__________________|");
            for (int i = 0; i <= n; i++) {
                dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
                dssv[i].xeploai(dssv[i].diemtb);
                System.out.printf("\n|%4d   |%9s |%29s |%8.2f  |%8.2f  |%8.2f  |%8.2f   |%16s  |", (i + 1),
                        dssv[i].mssv,
                        dssv[i].hovaten, dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb, dssv[i].xeploai);
            }
            System.out.println(
                    "\n'-----------------------------------------------------------------------------------------------------------------'");
        }
        char traloi1;
        do {
            System.out.println("Ban co muon xoa 1 sinh vien ra khoi danh sach khong (Y/N)?: ");
            traloi1 = scanner.next().charAt(0);
        } while (traloi1 != 'Y' && traloi1 != 'N' && traloi1 != 'y' && traloi1 != 'n');
        if (traloi1 == 'Y' || traloi1 == 'y') {
            kiemtra = 0;
            scanner.nextLine();
            System.out.println("Hay nhap ma sinh vien ma ban muon xoa: ");
            String masinhvienmuonxoa = scanner.nextLine();
            for (int i = 0; i <= n; i++) {
                if (masinhvienmuonxoa.contains(dssv[i].mssv)) {
                    kiemtra++;
                    for (int j = i; j < n; j++) {
                        dssv[j] = dssv[j + 1];
                    }
                    n--;
                }
            }
            System.out.println(
                    "._________________________________________________________________________________________________________________.");
            System.out.printf("|%5s  |%10s|%30s|%8s  |%8s  |%8s  |%9s  |%13s     |", "STT", "MSSV", "Ho ten", "Diem 1",
                    "Diem 2", "Diem 3", "Diem TB", "Xep loai");
            System.out.print(
                    "\n|_______|__________|______________________________|__________|__________|__________|___________|__________________|");
            for (int i = 0; i <= n; i++) {
                dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
                dssv[i].xeploai(dssv[i].diemtb);
                System.out.printf("\n|%4d   |%9s |%29s |%8.2f  |%8.2f  |%8.2f  |%8.2f   |%16s  |", (i + 1),
                        dssv[i].mssv,
                        dssv[i].hoten, dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb, dssv[i].xeploai);
            }
            System.out.println(
                    "\n'-----------------------------------------------------------------------------------------------------------------'");
        }
        if (kiemtra == 0)
            System.out.println("Sinh vien ma ban muon xoa khong ton tai !!!");
        char traloi2;
        do {
            System.out.println("Ban co muon thay doi thong tin cua sinh vien co trong danh sach hay khong (Y/N)???: ");
            traloi2 = scanner.next().charAt(0);
        } while (traloi2 != 'Y' && traloi2 != 'N' && traloi2 != 'y' && traloi2 != 'n');
        if (traloi2 == 'Y' || traloi2 == 'y') {
            kiemtra = 0;
            scanner.nextLine();
            System.out.println("Hay nhap ma so sinh vien ma ban muon thay doi thong tin: ");
            String mssvmuondoi = scanner.nextLine();
            for (int i = 0; i <= n; i++) {
                if (dssv[i].mssv.contains(mssvmuondoi)) {
                    do {
                        kiemtra = 0;
                        System.out.print("\nHay nhap ten cua sinh vien thu " + (i + 1) + ": ");
                        dssv[i].hoten = scanner.nextLine();
                        if (dssv[i].hoten.matches(".*[0-9]")) {
                            kiemtra++;
                        }
                    } while (kiemtra > 0);
                    do {
                        kiemtra = 0;
                        System.out.print("Hay nhap ma so sinh vien cua sinh vien thu " + (i + 1) +
                                ": ");
                        dssv[i].mssv = scanner.nextLine();
                        if (dssv[i].mssv.length() != 8)
                            kiemtra++;
                        for (int j = 0; j < i; j++) {
                            if (dssv[i].mssv.contains(dssv[j].mssv))
                                kiemtra++;
                        }
                    } while (kiemtra > 0);
                    do {
                        System.out.print("Hay nhap diem thu nhat cua sinh vien thu " + (i + 1) + ": ");
                        dssv[i].diem1 = scanner.nextFloat();
                    } while (dssv[i].diem1 > 10 || dssv[i].diem1 < 0);
                    do {
                        System.out.print("Hay nhap diem thu hai cua sinh vien thu " + (i + 1) + ": ");
                        dssv[i].diem2 = scanner.nextFloat();
                    } while (dssv[i].diem2 > 10 || dssv[i].diem2 < 0);
                    do {
                        System.out.print("Hay nhap diem thu ba cua sinh vien thu " + (i + 1) + ": ");
                        dssv[i].diem3 = scanner.nextFloat();
                    } while (dssv[i].diem3 > 10 || dssv[i].diem3 < 0);
                    kiemtra++;
                }
            }
            for (int i = 0; i <= n; i++) {
                dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
                for (int j = i; j <= n; j++) {
                    dssv[j].tinhdiemtrungbinh(dssv[j].diem1, dssv[j].diem2, dssv[j].diem3, dssv[j].diemtb);
                    if (dssv[i].diemtb > dssv[j].diemtb) {
                        thongtinsinhvien2 temp = dssv[i];
                        dssv[i] = dssv[j];
                        dssv[j] = temp;
                    }
                }
            }
            for (int i = 0; i <= n; i++) {
                char kytu[] = dssv[i].hoten.toCharArray();
                for (int j = 0; j < dssv[i].hoten.length(); j++) {
                    if (kytu[0] >= 'a' && kytu[0] <= 'z') {
                        kytu[0] = Character.toUpperCase(kytu[0]);
                    } else if (kytu[j] == ' ' && kytu[j + 1] != ' ' && kytu[j + 1] >= 'a' && kytu[j + 1] <= 'z') {
                        kytu[j + 1] = Character.toUpperCase(kytu[j + 1]);
                    }
                    dssv[i].hovaten2 += Character.toString(kytu[j]);
                }
            }
            System.out.println(
                    "._________________________________________________________________________________________________________________.");
            System.out.printf("|%5s  |%10s|%30s|%8s  |%8s  |%8s  |%9s  |%13s     |", "STT", "MSSV", "Ho ten", "Diem 1",
                    "Diem 2", "Diem 3", "Diem TB", "Xep loai");
            System.out.print(
                    "\n|_______|__________|______________________________|__________|__________|__________|___________|__________________|");
            for (int i = 0; i <= n; i++) {
                dssv[i].tinhdiemtrungbinh(dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb);
                dssv[i].xeploai(dssv[i].diemtb);
                System.out.printf("\n|%4d   |%9s |%29s |%8.2f  |%8.2f  |%8.2f  |%8.2f   |%16s  |", (i + 1),
                        dssv[i].mssv,
                        dssv[i].hovaten2, dssv[i].diem1, dssv[i].diem2, dssv[i].diem3, dssv[i].diemtb, dssv[i].xeploai);
            }
            System.out.println(
                    "\n'-----------------------------------------------------------------------------------------------------------------'");
        }
        if (kiemtra == 0)
            System.out.println("Sinh vien ma ban can thay doi thong tin khong ton tai !!!");
    }
}