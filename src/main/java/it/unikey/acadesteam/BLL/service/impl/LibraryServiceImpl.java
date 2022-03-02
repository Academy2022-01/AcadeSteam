package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.LibraryMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.LibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LibraryServiceImpl implements CrudService<LibraryDto> {

    private final LibraryMapper mapper;
    private final LibraryRepository repository;

    @Override
    public LibraryDto insert(LibraryDto dto) {
        return mapper
                .fromLibraryEntityToLibrarySto(repository
                        .save(mapper
                                .fromLibraryDtoToLibraryEntity(dto)));
    }

    @Override
    public LibraryDto getById(Integer id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Not found at id " + id);
        }
        return mapper
                .fromLibraryEntityToLibrarySto(repository
                        .getById(id));

    }

    @Override
    public List<LibraryDto> getAll() {

        return repository
                .findAll()
                .stream()
                .map(mapper::fromLibraryEntityToLibrarySto)
                .collect(Collectors.toList());
    }

    @Override
    public LibraryDto update(LibraryDto dto) throws NotFoundException {
        if (!repository.existsById(dto.getId())) {
            throw new NotFoundException("Not found at id " + dto.getId());
        }
        return mapper
                .fromLibraryEntityToLibrarySto(repository
                        .save(mapper
                                .fromLibraryDtoToLibraryEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if (!repository.existsById(id)) {
            throw new NotFoundException("Not found at id " + id);
        }
        repository.deleteById(id);
    }
}
