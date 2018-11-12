package com.loger.controller;

import com.alibaba.druid.util.StringUtils;
import com.loger.entity.User;
import com.loger.service.impl.UserService;
import com.loger.utils.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by 王睿 on 2018/5/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

   // @RequestMapping(value = "/add.do",method = RequestMethod.POST)
   @RequestMapping("/add.do")
    public void add(User user, HttpServletResponse response) throws Exception {
        int flag = userService.addUser(user);
        if(flag<=0){
            ResponseUtil.write(response,"新增失败！");
        }else{
            ResponseUtil.write(response,"新增成功！");
        }
    }

    @RequestMapping("/del.do")
    public void del(Integer id,HttpServletResponse response) throws IOException {
        int flag = userService.delUserById(id);
        if (flag<0){
            ResponseUtil.write(response,"删除失败");
        }else {
            ResponseUtil.write(response,"删除成功");
        }
    }

    @RequestMapping("/get.do")
    public void getUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("id",id);
        map.put("name",name);
        map.put("age",age);
        List<User> list = userService.getUser(map);
        if (list == null || list.size()==0){
            ResponseUtil.write(response,"没有数据");
            return;
        }
        ResponseUtil.write(response,list);
    }

    @RequestMapping("/update.do")
    public void update(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String age = request.getParameter("age");

        if (StringUtils.isEmpty(id)){
            ResponseUtil.write(response,"主键不能为空");
            return;
        }
        User user = new User();
        user.setId(Integer.valueOf(id));
        user.setName(name);
        if (StringUtils.isEmpty(age)){
            user.setAge(null);
        }else {
            user.setAge(Integer.valueOf(age));
        }
        int flag = userService.updateUser(user);
        if(flag<=0){
            ResponseUtil.write(response,"失败！");
        }else{
            ResponseUtil.write(response,"成功！");
        }

    }


}
