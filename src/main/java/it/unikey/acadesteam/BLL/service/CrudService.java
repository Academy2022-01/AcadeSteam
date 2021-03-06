package it.unikey.acadesteam.BLL.service;

import it.unikey.acadesteam.BLL.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {
    T insert(T dto);
    T getById(Integer id) throws NotFoundException;
    List<T> getAll();
    T update(T dto) throws NotFoundException;
    void delete(Integer id) throws NotFoundException;
}
