package 设计模式.bridge;

public class BlackShoe extends Clothing {

	@Override
	public void personDressCloth(Person person) {

		System.out.println(person.getType() + "cloth black shoe ...");
	}
}
