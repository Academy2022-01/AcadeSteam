package it.unikey.acadesteam.BLL.service.impl;



import it.unikey.acadesteam.BLL.dto.ReportTypeDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.ReportTypeMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.ReportTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportTypeService implements CrudService<ReportTypeDto> {
    private final ReportTypeMapper mapper;
    private final ReportTypeRepository repository;

    @Override
    public ReportTypeDto insert(ReportTypeDto dto) {
        return mapper.fromEntityToDto(repository.save(mapper.fromDtoToEntity(dto)));
    }

    @Override
    public ReportTypeDto getById(Integer id) throws NotFoundException {
        if (!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
        return mapper.fromEntityToDto(repository.getById(id));
    }

    @Override
    public List<ReportTypeDto> getAll() {
        return repository.findAll().stream().map(mapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ReportTypeDto update(ReportTypeDto dto) throws NotFoundException {
        if (!repository.existsById(dto.getId()))
            throw new NotFoundException("Not found at id " + dto.getId());
        return mapper.fromEntityToDto(repository.save(mapper.fromDtoToEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
        repository.deleteById(id);
    }
}
