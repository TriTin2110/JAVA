public class Animal {
        protected String name;

        public Animal(String name) {
                this.name = name;
        }

        /**
         * void()
         */
        public void eat() {
                System.out.println("I'm eating");
        }

        /**
         * ngu()
         */
        public void sleep() {
                System.out.println("I'm sleeping");
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }
}
