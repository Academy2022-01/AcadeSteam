package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.UserDTO;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.PL.mapper.UserRESTMapper;
import it.unikey.acadesteam.PL.rest.UserREST;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserRESTMapper userRESTMapper;

    @GetMapping
    private ResponseEntity<Set<UserREST>> findAllUsers() {
        Set<UserDTO> dtoS = userService.findAll();
        return new ResponseEntity<>(dtoS.stream()
                .map(userRESTMapper::fromUserDTOToUserRest)
                .collect(Collectors.toList()),
                HttpStatus.OK
        );
    }

    @GetMapping(path = "/{id}")
    private ResponseEntity<UserREST> findById(@PathVariable("id") UUID uuid) {
        try {
            UserDTO dto = service.findById(uuid);
            return new ResponseEntity<>(userRESTMapper.fromUserDTOToUserRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping() //username
    private ResponseEntity<UserREST> findByUserName (
            @RequestParam("username") String userName
            )  {
        try {
            UserREST dto = service.findByUsername(userName);
            return new ResponseEntity<UserREST>(dto
                    .map(userRESTMapper.fromUserDTOToUserRest), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }




}
