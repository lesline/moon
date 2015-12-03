package com.moon.web.controller.user;

import com.moon.model.User;
import com.moon.service.UserService;
import com.moon.web.model.GridData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lesline on 15/11/4.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users.json")
    @ResponseBody
    public GridData getUsers(HttpServletRequest request, HttpServletResponse response) {
        logger.info("-------------get Users start>>>");
        GridData gridData = GridData.newInstance();
        List<User> list = userService.getUsers(new User());
        Integer totalCount = 11;
        gridData.setData(list);
        gridData.setTotalCount(totalCount);
        gridData.setAsSuccess();
        System.out.println(gridData);
        logger.info("-------------get Users end>>>");
        return gridData;
    }

    @RequestMapping(value = "/test.json")
    @ResponseBody
    public String test(HttpServletRequest request, HttpServletResponse response) {

        System.out.println("----ext-------1");


        System.out.println("----ext-------2");

        return "success";
    }

    private List<User> getUsers() {
        List<User> list = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(i);
            user.setName("name" + i);
            user.setEmail(i + "00000000@qq.com");
            list.add(user);
        }

        return list;
    }


}
