
public class Counter {
	int n;
	public Counter() {
		this.n = 0;
	}
	public void setN(int n) {
		this.n = n;
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
