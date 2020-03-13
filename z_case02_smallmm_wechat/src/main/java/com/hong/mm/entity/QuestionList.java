package com.hong.mm.entity;

import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/13
 */
public class QuestionList {
    /**
     * 把按技术点、企业、方向三种类型的区分称为题库列表的种类（CategoryKind）
     * categoryKind：1 = TAG，按技术点（按目录）
     * categoryKind：2 = 企业，按企业
     * categoryKind：3 = 方向，按方向
     *
     * 三种列表(题库列表、错题本列表、收藏本列表、练习本列表) 称为题库列表的类型（CategoryType）
     * categoryType：101 = 刷题（面试题库，题库列表）
     * categoryType：201 = 错题本
     * categoryType：202 = 我的练习
     * categoryType：203 = 收藏题库
     **/
    private int categoryKind;
    private int categoryType;

    public int getCategoryKind() {
        return categoryKind;
    }

    public void setCategoryKind(int categoryKind) {
        this.categoryKind = categoryKind;
    }

    public int getCategoryType() {
        return categoryType;
    }

    public void setCategoryType(int categoryType) {
        this.categoryType = categoryType;
    }

    /**
     * errmsg : 加载列表成功
     * items : [{"finishedCount":0,"id":1,"allCount":146,"title":"Java基础"},{"finishedCount":0,"id":2,"allCount":229,"title":"JavaWeb"},{"finishedCount":0,"id":3,"allCount":110,"title":"Spring MVC"},{"finishedCount":0,"id":4,"allCount":105,"title":"Spring boot"}]
     */
    private String errmsg;
    private List<ItemsEntity> items;

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public void setItems(List<ItemsEntity> items) {
        this.items = items;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public List<ItemsEntity> getItems() {
        return items;
    }

    public class ItemsEntity {
        /**
         * finishedCount : 0
         * id : 1
         * allCount : 146
         * title : Java基础
         */
        private int finishedCount;
        private int id;
        private int allCount;
        private String title;

        public void setFinishedCount(int finishedCount) {
            this.finishedCount = finishedCount;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setAllCount(int allCount) {
            this.allCount = allCount;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getFinishedCount() {
            return finishedCount;
        }

        public int getId() {
            return id;
        }

        public int getAllCount() {
            return allCount;
        }

        public String getTitle() {
            return title;
        }
    }

    @Override
    public String toString() {
        return "QuestionList{" +
                "errmsg='" + errmsg + '\'' +
                ", items=" + items +
                '}';
    }
}
