package it.unikey.acadesteam.BLL.service.impl;

import it.unikey.acadesteam.BLL.dto.GameStateDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.GameStateMapper;
import it.unikey.acadesteam.BLL.service.CrudService;
import it.unikey.acadesteam.DAL.entity.GameStateEntity;
import it.unikey.acadesteam.DAL.repository.GameStateRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class GameStateServiceImpl implements CrudService<GameStateDto> {

    private final GameStateMapper gameStateMapper;
    private final GameStateRepository gameStateRepository;

    @Override
    public GameStateDto insert(GameStateDto dto) {
        GameStateEntity newGameState = gameStateMapper.fromGameStateDtoToGameStateEntity(dto);
        GameStateEntity stateWithId = gameStateRepository.save(newGameState);
        GameStateDto savedStateDto = gameStateMapper.fromGameStateEntityToGameStateDto(stateWithId);
        return savedStateDto;
    }

    @Override
    public GameStateDto getById(UUID id) throws NotFoundException {
        return null;
    }

    @Override
    public List<GameStateDto> getAll() {
        return null;
    }

    @Override
    public GameStateDto update(GameStateDto dto) throws NotFoundException {
        return null;
    }

    @Override
    public void delete(UUID id) throws NotFoundException {

    }
}
