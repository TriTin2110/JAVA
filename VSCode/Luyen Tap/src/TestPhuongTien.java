public class TestPhuongTien {
        public static void main(String[] args) {
                HangSanXuat hsx1 = new HangSanXuat("VietJet", "Việt Nam");
                MayBay pt1 = new MayBay("Xăng", hsx1);
                System.out.println(pt1.tinhVanToc(500) + "/km");
                System.out.println(pt1.getHangSanXuat().getTenHang());
                System.out.println(pt1.getTenNhienLieu());
                pt1.catCanh();
                pt1.haCanh();

                System.out.println("\n------------------------------\n");

                HangSanXuat hsx2 = new HangSanXuat("Ford", "Hoa Kỳ");
                XeOTo oto = new XeOTo("Dầu", hsx2);
                System.out.println(oto.tinhVanToc(100));

                System.out.println("\n------------------------------\n");

                HangSanXuat hsx3 = new HangSanXuat("BMX", "Hoa Kỳ");
                XeDap xeDap = new XeDap("Không", hsx3);
                System.out.println(xeDap.tinhVanToc(20));
        }
}
