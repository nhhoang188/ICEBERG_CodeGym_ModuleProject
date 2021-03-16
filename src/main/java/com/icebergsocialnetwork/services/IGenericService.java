package com.icebergsocialnetwork.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGenericService<T> {
    Page<T> findAll(Pageable pageable);

    Iterable<T> findAll();

    T findById(Long id);

    T save(T t);

    void deleteById(Long id);

}
