package com.hy.crm.user.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hy.crm.user.pojo.User;
import com.hy.crm.user.service.IUserService;
import com.hy.crm.utils.FileUtils;
import com.hy.crm.utils.LayuiUtils;
import com.mysql.jdbc.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

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
    @Autowired
    private IUserService userServiceImpl;

    /*
     * 用户注册*/
    @PostMapping("/zhuceuser.do")
    @ResponseBody
    public String addUser(User user) {
        if (!ObjectUtils.isEmpty(user) && !StringUtils.isNullOrEmpty(user.getUsername())
        && !StringUtils.isNullOrEmpty(user.getUseraccount()) && !StringUtils.isNullOrEmpty(user.getUserpassword())
        && !StringUtils.isNullOrEmpty(user.getDeptname())
        ) {
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("username",user.getUsername());
            List<User> userList=userServiceImpl.list(queryWrapper);
            if (null!=userList && userList.size()>0) {
                return "用户名重复";
            } else {
                userServiceImpl.save(user);
                return "yes";
            }
        } else {
            return "用户信息有误，请重新注册";
        }

    }

    /*登录校验*/
    @RequestMapping("/login.do")
    public String userLogin(User user,HttpServletRequest request){
        if(!StringUtils.isNullOrEmpty(user.getUseraccount()) && !StringUtils.isNullOrEmpty(user.getUserpassword())){
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(user.getUseraccount(),user.getUserpassword());
            Subject subject= SecurityUtils.getSubject();
            try {
                subject.login(usernamePasswordToken);
            } catch (UnknownAccountException e) {
                /*未知账号异常*/
                return "redirect:/veiw/login.html";
            }catch (IncorrectCredentialsException ice) {
                /*凭证有误异常*/
                return "redirect:/veiw/login.html";
            }
            /*shrio记住账号密码*/
            usernamePasswordToken.setRememberMe(true);
            /*验证成功需要重定向  因为主页可以直接重新加载*/
            QueryWrapper queryWrapper=new QueryWrapper();
            queryWrapper.eq("useraccount",user.getUseraccount());
            User user1=userServiceImpl.getOne(queryWrapper);
            request.getSession().setAttribute("user",user1);
            /*subject.getSession().setAttribute("user",user1);*/
            return "redirect:/view/main.html";
        }else{
            return "redirect:/view/login.html";
        }
    }

    /*Layui的文件上传*/
    @PostMapping("/fileupload.do")
    @ResponseBody
    public LayuiUtils fileupload(@RequestParam("file") MultipartFile mufile, HttpServletRequest request) throws IOException {
        LayuiUtils layuiUtils=new LayuiUtils();
        layuiUtils.setMsg(FileUtils.getFileName(mufile,request));
        return layuiUtils;
    }

    @PostMapping("/updateUser.do")
    @ResponseBody
    public String updateUser(User user){
        if(null!=user && !StringUtils.isNullOrEmpty(user.getUsername())){
            if(userServiceImpl.updateById(user)){
                return "修改成功";
            }else{
                return "非法输入，修改失败";
            }

        }else {
            return "非法入侵，请返回";
        }
    }

}
