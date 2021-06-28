package com.lk.rest.Controller;


import com.lk.rest.Model.Userp;
import com.lk.rest.Service.UserService;
import com.lk.rest.Util.ListUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/id/{id}")
    @ResponseBody
    public Userp findById(@PathVariable(value = "id") int id){
        Userp user = userService.findById(id);
        if(null != user) {
            System.out.println(user.getName());
        }
        return user;
    }

    @GetMapping("/name/{name}")
    public List<Userp> findByName(@PathVariable(value = "name") String name){
        List<Userp> users = userService.findByName(name);

        return users;
    }

    @GetMapping("/age/{age}")
    public List<Userp> findByAge(@PathVariable(value = "age") int age){
        List<Userp> users = userService.findByAge(age);
        if(!ListUtil.isNull(users)) {
            System.out.println(users.get(0).getName());
        }
        return users;
    }

    @GetMapping("/time")
    public List<Userp> findByPeriod(@RequestParam("beginTime") String beginTime,
                             @RequestParam("endTime") String endTime){
        List<Userp> users = userService.findUserByPeriod(beginTime, endTime);
        if(!ListUtil.isNull(users)) {
            System.out.println(users.get(0).getName());
        }
        return users;
    }

    @GetMapping("/all")
    public List<Userp> findAll(@RequestParam("page") int page,
                                    @RequestParam("size") int size){
        List<Userp> users = userService.findAll(page, size);
        if(!ListUtil.isNull(users)) {
            System.out.println(users.get(0).getName());
        }
        return users;
    }


    @PostMapping("/save")
    public Userp saveUser(@RequestBody Userp user){
        return  userService.save(user);
    }

    @DeleteMapping("/delete")
    public void deleteUser(@RequestBody Userp user){
        userService.delete(user);
    }
}
