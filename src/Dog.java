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

        @Override
        public void eat() {
                // TODO Auto-generated method stub
                System.out.println("Tôi ăn xương");
        }

        @Override
        public void sound() {
                // TODO Auto-generated method stub
                System.out.println("Gau Gau");
        }

}
