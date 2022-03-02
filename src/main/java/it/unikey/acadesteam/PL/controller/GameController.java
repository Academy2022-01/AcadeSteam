package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.GameDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.PL.mapper.GameRestMapper;
import it.unikey.acadesteam.PL.rest.GameRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
@RequestMapping("/game")
public class GameController {

    private final GameRestMapper gameMapper;
    private final GameServiceImpl service;

    @PostMapping
    private ResponseEntity<GameRest> postGame(@RequestBody GameRest game) {
        GameDto dtoInserted = service.insert(gameMapper.fromGameRestToGameDto(game);
        return new ResponseEntity<>(gameMapper.fromGameDtoToGameRest(dtoInserted), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<GameRest> getGameById(@PathVariable("id") Integer id) {
        try{
            GameDto dto = service.getById(id);
            return new ResponseEntity<>(gameMapper.fromGameDtoToGameRest(dto), HttpStatus.OK);
        } catch(NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    private ResponseEntity<List<GameRest>> getAllGame() {
        return new ResponseEntity<>(service.findAll().stream().map(gameMapper::fromGameDtoToGameRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<GameRest> putGame(@RequestBody GameRest game) {
        try{
            GameDto dtoUpdated = service.update(gameMapper.fromGameRestToGameDto(game));
            return new ResponseEntity<>(gameMapper.fromGameDtoToGameRest(dtoUpdated), HttpStatus.OK);
        } catch(NotFoundException e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteGame(@PathVariable("id") Integer id) {
        try {
            service.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
