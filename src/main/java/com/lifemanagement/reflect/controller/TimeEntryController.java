package com.lifemanagement.reflect.controller;

import com.lifemanagement.reflect.dto.TimeEntryDTO;
import com.lifemanagement.reflect.dto.TimeEntryResponseDTO;
import com.lifemanagement.reflect.entity.TimeEntry;
import com.lifemanagement.reflect.service.TimeEntryService;
import lombok.AllArgsConstructor;
//import org.hibernate.query.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import java.util.Map;

@Slf4j
@AllArgsConstructor
@RestController
@RequestMapping("/api/time-entry")
public class TimeEntryController {
    private final TimeEntryService timeEntryService;

    @PostMapping
    public ResponseEntity<TimeEntryResponseDTO> createTimeEntry(@RequestBody TimeEntryDTO timeEntryDTO){

        try {
            TimeEntryResponseDTO timeEntryResponseDTO= timeEntryService.saveTimeEntry(timeEntryDTO);
            return new ResponseEntity<>(timeEntryResponseDTO,HttpStatus.CREATED);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<TimeEntryResponseDTO> updateTimeEntry(@PathVariable long id, @RequestBody TimeEntryDTO timeEntryDTO){
        try {

            TimeEntryResponseDTO timeEntryResponseDTO= timeEntryService.saveTimeEntry(id,timeEntryDTO);


            return new ResponseEntity<>(timeEntryResponseDTO,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
//    @GetMapping
//    public ResponseEntity<List<TimeEntry>> getTimeEntries(){
//
//        return new ResponseEntity<>(timeEntryService.getListEntries(),HttpStatus.OK);
//
//    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTimeEntry(@PathVariable long id){

        try{
            timeEntryService.deleteTimeEntry(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping
    public ResponseEntity<Map<String,Object>> getTimeEntries(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size,@RequestParam(defaultValue = "id") String sortBy){
        try{
            Page<TimeEntryResponseDTO> timeEntriesPage = timeEntryService.getTimeEntries(page, size, sortBy);


            Map<String, Object> response = new HashMap<>();
            response.put("entries", timeEntriesPage.getContent());
            response.put("currentPage", timeEntriesPage.getNumber());
            response.put("totalItems", timeEntriesPage.getTotalElements());
            response.put("totalPages", timeEntriesPage.getTotalPages());
            response.put("pageSize", timeEntriesPage.getSize());

            return new ResponseEntity<>(response, HttpStatus.OK);
        }
        catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
}
