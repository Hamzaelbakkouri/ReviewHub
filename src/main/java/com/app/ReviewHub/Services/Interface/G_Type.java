package com.app.ReviewHub.Services.Interface;

import org.springframework.data.domain.Page;

public interface G_Type<R, S, I> {
    S save(R r);

    S find(I i);

    Boolean remove(I i);

    Page<S> findAll();

    Page<S> search(R r);
}
