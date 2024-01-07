public class MainOverLoading {
        public static void main(String[] args) {
                ExOverLoanding eol = new ExOverLoanding();
                System.out.println(eol.timMin(5, 4));
                System.out.println(eol.timMin(3.5, 4.6));
                System.out.println(eol.tinhTong(5, 4));
                int[] mang = { 1, 2, 3, 4, 5 };
                System.out.println(eol.tinhTongMang(mang));
        }
}
