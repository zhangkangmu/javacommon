package com.hong.mm.dao;

import com.hong.mm.pojo.ReviewLog;
import org.apache.ibatis.annotations.Insert;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
public interface ReviewLogDao {
    @Insert(" INSERT INTO t_review_log VALUES (null,#{comments},#{status},#{questionId},#{userId},#{createDate})")
     int addReviewLog(ReviewLog reviewLog) ;
}
