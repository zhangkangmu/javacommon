package domain;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/2/13
 */
public class ContactPage<T> {
    /**
     * 全部的联系人
     */
    private List<T> contactAll;
    /**
     * 总页数
     */
    private Integer pageNumberAll;
    /**
     * 页码
     */
    private Integer pageNumber;
    /**
     * 一共有多少条数据
     */
    private Integer totalNumber;
    /**
     * 每页显示数量
     */
    private Integer pagesize;

    public List<T> getContactAll() {
        return contactAll;
    }

    public void setContactAll(List<T> contactAll) {
        this.contactAll = contactAll;
    }

    public Integer getPageNumberAll() {
        return pageNumberAll;
    }

    public void setPageNumberAll(Integer pageNumberAll) {
        this.pageNumberAll = pageNumberAll;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(Integer totalNumber) {
        this.totalNumber = totalNumber;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
