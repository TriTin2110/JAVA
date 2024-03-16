public class InTamGiac {
        public static void main(String[] args) {
                int cuoi = 19;
                for (int i = 0; i < cuoi; i++) {
                        for (int j = i + 1; j < cuoi - (i + 1); j++) {
                                System.out.print("*");
                        }
                        System.out.println();
                        for (int j = 0; j <= i; j++) {
                                System.out.print(" ");
                        }

                }
        }
}
