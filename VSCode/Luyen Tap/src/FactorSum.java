public class FactorSum {
        public static void main(String[] args) {
                
                System.out.println(factorSum(24));
                
        }

        static int factorSum(int n)
        {
            while (n != solve(n))
                n = solve(n);
            return n;
        }

        public static int solve(int n) {
                int k = 2;
                int tong = 0;
                while (n > 1) {
                        while (n % k == 0) {
                                n /= k;
                                tong += k;
                        }
                                k++;
                }
                return tong;
        }
}
