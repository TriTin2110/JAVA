public class Cat extends Animal {
        public Cat(String name) {
                super(name);
        }

        /**
         * meow
         */
        public void meow() {
                System.out.println("The cat is meowing!");
        }

        @Override
        /**
         * eat()
         */
        public void eat() {
                System.out.println("Tôi ăn cá!");
        }

        @Override
        /**
         * meow()
         */

        public void sound() {
                System.out.println("Meow Meow");
        }
}
