package com.parish.parish.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update user set area_code = :areaCode where pastoral_code = :pastoralCode",
            nativeQuery = true)
    void updateUserAreaCode(@Param("areaCode") Integer areaCode, @Param("pastoralCode") Long pastoralCode);

    Optional<User> findByUserNameAndUserNameSeparator(String userName, String userNameSeparator);

    List<User> findByPastoralCode(Long pastoralCode);
}
