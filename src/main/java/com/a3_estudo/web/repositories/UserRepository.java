package com.a3_estudo.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.a3_estudo.web.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
