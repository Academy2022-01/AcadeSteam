package it.unikey.acadesteam.PL.controller;


import it.unikey.acadesteam.BLL.dto.LibraryDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.LibraryServiceImpl;
import it.unikey.acadesteam.PL.mapper.LibraryRestMapper;
import it.unikey.acadesteam.PL.rest.LibraryRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/library")
public class LibraryController {


    private final LibraryRestMapper mapper;
    private final LibraryServiceImpl service;

    @GetMapping
    private ResponseEntity<List<LibraryRest>> getAllUserInfo(){
        List<LibraryDto> libraries = service.getAll();
        return new ResponseEntity<>(libraries.stream().map(mapper::fromDtoToRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<LibraryRest> postUserInfo(@RequestBody LibraryRest body){
        return new ResponseEntity<>(mapper.fromDtoToRest(service.insert(mapper.fromRestToDto(body))), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<LibraryRest> putReport(@RequestBody LibraryRest body){
        try{
            return new ResponseEntity<>(mapper.fromDtoToRest(service.update(mapper.fromRestToDto(body))), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Void> deleteReport(@PathVariable("id") Integer id){
        try{
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
