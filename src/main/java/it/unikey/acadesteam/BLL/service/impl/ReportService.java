package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.ReportMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.ReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReportService  implements CrudService<ReportDto> {
    private final ReportMapper mapper;
    private final ReportRepository repository;

    @Override
    public ReportDto insert(ReportDto dto) {
        return mapper.fromEntityToDto(repository.save(mapper.fromDtoToEntity(dto)));
    }

    @Override
    public ReportDto getById(Integer id) throws NotFoundException {
        if (!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
        return mapper.fromEntityToDto(repository.getById(id));
    }

    @Override
    public List<ReportDto> getAll() {
        return repository.findAll().stream().map(mapper::fromEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ReportDto update(ReportDto dto) throws NotFoundException {
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
