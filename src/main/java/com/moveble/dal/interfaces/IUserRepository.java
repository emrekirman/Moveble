package com.moveble.dal.interfaces;

import com.moveble.dto.LoginDto;
import com.moveble.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);

    @Query("select u from User u where u.name = :#{#loginDto.username} and u.password = :#{#loginDto.password}")
    User findUserByLoginDto(@Param("loginDto") LoginDto loginDto);

}
