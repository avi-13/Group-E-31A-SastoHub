package com.system.sastohub.controller;
//
//<<<<<<< HEAD
//
//import org.springframework.security.authentication.AnonymousAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//@Controller
//@RequestMapping
//public class LoginController {
//
//
//
//
//    @PostMapping("/logout")
//    public String logout(Authentication authentication) {
//        if (authentication.isAuthenticated()) {
//            SecurityContextHolder.clearContext();
//        }
//        return "redirect:/login";
//    }
//
//=======
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping()
public class LoginController {
    @GetMapping("/login")
    public String getLoginPage() {
        return "redirect:/user/login";
    }
//>>>>>>> 3de7b31e2a3754c24ea6fd4b2af186e8b7d8a25f
}
