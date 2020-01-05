package 基础.day01静态_继承_模板设计模式_抽象类_final.demo13_继承构造方法访问规则;

/**
 * @author 彭智林
 * @date 2017/12/15 11:53
 */
public class Student extends Person {
    /**
     * 成绩
     */
    private int score;

    // 构造方法
    public Student(){

    }

    public Student(String name,int age,int score){
        this.score = score;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
