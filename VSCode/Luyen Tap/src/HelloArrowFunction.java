@FunctionalInterface
/**
 * InnerHelloArrowFunction
 */
interface Hello {
        /**
         * InnerHelloArrowFunction
         */
        void sayHello();
}

public class HelloArrowFunction {
        public static void main(String[] args) {
                Hello dog = () -> {
                        System.out.println("Gau Gau");
                };
                dog.sayHello();
        }

}
