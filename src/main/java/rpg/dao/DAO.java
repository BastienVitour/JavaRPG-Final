package main.java.rpg.dao;

import java.util.List;

public interface DAO<T> {
    boolean save(T item);
    boolean update(T item);
    boolean delete(T item);
    T findByName(String name);
    List<T> findAll();
}
