package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.GameDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.GameMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GameService  implements CrudService<GameDto> {
    private final GameMapper mapper;
    private final GameRepository repository;

    @Override
    public GameDto insert(GameDto dto) {
        return mapper.fromGameEntityToGameDto(repository.save(mapper.fromGameDtoToGameEntity(dto)));
    }

    @Override
    public GameDto getById(UUID id) throws NotFoundException {
        if (!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
        return mapper.fromGameEntityToGameDto(repository.getById(id));
    }

    @Override
    public List<GameDto> getAll() {
        return repository.findAll().stream().map(mapper::fromGameEntityToGameDto).collect(Collectors.toList());
    }

    @Override
    public GameDto update(GameDto dto) throws NotFoundException {
        if (!repository.existsById(dto.getId()))
            throw new NotFoundException("Not found at id " + dto.getId());
        return mapper.fromGameEntityToGameDto(repository.save(mapper.fromGameDtoToGameEntity(dto)));
    }

    @Override
    public void delete(UUID id) throws NotFoundException {
        if(!repository.existsById(id))
            throw new NotFoundException("Not found at id " + id);
        repository.deleteById(id);
    }
}
