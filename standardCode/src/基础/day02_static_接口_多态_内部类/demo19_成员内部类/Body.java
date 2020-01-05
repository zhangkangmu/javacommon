package 基础.day02_static_接口_多态_内部类.demo19_成员内部类;

/**
 * @author 彭智林
 * @date 2017/12/16 15:39
 */
public class Body {// 外部类

    // 成员变量
    private int numW = 10;

    int num = 100;

    // 成员方法
    public void methodW1(){
        System.out.println("外部类中的methodW1方法...");
    }

    public void methodW2(){
        System.out.println("外部类中的methodW2方法...");
        // 创建内部类对象
        Heart bh = new Body().new Heart();
        // 访问内部类成员变量
        System.out.println("内部类成员变量numN:"+bh.numN);
        // 访问内部类成员方法
        bh.methodN2();
    }

    public class Heart{// 成员内部类
        // 成员变量
        int numN = 20;

        int num = 200;

        // 成员方法
        public void methodN(){
            System.out.println("内部类中的methodN方法...");
            // 访问外部类成员变量
            System.out.println("外部类成员变量:"+numW);
            // 访问外部类成员方法
            methodW1();
        }

        public void methodN2(){
            System.out.println("内部类中的methodN2方法...");
        }

        public void methodN3(){
            int num = 300;
            System.out.println("局部变量num:"+num);// 300
            System.out.println("内部类成员变量num:"+this.num);// 200
            System.out.println("外部类成员变量num:"+Body.this.num);// 100
        }
    }

}
