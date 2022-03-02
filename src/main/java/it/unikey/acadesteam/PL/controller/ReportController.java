package it.unikey.acadesteam.PL.controller;

import it.unikey.acadesteam.BLL.dto.ReportDto;
import it.unikey.acadesteam.BLL.exception.NotFoundException;
import it.unikey.acadesteam.BLL.service.impl.ReportService;
import it.unikey.acadesteam.PL.mapper.ReportRestMapper;
import it.unikey.acadesteam.PL.rest.ReportRest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@RestController
@RequestMapping("/report")
public class ReportController {

    private final ReportRestMapper mapper;
    private final ReportService service;

    @GetMapping
    private ResponseEntity<List<ReportRest>> getAllReport(){
        List<ReportDto> reports = service.getAll();
        return new ResponseEntity<>(reports.stream().map(mapper::fromDtoToRest).collect(Collectors.toList()), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<ReportRest> postReport(@RequestBody ReportRest body){
        return new ResponseEntity<>(mapper.fromDtoToRest(service.insert(mapper.fromRestToDto(body))), HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<ReportRest> putReport(@RequestBody ReportRest body){
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
