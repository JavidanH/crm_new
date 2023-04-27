package com.javidan.crm_new.repository;

import com.javidan.crm_new.entity.OurUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository <OurUser,Long>{

    @Query(value = "select username from OurUser where  username= :username")
    Optional<OurUser> findByUsername (String  username);
}
