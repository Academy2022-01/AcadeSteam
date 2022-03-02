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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GameStateServiceImpl implements CrudService<GameStateDto> {

    private final GameStateMapper gameStateMapper;
    private final GameStateRepository gameStateRepository;

    @Override
    public GameStateDto insert(GameStateDto dto) {
        return gameStateMapper.fromGameStateEntityToGameStateDto(gameStateRepository.save(gameStateMapper.fromGameStateDtoToGameStateEntity(dto)));
    }

    @Override
    public GameStateDto getById(Integer id) throws NotFoundException {
        if(!gameStateRepository.existsById(id))
        {
            throw new NotFoundException("Id GameStateDto does not exist!");
        }
        return gameStateMapper.fromGameStateEntityToGameStateDto(gameStateRepository.getById(id));
    }

    @Override
    public List<GameStateDto> getAll() {
    return gameStateRepository.findAll()
            .stream()
            .map(gameStateMapper::fromGameStateEntityToGameStateDto)
            .collect(Collectors.toList()); //gg :)
    }

    @Override
    public GameStateDto update(GameStateDto dto) throws NotFoundException {
       if(!gameStateRepository.existsById(dto.getId())){
           throw new NotFoundException("Not found state!");
       }
        return gameStateMapper.fromGameStateEntityToGameStateDto(gameStateRepository.save(gameStateMapper.fromGameStateDtoToGameStateEntity(dto)));
    }

    @Override
    public void delete(Integer id) throws NotFoundException {
        if(!gameStateRepository.existsById(id))
        {
            throw new NotFoundException("Does not exist Id!");
        }
        gameStateRepository.deleteById(id);
    }
}
