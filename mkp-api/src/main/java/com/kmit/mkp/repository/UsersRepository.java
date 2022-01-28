package com.kmit.mkp.repository;

import com.kmit.mkp.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<Users,String> {
    Users findUsersByUsernameAndPassword(String username,String password);
}
