package com.system.sastohub.services;


import com.system.sastohub.pojo.UserPojo;

public interface UserServices {
    String save (UserPojo userpojo);
    UserPojo findByEmail(String email);
}
