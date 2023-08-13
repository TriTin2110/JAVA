public class MainAnimal {
        public static void main(String[] args) {
                Dog d = new Dog();
                System.out.println(d.getName());
                d.eat();
                d.bark();

                BabyDog bbd = new BabyDog();
                bbd.eat();
                bbd.bark();
                bbd.weep();

                Cat c = new Cat();
                System.out.println(c.getName());
                c.eat();
                c.Meow();

                Bird b = new Bird();
                System.out.println(b.getName());
                b.eat();
                b.Flying();
        }
}
