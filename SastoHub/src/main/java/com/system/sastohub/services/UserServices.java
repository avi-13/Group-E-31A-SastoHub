package com.system.sastohub.services;


import com.system.sastohub.entity.User;
import com.system.sastohub.pojo.UserPojo;

import java.util.List;

public interface UserServices {
    String save (UserPojo userpojo);
    UserPojo findByEmail(String email);
    List<User> fetchAll();

    void deleteById(Integer id);

    String updateResetPassword(String email);
}
