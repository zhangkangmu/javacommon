package 设计模式.interpreter;

public class SimpleExpression extends Expression {

	@Override
	void interpret() {

		System.out.println("这是一个简单的解析器 ...");
	}
}
