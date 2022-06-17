package com.parish.parish.domain;

import com.parish.parish.web.dto.ServiceAttendancePerPastoral;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.parish.parish.domain.QServiceAttendance.serviceAttendance;
import static com.parish.parish.domain.QUser.user;

@RequiredArgsConstructor
@Repository
@Slf4j
public class ServiceAttendanceRepoSupport {
    private final JPAQueryFactory queryFactory;

    public List<ServiceAttendancePerPastoral> getAttendance(long pastoralCode, List<LocalDate> targetDate) {
        return queryFactory
                .select(Projections.fields(ServiceAttendancePerPastoral.class,
                        user.userName.as("userName"),
                        user.userNameSeparator.as("userNameSeparator"),
                        serviceAttendance.serviceDate.as("serviceDate"),
                        serviceAttendance.serviceType.as("serviceType"),
                        serviceAttendance.isOnline.as("online")
                        ))
                .from(serviceAttendance)
                .leftJoin(user).on(serviceAttendance.userId.eq(user.userId))
                .where(serviceAttendance.serviceDate.in(targetDate).and(user.pastoralCode.eq(pastoralCode)))
                .orderBy(user.userName.asc(), user.userNameSeparator.asc())
                .fetch();
    }
//    public List<ServiceAttendanceGraph>
}
