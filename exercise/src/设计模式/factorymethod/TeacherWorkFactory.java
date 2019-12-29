package 设计模式.factorymethod;

public class TeacherWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new TeacherWork();
	}
}
