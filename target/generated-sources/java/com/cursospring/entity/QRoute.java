package com.cursospring.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QRoute is a Querydsl query type for Route
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QRoute extends EntityPathBase<Route> {

    private static final long serialVersionUID = -124748720L;

    public static final QRoute route = new QRoute("route");

    public final NumberPath<Integer> idroute = createNumber("idroute", Integer.class);

    public final StringPath routedescription = createString("routedescription");

    public final StringPath routename = createString("routename");

    public QRoute(String variable) {
        super(Route.class, forVariable(variable));
    }

    public QRoute(Path<? extends Route> path) {
        super(path.getType(), path.getMetadata());
    }

    public QRoute(PathMetadata metadata) {
        super(Route.class, metadata);
    }

}

