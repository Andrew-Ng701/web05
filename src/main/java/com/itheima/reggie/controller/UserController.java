package com.itheima.reggie.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.itheima.reggie.Utils.SMSUtils;
import com.itheima.reggie.Utils.ValidateCodeUtils;
import com.itheima.reggie.common.R;
import com.itheima.reggie.entity.User;
import com.itheima.reggie.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/sendMsg")
    public R<String> sendMsg(@RequestBody User user, HttpSession session){
        String phone = user.getPhone();
        if(StringUtils.isNotEmpty(phone)){
            String code = ValidateCodeUtils.generateValidateCode(4).toString();
//            SMSUtils.sendMessage("code","",phone,code);
            session.setAttribute(phone,code);
            return R.success("success");
        }
        return null;
    }

    @PostMapping("/login")
    public R<User> login(@RequestBody Map map, HttpSession session){

        String phone = map.get("phone").toString();
        String code = map.get("code").toString();

        String key = phone;
        Object codeObj = session.getAttribute("userPhone");
        String codeInSession = codeObj == null ? null : codeObj.toString();


//        if (codeInSession != null && codeInSession.equals(code)) {
        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
        qw.eq(User::getPhone, phone);
        User user = userService.getOne(qw);
        if (user == null) {
            user = new User();
            user.setPhone(phone);
            user.setStatus(1);
            userService.save(user);
        }
        session.setAttribute("user", user.getId());
        return R.success(user);
//        }

//        return R.error("验证码无效或已过期");
    }

//    @PostMapping("/login")
//    public R<User> devLogin(@RequestBody Map<String, Object> map, HttpSession session) {
//        String phone = map.get("phone") == null ? "13800000000" : map.get("phone").toString().trim();
//        LambdaQueryWrapper<User> qw = new LambdaQueryWrapper<>();
//        qw.eq(User::getPhone, phone);
//        User user = userService.getOne(qw);
//        if (user == null) {
//            user = new User();
//            user.setPhone(phone);
//            user.setStatus(1);
//            userService.save(user);
//        }
//        session.setAttribute("user", user.getId());
//        return R.success(user);
//    }
}
