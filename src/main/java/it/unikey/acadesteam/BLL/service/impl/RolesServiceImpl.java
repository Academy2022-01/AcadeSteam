package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.RolesMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.RolesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RolesServiceImpl implements CrudService<RolesDto> {

    private final RolesRepository repository;
    private final RolesMapper mapper;


    @Override
    public RolesDto insert(RolesDto dto) {
        return mapper.fromRolesEntityToRolesDto(repository
                .save(mapper.fromRolesDtoToRolesEntity(dto)));
    }

    @Override
    public RolesDto getById(Integer id) throws NotFoundException {
        if(!repository.existsById(id)){
            throw new NotFoundException("id not found in DB");
        }
        return mapper.fromRolesEntityToRolesDto(repository.getById(id));
    }

    @Override
    public List<RolesDto> getAll() {
        return repository.findAll()
                .stream().map(mapper::fromRolesEntityToRolesDto).collect(Collectors.toList());
    }

    @Override
    public RolesDto update(RolesDto dto) throws NotFoundException {
        if(!repository.existsById(dto.getId())){
            throw new NotFoundException("Roles not found in DB");
        }
        return mapper.fromRolesEntityToRolesDto(repository.save(mapper.fromRolesDtoToRolesEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!repository.existsById(id)){
            throw new NotFoundException("ID not found in DB");
        }
      repository.deleteById(id);
    }
}
