package com.system.sastohub.userrepo;

import com.system.sastohub.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer> {
}
