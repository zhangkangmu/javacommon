package 基础.day02_static_接口_多态_内部类.demo14_多态的几种表现形式;

/**
 * @author 彭智林
 * @date 2019/12/16 12:05
 */
public class Demo {
    public static void main(String[] args) {
        /*
            多态的几种表现形式:
                抽象父类多态
                    public abstract class Fu{
                        public abstract void method();
                    }

                    public class Zi extends Fu{
                        @Override
                        public void method(){

                        }
                    }

                    public class Test{
                        public static void main(String[] args){
                            Fu fu = new Zi();// 父类的引用指向子类的对象
                        }
                    }

                普通父类多态
                     public  class Fu{
                        public  void method(){

                        }
                    }

                    public class Zi extends Fu{
                        @Override
                        public void method(){

                        }
                    }

                    public class Test{
                        public static void main(String[] args){
                            Fu fu = new Zi();// 父类的引用指向子类的对象
                        }
                    }

                父接口多态
                    public interface AInterface{
                        void method();
                    }

                    public class ImpA implements AInterface{
                         @Override
                        public void method(){

                        }
                    }

                     public class Test{
                        public static void main(String[] args){
                            AInterface a = new ImpA();// 父接口的引用指向实现类的对象
                        }
                    }
         */
        AInterface a = new ImpA();
    }
}
