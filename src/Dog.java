public class Dog extends Animal {

        public Dog(String name) {
                super(name);
        }

        /**
         * InnerDog
         */
        public void bark() {
                System.out.println("The dog is barking");
        }
}
