package ua.dymohlo.dao;

import java.util.Optional;

public interface Dao<T> {
    T create(T entity);

    Optional<User> findById(Long id);

    Optional<User> update(T entity);

    void deleteById(Long id);
}
