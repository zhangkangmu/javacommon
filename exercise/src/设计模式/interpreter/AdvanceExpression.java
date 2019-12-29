package 设计模式.interpreter;

public class AdvanceExpression extends Expression {

	@Override
	void interpret() {

		System.out.println("这是一个高级解析器 ...");
	}
}
