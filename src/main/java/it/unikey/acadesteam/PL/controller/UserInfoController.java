package it.unikey.acadesteam.PL.controller;


import it.unikey.acadesteam.BLL.dto.UserInfoDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.UserInfoServiceImpl;
import it.unikey.acadesteam.PL.mapper.UserInfoRestMapper;
import it.unikey.acadesteam.PL.rest.UserInfoRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/userinfo")
public class UserInfoController {

    private final UserInfoRestMapper mapper;
    private final UserInfoServiceImpl service;

    @GetMapping
    private ResponseEntity<List<UserInfoRest>> getAllUserInfo(){
        List<UserInfoDto> usersInfos = service.getAll();
        return new ResponseEntity<>(usersInfos.stream().map(mapper::fromDtoToRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<UserInfoRest> postUserInfo(@RequestBody UserInfoRest body){
        return new ResponseEntity<>(mapper.fromDtoToRest(service.insert(mapper.fromRestToDto(body))), HttpStatus.CREATED);
    }

    @PutMapping
    private ResponseEntity<UserInfoRest> putReport(@RequestBody UserInfoRest body){
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
