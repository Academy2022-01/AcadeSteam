package it.unikey.acadesteam.BLL.service;

import it.unikey.acadesteam.BLL.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {
    T insert(T entity);
    T getById(UUID id) throws NotFoundException;
    List<T> getAll();
    T update(T entity) throws NotFoundException;
    void delete(UUID id) throws NotFoundException;
}
