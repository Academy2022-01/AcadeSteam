package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.UserDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.UserService;
import it.unikey.acadesteam.BLL.service.impl.UserServiceImpl;
import it.unikey.acadesteam.PL.mapper.UserRestMapper;
import it.unikey.acadesteam.PL.rest.UserRest;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserServiceImpl userService;
    private final UserRestMapper userRESTMapper;

    @GetMapping
    private ResponseEntity<List<UserRest>> findAllUsers() {
        List<UserDto> dtoS = userService.getAll();
        return new ResponseEntity<>(dtoS.stream()
                .map(userRESTMapper::fromUserDTOToUserRest)
                .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<UserRest> findById(@PathVariable("id") Integer id) {
        try {
            UserDto dto = userService.getById(id);
            return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping() //username
    private ResponseEntity<UserRest> findByUserName(
            @RequestParam("username") String userName
    ) {
        try {
            UserDto dto = userService.findByUsername(userName);
            return new ResponseEntity<UserRest>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping()
    private ResponseEntity<UserRest> findByEmail(
            @RequestParam("email") String email
    ) {
        try {
            UserDto dto = userService.findByEmail(email);
            return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<UserRest> update(@RequestBody UserRest user) {
        try {
            UserDto userUpdated = userService.update(userRESTMapper.fromUserRestToUserDTO(user));
            return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(userUpdated), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }


    @PostMapping()
    private ResponseEntity<UserRest> save(@RequestBody UserRest user) {
        if (user.getId() != null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        UserDto userDTO = userService.insert(userRESTMapper.fromUserRestToUserDTO(user));
        return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteUserById(@PathVariable("id") Integer id) {
        try {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

}
