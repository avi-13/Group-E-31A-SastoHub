package com.system.sastohub.controller;

import com.system.sastohub.entity.Product;
import com.system.sastohub.entity.User;
import com.system.sastohub.pojo.ProductPojo;
import com.system.sastohub.services.UserServices;
import com.system.sastohub.pojo.UserPojo;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.method.P;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;


@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserServices userServices;


    @GetMapping("/admin")
    public String admin() {
        return "Admindashboard";
    }

//    @GetMapping("/store")
//    public String store(){
//        return "adminproduct";
//    }

    @GetMapping("/stat")
    public String stat() {
        return "visualization";
    }

    @GetMapping("/create")
    public String createUser(Model model) {
        model.addAttribute("user", new UserPojo());

        return "Signup";
    }

    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/home/homepage";
    }

    @PostMapping("/save")
    public String saveUser(@Valid UserPojo userPojo) {
        userServices.save(userPojo);
        return "redirect:/user/login";
    }


    @GetMapping("/profile")
    public String profile() {
        return "updateprofile";
    }

    @GetMapping("/myproduct")
    public String myproduct() {
        return "myproduct";
    }


    @GetMapping("/profile/{id}")
    public String getUserProfiile(@PathVariable("id") Integer id, Model model ){
        User user = userServices.fetchById(id);
        model.addAttribute("users", new UserPojo(user));
//        model.addAttribute("user", userServices.findByEmail(principal.getName()));
        model.addAttribute("currentUser", user);
        return "updateprofile";
    }


    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Integer id, Model model){
        User user =userServices.fetchById(id);
        model.addAttribute("currentUser", new UserPojo(user));
        return "redirect:/user/profile/{id}";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Integer id) {
        userServices.deleteById(id);
        return "redirect:/login";
    }

}
