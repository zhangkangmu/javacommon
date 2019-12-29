package 设计模式.build;

public class PersonDirector {

	public Person construtorPerson(PersonBuilder pb) {

		pb.buildHead();
		pb.buildBody();
		pb.buildFoot();

		return pb.buildPerson();

	}
}
