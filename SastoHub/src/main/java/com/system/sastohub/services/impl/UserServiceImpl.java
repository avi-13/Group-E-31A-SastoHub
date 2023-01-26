package com.system.sastohub.services.impl;

import com.system.sastohub.exception.AppException;
import com.system.sastohub.services.UserServices;
import com.system.sastohub.pojo.UserPojo;
import com.system.sastohub.repo.UserRepo;
import com.system.sastohub.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

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

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(userPojo.getPassword());
        user.setPassword(encodePassword);

        userRepo.save(user);
        return "created";
    }

    @Override
    public UserPojo findByEmail(String email) {
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new AppException("Invalid User email", HttpStatus.BAD_REQUEST));
        return new UserPojo(user);
    }

    @Override
    public List<User> fetchAll() {
        return userRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        userRepo.deleteById(id);

    }

    @Override
    public String updateResetPassword(String email) {
        User user = (User) userRepo.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("Invalid User email"));
        String updated_password = generatePassword();
        try {
            userRepo.updatePassword(updated_password, email);
            return "CHANGED";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "ds";
    }

    public String generatePassword() {
        int length = 8;
        String password = "";
        Random r = new Random();
        for (int i = 0; i < length; i++) {
            int randomChar = (int)(r.nextInt(94) + 33);
            char c = (char)randomChar;
            password += c;
        }
        return password;
    }

}
