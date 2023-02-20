package com.heaven.heaven.applicationUsers.repositories;


import com.heaven.heaven.applicationUsers.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;


@Repository
@Transactional
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {
    Optional<ApplicationUser> findByUsername(String username);

    @Modifying
    @Query("update ApplicationUser u set u.email = :email where u.username = :username")
    Optional <Void> updateEmail(@Param("email") String email, @Param("username") String username);

    @Modifying
    @Query("update ApplicationUser u set u.password = :password where u.username = :username")
    Optional <Void> updatePassword(@Param("password") String password, @Param("username") String username);


}


