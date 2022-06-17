package com.parish.parish.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QServiceAttendance is a Querydsl query type for ServiceAttendance
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QServiceAttendance extends EntityPathBase<ServiceAttendance> {

    private static final long serialVersionUID = -87290719L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QServiceAttendance serviceAttendance = new QServiceAttendance("serviceAttendance");

    public final BooleanPath isOnline = createBoolean("isOnline");

    public final NumberPath<Long> serviceAttendanceId = createNumber("serviceAttendanceId", Long.class);

    public final DatePath<java.time.LocalDate> serviceDate = createDate("serviceDate", java.time.LocalDate.class);

    public final StringPath serviceType = createString("serviceType");

    public final QUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QServiceAttendance(String variable) {
        this(ServiceAttendance.class, forVariable(variable), INITS);
    }

    public QServiceAttendance(Path<? extends ServiceAttendance> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QServiceAttendance(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QServiceAttendance(PathMetadata metadata, PathInits inits) {
        this(ServiceAttendance.class, metadata, inits);
    }

    public QServiceAttendance(Class<? extends ServiceAttendance> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QUser(forProperty("user")) : null;
    }

}

