package 设计模式.iterator;

public interface List {

	Iterator iterator();

	Object get(Integer index);

	Integer getSize();

	void add(Object obj);
}
