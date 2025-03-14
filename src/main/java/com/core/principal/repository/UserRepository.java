package com.core.principal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.core.principal.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    @Transactional @Modifying
    @Query(value = "UPDATE tbl_user u SET u.token = ?2 WHERE u.id = ?1", nativeQuery = true)
    int updateTokenById(String id, String token);

    @Transactional @Modifying
    @Query(value = "UPDATE tbl_user u SET u.token = '' WHERE u.token = ?1", nativeQuery = true)
    int updateToken(String token);
}
