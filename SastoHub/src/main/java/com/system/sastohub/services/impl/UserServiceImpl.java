package com.system.sastohub.services.impl;

import com.system.sastohub.services.UserServices;
import com.system.sastohub.userpojo.UserPojo;
import com.system.sastohub.userrepo.UserRepo;
import com.system.sastohub.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserServices {
    private final UserRepo userRepo;

    @Override
    public String save(UserPojo userPojo){
        User user =new User();
        user.setFull_name(userPojo.getFullname());
        user.setAddress(userPojo.getAddress());
        user.setEmail(userPojo.getEmail());
        user.setMobileNo(userPojo.getMobile_no());
        user.setPassword(userPojo.getPassword());
        userRepo.save(user);
        return "created";
    }



}
