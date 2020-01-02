package 基础.day13_JUnit单元测试_反射_注解_动态代理_JDK新特性.demo2_Junit单元测试其他注解;

import org.junit.*;

/**
 * @author 彭智林
 * @date 2020/1/2 9:04
 */
public class Demo {
    /*
        Junit单元测试其他注解:  @Before  @After @BeforeClass @AfterClass
            @Before:修饰非静态方法,在@Test方法之前执行,@Before方法可以有多个,执行顺序为方法名的降序
                    凡是执行@Test修饰的方法,都会执行@Before修饰的方法
            @After: 修饰非静态方法,在@Test方法之后执行,@After方法可以有多个,执行顺序为方法名的升序
                    凡是执行@Test修饰的方法,都会执行@After修饰的方法

            @BeforeClass: 修饰静态方法,在所有@Before执行之前执行,只会执行一次
                          @BeforeClass方法可以有多个,执行顺序为方法名的降序
           @AfterClass: 修饰静态方法,在所有@After执行之后执行,只会执行一次
                        @AfterClass方法可以有多个,执行顺序为方法名的升序
     */
    @BeforeClass
    public static void b1Class(){
        System.out.println("b1Class...");
    }

    @BeforeClass
    public static void b2Class(){
        System.out.println("b2Class...");
    }


    @Before
    public void b1(){
        System.out.println("b1...");
    }

    @Before
    public void b2(){
        System.out.println("b2...");
    }

    @Before
    public void b3(){
        System.out.println("b3...");
    }


    @Test
    public void show1(){
        System.out.println("show1...");
    }

    @Test
    public void show2(){
        System.out.println("show2...");
    }

    @After
    public void a1(){
        System.out.println("a1...");
    }

    @After
    public void a2(){
        System.out.println("a2...");
    }

    @After
    public void a3(){
        System.out.println("a3...");
    }

    @AfterClass
    public static void a1Class(){
        System.out.println("a1Class...");
    }

    @AfterClass
    public static void a2Class(){
        System.out.println("a2Class...");
    }

}
