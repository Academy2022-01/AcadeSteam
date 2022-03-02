package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.GameStateDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.GameStateServiceImpl;
import it.unikey.acadesteam.PL.mapper.GameStateRestMapper;
import it.unikey.acadesteam.PL.rest.GameStateRest;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
@RequestMapping("/gameState")
public class GameStateController {

    private final GameStateRestMapper gameStateMapper;
    private final GameStateServiceImpl gameStateService;

    @GetMapping
    private ResponseEntity<List<GameStateRest>> getAllGameState(){
        return ResponseEntity.ok(gameStateService.getAll()
                .stream()
                .map(gameStateMapper::fromGameStateDtoToGameRest)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    private ResponseEntity<GameStateRest> getById(@PathVariable Integer id){
        try {
            GameStateDto gameState = gameStateService.getById(id);
            return new ResponseEntity(gameStateMapper.fromGameStateDtoToGameRest(gameState),HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<GameStateRest> insertAuthor(@RequestBody GameStateRest stateToSave) {
        GameStateDto stateSaved = gameStateService.insert(gameStateMapper.fromGameStateRestToGameDto(stateToSave));
        return new ResponseEntity(gameStateMapper.fromGameStateDtoToGameRest(stateSaved),HttpStatus.OK);
    }

    @PutMapping("/update")
    private ResponseEntity<GameStateRest> updateState(@RequestBody GameStateRest stateToUpdate) {
        try {
            GameStateDto stateUpdated = gameStateService.update(gameStateMapper.fromGameStateRestToGameDto(stateToUpdate));
            return new ResponseEntity(gameStateMapper.fromGameStateDtoToGameRest(stateUpdated), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private  ResponseEntity<Void> deleteState(@PathVariable Integer id){
        try {
            gameStateService.delete(id);
            return ResponseEntity.ok().build();
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
