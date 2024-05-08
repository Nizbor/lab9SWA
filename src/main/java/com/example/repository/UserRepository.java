package com.example.repository;

import com.example.model.MyUser;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends CrudRepository<MyUser, Integer> {
    //MyUser findByLogin(String login);
    MyUser findRoleByLogin(String login);
    MyUser findByEmail(String email);

    Optional<MyUser> findByLogin(String login);

    @Query("update MyUser e set e.deleted=true where e.id=?1")
    @Transactional
    @Modifying
    void softDelete(Integer id);
    @Query("update MyUser e set e.deleted=false where e.id=?1")
    @Transactional
    @Modifying
    void phoenix(Integer id);
}
