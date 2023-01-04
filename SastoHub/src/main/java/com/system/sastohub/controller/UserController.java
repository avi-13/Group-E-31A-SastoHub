package com.system.sastohub.controller;

import com.system.sastohub.services.UserServices;
import com.system.sastohub.userpojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;


    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserPojo());

        return "html/Signup";
}

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo){
        userServices.save(userPojo);
        return "redirect:html/uploadfile";
    }


}

