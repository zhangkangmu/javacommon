package com.hong.mm.controller;

import com.hong.mm.constants.Constants;
import com.hong.mm.entity.Result;
import com.hong.mm.pojo.Question;
import com.hong.mm.pojo.ReviewLog;
import com.hong.mm.pojo.User;
import com.hong.mm.security.PreAuthority;
import com.hong.mm.service.ReviewLogService;
import com.hong.mm.utils.DateUtils;
import com.hong.mm.utils.JsonUtils;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.Date;

/**
 * Created by zhangyuhong
 * Date:2020/3/7
 */
@Controller
public class ReviewLogController {
private ReviewLogService service=new ReviewLogService();
    /**
     * 审核试题是否通过
     * 表示/review/reviewQuestion，需要有QUESTION_REVIEW_UPDATE权限 才可以访问
     */
    @PreAuthority("QUESTION_REVIEW_UPDATE")
    @RequestMapping("/review/reviewQuestion")
    public void  reviewQuestion(HttpServletRequest request, HttpServletResponse response)  {
        try {
            ReviewLog reviewLog = JsonUtils.parseJSON2Object(request, ReviewLog.class);
            if (reviewLog != null) {
                reviewLog.setCreateDate(DateUtils.parseDate2String(new Date()));
                User user= (User) request.getSession().getAttribute("user");
                if (user != null) {
                    //审核人
                    reviewLog.setUserId(user.getId());
                    System.out.println(reviewLog);
                    //请求更新审核数据
                    boolean update=service.reviewQuestion(reviewLog);
                    if (update){
                        JsonUtils.printResult(response,new Result(true,"更新成功"));
                    }else {
                        JsonUtils.printResult(response,new Result(false,"更新审核状态失败"));
                    }
                }else{
                    JsonUtils.printResult(response,new Result(false,"请登录"));
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
