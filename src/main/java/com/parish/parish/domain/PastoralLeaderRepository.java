package com.parish.parish.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface PastoralLeaderRepository extends JpaRepository<PastoralLeader, Long> {
    Optional<PastoralLeader> findByUserId(Long userId);

}
