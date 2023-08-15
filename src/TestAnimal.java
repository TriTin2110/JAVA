public class TestAnimal {
        public static void main(String[] args) {
                Bird b = new Bird();
                Dog d = new Dog("LuLu");
                Cat c = new Cat();

                System.out.println(d.getName()); 
                d.eat();
                d.sleep();
                d.bark();

                c.eat();
                c.meow();

                b.sleep();
                b.flying();
        }
}
