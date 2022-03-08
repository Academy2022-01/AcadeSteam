package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.RolesDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.mapper.RolesMapper;
import it.unikey.acadesteam.BLL.service.impl.RolesServiceImpl;
import it.unikey.acadesteam.PL.mapper.RolesRESTMapper;
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

    private RolesRESTMapper rolesMapper;
    private RolesServiceImpl service;

    @GetMapping(path = "/{id}")
    private ResponseEntity<RolesRest> getById(@PathVariable("id") Integer id) {
        try {
            RolesDto dto = service.getById(id);
            return new ResponseEntity<>(rolesMapper.fromRolesDtoToRolesRest(dto), HttpStatus.OK);

        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    private ResponseEntity<List<RolesRest>> getAll() {
        List<RolesDto> dtoS = service.getAll();
        return new ResponseEntity<List<RolesRest>>(dtoS.stream().map(rolesMapper::fromRolesDtoToRolesRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<RolesRest> update(@RequestBody RolesRest role) {
        try {
            RolesDto dto = service.update(rolesMapper.fromRolesRestToRolesDto(role));
            return new ResponseEntity<RolesRest>(rolesMapper.fromRolesDtoToRolesRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    private ResponseEntity<RolesRest> post(@RequestBody RolesRest role) {
        try {
            RolesDto dto = service.getById(role.getId());
            return new ResponseEntity<RolesRest>(rolesMapper.fromRolesDtoToRolesRest(dto), HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping( path = "/{id}")
    private ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        try {
            RolesDto dto = service.getById(id);
            return new ResponseEntity<Void>(HttpStatus.OK);
        } catch (NotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }
}
