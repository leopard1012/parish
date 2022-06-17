package com.parish.parish.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPastoralLeader is a Querydsl query type for PastoralLeader
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPastoralLeader extends EntityPathBase<PastoralLeader> {

    private static final long serialVersionUID = -1886795962L;

    public static final QPastoralLeader pastoralLeader = new QPastoralLeader("pastoralLeader");

    public final NumberPath<Integer> areaCode = createNumber("areaCode", Integer.class);

    public final NumberPath<Integer> parishCode = createNumber("parishCode", Integer.class);

    public final NumberPath<Long> pastoralLeaderId = createNumber("pastoralLeaderId", Long.class);

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public final StringPath userName = createString("userName");

    public final StringPath userNameSeparator = createString("userNameSeparator");

    public QPastoralLeader(String variable) {
        super(PastoralLeader.class, forVariable(variable));
    }

    public QPastoralLeader(Path<? extends PastoralLeader> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPastoralLeader(PathMetadata metadata) {
        super(PastoralLeader.class, metadata);
    }

}

