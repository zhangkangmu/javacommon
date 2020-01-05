package 设计模式.singleton;

/**
 * 枚举实现单例 最佳
 * 避免反射攻击、避免序列化问题
 *
 * @author Administrator
 */
public class EnumSingleton {
    //
//	INSTANCE;
//
//	public EnumSingleton getInstance() {
//		return INSTANCE;
//	}
    //可以在里面增加方法，实际是一个类
    public int getNum() {
        return 10;
    }
}
