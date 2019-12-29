package 设计模式.adapter;

public class Adapter implements Target {

	private Adaptee adaptee;

	public Adapter(Adaptee adaptee) {

		this.adaptee = adaptee;
	}

	public void adapteeMethod() {
		adaptee.adapteeMethod();
	};

	@Override
	public void adapterMethod() {
		System.out.println("Adapter Method ...");
	}
}
