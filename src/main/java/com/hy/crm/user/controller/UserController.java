package com.hy.crm.user.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author zzx
 * @since 2020-08-29
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/logout.do")
    @ResponseBody
    public String logout() {
        System.out.println("进来");
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存
            return "exist";
        }
        return null;
    }

}
