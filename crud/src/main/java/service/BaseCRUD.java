package service;

import model.Product;

import java.util.List;

public interface BaseCRUD<T> {
    List<T> findAll();
    void create(Product product);
    void update(Product product);
    void delete(int id);
    T findById(int id);
}
