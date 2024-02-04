package com.app.ReviewHub.Services.Interface;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface G_Type<R, S, I> {
    S save(R r);

    S find(I i);

    Boolean remove(I i);

    Page<S> findAll(Pageable pageable);

    Page<S> search(R r, Pageable pageable);
}
