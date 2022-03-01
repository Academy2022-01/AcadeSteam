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

@Service
@RequiredArgsConstructor
public class ReportTypeService implements CrudService<ReportTypeDto> {
    private final ReportTypeMapper mapper;
    private final ReportTypeRepository repository;

    @Override
    public ReportTypeDto insert(ReportTypeDto entity) {
        return null;
    }

    @Override
    public ReportTypeDto getById(UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public List<ReportTypeDto> getAll() {
        return null;
    }

    @Override
    public ReportTypeDto update(ReportTypeDto entity) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        if(!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
    }
}
