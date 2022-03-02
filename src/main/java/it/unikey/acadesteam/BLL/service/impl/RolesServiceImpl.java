package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.RolesMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.RolesRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class RolesServiceImpl implements CrudService<RolesDto> {

    private final RolesRepository rolesRepository;
    private final RolesMapper rolesMapper;


    @Override
    public RolesDto insert(RolesDto dto) {
        return rolesMapper.fromRolesEntityToRolesDto(rolesRepository
                .save(rolesMapper.fromRolesDtotoRolesEntity(dto)));
    }

    @Override
    public RolesDto getById(Integer id) throws NotFoundException {
        if(!rolesRepository.existsById(id)){
            throw new NotFoundException("id not found in DB");
        }
        return rolesMapper.fromRolesEntityToRolesDto(rolesRepository.getById(id));
    }

    @Override
    public List<RolesDto> getAll() {
        return rolesRepository.findAll()
                .stream().map(rolesMapper::fromRolesEntityToRolesDto).collect(Collectors.toList());
    }

    @Override
    public RolesDto update(RolesDto dto) throws NotFoundException {
        if(rolesRepository.existsById(dto.getId())){
            throw new NotFoundException("Roles not found in DB");
        }
        return rolesMapper.fromRolesEntityToRolesDto(rolesRepository.save(rolesMapper.fromRolesDtotoRolesEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!rolesRepository.existsById(id)){
            throw new NotFoundException("ID not found in DB");
        }
      rolesRepository.deleteById(id);
    }
}
