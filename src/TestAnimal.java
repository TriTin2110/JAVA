public class TestAnimal {
        public static void main(String[] args) {
                Bird b = new Bird("Họa mi");
                Dog d = new Dog("LuLu");
                Cat c = new Cat("Miu");

                System.out.println(d.getName());
                d.eat();
                d.sleep();
                d.bark();
                d.sound();
                System.out.println("\n-----------------------\n");
                System.out.println(c.getName());
                c.eat();
                c.meow();
                c.sound();

                System.out.println("\n-----------------------\n");
                System.out.println(b.getName());
                b.eat();
                b.sleep();
                b.flying();
                b.sound();
        }
}
