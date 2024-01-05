package ua.dymohlo.dao;

public interface Dao<T> {
    T create(T entity);

    T findById(Long id);

    T update(Long id);

    void deleteById(Long id);
}
