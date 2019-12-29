package 设计模式.interpreter;

import java.util.ArrayList;
import java.util.List;

public class Context {

	private String content;

	private List<Expression> expressionList = new ArrayList<Expression>();

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void add(Expression expression) {
		expressionList.add(expression);
	}

	public List<Expression> getList() {
		return expressionList;
	}

}
