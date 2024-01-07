public class Animal {
        protected String name;

        public Animal(String name) {
                this.name = name;
        }

        /**
         * eat()
         */
        public void eat() {
                System.out.println("I'm eating");
        }

        public String getName() {
                return name;
        }
        public void setName(String name) {
                this.name = name;
        }
}
