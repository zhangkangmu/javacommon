package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo17_动态代理;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 彭智林
 * @date 2020/1/2 16:54
 */
public class Demo {
    public static void main(String[] args) {
        /*
            动态代理:可以直接生成一个代理对象 ,不需要创建代理类
            Java.lang.reflect.Proxy类: 表示代理
            作用:Proxy类中提供了很多静态方法,可以动态的生成一个代理对象
            静态方法:
                static Object newProxyInstance(ClassLoader loader, Class<?>[] interfaces, InvocationHandler h) 动态生成一个类的代理对象
                参数1loader: 表示被代理类的类加载器   被代理类的字节码对象.getClassLoader()
                参数2interfaces: 表示被代理类实现的所有接口的数组  被代理类的字节码对象.getInterfaces()
                以上这2个参数,就是为了动态生成一个代理对象

                参数3InvocationHandler: 执行处理接口,传入InvocationHandler实现类,用来执行代理对象要执行的方法
                参数3为了执行代理对象调用的方法
                InvocationHandler接口中的方法;
                        public Object invoke(Object proxy, Method method, Object[] args){}
                        1. 但凡是代理对象调用方法就会执行InvocationHandler中invoke方法
                        2. invoke方法中的参数1 proxy: 表示动态生成的代理对象,注意,在invoke方法里面不要使用proxy调用方法,否则会栈内存溢出错误
                        3. invoke方法中的参数2 method: 表示代理对象调用的方法
                        4. invoke方法中的参数3 args: 表示代理对象调用的方法 传入的实参
                        5. invoke方法中的返回值类型: 表示代理对象调用的方法的 返回值类型
         */
        JinLian jinLian = new JinLian();
        // 使用动态代理模式生成JinLian的代理对象:
        FindHappy proxy = (FindHappy) Proxy.newProxyInstance(JinLian.class.getClassLoader(), JinLian.class.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                System.out.println("哈哈哈");
//                System.out.println(method);
//                System.out.println(args.length);
//                System.out.println(args[0]);
                System.out.println("王婆以做头发的名义把房间开好了...");
                method.invoke(jinLian);
                System.out.println("happy完后,王婆打扫战场...");
                return null;
            }
        });

        System.out.println("呵呵呵");
        proxy.happy();// 代理对象执行happy方法
        System.out.println("嘿嘿嘿");


    }
}
