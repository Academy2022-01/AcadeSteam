package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.UserDTO;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.PL.mapper.UserRestMapper;
import it.unikey.acadesteam.PL.rest.UserRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRestMapper userRESTMapper;

    @GetMapping
    private ResponseEntity<Set<UserRest>> findAllUsers() {
        Set<UserDTO> dtoS = userService.findAll();
        return new ResponseEntity<>(dtoS.stream()
                .map(userRESTMapper::fromUserDTOToUserRest)
                .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<UserRest> findById(@PathVariable("id") UUID uuid) {
        try {
            UserDTO dto = service.findById(uuid);
            return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping() //username
    private ResponseEntity<UserRest> findByUserName (
            @RequestParam("username") String userName
            )  {
        try {
            UserDTO dto = service.findByUsername(userName);
            return new ResponseEntity<UserRest>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping
    private ResponseEntity<UserRest> update(@RequestBody UserRest user) {
        if(!userService.existsById(user.getId()))
            UserDTO
            return service.update(userRESTMapper.fromUserRestToUserDTO(user)
            )

    }


    @PostMapping()
    private ResponseEntity<UserRest> save(@RequestBody UserRest user) {
        if (user.getId() != null)
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        try {
            UserDTO userDTO = service.insert(user);
            return new ResponseEntity<UserRest>(userRESTMapper.fromUserDTOToUserRest(userDTO), HttpStatus.CREATED);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping(path = "/{id}")
    private ResponseEntity<Void> deleteUserById(@PathVariable("id") UUID uuid) {
        try {
            userService.delete(uuid);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }






}
