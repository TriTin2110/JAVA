package Rectangle;

class Rectangle {
	protected double length, width;

	public Rectangle(double length, double width) {
		this.length = length;
		this.width = width;
	}

	double getLength() {
		return length;
	}

	void setLength(double length) {
		this.length = length;
	}

	double getWidth() {
		return width;
	}

	void setWidth(double width) {
		this.width = width;
	}

	double getArea() {
		return width * length;
	}

	public String toString() {
		return width + "*" + length + "=" + getArea();
	}
}
