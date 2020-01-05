package 基础.day15_单例_多例_枚举_工厂模式.demo11_工厂模式的实现;

/**
 * @author 彭智林
 * @date 2020/1/5 11:20
 */
public class CarFactory {

    public static Car getCar(String type){
        // 定义一个Car类型的变量,用来存储汽车对象
        Car car = null;

        // 根据传入的类型来生产汽车对象
        if ("Falali".equalsIgnoreCase(type)){
            car = new Falali(500);
        }else if ("Benchi".equalsIgnoreCase(type)){
            car = new Benchi(300);
        }

        // 返回汽车对象
        return car;
    }

}
