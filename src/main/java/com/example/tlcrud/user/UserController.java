package com.example.tlcrud.user;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/info")
    public String getInfo(){
        System.out.println("użytkownik próbuje pobrać informacje o aplikacji");
        return "infoPage";
    }

    @GetMapping("/list")
    public String getListOfUsers(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User(1l));
        users.add(new User(2l));
        users.add(new User(3l));
        users.add(new User(4l, "kacper-warda", "kacper.warda@logintegra.com", true));
        users.add(new User(5l, "karolina-warda", "karolina.warda@logintegra.com", true));
        
        model.addAttribute("users", users);
        System.out.println(users);
        
        return "usersList";
    }
}
