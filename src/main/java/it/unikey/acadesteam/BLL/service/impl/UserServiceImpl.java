package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.UserMapper;
import it.unikey.acadesteam.BLL.service.UserService;
import it.unikey.acadesteam.DAL.entity.UserEntity;
import it.unikey.acadesteam.DAL.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserDto insert(UserDto userDto) {
        return userMapper
            .fromUserEntityToUserDto(userRepository
                .save(userMapper
                    .fromUserDtoToUserEntity(userDto)));
    }

    @Override
    public List<UserDto>getAll() {
        return userRepository.findAll()
            .stream()
                .map(userMapper::fromUserEntityToUserDto)
                    .collect(Collectors.toList());
    }


    @Override
    public UserDto update(UserDto entity) throws NotFoundException{
        if (!userRepository.existsById(entity.getId())){
            throw new NotFoundException("id");
        }
        UserEntity userUpdated = userRepository.save(userMapper.fromUserDtoToUserEntity(entity));
        return userMapper.fromUserEntityToUserDto(userUpdated);
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("not found in DB");
        }
        userRepository.deleteById(id);
    }


    @Override
    public UserDto getById(Integer id) throws NotFoundException {
        if (!userRepository.existsById(id)) {
            throw new NotFoundException("l");
        }
        return userMapper.fromUserEntityToUserDto(userRepository.getById(id));
    }


    @Override
    public UserDto findByUsername(String username) throws NotFoundException {
        if (!userRepository.existsByUsername(username)) {
            throw new NotFoundException("a");
        }
        return userMapper.fromUserEntityToUserDto(userRepository.findByUsername(username));
    }


    @Override
    public UserDto findByEmail(String email) throws NotFoundException {
        if (!userRepository.existsByEmail(email)) {
            throw new NotFoundException("a");
        }
        return userMapper.fromUserEntityToUserDto(userRepository.findByEmail(email));
    }
}
