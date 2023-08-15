public class Bird extends Animal {
        public Bird(String name) {
                super(name);
        }

        /**
         * InnerBird
         */
        public void flying() {
                System.out.println("The bird is flying!");
        }

        @Override
        /**
         * eat()
         */
        public void eat() {
                System.out.println("Tôi ăn sâu!");
        }

        @Override
        /**
         * sound()
         */
        public void sound() {
                System.out.println("Tôi hót");
        }
}
