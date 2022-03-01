package it.unikey.acadesteam.BLL.service;

import it.unikey.acadesteam.BLL.exception.NotFoundException;

import java.util.List;

public interface CrudService<T> {
    T insert(T entity);
    T getById(Integer id) throws NotFoundException;
    List<T> getAll();
    T update(T entity) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
}
