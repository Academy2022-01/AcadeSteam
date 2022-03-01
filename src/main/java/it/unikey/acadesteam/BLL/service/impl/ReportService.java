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

@Service
@RequiredArgsConstructor
public class ReportService  implements CrudService<ReportDto> {
    private final ReportMapper mapper;
    private final ReportRepository repository;

    @Override
    public ReportDto insert(ReportDto entity) {
        return null;
    }

    @Override
    public ReportDto getById(UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public List<ReportDto> getAll() {
        return null;
    }

    @Override
    public ReportDto update(ReportDto entity) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(UUID id) throws NotFoundException {

    }
}
