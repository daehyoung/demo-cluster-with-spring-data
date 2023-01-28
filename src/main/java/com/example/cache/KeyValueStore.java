package com.example.cache;

public interface KeyValueStore<T,K> {
    T findById(K id);
    Iterable<T> findAll();
    T save(T data);
}
