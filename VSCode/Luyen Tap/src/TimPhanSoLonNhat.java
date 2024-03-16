public class TimPhanSoLonNhat {
        public static void main(String[] args) {
                int[] numerators = {1,2};
                int[] denominators = {4,3};
                System.out.println(MaxFraction(numerators, denominators));
        }

        public static int MaxFraction(int[] numerators, int[] denominators)
        {
                int cs = 0;
                for(int i  = 0; i < numerators.length; i++)
                {
                        if(numerators[cs] * denominators[i] < numerators[i] * denominators[cs])
                        {
                                cs = i;
                        }
                }
                return cs;
        }
}
