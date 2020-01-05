package 基础.day07_排序算法_异常_多线程基础.demo13_自定义异常;

/**
 * @author 彭智林
 * @date 2017/12/24 14:42
 */
public class RegisterException extends RuntimeException{
    // 注册异常类  运行异常类

    public RegisterException() {
    }

    public RegisterException(String message) {
        super(message);
    }
}
