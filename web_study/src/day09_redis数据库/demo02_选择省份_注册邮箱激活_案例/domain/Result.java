package day09_redis数据库.demo02_选择省份_注册邮箱激活_案例.domain;

/**
 * Created by zhangyuhong
 * Date:2020/2/24
 */
public class Result {
    private Object provinceAll;
    private boolean flag;
    private String message;

    public Result() {
    }

    public Result(Object provinceAll, boolean flag, String message) {
        this.provinceAll = provinceAll;
        this.flag = flag;
        this.message = message;
    }

    public Result(boolean flag, String message) {
        this.flag = flag;
        this.message = message;
    }

    public Object getProvinceAll() {
        return provinceAll;
    }

    public void setProvinceAll(Object provinceAll) {
        this.provinceAll = provinceAll;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
