package com.parish.parish.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface ServiceAttendanceRepository extends JpaRepository<ServiceAttendance, Long> {
    boolean existsByServiceDateAndUserIdAndServiceType(LocalDate serviceDate, Long userId, String serviceType);

    Optional<ServiceAttendance> findByServiceDateAndServiceTypeAndUserId(LocalDate serviceDate, String serviceType, Long userId);

    List<ServiceAttendance> findByUserIdIn(Collection<Long> userIds);

//    @Transactional
//    @Modifying(clearAutomatically = true)
//    @Query(value = "update service_attendance set user_id = :userId where pastoral_code = :pastoralCode",
//            nativeQuery = true)
//    void updateUserAttendance(@Param("areaCode") Integer areaCode, @Param("pastoralCode") Long pastoralCode);
}
