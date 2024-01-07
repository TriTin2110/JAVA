package Thread;

public class WithDraw {
        public static void main(String[] args) {
                Runnable account = new Account("Tín", 15, 10);
                Thread t1 = new Thread(account);
                Thread t2 = new Thread(account);
                t1.start();
                t2.start();
        }
}
