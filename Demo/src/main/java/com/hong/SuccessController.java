package com.hong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhangyuhong
 * Date:2020/6/14
 */
@CrossOrigin
@Controller//注意这里没有配置 @RestController
@RequestMapping("/api")
public class SuccessController {
    @RequestMapping("/success")
    public String success(){
        return "success";
    }
}
