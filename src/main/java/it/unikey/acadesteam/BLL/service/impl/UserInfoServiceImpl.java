package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.UserInfoMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserInfoServiceImpl implements CrudService<UserInfoDto> {

    private final UserInfoMapper mapper;
    private final UserInfoRepository repository;

    @Override
    public UserInfoDto insert(UserInfoDto dto) {
        return mapper
                .fromUserInfoEntitytoUserInfoDto(repository
                        .save(mapper
                                .fromUserInfoDtotoUserInfoEntity(dto)));
    }

    @Override
    public UserInfoDto getById(Integer id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Not found at id " + id);
        }
        return mapper
                .fromUserInfoEntitytoUserInfoDto(repository
                        .getById(id));
    }

    @Override
    public List<UserInfoDto> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::fromUserInfoEntitytoUserInfoDto)
                .collect(Collectors
                        .toList());
    }

    @Override
    public UserInfoDto update(UserInfoDto dto) throws NotFoundException {
        if (!repository.existsById(dto.getId())) {
            throw new NotFoundException("Not found at id " + dto.getId());
        }
        return mapper
                .fromUserInfoEntitytoUserInfoDto(repository
                        .save(mapper
                                .fromUserInfoDtotoUserInfoEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Not found at id " + id);
        }
        repository.deleteById(id);
    }
}
