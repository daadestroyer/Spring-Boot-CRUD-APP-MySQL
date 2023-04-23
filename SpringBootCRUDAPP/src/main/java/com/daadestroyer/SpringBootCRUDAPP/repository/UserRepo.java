package com.daadestroyer.SpringBootCRUDAPP.repository;

import com.daadestroyer.SpringBootCRUDAPP.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
