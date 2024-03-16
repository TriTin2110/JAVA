package Generic;

class Box<V> {
	private V giaTri;

	public Box(V giaTri) {
		this.giaTri = giaTri;
	}

	V getGiaTri() {
		return giaTri;
	}

	void setGiaTri(V giaTri) {
		this.giaTri = giaTri;
	}

}
