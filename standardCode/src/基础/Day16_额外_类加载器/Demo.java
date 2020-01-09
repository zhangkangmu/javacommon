package 基础.Day16_额外_类加载器;

/**
 * Created by zhangyuhong
 * Date:2018/1/9
 */
public class Demo {
    /**
     * bootstrapClassLoader：引导类加载器，加载jdk本身的一些核心包，比如：java.lang.String, ....
     * 由C/C++编写的，它本身是虚拟机的一部分，所以它并不是一个JAVA类，也就是无法在java代码中获取它的引用
     * URL[] urls=sun.misc.Launcher.getBootstrapClassPath().getURLs();-->查看加载了那些核心类库
     *
     * ExpClassLoader：扩展类加载器，C:\Program Files\Java\jdk1.8.0_151\jre\lib\ext
     * ClassLoader classLoader = sun.security.ec.SunEC.class.getClassLoader();
     *
     * AppClassLoader：应用类加载器，加载第三方的类，比如：我们写的类，我们导入的jar包...
     *
     *      我们写的类.class.getClassLoader();--->获取的是应用类加载器，如果要获取扩展类加载器，需要getparcent来获取
     *
     *      VM初始化sun.misc.Launcher并创建Extension ClassLoader和AppClassLoader实例。并将ExtClassLoader设置为AppClassLoader的父加载器。
     *      bootstrap没有父加载器，但是它却可以作用一个ClassLoader的父加载器。比如ExtClassLoader。
     *      这也可以解释之前通过ExtClassLoader的getParent方法获取为Null的现象
     */

}
