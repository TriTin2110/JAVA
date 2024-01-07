package ArrowFunction;

abstract class MainHello implements HelloArrowFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HelloArrowFunction hel = () -> {
			System.out.println("Hello world!");
		};
		hel.show();
	}

}
