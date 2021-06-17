package com.moveble.dal.interfaces;

import com.moveble.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findUserByUsernameAndPassword(String username, String password);

    boolean existsByUsernameAndPassword(String username, String password);

}
