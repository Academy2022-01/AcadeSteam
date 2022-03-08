package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.RolesServiceImpl;
import it.unikey.acadesteam.PL.mapper.RolesRestMapper;
import it.unikey.acadesteam.PL.rest.RolesRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/roles")
public class RolesController {

    private final RolesRestMapper mapper;
    private final RolesServiceImpl service;

    @GetMapping(path = "/{id}")
    private ResponseEntity<RolesRest> getById(@PathVariable("id") Integer id) {
        try {
            RolesDto dto = service.getById(id);
            return new ResponseEntity<>(mapper.fromRolesDtoToRolesRest(dto), HttpStatus.OK);

        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    private ResponseEntity<List<RolesRest>> getAll() {
        List<RolesDto> dtoS = service.getAll();
        return new ResponseEntity<>(dtoS.stream().map(mapper::fromRolesDtoToRolesRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<RolesRest> update(@RequestBody RolesRest roleRest) {
        try {
            RolesDto dto = service.update(mapper.fromRolesRestToRolesDto(roleRest));
            return new ResponseEntity<>(mapper.fromRolesDtoToRolesRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<RolesRest> post(@RequestBody RolesRest roleRest) {
        RolesDto roleDto = mapper.fromRolesRestToRolesDto(roleRest);
        return new ResponseEntity<>(mapper.fromRolesDtoToRolesRest(service.insert(roleDto)), HttpStatus.OK);
    }

    @DeleteMapping( path = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        try {
            service.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
