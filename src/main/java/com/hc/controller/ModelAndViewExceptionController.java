package com.hc.controller;

import com.hc.exp.CustomException;
import com.hc.anno.ModelAndView;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: 梁云亮
 * @Date 2020/4/30 1:41
 * @Description: 统一异常处理
 */

@Controller
@RequestMapping("/mave")
@Slf4j
public class ModelAndViewExceptionController {

    /**
     * 模拟系统异常
     */
    @ModelAndView
    @GetMapping("/fun1")
    public String fun1() {
        try {
            Class.forName("com.mysql.jdbc.xxxx.Driver");
        } catch (ClassNotFoundException e) {
            throw new CustomException(400,"在XXX业务，ff1()方法内，出现ClassNotFoundException");
        }
        return "index";
    }

}
