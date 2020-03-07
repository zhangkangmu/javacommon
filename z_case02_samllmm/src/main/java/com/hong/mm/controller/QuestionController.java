package com.hong.mm.controller;

import com.hong.mm.entity.PageResult;
import com.hong.mm.entity.QueryPageBean;
import com.hong.mm.entity.Result;
import com.hong.mm.pojo.Question;
import com.hong.mm.pojo.User;
import com.hong.mm.service.QuestionService;
import com.hong.mm.utils.DateUtils;
import com.hong.mm.utils.JsonUtils;
import com.hong.mm.utils.LogUtil;
import com.itheima.mm.framework.annotation.Controller;
import com.itheima.mm.framework.annotation.RequestMapping;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by zhangyuhong
 * Date:2020/3/6
 */
@Controller
public class QuestionController {
    private QuestionService service = new QuestionService();

//    这里的方法不要忘记增加参数了,是因为RequestMapping要求的
    @RequestMapping("/question/getQuestionList")
    public void getQuestionList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        QueryPageBean pageBean = JsonUtils.parseJSON2Object(request, QueryPageBean.class);
        try {
            PageResult result = service.getQuestionList(pageBean);
            if (result != null) {
                JsonUtils.printResult(response,new Result(true,"成功获取基础题库信息",result));
            }else{
                JsonUtils.printResult(response,new Result(true,"获取基础资料失败"));
            }
        } catch (IOException e) {
            JsonUtils.printResult(response,new Result(true,"获取基础资料失败"));
            e.printStackTrace();
        }
    }

    //新增试题保存的提交路径
    @RequestMapping("/question/questionSave")
    public void questionSave(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Question question = JsonUtils.parseJSON2Object(request, Question.class);
        //补全question的信息
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            question.setUserId(user.getId());
        }
        question.setCreateDate(DateUtils.parseDate2String(new Date()));
        try {
            boolean result = service.saveQuestion(question);
            if (result ) {
                JsonUtils.printResult(response,new Result(true,"新增试题成功"));
            }else{
                JsonUtils.printResult(response,new Result(true,"新增试题失败"));
            }
        } catch (IOException e) {
            JsonUtils.printResult(response,new Result(true,"新增试题失败"));
            e.printStackTrace();
        }
    }
}
