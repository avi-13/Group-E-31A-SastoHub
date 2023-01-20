package com.system.sastohub.controller;

import com.system.sastohub.services.UserServices;
import com.system.sastohub.pojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/home")
    public String homePage(){
        return "HomePage";
    }

    @GetMapping("/admin")
    public String admin(){
        return "Admindashboard";
    }

    @GetMapping("/store")
    public String store(){
        return "adminproduct";
    }

    @GetMapping("/create")
    public String createUser(Model model){
        model.addAttribute("user",new UserPojo());

        return "Signup";
}

    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication==null||authentication instanceof AnonymousAuthenticationToken){
            return "/login";
        }
        return "redirect:/home";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo){
        userServices.save(userPojo);
        return "redirect:uploadfile";
    }


}

