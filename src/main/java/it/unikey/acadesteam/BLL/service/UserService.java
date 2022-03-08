package it.unikey.acadesteam.BLL.service;

import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import org.aspectj.weaver.ast.Not;

public interface UserService extends CrudService<UserDto>{

    UserDto findByUsername(String username) throws NotFoundException;
    UserDto findByEmail(String email) throws NotFoundException;


}
