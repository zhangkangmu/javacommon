package 设计模式.decorator;

public abstract class Decorator implements Person {

	protected Person person;

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void eat() {
		person.eat();
	}
}
