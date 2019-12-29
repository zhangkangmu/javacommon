package 设计模式.factorymethod;

public class TeacherWork implements Work {

	@Override
	public void doWork() {
		System.out.println("老师在批改作业！");
	}

}
