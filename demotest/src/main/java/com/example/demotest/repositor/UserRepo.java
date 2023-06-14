package com.example.demotest.repositor;

import com.example.demotest.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User, Integer> {
    @Query(value = "select * from user where id = ?1", nativeQuery = true)
    User getUserByUserID(String userId);

    @Query(value = "select * from user where id = ?1 and address = ?2", nativeQuery = true)
    User getUserByUserIDandAddress(String userId, String address);

    /*
    @Modifying
    @Query(value = "update * from user where id = ?1 and address = ?2", nativeQuery = true)
    User getUserByUserIDandAddress(String userId, String address);
     */

}
