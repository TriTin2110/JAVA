/**
 * Counter
 */
public class Counter {
    int n;

    public Counter() {
        this.n = 0;
    }

    public int getN() {
        return n;
    }

    public void Tang() {
        this.n++;
    }

    public void Giam() {
        this.n--;
    }

    public void Reset() {
        this.n = 0;
    }
}