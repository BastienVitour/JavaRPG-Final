package main.java.rpg.controllers;

import java.util.List;

public interface Controller<T> {
    List<T> findAll();
    boolean save(T item);
}
